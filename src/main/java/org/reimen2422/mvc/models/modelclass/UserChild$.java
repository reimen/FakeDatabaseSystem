package org.reimen2422.mvc.models.modelclass;

/**
 * Created by hayashi on 2014/05/25.
 */
public class UserChild$ implements TableObjectInterface$<UserChild> {
    private static UserChild$ instance = null;

    public static UserChild$ getInstance() {
        if(instance == null) {
            instance = new UserChild$();
        }
        return instance;
    }

    @Override
    public UserChild serializeModel(String data) {
        try {
            String[] dataArray = data.split(" ");
            if(dataArray.length == 2) {
                int id = new Integer(dataArray[0]);
                String name = dataArray[1];
                return new UserChild(id, name);
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
        return "userChild";
    }
}
