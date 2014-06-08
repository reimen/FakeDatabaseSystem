package org.reimen2422.mvc.models.database.schemamodels.usertype;

import java.util.ArrayList;
import java.util.List;

public class User extends UserType {
    protected List<UserChild> userChildList = new ArrayList<UserChild>();

//    public User(int id, String name) {
//        super(id, name);
//        this.children = new ArrayList<UserChild>();
//    }

    public User(int id, String name) {
        super(id, name);
    }

    public User(int id, String name, List<UserChild> children) {
        super(id, name);
        this.userChildList = children;
    }

    @Override
    public String toData() {
        StringBuilder data = new StringBuilder(id + " " + name);
        if (userChildList.size() != 0) {
            data.append(" ");
        }
        for (int i = 0; i < userChildList.size(); i++) {
            if (i == (userChildList.size() - 1)) {
                data.append(userChildList.get(i).getId());
            } else {
                data.append(userChildList.get(i).getId()).append(" ");
            }
        }
        return data.toString();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(getClass().getSimpleName() + "(id=" + id + ", name=" + name + ")");
        string.append(" [ ");
        for (int i = 0; i < userChildList.size(); i++) {
            if (i == userChildList.size() - 1) {
                string.append(userChildList.get(i).toString());
            } else {
                string.append(userChildList.get(i).toString()).append(", ");
            }
        }
        string.append(" ]");
        return string.toString();
    }

    @Override
    public boolean equals(Object user) {
        return user instanceof User && id == ((User) user).getId();
    }

    public List<UserChild> getChildrenId() {
        return userChildList;
    }
}
