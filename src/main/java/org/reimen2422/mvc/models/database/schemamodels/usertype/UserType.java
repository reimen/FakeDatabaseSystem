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
        // 本当は最初にthisが隠れている
        // getClass()でクラスを返してくれる
        // getName()でフルパスを取得できる
        // getSimpleName()でフルパスの最後尾（クラス名）を取得できる
        return getClass().getSimpleName() + "(id=" + id + ", name=" + name + ")";
    }

//    ここでこの定義をしてもUserとUserChildを比較したときtrueを返されてしまう
//    genericsをうまく使えば解決できるかもしれない
//    @Override
//    public boolean equals(Object object) {
//        return object instanceof UserType && id == ((UserType) object).getId();
//    }

}
