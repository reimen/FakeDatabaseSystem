package org.reimen2422.mvc.models.database.schemamodels.usertype;

import org.junit.Test;
import org.reimen2422.mvc.models.database.schemamodels.usertype.User;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testGetId() throws Exception {
        // SetUp and Exercise
        int actual = new User(1, "reimen2422").getId();
        int expected = 1;
        // Verify
        assertThat(actual, is(expected));
    }


    @Test
    public void testGetName() throws Exception {
        // SetUp and Exercise
        String actual = new User(1, "reimen2422").getName();
        String expected = "reimen2422";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testToString() throws Exception {
        // SetUp and Exercise
        String actual = new User(1, "reimen2422").toString();
        String expected = "User(id=1, name=reimen2422)";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testEquals() throws Exception {
        // SetUp
        User user1 = new User(1, "reimen");
        User user2 = new User(1, "reimen2422");
        // Verify
        assertThat(user1, is(user2));
    }

    @Test
    public void testEqualsNotUserAndUserChild() throws Exception {
        // SetUp
        User user = new User(1, "reimen");
        UserChild userChild = new UserChild(1, "reimen2422");
        boolean actual = user.equals(userChild);
        // Verify
        assertThat(actual, is(false));
    }

    @Test
    public void testToData() throws Exception {
        // SetUp and Exercise
        String actual = new User(1, "reimen2422").toData();
        String expected = "1 reimen2422";
        // Verify
        assertThat(actual, is(expected));
    }

}