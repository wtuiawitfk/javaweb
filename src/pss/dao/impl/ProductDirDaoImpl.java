package pss.dao.impl;

import pss.dao.IProductDirDAO;
import pss.domain.ProductDir;
import pss.template.JdbcTemplate;
import pss.template.handler.BeanHandler;
import pss.template.handler.BeanListHandler;

import java.util.List;

public class ProductDirDaoImpl implements IProductDirDAO{
    @Override
    public void save(ProductDir pd) {
        String sql = "INSERT INTO product_dir(dirname,parent_id) values(?,?)";
        JdbcTemplate.update(sql, pd.getDirName(), pd.getParent_id());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM product_dir WHERE id=?";
        JdbcTemplate.update(sql, id);
    }

    @Override
    public void update(ProductDir newPd) {
        String sql = "UPDATE product_dir SET dirName=?,parent_id=? WHERE id=?";
        JdbcTemplate.update(sql, newPd.getDirName(), newPd.getParent_id(), newPd.getId());
    }

    @Override
    public ProductDir get(Long id) {
        System.out.println("-------------------------");
        String sql = "SELECT * FROM product_dir WHERE id=?";
        ProductDir query = JdbcTemplate.query(sql, new BeanHandler(ProductDir.class), id);
        return query;
    }

    @Override
    public List<ProductDir> list() {
        String sql = "SELECT * FROM product_dir";
        List<ProductDir> list = JdbcTemplate.query(sql, new BeanListHandler(ProductDir.class));
        return list;
    }
}
