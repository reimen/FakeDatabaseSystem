package org.reimen2422.mvc.models.database.schemamodels.usertype;

import org.reimen2422.mvc.models.database.schemamodels.SchemaModelInterface$;

public class UserChild$ implements SchemaModelInterface$<UserChild> {
    private static UserChild$ instance = null;

    public static synchronized UserChild$ getInstance() {
        if(instance == null) {
            instance = new UserChild$();
        }
        return instance;
    }

    @Override
    public UserChild serializeModel(String data) {
//        System.out.println("selialize: " + data);
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
