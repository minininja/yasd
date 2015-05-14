package org.dorkmaster.yasd.where;

import org.dorkmaster.yasd.Column;

/**
 * Author: mjackson
 * Date: 5/13/15 11:11 PM
 */
public class GtEq extends Gt {
    public GtEq(Column column, Object param) {
        super(column, param);
    }

    public GtEq(String column, Object param) {
        super(column, param);
    }

    public String sql() {
        return new StringBuilder(column.sql()).append(" >= ?").toString();
    }

}
