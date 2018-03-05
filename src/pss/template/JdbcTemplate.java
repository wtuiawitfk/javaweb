package pss.template;

import pss.dao.IResultHandler;
import pss.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
    public static void update(String sql, Object... parms) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parms.length; i++) {
                ps.setObject(i + 1, parms[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, ps, null);
        }
    }

    public static <T> T query(String sql, IResultHandler res, Object... parms) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parms.length; i++) {
                ps.setObject(i + 1, parms[i]);
            }
            rs = ps.executeQuery();
            T obj = (T) res.handle(rs);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn, ps, rs);
        }
        return null;
    }

    private JdbcTemplate() {

    }
}
