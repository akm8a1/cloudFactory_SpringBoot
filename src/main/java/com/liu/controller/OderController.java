package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.*;
import com.liu.service.*;
import com.liu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author 陆源东
 * 订单Controller
 */
@RestController
public class OderController {
    @Autowired
    private OrderService service;
    @Autowired
    private ContactAddressTabService contact_service;
    @Autowired
    private SchedulingService schedulingService;
    @Autowired
    private SchedulingChildService schedulingChildService;
    @Autowired
    private EquipmentInfoService equipmentInfoService;
    @Autowired
    private LogService logService;

    /**
     * 分页查询订单
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/Orders/{pageCode}/{pageSize}")
    public PageInfo<Order> queryOrders(@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<Order> orders = service.queryAllOrders();
        return new PageInfo<>(orders);
    }

    /**
     * 查询与当前用户（云工厂有关的订单）
     * @param id
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/FactoryOrders/{pageCode}/{pageSize}/{id}")
    public PageInfo<Order> queryFactoryOrders(@PathVariable String id,@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<Order> orders = service.queryFactoryOrdersByUserId(id);
        return new PageInfo<>(orders);
    }

    /**
     * 查询与当前用户（经销商）有关的订单）
     * @param id
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/TraderOrders/{pageCode}/{pageSize}/{id}")
    public PageInfo<Order> queryTraderOrders(@PathVariable String id,@PathVariable int pageCode, @PathVariable  int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<Order> orders = service.queryTraderOrdersByUserId(id);
        return new PageInfo<>(orders);
    }

    /**
     * 根据订单的编号查询
     * @param no
     * @return
     */
    @RequestMapping("/searchOrder/{orderNo}")
    public  List<Order> queryOrderByNo(@PathVariable("orderNo") String no) {
        return service.queryOrderByNo(no);
    }

    /**
     * 新增
     * @param order
     * @return
     */
    @RequestMapping("/addOrder")
    public boolean addOrder(@RequestBody OderAndContact order) {
        int result = 0 ;
        System.out.println(order);
        //观察联系方式是不是新的
        Contact_address_tab contact = new Contact_address_tab();
        contact.setAddress(order.getAddress());
        contact.setContact(order.getMobile());
        contact.setReceptname(order.getReceptname());

        Order o = new Order();
        o.setId(Utils.getUUID());
        o.setOrderno(Utils.getOrderCode());
        o.setProductid(order.getProductid());
        o.setOrdernum(order.getOrdernum());
        o.setDeaddate(order.getDeaddate());
        o.setDeliverDate(order.getDeliverDate());
        o.setOrderstatus(order.getOrderstatus());
        o.setFactoryid(order.getFactoryid());
        o.setTrader_id(order.getTrader_id());
        o.setCreate_time(order.getCreate_time());
        o.setUpdate_time(order.getUpdate_time());
        int count = contact_service.getCountsofContact(contact);
        if (count==0) {
            String contact_id = Utils.getUUID();
            contact.setId(contact_id);
            contact.setCreate_time(order.getUpdate_time());
            contact.setUpdate_time(order.getUpdate_time());
            result = contact_service.addContact_address_tab(contact);
            if (result<=0) {return false;}
            o.setContact_id(contact_id);
            result = service.addOrder(o);
            if (result>0){return true;}
            else {
                contact_service.deleteContact_address_tab(contact_id);
                return false;
            }
        } else {
            //已经有记录，修改这个订单地contact_id就行
            Contact_address_tab c = contact_service.queryContactByCond(contact);
            o.setContact_id(c.getId());
            result = service.addOrder(o);
            if (result<=0) {return false;}
        }
        return true;
    }

    /**
     * 修改
     * @param order
     * @return
     */
    @RequestMapping("/updateOrder")
    public boolean updateOrder(@RequestBody OderAndContact order) {
        int result = 0 ;
        System.out.println(order);
        Contact_address_tab contact = new Contact_address_tab();
        contact.setAddress(order.getAddress());
        contact.setContact(order.getMobile());
        contact.setReceptname(order.getReceptname());

        Order o = new Order();
        o.setId(order.getOrderid());
        o.setProductid(order.getProductid());
        o.setOrdernum(order.getOrdernum());
        o.setDeaddate(order.getDeaddate());
        o.setDeliverDate(order.getDeliverDate());
        o.setFactoryid(order.getFactoryid());
        o.setUpdate_time(order.getUpdate_time());
        int count = contact_service.getCountsofContact(contact);
        if (count==0) {
            String contact_id = Utils.getUUID();
            contact.setId(contact_id);
            contact.setCreate_time(order.getUpdate_time());
            contact.setUpdate_time(order.getUpdate_time());
            result = contact_service.addContact_address_tab(contact);
            if (result<=0) {return false;}
            o.setContact_id(contact_id);
            result = service.updateOrder(o);
            if (result>0){return true;}
            else {
                contact_service.deleteContact_address_tab(contact_id);
                return false;
            }
        } else {
            //已经有记录，修改这个订单地contact_id就行
            Contact_address_tab c = contact_service.queryContactByCond(contact);
            o.setContact_id(c.getId());
            result = service.updateOrder(o);
            if (result<=0) {return false;}
        }
        return true;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteOrder/{id}")
    public boolean deleteOrder(@PathVariable("id")String id) {
        System.out.println(id);
        int result = service.deleteOrder(id);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 所有可竞标订单
     * @param pageCode
     * @param pageSize
     * @param factoryid
     * @return
     */
    @GetMapping("/getOrders/{pageCode}/{pageSize}/{factoryid}")
    public PageInfo<Order> getOrders(@PathVariable int pageCode, @PathVariable  int pageSize,@PathVariable String factoryid) {
        //使用Mybatis分页插件
        System.out.println("123"+factoryid);
        PageHelper.startPage(pageCode,pageSize,true);
        //调用分页查询方法，mybaits自动进行分页的计算
        List<Order> orders = service.queryOrdersBidable(factoryid);
        return new PageInfo<>(orders);
    }

    /**
     * 变更状态
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/modifyStatus/{status}/{id}")
    public boolean modifyStatus(@PathVariable String id,@PathVariable int status) {
        System.out.println("订单状态" + id + status);
        int result = service.updateStatus(id,status);
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 订单排产
     * @param schedulingAndChild
     * @return
     */
    @RequestMapping("/scheduling")
    public boolean scheduling(@RequestBody SchedulingAndChild schedulingAndChild) {
        System.out.println(schedulingAndChild);
        //需要改变订单状态为已排产
        int result = service.updateStatus(schedulingAndChild.getOrderid(),4);
        if (result<=0) {return false;}
        Order order = service.queryOrderById(schedulingAndChild.getOrderid());
        //新增排产记录以及排产子记录
        Scheduling main = new Scheduling();
        String main_id = Utils.getUUID();
        main.setId(main_id);
        main.setOrderid(schedulingAndChild.getOrderid());
        main.setFactoryid(schedulingAndChild.getFactoryid());
        main.setBegindate(schedulingAndChild.getBegindate());
        main.setEnddate(schedulingAndChild.getEnddate());
        main.setCreate_time(schedulingAndChild.getCreate_time());
        main.setUpdate_time(schedulingAndChild.getUpdate_time());
        result = schedulingService.addScheduling(main);
        if (result<=0) {return false;}
        SchedulingChild schedulingChild = new SchedulingChild();
        schedulingChild.setId(Utils.getUUID());
        schedulingChild.setBegindate(schedulingAndChild.getBeginProduceDate());
        schedulingChild.setEnddate(schedulingAndChild.getEndProduceDate());
        schedulingChild.setEquipment_id(schedulingAndChild.getEquipment_id());
        schedulingChild.setMain_id(main_id);
        schedulingChild.setCreate_time(schedulingAndChild.getCreate_time());
        schedulingChild.setUpdate_time(schedulingAndChild.getUpdate_time());
        result = schedulingChildService.addSchedulingChild(schedulingChild);
        if (result<=0) {return false;}
        //修改设备的状态——生产状态
        result = equipmentInfoService.updateStatus(1,schedulingAndChild.getEquipment_id());
        new Thread(){
            @Override
            public void run() {
                Log log = new Log(Utils.getUUID(),Utils.getAdminId(),order.getTrader_id(),"订单"+order.getOrderno()+"已排产，请关注",1);
                logService.addLog(log);
            }
        }.start();
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 完工:需要同时操作订单表与设备表
     * @param orderid
     * @return
     */
    @RequestMapping("/complete/{orderid}")
    public boolean complete(@PathVariable String orderid) {
        //先修改订单状态
        Order order = service.queryOrderById(orderid);
        int result = service.updateStatus(orderid,5);
        if (result<=0) {return false;}
        List<EquipmentInfo> list = equipmentInfoService.queryAllEquipsWithOrder(orderid);
        for (EquipmentInfo equipmentInfo : list) {
            result = equipmentInfoService.updateStatus(2,equipmentInfo.getId());
        }
        new Thread(){
            @Override
            public void run() {
                Log log = new Log(Utils.getUUID(),Utils.getAdminId(),order.getTrader_id(),"订单"+order.getOrderno()+"已完工，请关注",1);
                logService.addLog(log);
            }
        }.start();
        if (result>0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取订单总数
     * @return
     */
    @RequestMapping("/getOrderCounts")
    public int getCounts(){
        return service.getCounts();
    }

    /**
     * 根据订单ID查找订单
     * @param id
     * @return
     */
    @RequestMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable("id") String id) {
        return service.queryOrderById(id);
    }
}
