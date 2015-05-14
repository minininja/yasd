package org.dorkmaster.yasd;

import org.dorkmaster.yasd.from.AbstractFrom;
import org.dorkmaster.yasd.from.Join;
import org.dorkmaster.yasd.from.Table;
import org.dorkmaster.yasd.select.Limit;
import org.dorkmaster.yasd.select.Order;
import org.dorkmaster.yasd.select.OrderType;
import org.dorkmaster.yasd.where.AbstractCondition;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Ye olde code based DSL for select statements
 * Author: mjackson
 * Date: 5/13/15 10:01 PM
 */
public class Select extends AbstractSqlPart {

    private List<Column> fields = new LinkedList<Column>();
    private List<AbstractFrom> table = new LinkedList<AbstractFrom>();
    private List<AbstractFrom> join = new LinkedList<AbstractFrom>();
    private AbstractCondition where = null;
    private List<Order> orderBy = new LinkedList<Order>();
    private Limit limit = null;
    private List<Column> groupBy = new LinkedList<Column>();

    public Select column(String name) {
        fields.add(new Column(name));
        return this;
    }

    public Select from(AbstractFrom from) {
        if (from instanceof Table) {
            this.table.add(from);
        } else if (from instanceof Join) {
            this.join.add(from);
        }
        return this;
    }

    public Select where(AbstractCondition condition) {
        this.where = condition;
        return this;
    }

    public Select orderBy(String column) {
        orderBy(column, null);
        return this;
    }

    public Select orderBy(String column, OrderType order) {
        orderBy.add(new Order(column, order));
        return this;
    }

    public Select limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    public Select groupBy(String column) {
        this.groupBy.add(new Column(column));
        return this;
    }

    public String sql() {
        // the minimum is the fields and from must be > 0
        assert (fields.size() > 0 && table.size() > 0);

        StringBuilder sb = new StringBuilder()
                .append("SELECT ")
                .append(join(fields, ", "))
                .append(" FROM ")
                .append(join(table, ", "));

        if (join.size() > 0) {
            sb.append(" ").append(join(join, " "));
        }

        // optional bits
        if (where != null) {
            sb.append(" WHERE ").append(where.sql());
        }

        if (groupBy.size() > 0) {
            sb.append(" GROUP BY ").append(join(groupBy, ", "));
        }

        if (orderBy.size() > 0) {
            sb.append(" ORDER BY ").append(join(orderBy, ", "));
        }

        if (limit != null) {
            sb.append(" ").append(limit.sql());
        }

        return sb.toString();
    }

    public Collection<Object> params() {
        assert (table.size() > 0);
        List<Object> params = assembleParams(table);
        if (join.size() > 0) {
            assembleParams(params, join);
        }
        if (where != null) {
            assembleParams(params, where);
        }
        return params;
    }
}
