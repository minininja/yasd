package org.dorkmaster.yasd.where;

/**
 * Author: mjackson
 * Date: 5/13/15 11:10 PM
 */
public class Paren extends Not {
    public Paren(AbstractCondition condition) {
        super(condition);
    }

    public String sql() {
        return new StringBuilder().append("(").append(condition.sql()).append(")").toString();
    }
}
