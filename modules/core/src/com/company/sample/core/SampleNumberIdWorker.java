package com.company.sample.core;

import com.haulmont.cuba.core.app.NumberIdWorker;

public class SampleNumberIdWorker extends NumberIdWorker {

    @Override
    protected String getSequenceName(String entityName) {
        if (entityName.equals("sample$Foo")) {
            return "FOO_SEQ";
        }
        return super.getSequenceName(entityName);
    }
}
