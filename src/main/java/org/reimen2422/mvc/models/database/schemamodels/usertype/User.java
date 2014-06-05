package org.reimen2422.mvc.models.database.schemamodels.usertype;

import java.util.ArrayList;
import java.util.List;

public class User extends UserType {
    protected List<UserChild> children = new ArrayList<UserChild>();

//    public User(int id, String name) {
//        super(id, name);
//        this.children = new ArrayList<UserChild>();
//    }

    public User(int id, String name) {
        super(id, name);
    }

    public User(int id, String name, List<UserChild> children) {
        super(id, name);
        this.children = children;
    }

    @Override
    public String toData() {
        StringBuilder data = new StringBuilder(id + " " + name);
        if (children.size() != 0) {
            data.append(" ");
        }
        for (int i = 0; i < children.size(); i++) {
            if (i == (children.size() - 1)) {
                data.append(children.get(i).getId());
            } else {
                data.append(children.get(i).getId()).append(" ");
            }
        }
        return data.toString();
    }

    @Override
    public boolean equals(Object user) {
        return user instanceof User && id == ((User) user).getId();
    }

    public List<UserChild> getChildrenId() {
        return children;
    }
}
