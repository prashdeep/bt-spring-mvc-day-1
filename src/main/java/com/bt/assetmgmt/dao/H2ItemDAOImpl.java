package com.bt.assetmgmt.dao;

import com.bt.assetmgmt.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class H2ItemDAOImpl implements ItemDAO {

    private JdbcTemplate jdbcTemplate;

    public H2ItemDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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