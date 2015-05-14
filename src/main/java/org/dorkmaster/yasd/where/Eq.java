package org.dorkmaster.yasd.where;

import org.dorkmaster.yasd.Column;
import org.dorkmaster.yasd.where.AbstractCondition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author: mjackson
 * Date: 5/13/15 10:41 PM
 */
public class Eq extends AbstractCondition {
    protected Column column;
    protected Object param;

    public Eq(Column column, Object param) {
        this.column = column;
        this.param = param;
    }

    public Eq(String column, Object param) {
        this.column = new Column(column);
        this.param = param;
    }

    public String sql() {
        return new StringBuilder(column.sql()).append(" = ?").toString();
    }

    @Override
    public Collection<Object> params() {
        List<Object> result = new ArrayList<Object>(1);
        result.add(param);
        return result;
    }


}
