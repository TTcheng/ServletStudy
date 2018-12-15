import com.wangchuncheng.ConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTester {
    @Test
    public void testConnection() throws SQLException {
        ConnectionFactory connectionFactory= ConnectionFactory.getInstance();
        Connection connection = connectionFactory.makeConnection();
        System.out.println(connection.getAutoCommit());
    }
}
