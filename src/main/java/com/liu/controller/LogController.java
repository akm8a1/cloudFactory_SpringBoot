package com.liu.controller;

import com.liu.pojo.Factory;
import com.liu.pojo.Log;
import com.liu.pojo.Order;
import com.liu.service.FactoryService;
import com.liu.service.LogService;
import com.liu.service.OrderService;
import com.liu.utils.Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author 陆源东
 * 消息日志Controller
 */
@RestController
public class LogController {
    @Autowired
    private LogService logService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private FactoryService factoryService;

    /**
     * 订单发货的记录
     * @param id
     * @return
     */
    @RequestMapping("/addSendLog/{orderid}")
    public boolean addSendOrderLog(@PathVariable("orderid") String id){
        Order order = orderService.queryOrderById(id);
        new Thread(){
            @Override
            public void run() {
                Log log = new Log(Utils.getUUID(),Utils.getAdminId(),order.getTrader_id(),"订单"+order.getOrderno()+"已发货，请关注",1);
                logService.addLog(log);
            }
        }.start();
        return true;
    }

    /**
     * 订单收货的记录
     * @param id
     * @return
     */
    @RequestMapping("/addReceiveLog/{orderid}")
    public boolean addreceiveOrderLog(@PathVariable("orderid") String id){
        Order order = orderService.queryOrderById(id);
        Factory factory = order.getFactory();
        new Thread(){
            @Override
            public void run() {
                Log log = new Log(Utils.getUUID(),Utils.getAdminId(),factory.getUser_id(),"订单"+order.getOrderno()+"已收到，请关注",1);
                logService.addLog(log);
            }
        }.start();
        return true;
    }

    /**
     * 根据用户id返回所有的状态为status未读日志
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/logs/{userid}/{status}")
    public List<Log> getAllUnreadLogs(@PathVariable("userid")String id,@PathVariable("status")int status){
        System.out.println(id);
        System.out.println(status);
        return logService.queryLogsByStatusAndId(id,status);
    }

    /**
     * 改变日志的状态为status
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateLog/{id}/{status}")
    public boolean updateLogStatus(@PathVariable("id")String id,@PathVariable("status")int status) {
        Log log = new Log();
        log.setId(id);
        log.setStatus(status);
        logService.updateLog(log);
        return true;
    }

    /**
     * 给touserid的status日志更改为newstatus
     * @param touserid
     * @param status
     * @param newstatus
     * @return
     */
    @RequestMapping("/udateLog/{touserid}/{status}/{newstatus}")
    public boolean updateAllLogs(@PathVariable("touserid")String touserid,@PathVariable("status")int status,@PathVariable("newstatus")int newstatus){
        logService.updateAllLogs(touserid,status,newstatus);
        return true;
    }

    /**
     * 删除所有status==3的日志
     * @param id
     * @return
     */
    @RequestMapping("/realDelete/{touserid}")
    public boolean realDelete(@PathVariable("touserid")String id) {
        logService.deletDeletedLogsByUserId(id);
        return true;
    }
}
