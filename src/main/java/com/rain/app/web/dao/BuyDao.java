package com.rain.app.web.dao;

import com.rain.app.web.bean.Buy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyDao {
    int addBuy(Buy shopping);
    List<Buy> queryBuyList(int state);
    void updateBuyById(Buy buy);
}
