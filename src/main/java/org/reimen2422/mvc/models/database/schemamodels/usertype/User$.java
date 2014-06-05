package org.reimen2422.mvc.models.database.schemamodels.usertype;

import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.schemamodels.SchemaModelInterface$;
import org.reimen2422.mvc.models.database.table.usertype.UserChildTable;
import org.reimen2422.mvc.models.database.table.usertype.UserTable;
import org.reimen2422.mvc.utils.Path;

import java.util.ArrayList;
import java.util.List;

public class User$ implements SchemaModelInterface$<User> {
    private static User$ instance = null;

    public static synchronized User$ getInstance() {
        if(instance == null) {
            instance = new User$();
        }
        return instance;
    }

    @Override
    public User serializeModel(String data) {
        try {
            String[] dataArray = data.split(" ");
            if(dataArray.length == 3) {
                int id = new Integer(dataArray[0]);
                String name = dataArray[1];

                String[] childIdArray = dataArray[2].split(",");
                List<UserChild> childList = new ArrayList<UserChild>();
                // UserChildTableのSelectByIdを使うための準備
                // ById() -> ChildTable -> Database必要
                Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
                database.use();
                UserChildTable userChildTable = new UserChildTable(database);

                for(String childId : childIdArray) {
                    childList.add(userChildTable.selectById( new Integer(childId) ));
                }

                return new User(id, name, childList);
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
