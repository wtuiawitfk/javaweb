package pss.dao;

import pss.domain.ProductStock;

import java.util.List;


public interface IProductStockDAO {
	/**
	 * 保存的库存
	 * @param ps 需要保存的库存
	 */
	void save(ProductStock ps);

	/**
	 * 删除指定的库存
	 * @param id  删除的库存的编号
	 */
	void delete(Long id);

	/**
	 * 更新指定对象库存信息
	 * @param newPs 新的库存信息
	 */
	void update(ProductStock newPs);

	/**
	 * 查询指定的库存
	 * @param id 查询的库存编号
	 * @return 如果查询的库存编号存在,则返回库存对象信息,如果不存在,则返回null
	 */
	ProductStock get(Long id);

	/**
	 * 查询所有的库存对象信息
	 * @return 如果存在库存对象,则返回库存对象的集合,如果不存在,则返回空集
	 */
	List<ProductStock> list();
}
