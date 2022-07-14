package connect;

import tech.tablesaw.api.Table;

import java.sql.SQLException;

public interface IConnect<T> {

    Table connect(String sql, T t) throws ClassNotFoundException, SQLException;
}
