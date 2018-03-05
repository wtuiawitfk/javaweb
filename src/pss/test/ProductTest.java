package pss.test;

import org.junit.jupiter.api.Test;
import pss.dao.IProductDAO;
import pss.dao.IProductDirDAO;
import pss.dao.impl.ProductDaoImpl;
import pss.dao.impl.ProductDirDaoImpl;
import pss.domain.Product;
import pss.domain.ProductDir;

import java.math.BigDecimal;
import java.util.List;

public class ProductTest {
    // 创建dao对象
    IProductDAO dao = new ProductDaoImpl();
    IProductDirDAO dirDao = new ProductDirDaoImpl();

    @Test
    public void testSave() {
        Product p = new Product(null,"IKBC G87",  new BigDecimal(399), "IKBC",
                "IKBC", 0.5, new BigDecimal(300),dirDao.get(5L));
        dao.save(p);

    }

    @Test
    public void testDelete() {
        dao.delete(25L);
    }

    //@Test
    //public void testUpdate() {
    //    Product p = new Product(21L, "苹果鼠标", 1L, new BigDecimal(99), "苹果",
    //            "苹果", 0.5, new BigDecimal(66));
    //    dao.update(p);
    //}

    @Test
    public void testGet() {
        Product product = dao.get(1L);
        System.out.println(product);
    }

    @Test
    public void testList() {
        List<Product> list = dao.list();
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
