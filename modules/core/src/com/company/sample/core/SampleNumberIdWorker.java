package com.company.sample.core;

import com.company.sample.annotation.IdSequence;
import com.haulmont.cuba.core.app.NumberIdWorker;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Metadata;

public class SampleNumberIdWorker extends NumberIdWorker {

    /**
     * @param entityName
     * @return sequence name to be used for id generation.
     * Follows standard behaviour if {@link IdSequence} annotation is not defined for an entity,
     * otherwise returns {@link IdSequence#name()} value
     */

    @Override
    protected String getSequenceName(String entityName) {
        Class<?> entityClass = AppBeans.get(Metadata.class).getSession().getClass(entityName).getJavaClass();
        if (entityClass != null && entityClass.isAnnotationPresent(IdSequence.class))
            return entityClass.getAnnotation(IdSequence.class).name();

        return super.getSequenceName(entityName);
    }
}
