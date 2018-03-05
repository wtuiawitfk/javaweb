package pss.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
    private static DataSource ds;
    static {
        Properties p = new Properties();
        try {
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            String driverClassName = p.getProperty("driverClassName");
            Class.forName(driverClassName);
            ds=DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            throw new RuntimeException("加载文件失败！", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载驱动失败", e);
        } catch (Exception e) {
            throw new RuntimeException("加载接连池失败", e);
        }

    }

    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                if (st != null) {
                    try {
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    private JdbcUtil() {

    }
}
