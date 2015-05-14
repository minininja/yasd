package org.dorkmaster.yasd.where;

import org.dorkmaster.yasd.Column;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author: mjackson
 * Date: 5/13/15 11:06 PM
 */
public class Between extends AbstractCondition{
    private Column column;
    private List<Object> params = new ArrayList<Object>(2);

    public Between(Column column, Object start, Object end) {
        this.column = column;
        this.params.add(start);
        this.params.add(end);
    }

    public Between(String column, Object start, Object end) {
        this(new Column(column), start, end);
    }

    @Override
    public String sql() {
        // perhaps don't need the parens in here
        return new StringBuilder().append("(").append(column.sql()).append( " BETWEEN ? AND ?)").toString();
    }

    @Override
    public Collection<Object> params() {
        return params;
    }
}
