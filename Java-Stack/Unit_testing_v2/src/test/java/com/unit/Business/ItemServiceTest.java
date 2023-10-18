package com.unit.Business;

import com.unit.Data.DataService;
import com.unit.Data.Item;
import com.unit.Repo.ItemRepo;
import com.unit.services.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//To test services we dont need spring web mvc
@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepo itemRepo;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(itemRepo.findAll()).thenReturn((Arrays.asList(new Item(2,"Item2", 10, 1000)
                , new Item(3,"Item3",100,1000))));
        List<Item> allItems = itemService.getAllItems();
        assertEquals(10000,allItems.get(0).getValue());
        assertEquals(100000,allItems.get(1).getValue());
    }
}