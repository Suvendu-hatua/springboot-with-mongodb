package com.spring_boot.mongodb.SpringBoot_MongoDB.service;

import com.spring_boot.mongodb.SpringBoot_MongoDB.Pojo.Item;
import com.spring_boot.mongodb.SpringBoot_MongoDB.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(String id) {
      return   itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(String id, Item item) {
        return null;
    }

    @Override
    public void deleteItemById(String id) {

    }
}
