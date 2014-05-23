package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.modelclass.TableObjectInterface;
import org.reimen2422.mvc.models.modelclass.User;
import org.reimen2422.mvc.utils.Path;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TableTest {

    @Ignore
    @Test
    public void testCreate() {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            database.use();
//            Table table = new Table("user", database);
            Table table = new UserTable(database);
            table.delete();
            // Exercise
            boolean actual = table.create();
            // Verify
            assertThat(actual, is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testInsert() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            database.use();
//            Table table = new Table("user", database);
            Table table = new UserTable(database);
            User user = new User(1, "hayashi");
            // Exercise
            boolean actual = table.insert(user);
            // Verify
            assertThat(actual, is(true));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            database.use();
//            Table table = new Table("user", database);
            Table table = new UserTable(database);
            // Exercise
            boolean actual = table.delete();
            // Verify
            assertThat(actual, is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() throws Exception {
//        // SetUp
//        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
//        try {
//            database.use();
//            Table table = new Table("user", database);
//            List expected = new ArrayList();
//            expected.add(new User(1, "hayashi"));
//            // Exercise
//            List actual = table.selectAll();
//            // Verify
//            assertThat(actual, is(expected));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            database.use();
//            Table table = new Table("user", database);
            Table table = new UserTable(database);
            table.delete();
            User user1 = new User(1, "hayashi1");
            User user2 = new User(2, "hayashi2");
            User user3 = new User(3, "hayashi3");
            List<TableObjectInterface> expected = new ArrayList<TableObjectInterface>();
            expected.add(user1);
            expected.add(user2);
            expected.add(user3);
            for(TableObjectInterface tableObject : expected) {
                table.insert(tableObject);
            }
            // Exercise
            List<TableObjectInterface> actual = table.selectAll();
            // Verify
            assertThat(actual, is(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectById() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));

        try {
            database.use();
//            Table table = new Table("user", database);
            Table table = new UserTable(database);
            table.delete();
            User user1 = new User(1, "hayashi1");
            User expected = new User(2, "hayashi2");
            User user2 = new User(3, "hayashi3");
            List<User> userList = new ArrayList<User>();
            userList.add(user1);
            userList.add(expected);
            userList.add(user2);
            for(User user : userList) {
                table.insert(user);
            }
            // Exercise
            User actual = (User)table.selectById(2);
            // Verify
            assertThat(actual, is(expected));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}