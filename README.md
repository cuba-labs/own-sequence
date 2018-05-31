# Using Own Database Sequences

1. Create a subclass of `NumberIdWorker` bean in the `core` module and override the `getSequenceName()` method like this:

    ```java
    @Override
    protected String getSequenceName(String entityName) {
        if (entityName.equals("sample$Foo")) {
            return "FOO_SEQ"; // an existing sequence
        }
        return super.getSequenceName(entityName);
    }
    ```
    See an example in [SampleNumberIdWorker.java](https://github.com/cuba-labs/own-sequence/blob/master/modules/core/src/com/company/sample/core/SampleNumberIdWorker.java).        

2. Register your bean in `spring.xml`.

3. Add `cuba.numberIdCacheSize = 1` to both `app.properties` and `web-app.properties`.
