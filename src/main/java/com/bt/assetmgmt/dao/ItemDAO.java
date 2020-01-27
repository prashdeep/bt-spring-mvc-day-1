package com.bt.assetmgmt.dao;

import com.bt.assetmgmt.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemDAO {

    Item save(Item item);

    List<Item> listAll();

    Optional<Item> findById(long itemId);

    void deleteItemById(long itemId);

    Item updateItem(long itemId, Item item);
}