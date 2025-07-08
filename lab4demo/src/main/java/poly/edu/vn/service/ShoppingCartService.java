package poly.edu.vn.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import poly.edu.vn.model.Item;

public interface ShoppingCartService {

    Item add(Integer id);

    void remove(Integer id);

    Item update(Integer id, int qty);

    void clear();

    Collection<Item> getItems();

    int getCount();

    double getAmount();

}
