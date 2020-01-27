package com.bt.assetmgmt.dao;

import com.bt.assetmgmt.model.Item;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Primary
public class InMemoryItemDAOImpl implements ItemDAO {

    private List<Item> itemlist = new ArrayList<>();

    @Override
    public Item save(Item item) {
        item.setItemId((long) Math.ceil(Math.random()*1000));
        this.itemlist.add(item);
        return item;
    }

    @Override
    public List<Item> listAll() {
        return this.itemlist;
    }

    @Override
    public Optional<Item> findById(long itemId) {
        Optional<Item> optionalItem = this.itemlist
                .stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst();
        return optionalItem;
    }

    @Override
    public void deleteItemById(long itemId) {
        this.itemlist.removeIf(item -> item.getItemId() == itemId);
    }


    @Override
    public Item updateItem(long itemId, Item item) {
        Optional<Item> optionalItem = findById(itemId);
        optionalItem.ifPresent(item1 -> {
            int index = this.itemlist.indexOf(item1);
            this.itemlist.add(index, item);
        } );
        return item;
    }
}