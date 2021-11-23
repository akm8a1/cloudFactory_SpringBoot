package com.liu.service;

import com.liu.pojo.ProductCategory;
import com.liu.pojo.SchedulingChild;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品类别Service接口
 */
public interface ProductCategoryService {
    /**
     * 获取所有的产品类型
     * @return
     */
    List<ProductCategory> queryAllProductCategories();

    /**
     * 根据产品类型的名字模糊查询
     * @param likename
     * @return
     */
    List<ProductCategory> queryProductCategoryByLikeName(@Param("likename")String likename);

    /**
     * 增加一个产品类别
     * @param productCategory
     * @return
     */
    int addProductCategory(ProductCategory productCategory);

    /**
     * 修改一个ProductCategory
     * @param productCategory
     * @return
     */
    int updateProductCategory(ProductCategory productCategory);

    /**
     * 删除一个产品类被
     * @param id
     * @return
     */
    int deleteProductCategory(@Param("id") String id);

    /**
     * 总数
     * @return
     */
    int getCounts();

    /**
     * 查找在这个cate下产品的数量
     * @param id
     * @return
     */
    int getProductCounts(String id);
}
