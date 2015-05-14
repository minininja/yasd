package org.dorkmaster.yasd;

import org.dorkmaster.yasd.from.Join;
import org.dorkmaster.yasd.from.Table;
import org.dorkmaster.yasd.select.Limit;
import org.dorkmaster.yasd.select.Order;
import org.dorkmaster.yasd.select.OrderType;
import org.dorkmaster.yasd.where.*;
import org.junit.Test;

import java.util.Date;

/**
 * Tests for the select dsl
 */
public class SelectTest extends AbstractTest {
    @Test
    public void basic() {
        Select select = new Select().column("*").from(new Table("test"));
        assertSql(select, "SELECT * FROM test", 0);
    }

    @Test
    public void multiColumn() {
        Select select = new Select().column("a").column("b").from(new Table("test"));
        assertSql(select, "SELECT a, b FROM test", 0);
    }

    @Test
    public void basicWhere() {
        Select select = new Select().column("*").from(new Table("test")).where(new Eq("a", "a'"));
        assertSql(select, "SELECT * FROM test WHERE a = ?", 1);
    }

    @Test
    public void basicWhereWithAnd() {
        Select select = new Select().column("*").from(new Table("test")).where(new And(new Eq("a", "a'"), new Eq("b", "b")));
        assertSql(select, "SELECT * FROM test WHERE a = ? AND b = ?", 2);
    }

    @Test
    public void complexWhere() {
        Select select = new Select()
                .column("*")
                .from(new Table("test"))
                .where(
                        new And(
                                new Paren(
                                        new Or(
                                                new Eq("a", "a"),
                                                new Gt("b", 0),
                                                new Lt("c", 0),
                                                new GtEq("d", 1),
                                                new Not(
                                                        new LtEq("e", 1)
                                                )
                                        )
                                ),
                                new Paren(
                                        new Or(
                                                new In("f", 1, 2, 3, 4, 5),
                                                new Between("g", new Date(), new Date())
                                        )
                                )
                        )
                );
        assertSql(select, "SELECT * FROM test WHERE (a = ? OR b > ? OR c < ? OR d >= ? OR NOT e <= ?) AND (f IN (?,?,?,?,?) OR (g BETWEEN ? AND ?))", 12);
    }

    @Test
    public void basicTableAndJoin() {
        Select select = new Select()
                .column("*")
                .from(new Table("test"))
                .from(new Join("test", "t", new Eq("t.a", 1)));
        assertSql(select, "SELECT * FROM test JOIN test t ON (t.a = ?)", 1);
    }

    @Test
    public void basicTableWithSelects() {
        Select select = new Select()
                .column("*")
                .from(new Table("test"))
                .limit(new Limit(1))
                .groupBy("a")
                .orderBy("a")
                .orderBy("b", OrderType.DESC);

        assertSql(select, "SELECT * FROM test GROUP BY a ORDER BY a, b DESC LIMIT 1", 0);
    }

}
