package org.dorkmaster.yasd.where;

/**
 * Author: mjackson
 * Date: 5/13/15 11:06 PM
 */
public class Or extends And {

    public Or(AbstractCondition... conditions) {
        super(conditions);
    }

    public String sql() {
        return join(conditions, " OR ");
    }
}
