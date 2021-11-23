package com.liu.service;

import com.liu.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *产品Servuce接口
 */
public interface ProductService {
    /**
     * 查找所有的产品
     * @return
     */
    List<Product> queryAllProducts();

    /**
     * 根据产品名字模糊查询产品
     * @param likename
     * @return
     */
    List<Product> queryProductByName(@Param("likename")String likename);

    /**
     * 增加一个产品
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 修改一个产品
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 删除一个产品
     * @param id
     * @return
     */
    int deleteProduct(@Param("id")String id);

    /**
     * 总数
     * @return
     */
    int getCounts();
}
