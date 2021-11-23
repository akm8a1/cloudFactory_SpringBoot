package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.EquipmentInfo;
import com.liu.pojo.Product;
import com.liu.pojo.User;
import com.liu.service.ProductService;
import com.liu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author 陆源东
 * 产品Controller
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    /**
     * 分页查询产品
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/products/{pageCode}/{pageSize}")
    public PageInfo<Product> queryProducts(@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<Product> products = service.queryAllProducts();
        return new PageInfo<>(products);
    }

    /**
     * 查询所有产品
     * @return
     */
    @GetMapping("/products")
    public List<Product> Products() {
        return service.queryAllProducts();
    }

    /**
     * 模糊查询
     * @param likename
     * @return
     */
    @RequestMapping("/searchProducts/{likename}")
    public  List<Product> queryProductByLikeName(@PathVariable("likename") String likename) {
        return service.queryProductByName(likename);
    }

    /**
     * 新增
     * @param product
     * @return
     */
    @RequestMapping("/addProduct")
    public boolean addProduct(@RequestBody Product product) {
        product.setId(Utils.getUUID());
        product.setProductno(Utils.getProductCode());
        System.out.println(product);
        int result = service.addProduct(product);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改
     * @param product
     * @return
     */
    @RequestMapping("/updateProduct")
    public boolean updateProduct(@RequestBody Product product) {
        int result = service.updateProduct(product);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteProduct/{id}")
    public boolean deleteProduct(@PathVariable("id")String id) {
        int result = service.deleteProduct(id);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取产品数量
     * @return
     */
    @RequestMapping("/getProCounts")
    public int getCounts(){
        return service.getCounts();
    }
}
