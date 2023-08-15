package com.unit.controller;

import com.unit.Data.Item;
import com.unit.services.ItemService;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"Ball",10,100 );
    }

    @GetMapping("/item-service")
    public Item itemFromService(){
        return itemService.retrievenewHardcodedItem();
    }

    @GetMapping("/all-items")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

}
