package org.reimen2422.mvc.models.database.schemamodels;

public interface SchemaModelInterface$<T> {

    T serializeModel(String data);

    String getTableName();
}
