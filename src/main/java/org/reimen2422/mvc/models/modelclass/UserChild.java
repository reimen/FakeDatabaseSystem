package org.reimen2422.mvc.models.modelclass;

public class UserChild implements TableObjectInterface {
    private int id;
    private String name;

    public UserChild(int id, String name) {
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

    @Override
    public String toString() {
        return "UserChild(id=" + id + ", name=" + name + ")";
    }

    @Override
    public boolean equals(Object userChild) {
        return userChild instanceof UserChild && id == ((UserChild) userChild).getId();
    }

}
