package org.dorkmaster.yasd.select;

import org.dorkmaster.yasd.Column;
import org.dorkmaster.yasd.SqlPart;

import java.util.Collection;
import java.util.Collections;

/**
 * Author: mjackson
 * Date: 5/13/15 11:50 PM
 */
public class Order implements SqlPart {
    private Column column;
    private OrderType order;

    public Order(Column column, OrderType order) {
        this.column = column;
        this.order = order;
    }

    public Order(Column column) {
        this(column, null);
    }

    public Order(String column, OrderType order) {
        this(new Column(column), order = order);
    }

    public Order(String column) {
        this(column, null);
    }

    @Override
    public String sql() {
        return new StringBuilder(column.sql()).append(order != null ? " " : "").append(order != null ? order.toString() : "").toString();
    }

    @Override
    public Collection<Object> params() {
        return Collections.emptyList();
    }
}

