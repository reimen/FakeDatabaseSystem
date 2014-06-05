package org.reimen2422.mvc.models.database.schemamodels.usertype;

import java.util.ArrayList;
import java.util.List;

public class User extends UserType {
    protected List<UserChild> children;

//    public User(int id, String name) {
//        super(id, name);
//        this.children = new ArrayList<UserChild>();
//    }

    public User(int id, String name, List<UserChild> children) {
        super(id, name);
        this.children = children;
    }

    @Override
    public String toData() {
        String childrenString = "";
        for(int i = 0; i < children.size(); i++) {
            if(i != 0) childrenString = childrenString + ",";
            childrenString = childrenString + children.get(i).getId();
        }
        return id + " " + name + " " + childrenString;
    }

    @Override
    public boolean equals(Object user) {
        return user instanceof User && id == ((User) user).getId();
    }

    public List<UserChild> getChildrenId() {
        return children;
    }
}
