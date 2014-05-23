package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.models.modelclass.TableObjectInterface;
import org.reimen2422.mvc.models.modelclass.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hayashi on 2014/05/22.
 */
public class UserTable extends Table {

    public UserTable(Database database) {
        super("user", database);
    }

    @Override
    public TableObjectInterface serialize(String string) {
        return User.serialize(string);
    }

    public List<User> selectByName(String name) {
        List<TableObjectInterface> userList = selectAll();
        List<User> resultList = new ArrayList<User>();
        for (TableObjectInterface user : userList) {
            if(name.equals(((User)user).getName())) {
                resultList.add((User)user);
            }
        }

        return resultList;
    }
}
