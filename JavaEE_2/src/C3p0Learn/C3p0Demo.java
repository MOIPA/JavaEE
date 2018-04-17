package C3p0Learn;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3p0Demo {
    public static void main(String[] args) throws SQLException {
//        DataSource dataSource = DataSourceUtil.getDataSource();
//        Connection connection = dataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from testuser");
//        boolean execute = preparedStatement.execute();
//        System.out.println(execute);
        QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
        Object[] query = queryRunner.query("select * from Account", new ArrayHandler());
        System.out.println(query);

        for (Object o : query) {
            System.out.println(o);
        }
    }
}
