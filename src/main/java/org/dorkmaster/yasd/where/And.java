package org.dorkmaster.yasd.where;

import java.util.Collection;
import java.util.List;

/**
 * Author: mjackson
 * Date: 5/13/15 10:58 PM
 */
public class And extends AbstractCondition {
    protected  List<AbstractCondition> conditions = null;

    public And(AbstractCondition... conditions) {
        this.conditions = toConditionList(conditions);
    }

    public String sql() {
        return join(conditions, " AND ");
    }

    public Collection<Object> params() {
        return processParams(conditions);
    }
}
