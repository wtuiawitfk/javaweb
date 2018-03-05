package pss.test;

import org.junit.jupiter.api.Test;
import pss.dao.IProductDirDAO;
import pss.dao.impl.ProductDirDaoImpl;
import pss.domain.ProductDir;

import java.util.List;

public class ProductDirTest {
    private IProductDirDAO dao = new ProductDirDaoImpl();
    @Test
    void testSave() {
        ProductDir dir = new ProductDir(null, "机械键盘", null);
        dao.save(dir);
    }

    @Test
    void testGet() {
        ProductDir productDir = dao.get(1L);
        System.out.println(productDir);
    }

    @Test
    void testList() {
        List<ProductDir> list = dao.list();
        System.out.println(list);
    }
}
