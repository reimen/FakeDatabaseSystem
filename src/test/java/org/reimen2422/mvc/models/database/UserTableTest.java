package org.reimen2422.mvc.models.database;

import org.junit.Ignore;
import org.junit.Test;
import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.models.modelclass.TableObjectInterface;
import org.reimen2422.mvc.models.modelclass.User;
import org.reimen2422.mvc.models.modelclass.User$;
import org.reimen2422.mvc.utils.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class UserTableTest {

    /**
     *  Table
     */
    @Test
    public void testGetName() {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            database.use();
            UserTable table = new UserTable(database);
            // Exercise
            String actual = table.getName();
            // Verify
            assertThat(actual, is("user"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            database.use();
            UserTable table = new UserTable(database);
            table.delete();
            // Exercise
            boolean actual = table.create();
            // Verify
            assertThat(actual, is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            database.use();
//            Table table = new Table("user", database);
            UserTable table = new UserTable(database);
            User user = new User(1, "hayashi");
            // Exercise
            boolean actual = table.insert(user);
            // Verify
            assertThat(actual, is(true));
        } catch(IOException e) {
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
            UserTable userTable = new UserTable(database);
            userTable.delete();
            User user1 = new User(1, "hayashi1");
            User user2 = new User(2, "hayashi2");
            User user3 = new User(3, "hayashi3");
            List<User> expected = new ArrayList<User>();
            expected.add(user1);
            expected.add(user2);
            expected.add(user3);
            for(User user : expected) {
                userTable.insert(user);
            }
            // Exercise
            List<User> actual = userTable.selectAll();
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
            UserTable userTable = new UserTable(database);
            userTable.delete();
            User user1 = new User(1, "hayashi1");
            User expected = new User(2, "hayashi2");
            User user2 = new User(3, "hayashi3");
            List<User> userList = new ArrayList<User>();
            userList.add(user1);
            userList.add(expected);
            userList.add(user2);
            for(User user : userList) {
                userTable.insert(user);
            }
            // Exercise
            User actual = userTable.selectById(2);
            // Verify
            assertThat(actual, is(expected));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
        try {
            database.use();
//            Table table = new Table("user", database);
            UserTable userTable = new UserTable(database);
            // Exercise
            boolean actual = userTable.delete();
            // Verify
            assertThat(actual, is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // これはUser$の責務なのでUser$でテストするべき
//    @Test
//    public void testSerialize() throws Exception {
//        // SetUp
//        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
//        UserTable userTable = new UserTable(database);
//        TableObjectInterface expected = User.serialize("1 hayashi");
//
//        // Exercise
//        User actual = User$.getInstance().serializeModel("1 hayashi");
//
//        //Verify
//        assertThat(actual, is(expected));
//    }

    /**
     *  UserTable
     */
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
            List<User> userList = new ArrayList<User>();
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            List<User> expected = new ArrayList<User>();
            expected.add(user1);
            expected.add(user2);
            for(User user : userList) {
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