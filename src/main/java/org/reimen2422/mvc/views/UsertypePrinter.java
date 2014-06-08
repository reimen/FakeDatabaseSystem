package org.reimen2422.mvc.views;

import org.reimen2422.mvc.models.database.schemamodels.usertype.UserType;

import java.util.List;

public class UsertypePrinter {
    public static void print(UserType userTypeObject) {
        System.out.println(userTypeObject.toString());
    }

    public static<T extends UserType> void printAll(List<T> userTypeList) {
        for(T userTypeObject : userTypeList) {
            System.out.println(userTypeObject.toString());
        }
    }
}
