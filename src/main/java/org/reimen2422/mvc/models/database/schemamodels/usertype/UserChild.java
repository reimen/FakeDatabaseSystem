package org.reimen2422.mvc.models.database.schemamodels.usertype;

public class UserChild extends UserType {

    public UserChild(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof UserChild && id == ((UserChild) object).getId();
    }

}
