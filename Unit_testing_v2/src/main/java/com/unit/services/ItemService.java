package com.unit.services;

import com.unit.Data.Item;
import com.unit.Repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    public Item retrievenewHardcodedItem() {
        return new Item(1,"Ball",10,100);
    }

    public List<Item> getAllItems(){
        List<Item> allItems = itemRepo.findAll();
        for (Item item:allItems){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return allItems;
    }
}
