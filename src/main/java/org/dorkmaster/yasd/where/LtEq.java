package org.dorkmaster.yasd.where;

import org.dorkmaster.yasd.Column;

/**
 * Author: mjackson
 * Date: 5/13/15 11:11 PM
 */
public class LtEq extends Lt {
    public LtEq(Column column, Object param) {
        super(column, param);
    }

    public LtEq(String column, Object param) {
        super(column, param);
    }

    public String sql() {
        return new StringBuilder(column.sql()).append(" <= ?").toString();
    }

}
