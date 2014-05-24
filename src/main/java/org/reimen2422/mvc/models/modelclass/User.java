package org.reimen2422.mvc.models.modelclass;

public class User implements TableObjectInterface {
    private int id;
    private String name;

    public User(int id, String name) {
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
        return "User(id=" + id + ", name=" + name + ")";
    }

    @Override
    public boolean equals(Object user) {
        return user instanceof User && id == ((User) user).getId();
    }

}
