package connect.impl;

import connect.IConnect;
import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaPlus;
import tech.tablesaw.api.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author hang.jia
 */
public class CalciteSimple<T extends schema.Schema> implements IConnect<T> {

    @Override
    public Table connect(String sql, T t) throws ClassNotFoundException, SQLException {
        //创建Calcite Connection对象
        Class.forName("org.apache.calcite.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        try (
                Connection connection = DriverManager.getConnection("jdbc:calcite:", info);
                CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);
                Statement statement = calciteConnection.createStatement();

        ) {
            SchemaPlus rootSchema = calciteConnection.getRootSchema();
            Schema schema = new ReflectiveSchema(t);
            rootSchema.add(t.getName(), schema);
            return Table.read().db(statement.executeQuery(sql));
        }
    }
}
