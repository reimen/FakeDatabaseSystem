package org.reimen2422.mvc.models.database;

import org.reimen2422.mvc.config.DatabaseConfig;
import org.reimen2422.mvc.utils.Path;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DatabaseTest {

    // Databaseの有無でテストを分けたいなら、Databaseに新しくデータベースが存在するか
    // 確かめるメソッドを用意して、それのテストを書く
    @Test
    public void testUse() {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
//        try {
//            database.delete();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Exercise
        try {
            database.use();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verify
    }

    @Ignore
    @Test
    public void testDelete() {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));
//        try {
//            database.use();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Exercise
        try {
            database.use();
            boolean actual = database.delete();

            // Verify
            assertThat(actual, is(true));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPath() throws Exception {
        // SetUp
        Database database = new Database(new Path(DatabaseConfig.PROJECT_PATH));

        // Exercise
        Path actual = database.getPath();
        Path expected = new Path(DatabaseConfig.PROJECT_PATH + "database/");

        // Verify
        assertThat(actual, is(expected));
    }
}