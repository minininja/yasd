package org.dorkmaster.yasd.where;

import org.dorkmaster.yasd.Column;

/**
 * Author: mjackson
 * Date: 5/13/15 11:06 PM
 */
public class Gt extends Eq {
    public Gt(Column column, Object param) {
        super(column, param);
    }

    public Gt(String column, Object param) {
        super(column, param);
    }

    public String sql() {
        return new StringBuilder(column.sql()).append(" > ?").toString();
    }
}
