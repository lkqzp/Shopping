package com.briup.shopping.service.impl;

import com.briup.shopping.bean.ex.SendGoodsEX;
import com.briup.shopping.mapper.ex.SendGoodsEXMapper;
import com.briup.shopping.service.IOrderServiceg;
import com.briup.shopping.service.ISendGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendGoodsServiceImpl implements ISendGoodsService {

    @Autowired
    private SendGoodsEXMapper sendGoodsEXMapper;

    @Autowired
    private IOrderServiceg orderServiceg;
    @Override
    public List<SendGoodsEX> findSendGoods(String status) throws RuntimeException {
        if ("待发货".equals(status)){
            return sendGoodsEXMapper.findSendGoods(2);
        }
        //return sendGoodsEXMapper.findSendGoods(2);
        return null;
    }

    @Override
    public SendGoodsEX download(int id) throws RuntimeException {
        return sendGoodsEXMapper.download(id);
    }

    @Override
    public void sendOut(int id) throws RuntimeException {
        orderServiceg.updateStore(id);
        sendGoodsEXMapper.sendOut(id);
    }
}
