package org.reimen2422.mvc.models.modelclass;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class User$Test {

    @Test
    public void testGetInstance() throws Exception {
        // SetUp and Exercise
        User$ actual = User$.getInstance();
        User$ expected = User$.getInstance();

        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testSerializeModel() throws Exception {
        // SetUp and Exercise
        User user1 = User$.getInstance().serializeModel("1 hayashi");
        User user2 = new User(1, "hayashi");
        // Verify
        assertThat(user1, is(user2));
    }

    @Test
    public void testSerializeRusultIsNull() throws Exception {
        // SetUp and Exercise
        User user1 = User$.getInstance().serializeModel("noNumber hayashi");
        // Verify
        assertThat(user1, nullValue());
    }

    @Test
    public void testGetTableName() throws Exception {
        // SetUp and Exercise
        String actual = User$.getInstance().getTableName();

        // Verify
        assertThat(actual, is("user"));
    }
}