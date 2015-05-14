package org.dorkmaster.yasd.from;

import java.util.Collection;
import java.util.Collections;

/**
 * Author: mjackson
 * Date: 5/13/15 10:09 PM
 */
public class Table extends AbstractFrom {
    String name;

    public Table(String name) {
        this.name = name;
    }

    public String sql() {
        return name;
    }

    public Collection<Object> params() {
        return Collections.emptyList();
    }
}
