package com.spring_boot.mongodb.SpringBoot_MongoDB.service;

import com.spring_boot.mongodb.SpringBoot_MongoDB.Pojo.Item;

import java.util.List;

public interface ItemService {

    public Item addItem(Item item);
    public Item getItemById(String id);
    public List<Item> getAllItems();
    public Item updateItem(String id,Item item);
    public void deleteItemById(String id);
}
