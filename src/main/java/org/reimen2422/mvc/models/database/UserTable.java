package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.models.modelclass.TableObjectInterface;
import org.reimen2422.mvc.models.modelclass.User;
import org.reimen2422.mvc.models.modelclass.User$;

import java.util.ArrayList;
import java.util.List;

public class UserTable extends Table<User> {

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

    public int deleteByName(String name) {
        List<User> targetList = selectByName(name);
        if(targetList.size() == 0) return 0;

        for(User user : targetList) {
            if(user.getName().equals(name)) {
                deleteById(user.getId());
            }
        }
        return targetList.size();
    }
}
