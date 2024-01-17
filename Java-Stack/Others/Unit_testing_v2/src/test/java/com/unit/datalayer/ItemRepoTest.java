package com.unit.datalayer;

import com.unit.Data.Item;
import com.unit.Repo.ItemRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//although unncessary to write a unit test from a mint repo which implements an interface
public class ItemRepoTest {
    @Autowired
    private ItemRepo itemRepo;

    @Test
    public void testFindAll(){
        List<Item> items = itemRepo.findAll();
        assertEquals(3, items.size());
    }

}
