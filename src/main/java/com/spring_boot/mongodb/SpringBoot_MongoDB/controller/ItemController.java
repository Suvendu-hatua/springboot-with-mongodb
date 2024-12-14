package com.spring_boot.mongodb.SpringBoot_MongoDB.controller;

import com.spring_boot.mongodb.SpringBoot_MongoDB.Pojo.Item;
import com.spring_boot.mongodb.SpringBoot_MongoDB.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
    @PostMapping("/items")
    public Item addItems(@RequestBody Item item){
        return itemService.addItem(item);
    }
}
