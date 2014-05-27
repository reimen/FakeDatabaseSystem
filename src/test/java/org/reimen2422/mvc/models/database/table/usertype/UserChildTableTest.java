package org.reimen2422.mvc.models.database.table.usertype;

import org.junit.Test;
import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.table.usertype.UserChildTable;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild;
import org.reimen2422.mvc.utils.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserChildTableTest {

    /**
     *  UserChildTable
     */
    @Test
    public void testSelectByName() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));

        try {
            database.use();
            UserChildTable userChildTable = new UserChildTable(database);
            userChildTable.delete();
            UserChild userChild1 = new UserChild(1, "hayashi");
            UserChild userChild2 = new UserChild(2, "hayashi");
            UserChild userChild3 = new UserChild(3, "tatsuhiko");
            List<UserChild> userChildList = new ArrayList<UserChild>();
            userChildList.add(userChild1);
            userChildList.add(userChild2);
            userChildList.add(userChild3);
            List<UserChild> expected = new ArrayList<UserChild>();
            expected.add(userChild1);
            expected.add(userChild2);
            for(UserChild userChild : userChildList) {
                userChildTable.insert(userChild);
            }
            // Exercise
            List<UserChild> actual = userChildTable.selectByName("hayashi");
            // Verify
            assertThat(actual, is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDeleteByName() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));

        try {
            database.use();
            UserChildTable userChildTable = new UserChildTable(database);
            userChildTable.delete();
            UserChild userChild1 = new UserChild(1, "hayashi");
            UserChild userChild2 = new UserChild(2, "hayashi");
            UserChild userChild3 = new UserChild(3, "tatsuhiko");
            List<UserChild> userChildList = new ArrayList<UserChild>();
            userChildList.add(userChild1);
            userChildList.add(userChild2);
            userChildList.add(userChild3);
            List<UserChild> expected2 = new ArrayList<UserChild>();
            expected2.add(userChild3);
            for(UserChild userChild : userChildList) {
                userChildTable.insert(userChild);
            }
            // Exercise
            int actual1 = userChildTable.deleteByName("hayashi");
            List<UserChild> actual2 = userChildTable.selectAll();
            // Verify
            assertThat(actual1, is(2));
            assertThat(actual2, is(expected2));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}