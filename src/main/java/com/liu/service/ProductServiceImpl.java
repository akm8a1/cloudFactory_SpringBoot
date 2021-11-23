package com.liu.service;

import com.liu.mapper.ProductMapper;
import com.liu.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品Servuce实现类
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper mapper;
    @Override
    public List<Product> queryAllProducts() {
        return mapper.queryAllProducts();
    }

    @Override
    public List<Product> queryProductByName(String likename) {
        return mapper.queryProductByName(likename);
    }

    @Override
    public int addProduct(Product product) {
        return mapper.addProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return mapper.updateProduct(product);
    }

    @Override
    public int deleteProduct(String id) {
        return mapper.deleteProduct(id);
    }

    @Override
    public int getCounts() {
        return mapper.getCounts();
    }
}
