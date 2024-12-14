package com.spring_boot.mongodb.SpringBoot_MongoDB.controller;

import com.spring_boot.mongodb.SpringBoot_MongoDB.Pojo.Item;
import com.spring_boot.mongodb.SpringBoot_MongoDB.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok(itemService.getAllItems());
    }
    @PostMapping("/items")
    public ResponseEntity<Item> addItems(@RequestBody Item item){
            Item result=itemService.addItem(item);
            return ResponseEntity.ok(result);
    }
    @GetMapping("/items/{id}")
    public ResponseEntity<?> getItemByID(@PathVariable String id){
        try{
            Item re=itemService.getItemById(id);
            return ResponseEntity.ok(re);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item,@PathVariable String id){
       try{
           Item re=itemService.updateItem(id,item);
           return ResponseEntity.ok(re);
       }catch (Exception e){
           return ResponseEntity.notFound().build();
       }

    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable String id){
        try{
            itemService.deleteItemById(id);
            return ResponseEntity.ok("successfully deleted.");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
