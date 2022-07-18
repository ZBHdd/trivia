package connect;

import tech.tablesaw.api.Table;

import java.sql.SQLException;

/**
 * @author hang.jia
 */
public interface IConnect<T> {

    /**
     * get table from sql by connect db
     * @param sql
     * @param t
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    Table connect(String sql, T t) throws ClassNotFoundException, SQLException;
}
