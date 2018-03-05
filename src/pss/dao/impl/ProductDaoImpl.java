package pss.dao.impl;

import pss.dao.IProductDAO;
import pss.domain.Product;
import pss.template.JdbcTemplate;
import pss.template.handler.BeanHandler;
import pss.template.handler.BeanListHandler;

import java.util.List;

public class ProductDaoImpl implements IProductDAO {
    public void save(Product p) {

        String sql = "INSERT INTO product(productName,dir_id,salePrice,supplier,brand,cutoff,costPrice) VALUES(?,?,?,?,?,?,?)";
        // 调用模板方法
        JdbcTemplate.update(sql, p.getProductName(), p.getProductDir().getId(),
                p.getSalePrice(), p.getSupplier(), p.getBrand(), p.getCutoff(),
                p.getCostPrice());

    }

    public void delete(Long id) {

        String sql = "DELETE FROM product WHERE id=?";
        // 调用模板方法
        JdbcTemplate.update(sql, id);
    }

    public void update(Product newPro) {

        String sql = "UPDATE product SET productName=?,dir_id=?,salePrice=?,supplier=?,brand=?,cutoff=?,costPrice=? WHERE id= ?";
        JdbcTemplate.update(sql, newPro.getProductName(), newPro.getProductDir().getId(),
                newPro.getSalePrice(), newPro.getSupplier(), newPro.getBrand(),
                newPro.getCutoff(), newPro.getCostPrice(), newPro.getId());
    }

    public Product get(Long id) {

        String sql = "SELECT * FROM product WHERE id=?";
        return JdbcTemplate.query(sql, new BeanHandler<>(Product.class), id);

    }

    public List<Product> list() {

        String sql = "SELECT * FROM product";
        return JdbcTemplate.query(sql, new BeanListHandler<>(Product.class));

    }
}
