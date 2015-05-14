package org.dorkmaster.yasd.select;

import org.dorkmaster.yasd.SqlPart;

import java.util.Collection;
import java.util.Collections;

/**
 * Author: mjackson
 * Date: 5/13/15 11:46 PM
 */
public class Limit implements SqlPart {
    private int limit;

    public Limit(int limit) {
        this.limit = limit;
    }

    @Override
    public String sql() {
        return new StringBuilder().append("LIMIT ").append(limit).toString();
    }

    @Override
    public Collection<Object> params() {
        return Collections.emptyList();
    }
}
