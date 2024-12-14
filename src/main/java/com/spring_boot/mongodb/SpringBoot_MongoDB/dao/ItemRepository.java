package com.spring_boot.mongodb.SpringBoot_MongoDB.dao;

import com.spring_boot.mongodb.SpringBoot_MongoDB.Pojo.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item,String> {
}
