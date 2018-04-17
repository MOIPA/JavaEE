package C3p0Learn.dao;

import C3p0Learn.DataSourceUtil;
import C3p0Learn.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * dao层的实现 数据持久化操作
 */
public class AccountDaoImpl {

    /**
     * 获得所有用户
     * @param sql sql语句内含有？占位符
     * @param list list是每个占位符该写的东西
     * @return
     */
    public List<Account> selectUsers(String sql, List<Object> list) {
        QueryRunner qr = new QueryRunner();
        try {
            List<Account> accountList = qr.query(DataSourceUtil.getConnection(), sql, new BeanListHandler<Account>(Account.class), list.toArray());
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
