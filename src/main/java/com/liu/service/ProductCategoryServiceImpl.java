package com.liu.service;

import com.liu.mapper.ProductCategoryMapper;
import com.liu.pojo.ProductCategory;
import com.liu.pojo.SchedulingChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品类别Service实现类
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
    @Autowired
    private ProductCategoryMapper mapper;
    @Override
    public List<ProductCategory> queryAllProductCategories() {
        return mapper.queryAllProductCategories();
    }

    @Override
    public List<ProductCategory> queryProductCategoryByLikeName(String likename) {
        return mapper.queryProductCategoryByLikeName(likename);
    }

    @Override
    public int addProductCategory(ProductCategory productCategory) {
        return mapper.addProductCategory(productCategory);
    }

    @Override
    public int updateProductCategory(ProductCategory productCategory) {
        return mapper.updateProductCategory(productCategory);
    }

    @Override
    public int deleteProductCategory(String id) {
        return mapper.deleteProductCategory(id);
    }

    @Override
    public int getCounts() {
        return mapper.getCounts();
    }

    @Override
    public int getProductCounts(String id) {
        return mapper.getProductCounts(id);
    }

}
