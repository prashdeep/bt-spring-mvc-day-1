package com.bt.assetmgmt.service;


import com.bt.assetmgmt.model.Item;

import java.util.List;

public interface AssetService {

    Item save(Item item);

    List<Item> listAll();

    Item findById(long itemId);

    Item update(long itemId, Item item);

    void deleteItemById(long itemId);
}