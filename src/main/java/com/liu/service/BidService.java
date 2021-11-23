package com.liu.service;

import com.liu.pojo.Bid;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 竞标Service接口
 */
public interface BidService {
    /**
     * 获取全部的Bid
     * @return
     */
    List<Bid> queryAllBids();

    /**
     * 增加一条数据
     * @param bid
     * @return
     */
    int addBid(Bid bid);

    /**
     * 删除一条数据
     * @param id
     * @return
     */
    int deleteBid(@Param("id") String id);

    /**
     * 修改一条数据
     * @param bid
     * @return
     */
    int updateBid(Bid bid);

    /**
     * 根据orderno获取竞标记录
     * @param orderno
     * @return
     */
    List<Bid> queryBidsByOrderNo(@Param("orderno") String orderno);

    /**
     * 经销商找到和自己有关的订单
     * @param id
     * @return
     */
    List<Bid> queryBidsByTraderUserId(@Param("userid") String id);

    /**
     * 选标
     * @param id
     * @return
     */
    int selectBid(String id);

    /**
     * 总数
     * @return
     */
    int getCounts();
}
