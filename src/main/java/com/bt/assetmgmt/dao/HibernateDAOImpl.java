package com.bt.assetmgmt.dao;

import com.bt.assetmgmt.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("hibernateDAO")
public class HibernateDAOImpl implements ItemDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public List<Item> listAll() {
        return null;
    }

    @Override
    public Optional<Item> findById(long itemId) {
        return Optional.empty();
    }

    @Override
    public void deleteItemById(long itemId) {

    }


    @Override
    public Item updateItem(long itemId, Item item) {
        return null;
    }
}