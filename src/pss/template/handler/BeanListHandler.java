package pss.template.handler;

import pss.dao.IProductDirDAO;
import pss.dao.IResultHandler;
import pss.dao.impl.ProductDirDaoImpl;
import pss.domain.ProductDir;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanListHandler<T> implements IResultHandler {
    private Class<T> classType;
    private IProductDirDAO dao = new ProductDirDaoImpl();
    private Map<Long, ProductDir> dirMap = new HashMap<>();

    public BeanListHandler(Class<T> classType) {
        this.classType = classType;
    }

    @Override
    public T handle(ResultSet rs) throws Exception {
        List<T> list = new ArrayList<>();
        while (rs.next()) {
            T obj = classType.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(classType, Object.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd :
                    propertyDescriptors) {
                String name = pd.getName();
                if ("productDir".equals(name)) {
                    Long id = (Long) rs.getObject("dir_id");
                    if (dirMap.containsKey(id)) {
                        ProductDir productDir = dirMap.get(id);
                        pd.getWriteMethod().invoke(obj, productDir);
                    } else {
                        ProductDir productDir = dao.get(id);
                        dirMap.put(id, productDir);
                    }
                } else {
                    Object value = rs.getObject(name);
                    pd.getWriteMethod().invoke(obj, value);
                }
            }
            list.add(obj);
        }
        return (T) list;
    }
}
