package org.dorkmaster.yasd;

import java.util.Collections;
import java.util.List;

/**
 * Author: mjackson
 * Date: 5/13/15 10:15 PM
 */
public class Column implements SqlPart {
    private String name;

    public Column(String name) {
        this.name = name;
    }

    public String sql() {
        return name;
    }

    public List<Object> params() {
        return Collections.emptyList();
    }
}
