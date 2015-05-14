package org.dorkmaster.yasd.from;

import org.dorkmaster.yasd.where.AbstractCondition;

import java.util.Collection;

/**
 * Author: mjackson
 * Date: 5/13/15 11:35 PM
 */
public class Join extends AbstractFrom {
    private String alias = null;
    private AbstractCondition on = null;
    private Table table = null;
    private JoinType type = null;

    public Join(JoinType type, String table, String alias, AbstractCondition on) {
        this(type, new Table(table), alias, on);
    }

    public Join(JoinType type, Table table, String alias, AbstractCondition on) {
        this.type = type;
        this.table = table;
        this.alias = alias;
        this.on = on;
    }

    public Join(Table table, String alias, AbstractCondition on) {
        this(null, table, alias, on);
    }

    public Join(Table table, AbstractCondition on) {
        this(null, table, null, on);
    }

    public Join(JoinType type, Table table, AbstractCondition on) {
        this(null, table, null, on);
    }

    public Join(String table, String alias, AbstractCondition on) {
        this(null, table, alias, on);
    }

    public Join(JoinType type, String table, AbstractCondition on) {
        this(type, table, null, on);
    }

    public Join(String table, AbstractCondition on) {
        this(null, table, null, on);
    }

    @Override
    public Collection<Object> params() {
        return on.params();
    }

    @Override
    public String sql() {
        assert (table != null && on != null);
        StringBuilder sb = new StringBuilder("JOIN ");
        if (type != null) {
            sb.append(type.toString()).append(" ");
        }
        sb.append(table.sql()).append(" ");
        if (alias != null) {
            sb.append(alias).append(" ");
        }
        sb.append("ON (").append(on.sql()).append(")");
        return sb.toString();
    }
}
