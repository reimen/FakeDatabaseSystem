package org.reimen2422.mvc.models.modelclass;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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

    }

    @Test
    public void testGetTableName() throws Exception {

    }
}