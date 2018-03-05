package pss.dao;

import pss.domain.Product;

import java.math.BigDecimal;
import java.util.List;



// 商品类的规范
public interface IProductDAO {
	/**
	 * 保存的商品对象
	 * @param p 需要保存的商品对象
	 */
	void save(Product p);

	/**
	 * 删除指定的商品对象
	 * @param id  删除的商品的编号
	 */
	void delete(Long id);

	/**
	 * 更新指定对象商品对象信息
	 * @param newPro 新的商品对象信息
	 */
	void update(Product newPro);

	/**
	 * 查询指定的商品信息
	 * @param id 查询的商品编号
	 * @return 如果查询的商品编号存在,则返回商品对象信息,如果不存在,则返回null
	 */
	Product get(Long id);

	/**
	 * 查询所有的商品对象信息
	 * @return 如果存在商品对象,则返回商品对象的集合,如果不存在,则返回空集
	 */
	List<Product> list();

	/**
	 * 高级查询
	 * @param productName 商品的名称 
	 * @param minSalePrice 最低零售价
	 * @param maxSalePrice 最高零售价
	 * @return 高级查询的商品的集合
	 */
	//List<Product> query1(String productName, BigDecimal minSalePrice,
     //                    BigDecimal maxSalePrice);
    //
	//List<Product> query(ProductQueryObject qo);
    //
	///**
	// * 分页查询
	// * @param currentPage 用户传递的当前页
	// * @param pageSize 用户传递的页面大小
	// * @return 返回分页的结果对象
	// */
	//PageResult page(Integer currentPage, Integer pageSize);
    //
	///**
	// * 高级查询+分页
	// * @param qo 高级查询的数据和分页的数据
	// * @return 返回分页之后的结果
	// */
	//PageResult pageQuery(ProductQueryObject qo);
}
