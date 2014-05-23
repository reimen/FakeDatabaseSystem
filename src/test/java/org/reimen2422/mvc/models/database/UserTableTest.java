package org.reimen2422.mvc.models.database;

import org.junit.Test;
import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.modelclass.TableObjectInterface;
import org.reimen2422.mvc.models.modelclass.User;
import org.reimen2422.mvc.utils.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTableTest {

    @Test
    public void testSerialize() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        UserTable userTable = new UserTable(database);
        TableObjectInterface expected = User.serialize("1 hayashi");

        // Exercise
        TableObjectInterface actual = userTable.serialize("1 hayashi");

        //Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testSelectByName() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));

        try {
            database.use();
            UserTable userTable = new UserTable(database);
            userTable.delete();
            User user1 = new User(1, "hayashi");
            User user2 = new User(2, "hayashi");
            User user3 = new User(3, "tatsuhiko");
            List<TableObjectInterface> userList = new ArrayList<TableObjectInterface>();
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            List<User> expected = new ArrayList<User>();
            expected.add(user1);
            expected.add(user2);
            for(TableObjectInterface user : userList) {
                userTable.insert(user);
            }
            // Exercise
            List<User> actual = userTable.selectByName("hayashi");
            // Verify
            assertThat(actual, is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}