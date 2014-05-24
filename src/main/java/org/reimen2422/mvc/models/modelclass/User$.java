package org.reimen2422.mvc.models.modelclass;

/**
 * Created by hayashi on 2014/05/24.
 */
public class User$ implements TableObjectInterface$<User> {
    private static User$ instance = null;

    public static User$ getInstance() {
        if(instance == null) {
            instance = new User$();
        }
        return instance;
    }

    @Override
    public User serializeModel(String data) {
        try {
            String[] dataArray = data.split(" ");
            if(dataArray.length == 2) {
                int id = new Integer(dataArray[0]);
                String name = dataArray[1];
                return new User(id, name);
            }
            else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getTableName() {
        return "user";
    }
}
