package org.reimen2422.mvc.models.modelclass;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class UserChild$Test {

    @Test
    public void testGetInstance() throws Exception {
        // SetUp and Exercise
        UserChild$ actual = UserChild$.getInstance();
        UserChild$ expected = UserChild$.getInstance();

        // Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testSerializeModel() throws Exception {
        // SetUp and Exercise
        UserChild userChild1 = UserChild$.getInstance().serializeModel("1 hayashi");
        UserChild userChild2 = new UserChild(1, "hayashi");
        // Verify
        assertThat(userChild1, is(userChild2));
    }

    @Test
    public void testSerializeResultIsNull() throws Exception {
        // SetUp and Exercise
        UserChild userChild1 = UserChild$.getInstance().serializeModel("noNumber hayashi");
        // Verify
        assertThat(userChild1, nullValue());
    }

    @Test
    public void testGetTableName() throws Exception {
        // SetUp and Exercise
        String actual = User$.getInstance().getTableName();

        // Verify
        assertThat(actual, is("user"));
    }
}