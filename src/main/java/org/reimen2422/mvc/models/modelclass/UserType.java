package org.reimen2422.mvc.models.modelclass;

public abstract class UserType implements TableObjectInterface {
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
        // 本当は最初にthisが隠れている
        // getClass()でクラスを返してくれる
        // getName()でフルパスを取得できる
        // getSimpleName()でフルパスの最後尾（クラス名）を取得できる
        return getClass().getSimpleName() + "(id=" + id + ", name=" + name + ")";
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof UserType && id == ((UserType) object).getId();
    }

}
