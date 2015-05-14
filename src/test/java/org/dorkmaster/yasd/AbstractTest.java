package org.dorkmaster.yasd;

import org.junit.Assert;

import java.util.Collection;

/**
 * Author: mjackson
 * Date: 5/13/15 10:23 PM
 */
public class AbstractTest {

    protected void assertSql(SqlPart part, String expectedSql, int expectedObjectCount) {
        String query = part.sql().trim();
        Collection<Object> params = part.params();
        Assert.assertEquals(expectedSql, query);
        Assert.assertEquals(expectedObjectCount, params.size());
    }
}
