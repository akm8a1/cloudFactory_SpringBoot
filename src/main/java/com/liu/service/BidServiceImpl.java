package com.liu.service;

import com.liu.mapper.BidMapper;
import com.liu.pojo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 竞标Service实现类
 */
@Service
public class BidServiceImpl implements BidService{
    @Autowired
    private BidMapper mapper;
    @Override
    public List<Bid> queryAllBids() {
        return mapper.queryAllBids();
    }

    @Override
    public int addBid(Bid bid) {
        return mapper.addBid(bid);
    }

    @Override
    public int deleteBid(String id) {
        return mapper.deleteBid(id);
    }

    @Override
    public int updateBid(Bid bid) {
        return mapper.updateBid(bid);
    }

    @Override
    public List<Bid> queryBidsByOrderNo(String orderno) {
        return mapper.queryBidsByOrderNo(orderno);
    }

    @Override
    public List<Bid> queryBidsByTraderUserId(String id) {
        return mapper.queryBidsByTraderUserId(id);
    }

    @Override
    public int selectBid(String id) {
        return mapper.selectBid(id);
    }

    @Override
    public int getCounts() {
        return mapper.getCounts();
    }
}
