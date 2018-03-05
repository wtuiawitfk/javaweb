package pss.template.handler;

import pss.dao.IProductDirDAO;
import pss.dao.IResultHandler;
import pss.dao.impl.ProductDirDaoImpl;
import pss.domain.ProductDir;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;


public class BeanHandler<T> implements IResultHandler {
    private Class<T> classType;
    private IProductDirDAO dao = new ProductDirDaoImpl();

    public BeanHandler(Class classType) {
        this.classType = classType;
    }
    @Override
    public T handle(ResultSet rs) throws Exception {
        if (rs.next()) {
            T obj = classType.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(classType, Object.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd :
                    propertyDescriptors) {
                String name = pd.getName();
                if ("productDir".equals(name)) {
                    long dir_id = rs.getLong("dir_id");
                    ProductDir productDir = dao.get(dir_id);
                    pd.getWriteMethod().invoke(obj, productDir);
                } else {
                    Object value = rs.getObject(name);
                    pd.getWriteMethod().invoke(obj, value);
                }
            }
            return obj;
        }
        return null;
    }
}
