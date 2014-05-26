package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.models.modelclass.User;
import org.reimen2422.mvc.models.modelclass.User$;
import org.reimen2422.mvc.models.modelclass.UserChild;
import org.reimen2422.mvc.models.modelclass.UserChild$;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hayashi on 2014/05/26.
 */
public class UserChildTable extends Table<UserChild>{
    public UserChildTable(Database database) {
        super(database, UserChild$.getInstance());
    }

    public List<UserChild> selectByName(String name) {
        List<UserChild> userChildList = selectAll();
        List<UserChild> resultList = new ArrayList<UserChild>();
        for (UserChild userChild : userChildList) {
            if(name.equals(userChild.getName())) {
                resultList.add(userChild);
            }
        }

        return resultList;
    }

    public int deleteByName(String name) {
        List<UserChild> targetList = selectByName(name);
        if(targetList.size() == 0) return 0;

        for(UserChild userChild : targetList) {
            if(userChild.getName().equals(name)) {
                deleteById(userChild.getId());
            }
        }
        return targetList.size();
    }
}
