package org.reimen2422.mvc.models.modelclass;

/**
 * Created by hayashi on 2014/05/24.
 */
public interface TableObjectInterface$<T> {

    T serializeModel(String data);

    String getTableName();
}
