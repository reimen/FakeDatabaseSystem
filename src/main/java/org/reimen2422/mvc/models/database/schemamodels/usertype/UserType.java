package org.reimen2422.mvc.models.database.schemamodels.usertype;

import org.reimen2422.mvc.models.database.schemamodels.SchemaModelInterface;

public abstract class UserType implements SchemaModelInterface {
    protected int id;
    protected String name;

    public UserType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toData() {
        return id + " " + name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getClass().getSimpleName() + "(id=" + id + ", name=" + name + ")";
    }

}
