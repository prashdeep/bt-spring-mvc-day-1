package com.bt.assetmgmt.dao;

import com.bt.assetmgmt.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("hibernateDAO")
@Primary
public class HibernateDAOImpl implements ItemDAO {

    private SessionFactory sessionFactory;

    public HibernateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Item save(Item item) {

        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(item);
        return item;
    }

    @Override
    @Transactional
    public List<Item> listAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List items = session.createQuery("FROM Item").list();
        return items;
    }

    @Override
    @Transactional
    public Optional<Item> findById(long itemId) {
        Session session = this.sessionFactory.getCurrentSession();
        Item item = session.find(Item.class, itemId);
        return Optional.of(item);
    }

    @Override
    @Transactional
    public void deleteItemById(long itemId) {
        Session session = this.sessionFactory.getCurrentSession();
        Item item = session.find(Item.class, itemId);
        session.delete(item);
    }


    @Override
    public Item updateItem(long itemId, Item item) {
        return null;
    }
}