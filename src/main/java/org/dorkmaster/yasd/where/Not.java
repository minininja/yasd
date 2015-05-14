package org.dorkmaster.yasd.where;

import java.util.Collection;

/**
 * Author: mjackson
 * Date: 5/13/15 11:06 PM
 */
public class Not extends AbstractCondition {
    protected AbstractCondition condition;

    public Not(AbstractCondition condition) {
        this.condition = condition;
    }

    public String sql() {
        return new StringBuilder().append("NOT ").append(condition.sql()).toString();
    }

    public Collection<Object> params() {
        return condition.params();
    }
}
