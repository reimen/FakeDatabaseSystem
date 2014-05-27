package org.reimen2422.mvc.models.database.schemamodels.usertype;

import org.junit.Test;
import org.reimen2422.mvc.models.database.schemamodels.usertype.User;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserChildTest {

    @Test
    public void testGetId() throws Exception {
        // SetUp
        UserChild userChild = new UserChild(1, "hayachi");
        // Exercise
        int actual = userChild.getId();
        int expected = 1;
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testToData() throws Exception {
        // SetUp and Exercise
        String actual = new UserChild(1, "reimen2422").toData();
        String expected = "1 reimen2422";
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
        String actual = new UserChild(1, "reimen2422").toString();
        String expected = "UserChild(id=1, name=reimen2422)";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testEquals() throws Exception {
        // SetUp
        UserChild userChild1 = new UserChild(1, "reimen2422");
        UserChild userChild2 = new UserChild(1, "reimen2422");
        // Verify
        assertThat(userChild1, is(userChild2));
    }
}