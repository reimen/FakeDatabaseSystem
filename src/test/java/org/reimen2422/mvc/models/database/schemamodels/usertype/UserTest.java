package org.reimen2422.mvc.models.database.schemamodels.usertype;

import org.junit.Test;
import org.reimen2422.mvc.models.database.schemamodels.usertype.User;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testGetId() throws Exception {
        // SetUp and Exercise
        List<UserChild> children = new ArrayList<UserChild>();
        children.add(new UserChild(1, "child"));
        int actual = new User(1, "reimen2422", children).getId();
        int expected = 1;
        // Verify
        assertThat(actual, is(expected));
    }


    @Test
    public void testGetName() throws Exception {
        // SetUp and Exercise
        List<UserChild> children = new ArrayList<UserChild>();
        children.add(new UserChild(1, "child"));
        String actual = new User(1, "reimen2422", children).getName();
        String expected = "reimen2422";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testToString() throws Exception {
        // SetUp and Exercise
        List<UserChild> children = new ArrayList<UserChild>();
        children.add(new UserChild(1, "child"));
        String actual = new User(1, "reimen2422", children).toString();
        String expected = "User(id=1, name=reimen2422)";
        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testEquals() throws Exception {
        // SetUp
        List<UserChild> children = new ArrayList<UserChild>();
        children.add(new UserChild(1, "child"));
        User user1 = new User(1, "reimen", children);
        User user2 = new User(1, "reimen2422", children);
        // Verify
        assertThat(user1, is(user2));
    }

    @Test
    public void testEqualsNotUserAndUserChild() throws Exception {
        // SetUp
        List<UserChild> children = new ArrayList<UserChild>();
        children.add(new UserChild(1, "child"));
        User user = new User(1, "reimen", children);
        UserChild userChild = new UserChild(1, "reimen2422");
        boolean actual = user.equals(userChild);
        // Verify
        assertThat(actual, is(false));
    }

    @Test
    public void testToData() throws Exception {
        // SetUp and Exercise
        List<UserChild> children = new ArrayList<UserChild>();
        children.add(new UserChild(1, "child"));
        children.add(new UserChild(2, "child2"));
        String actual = new User(1, "reimen2422", children).toData();
        String expected = "1 reimen2422 1,2";
        // Verify
        assertThat(actual, is(expected));
    }

}