package smis.handler;

import smis.dao.IResultHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHandler<T> implements IResultHandler {
    private Class<T> classType;

    public BeanHandler(Class classType) {
        this.classType = classType;
    }

    @Override
    public T handle(ResultSet res) throws Exception {
        if (res.next()) {
            T obj = classType.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(classType, Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd :
                    pds) {
                String name = pd.getName();
                Object value = res.getObject(name);
                pd.getWriteMethod().invoke(obj, value);
            }
            return obj;
        }
        return null;
    }
}
