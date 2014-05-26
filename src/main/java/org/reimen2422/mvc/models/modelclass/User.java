package org.reimen2422.mvc.models.modelclass;

public class User extends UserType {

    public User(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean equals(Object user) {
        return user instanceof User && id == ((User) user).getId();
    }

}
