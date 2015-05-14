package org.dorkmaster.yasd;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: mjackson
 * Date: 5/13/15 10:03 PM
 */
public interface SqlPart {
    String sql();
    Collection<Object> params();
}
