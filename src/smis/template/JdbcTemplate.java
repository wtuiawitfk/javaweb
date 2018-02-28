package smis.template;

import com.sun.tools.javac.util.Name;
import smis.dao.IResultHandler;
import smis.domain.Column;
import smis.domain.Table;
import smis.util.JdbcUtil;

import javax.swing.text.StyledEditorKit;
import java.beans.*;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作通用模版
 */
public class JdbcTemplate {
    /**
     * DML操作模版
     *
     * @param sql   数据库操作语句
     * @param parms 参数
     * @return 影响的行号
     */
    public static int update(String sql, Object... parms) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parms.length; i++) {
                ps.setObject(i + 1, parms[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn, ps, null);
        }
        return 0;
    }

    public static void save(Object obj) throws Exception {
        StringBuffer bs = new StringBuffer(80);
        List<String> parms = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        bs.append("insert into ");
        String tableName;
        if (obj.getClass().isAnnotationPresent(Table.class)) {
            tableName = obj.getClass().getAnnotation(Table.class).value();
        } else {
            throw new RuntimeException("类上没有表标签");
        }
        bs.append(tableName + "(");
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd :
                pds) {
            String name = pd.getName();
            Field columnName = obj.getClass().getDeclaredField(name);
            if (columnName.isAnnotationPresent(Column.class)) {
                String parm = columnName.getAnnotation(Column.class).value();
                parms.add(parm);
                Object value = pd.getReadMethod().invoke(obj);
                values.add(value);
            }
        }
        for (int i = 0; i < parms.size(); i++) {
            if (i == parms.size() - 1) {
                bs.append(parms.get(i) + ") ");
                break;
            }
            bs.append(parms.get(i) + ",");
        }
        bs.append("values(");
        for (int i = 0; i < values.size(); i++) {
            if (i == values.size() - 1) {
                bs.append("?" + ");");
                break;
            }
            bs.append("?" + ",");
        }
        System.out.println(bs.toString());
        System.out.println(values);
        update(bs.toString(), values.toArray());
    }

    public static <T> T query(String sql, IResultHandler<T> res,Object...parms) {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parms.length; i++) {
                ps.setObject(i + 1, parms[i]);
            }
            rs = ps.executeQuery();
            T result = res.handle(rs);
            return result;
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
