package com.company.cesc.core

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.sys.PersistenceSecurityImpl
import com.haulmont.cuba.core.sys.SecurityImpl
import com.haulmont.cuba.security.global.ConstraintData
import org.apache.commons.lang.StringUtils
import org.codehaus.groovy.runtime.MethodClosure
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Inject

class SecurityConstraintExtensionImpl extends PersistenceSecurityImpl {

    private final Logger log = LoggerFactory.getLogger(SecurityConstraintExtensionImpl.class);

    @Inject
    DataManager dataManager

    @Override
    protected void fillGroovyConstraintsContext(Map<String, Object> context) {
        context["dataManager"] = dataManager
    }

    @Override
    protected boolean isPermitted(Entity entity, ConstraintData constraint) {
        String metaClassName = entity.getMetaClass().getName();
        String groovyScript = constraint.getGroovyScript();
        if (constraint.getCheckType().memory() && StringUtils.isNotBlank(groovyScript)) {
            Map<String, Object> context = new HashMap<>();

            /////////////////////////////////////////////
            // adjustments START
            /////////////////////////////////////////////

            /*
             this original entity is important, because of metadataTools.deepCopy(entity).
             When i try to do a
                PersistenceHelper.checkLoaded({E}, 'paymentMethod')
             on the copy, it will just return null instead of throwing an exception.

             In the update case i could reload the entity, but in the create case this is
             not possible, because the entity is not yet persisted
             */
            context.put("__originalEntity__", entity);
            /////////////////////////////////////////////
            // adjustments END
            /////////////////////////////////////////////

            context.put("__entity__", metadataTools.deepCopy(entity)); // copy to avoid implicit modification
            context.put("parse", new MethodClosure(this, "parseValue"));
            context.put("userSession", userSessionSource.getUserSession());
            fillGroovyConstraintsContext(context);
            try {
                Object o = scripting.evaluateGroovy(groovyScript.replace("{E}", "__entity__"), context);
                if (Boolean.FALSE.equals(o)) {
                    log.trace("Entity does not match security constraint. Entity class [{}]. Entity [{}]. Constraint [{}].",
                            metaClassName, entity.getId(), constraint.getCheckType());
                    return false;
                }
            } catch (Exception e) {
                log.error("An error occurred while applying constraint's Groovy script. The entity has been filtered out." +
                        "Entity class [{}]. Entity [{}].", metaClassName, entity.getId(), e);
                return false;
            }
        }
        return true;
    }
}
