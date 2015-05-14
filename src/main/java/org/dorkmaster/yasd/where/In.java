package org.dorkmaster.yasd.where;

import org.dorkmaster.yasd.Column;

import java.util.Collection;
import java.util.List;

/**
 * Author: mjackson
 * Date: 5/13/15 11:06 PM
 */
public class In extends AbstractCondition {
    private Column column;
    private List<Object> params;

    public In(Column column, Object... params) {
        this.column = column;
        this.params = toObjectList(params);
    }

    public In(String column, Object... params) {
        this(new Column(column), params);
    }

    @Override
    public String sql() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < params.size(); i++) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append("?");
        }
        return sb.insert(0, " IN (").insert(0, column.sql()) .append(")").toString();
    }

    @Override
    public Collection<Object> params() {
        return params;
    }
}
