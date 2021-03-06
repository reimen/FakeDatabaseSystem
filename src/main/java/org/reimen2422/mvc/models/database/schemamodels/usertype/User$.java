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
            Database db = new Database(new Path(DatabaseConfig.PROJECT_PATH));

            if (dataArray.length >= 2) {
                int id = new Integer(dataArray[0]);
                String name = dataArray[1];
                List<Integer> childIdList = new ArrayList<Integer>();
                List<UserChild> childList = new ArrayList<UserChild>();

                // 子供id(int) 抽出
                for (int i = 2; i < dataArray.length; i++) {
                    childIdList.add(new Integer(dataArray[i]));
                }
                // 子供idからlistの作成
                for (int childId : childIdList) {
                    UserChild userChild = new UserChildTable(db).selectById(childId);
                    if (userChild != null) {
                        childList.add(userChild);
                    }
                }

                return new User(id, name, childList);
            } else {
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
