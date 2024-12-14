package com.spring_boot.mongodb.SpringBoot_MongoDB.service;

import com.spring_boot.mongodb.SpringBoot_MongoDB.Pojo.Item;
import com.spring_boot.mongodb.SpringBoot_MongoDB.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    @Override
    @Transactional
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(String id) {
      return   itemRepository.findById(id)
              .orElseThrow(()->new RuntimeException("Not found with id: "+id));
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(String id, Item updatedItem) {
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){
            Item item=result.get();
            item.setTitle(updatedItem.getTitle());
            item.setDesc(updatedItem.getDesc());
            item.setPrice(updatedItem.getPrice());
            return itemRepository.save(result.get());
        }
        throw new RuntimeException("Not found Item with id:"+id);
    }

    @Override
    @Transactional
    public void deleteItemById(String id) {
        Optional<Item> result=itemRepository.findById(id);
        if(result.isPresent()){
            itemRepository.delete(result.get());
            return;
        }
        throw new RuntimeException("Not Found with Id:"+id);
    }
}
