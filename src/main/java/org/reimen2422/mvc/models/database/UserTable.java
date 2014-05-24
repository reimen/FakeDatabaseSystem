package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.models.modelclass.TableObjectInterface;
import org.reimen2422.mvc.models.modelclass.User;
import org.reimen2422.mvc.models.modelclass.User$;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hayashi on 2014/05/22.
 */
public class UserTable extends Table {

    public UserTable(Database database) {
        super(database, User$.getInstance());
    }

    public List<User> selectByName(String name) {
        List<User> userList = selectAll();
        List<User> resultList = new ArrayList<User>();
        for (User user : userList) {
            if(name.equals(user.getName())) {
                resultList.add(user);
            }
        }

        return resultList;
    }
}