package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.Bid;
import com.liu.pojo.Log;
import com.liu.pojo.Order;
import com.liu.pojo.Product;
import com.liu.service.*;
import com.liu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陆源东
 * 竞标Controller
 */
@RestController
public class BidController {
    @Autowired
    private BidService service;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private FactoryService factoryService;
    @Autowired
    private LogService logService;

    /**
     * 分页查询竞标
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/Bids/{pageCode}/{pageSize}")
    public PageInfo<Bid> queryProducts(@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<Bid> bids= service.queryAllBids();
        return new PageInfo<>(bids);
    }

    /**
     * 根据orderno查询bid查询
     * @param orderno
     * @return
     */
    @RequestMapping("/searchBids/{orderno}")
    public  List<Bid> queryBidByOrderNo(@PathVariable("orderno") String orderno) {
        return service.queryBidsByOrderNo(orderno);
    }

    /**
     * 新增竞标
     * @param bid
     * @return
     */
    @RequestMapping("/addBid")
    public boolean addBid(@RequestBody Bid bid) {
        bid.setId(Utils.getUUID());
        int result = service.addBid(bid);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改
     * @param bid
     * @return
     */
    @RequestMapping("/updateBid")
    public boolean updateBid(@RequestBody Bid bid) {
        int result = service.updateBid(bid);
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
    @RequestMapping("/deleteBid/{id}")
    public boolean deleteBid(@PathVariable("id")String id) {
        System.out.println("i bet my life");
        int result = service.deleteBid(id);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 经销商查找出和自己的订单被竞标的记录
     * @param pageCode
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/TraderBids/{pageCode}/{pageSize}/{id}")
    public PageInfo<Bid> queryTraderBids(@PathVariable int pageCode, @PathVariable  int pageSize,@PathVariable String id) {
        System.out.println(id);
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<Bid> bids= service.queryBidsByTraderUserId(id);
        return new PageInfo<>(bids);
    }

    /**
     * 选标
     * @param factoryid
     * @param bidid
     * @param orderid
     * @return
     */
    @RequestMapping("/selectBid/{factoryid}/{bidid}/{orderid}")
    public boolean selectBid(@PathVariable String factoryid,@PathVariable String bidid,@PathVariable String orderid) {
        System.out.println("factoryid"+factoryid);
        System.out.println("bidid"+bidid);
        System.out.println("order"+orderid);
        Order selectOrder = orderService.queryOrderById(orderid);
        int result = service.selectBid(bidid);
        if (result<=0) {return false;}
        result = orderService.bidComplete(factoryid,orderid);
        List<String> ids = userService.getUserIdByOrderAndBid(orderid);
        for (String id : ids) {
            new Thread(){
                @Override
                public void run() {
                    Log log = new Log(Utils.getUUID(),Utils.getAdminId(),id,"订单"+selectOrder.getOrderno()+"选标已结束，请关注",1);
                    logService.addLog(log);
                }
            }.start();
        }
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获得所有的选标数
     * @return
     */
    @RequestMapping("/getBidCounts")
    public int getCounts(){
        return service.getCounts();
    }
}

