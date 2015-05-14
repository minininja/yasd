package org.dorkmaster.yasd.where;

import org.dorkmaster.yasd.AbstractSqlPart;
import org.dorkmaster.yasd.from.AbstractFrom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: mjackson
 * Date: 5/13/15 10:19 PM
 */
public abstract class AbstractCondition extends AbstractSqlPart {

    protected List<AbstractCondition> toConditionList(AbstractCondition[] conditions) {
        List<AbstractCondition> result = new ArrayList<AbstractCondition>(conditions.length);
        for (AbstractCondition ac : conditions) {
            result.add(ac);
        }
        return result;
    }

    protected List<Object> toObjectList(Object[] objs) {
        List<Object> result = new ArrayList<Object>(objs.length);
        for (Object obj : objs) {
            result.add(obj);
        }
        return result;
    }

    protected List<Object> processParams(List<? extends AbstractCondition> conditions) {
        List<Object> result = new LinkedList<Object>();
        for (AbstractCondition ac : conditions) {
            result.addAll(ac.params());
        }
        return result;
    }
}
