package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.EquipmentCategory;
import com.liu.pojo.ProductCategory;
import com.liu.service.ProductCategoryService;
import com.liu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author 陆源东
 * 产品类别Controller
 */
@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService service;

    /**
     * 分页查询产品
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/productCategory/{pageCode}/{pageSize}")
    public PageInfo<ProductCategory> queryProductCategories(@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<ProductCategory> categories = service.queryAllProductCategories();
        return new PageInfo<>(categories);
    }

    /**
     * 获取所有的产品
     * @return
     */
    @GetMapping("/productCategory")
    public List<ProductCategory> queryProductCategories() {
        List<ProductCategory> categories = service.queryAllProductCategories();
        return categories;
    }

    /**
     * 模糊查询
     * @param catename
     * @return
     */
    @GetMapping("/searchProductCategory/{catename}")
    public List<ProductCategory> queryProductCategoryByLikeName(@PathVariable("catename")String catename) {
        System.out.println(catename);
        List<ProductCategory> list = service.queryProductCategoryByLikeName(catename);
        return list;
    }

    /**
     * 新增
     * @param productCategory
     * @return
     */
    @PostMapping("/addProductCategory")
    public boolean addProductCategory(@RequestBody ProductCategory productCategory){
        productCategory.setId(Utils.getUUID());
        int result = service.addProductCategory(productCategory);
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
    @RequestMapping("/deleteProductCategory/{id}")
    public boolean deleteEProductCategory(@PathVariable("id") String id){
        int result = service.deleteProductCategory(id);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改
     * @param productCategory
     * @return
     */
    @PostMapping("/updateProductCategory")
    public boolean updateProductCategory(@RequestBody ProductCategory productCategory){
        int result = service.updateProductCategory(productCategory);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取某类别下产品的数量
     * @return
     */
    @RequestMapping("/getProCateCounts")
    public int getCounts(){
        return service.getCounts();
    }

    /**
     * 获取某类别下设备的数量
     * @param id
     * @return
     */
    @RequestMapping("/productCountsInCate/{id}")
    public boolean getProductCountsInCate(@PathVariable("id")String id) {
        int result = service.getProductCounts(id);
        System.out.println(result);
        if (result>0) {
            return false;
        } else {
            return true;
        }
    }
}
