package smis.handler;

import smis.dao.IResultHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListHandler<T> implements IResultHandler {
    private Class<T> classType;

    public ListHandler(Class classType) {
        this.classType = classType;
    }
    @Override
    public List<T> handle(ResultSet res) throws Exception {
        List<T> objs = new ArrayList<>();
        while (res.next()) {
            T obj = classType.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd :
                    pds) {
                String name = pd.getName();
                Object value = res.getObject(name);
                pd.getWriteMethod().invoke(obj, value);
            }
            objs.add(obj);
        }
        return objs;
    }
}
