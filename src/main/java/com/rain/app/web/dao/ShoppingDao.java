package com.rain.app.web.dao;

import com.rain.app.web.bean.Shopping;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingDao {
    int addShopping(Shopping shopping);
    List<Shopping> queryShoppingList();
    Shopping queryShoppingById(int id);
}
