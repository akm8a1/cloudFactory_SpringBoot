package com.liu.service;

import com.liu.pojo.EquipmentInfo;
import com.liu.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author 刘源栋
 * 订单Service接口
 */
public interface OrderService {
    /**
     * 获取所有订单
     * @return  所有订单列表
     */
    List<Order> queryAllOrders();

    /**
     * 根据订单编号获取订单
     * @param no 订单编号
     * @return 根据OrderNo获取Order
     */
    List<Order> queryOrderByNo(@Param("no")String no);

    /**
     * 增加一条订单
     * @param order 增加的订单
     * @return 操作是否成功
     */
    int addOrder(Order order);

    /**
     * 修改一条订单
     * @param order 修改的订单信息
     * @return 操作是否成功
     */
    int updateOrder(Order order);

    /**
     * 删除一条订单
     * @param id 订单id
     * @return 操作是否成功
     */
    int deleteOrder(@Param("id")String id);
    /**
     * 根据用户id给出工厂与自己有关的订单
     * @param id 用户id
     * @return 某工厂的所有订单
     */
    List<Order> queryFactoryOrdersByUserId(@Param("id")String id);
    /**
     * 根据用户id给出经销商自己有关的订单
     * @param id 用户id
     * @return 订单列表
     */
    List<Order> queryTraderOrdersByUserId(@Param("id")String id);
    /**
     * 找出所有的可竞标订单
     * @param id id
     * @return 订单列表
     */
    List<Order> queryOrdersBidable(String id);

    /**
     * @param id 订单id
     * @param status 修改的status
     * @return 操作成功与否
     */
    int updateStatus(@Param("id")String id,@Param("status")int status);

    /**
     * 订单被竞标完成
     * @param factoryid 工厂id
     * @param orderid 订单id
     * @return
     */
    int bidComplete(@Param("factoryid")String factoryid,@Param("orderid")String orderid);

    /**
     * 订单总数
     * @return
     */
    int getCounts();

    /**
     * 根据id查找order
     * @param id 订单id
     * @return 相应的订单
     */
    Order queryOrderById(@Param("id") String id);
}
