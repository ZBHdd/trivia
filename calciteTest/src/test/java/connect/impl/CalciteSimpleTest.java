package connect.impl;

import org.junit.Before;
import org.junit.Test;
import schema.TestSchema;
import tech.tablesaw.api.Table;

import java.sql.SQLException;


public class CalciteSimpleTest {
    TestSchema schema;
    CalciteSimple<TestSchema> calciteSimple;

    @Before
    public void Before() {
        schema = new TestSchema();
        calciteSimple = new CalciteSimple<>();
    }

    @Test
    public void testConnect() throws SQLException, ClassNotFoundException {
        Table db = calciteSimple.connect("select u.id,u.name from test.users u", schema);
        db.printAll();
    }
}