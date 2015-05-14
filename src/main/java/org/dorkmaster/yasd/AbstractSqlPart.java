package org.dorkmaster.yasd;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: mjackson
 * Date: 5/13/15 10:04 PM
 */
public abstract class AbstractSqlPart implements SqlPart {
    protected String join(Collection<? extends SqlPart> parts, String delimiter) {
        StringBuilder sb = new StringBuilder();

        for (SqlPart part : parts) {
            if (sb.length() != 0) {
                sb.append(delimiter);
            }
            sb.append(part.sql());
        }

        return sb.toString();
    }

    protected List<Object> assembleParams(Collection<? extends SqlPart> parts) {
        return assembleParams(new LinkedList<Object>(), parts);
    }

    protected List<Object> assembleParams(List<Object> startingList, Collection<? extends SqlPart> parts) {
        for (SqlPart part : parts) {
            startingList.addAll(part.params());
        }
        return startingList;
    }

    protected List<Object> assembleParams(SqlPart part) {
        return assembleParams(new LinkedList<Object>(), part);
    }

    protected List<Object> assembleParams(List<Object> startingList, SqlPart part) {
        startingList.addAll(part.params());
        return startingList;
    }

}
