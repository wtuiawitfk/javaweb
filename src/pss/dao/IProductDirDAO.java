package pss.dao;

import pss.domain.ProductDir;

import java.util.List;





public interface IProductDirDAO {
	/**
	 * 保存的商品分类
	 * @param pd 需要保存的商品分类
	 */
	void save(ProductDir pd);

	/**
	 * 删除指定的商品分类
	 * @param id  删除的商品分类的编号
	 */
	void delete(Long id);

	/**
	 * 更新指定对象商品分类信息
	 * @param newPd 新的商品分类信息
	 */
	void update(ProductDir newPd);

	/**
	 * 查询指定的商品分类
	 * @param id 查询的商品分类编号
	 * @return 如果查询的商品分类编号存在,则返回商品分类对象信息,如果不存在,则返回null
	 */
	ProductDir get(Long id);

	/**
	 * 查询所有的商品分类对象信息
	 * @return 如果存在商品分类对象,则返回商品分类对象的集合,如果不存在,则返回空集
	 */
	List<ProductDir> list();
}
