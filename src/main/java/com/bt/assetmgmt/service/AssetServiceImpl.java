package com.bt.assetmgmt.service;


import com.bt.assetmgmt.dao.ItemDAO;
import com.bt.assetmgmt.model.Item;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final ItemDAO itemDAO;

    /* public ItemServiceImpl(@Qualifier("inMemory") ItemDao itemDao){
         this.itemDAO = itemDao;
     }*/
    public AssetServiceImpl(ItemDAO itemDao){
        this.itemDAO = itemDao;
    }


    @Override
    public Item save(Item item) {
        return this.itemDAO.save(item);
    }

    @Override
    public List<Item> listAll() {
        return this.itemDAO.listAll();
    }

    @Override
    public Item findById(long itemId) {
        return this.itemDAO.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
    }

    @Override
    public Item update(long itemId, Item item) {
        return this.itemDAO.updateItem(itemId, item);
    }

    @Override
    public void deleteItemById(long itemId) {
        this.itemDAO.deleteItemById(itemId);
    }
}