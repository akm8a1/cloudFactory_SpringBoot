package com.liu.mapper;

import com.liu.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单Mapper
 */
@Mapper
@Repository
public interface OrderMapper {
    /**
     * 获取所有Order
     * @return
     */

    List<Order> queryAllOrders();

    /**
     * 根据OrderNo获取Order
     * @param no
     * @return
     */

    List<Order> queryOrderByNo(@Param("no")String no);

    /**
     * 增加一条订单
     * @param order
     * @return
     */

    int addOrder(Order order);

    /**
     * 修改一条订单
     * @param order
     * @return
     */

    int updateOrder(Order order);

    /**
     * 删除一条订单
     * @param id
     * @return
     */

    int deleteOrder(@Param("id")String id);

    /**
     * 根据用户id给出工厂与自己有关的订单
     * @param id
     * @return
     */

    List<Order> queryFactoryOrdersByUserId(@Param("id")String id);

    /**
     * 根据用户id给出经销商自己有关的订单
     * @param id
     * @return
     */

    List<Order> queryTraderOrdersByUserId(@Param("id")String id);

    /**
     * 找出所有的可竞标订单
     * @param id
     * @return
     */

    List<Order> queryOrdersBidable(@Param("factoryid") String id);

    /**
     * 变更状态
     * @param id
     * @param status
     * @return
     */

    int updateStatus(@Param("id")String id,@Param("status")int status);

    /**
     * 订单被竞标完成
     * @param factoryid
     * @param orderid
     * @return
     */

    int bidComplete(@Param("factoryid")String factoryid,@Param("orderid")String orderid);

    /**
     * 总数
     * @return
     */

    int getCounts();

    /**
     * 根据id查找order
     * @param id
     * @return
     */
    /*根据id查找order*/
    Order queryOrderById(@Param("id") String id);
}
