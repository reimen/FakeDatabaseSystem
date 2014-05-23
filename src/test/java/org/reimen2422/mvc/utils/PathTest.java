package org.reimen2422.mvc.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void testGetPath() throws Exception {
        // SetUp & Exercise
        String actual = new Path("~/test/path/").toString();
        String expected = System.getProperty("user.home") + "/test/path/";

        //Verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testEquals() throws Exception {
        // SetUp
        Path path1 = new Path("~/test/path/");
        Path path2 = new Path("~/test/path/");

        // Exercise and Verify
        assertThat(path1, is(path2));
    }
}