package com.unit.controller;

import com.unit.Data.Item;
import com.unit.services.ItemService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ItemController.class)

class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;
    @Test
    public void dummyItem_basic() throws Exception {
        //JSON Checking

        //call the url for GET /hello-world
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10}"))
                .andReturn();
    }
    @Test
    public void itemFromService() throws Exception {
        //Mocking the ItemService to use below
        when(itemService.retrievenewHardcodedItem()).thenReturn(
                new Item(2,"Item 2",10,10));

        //JSON Checking
        //call the url for GET /hello-world
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 2,name:\"Item 2\",price:10}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItems() throws Exception {
        //Mocking the ItemService to use below
        when(itemService.getAllItems()).thenReturn
                (Arrays.asList(new Item(2,"Item2", 10, 1000)
                    , new Item(3,"Item3",100,1000)));

        //JSON Checking
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id: 2,name:Item2,price:10, quantity: 1000}" +
                        ",{id: 3,name:Item3,price:100, quantity: 1000}]"))
                .andReturn();
    }

//    @Test
//    public void PostMethod() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders
//                .post("/all-items")
//                .accept(MediaType.APPLICATION_JSON)
//                .content("{id:2,name:Item2,price:10, quantity: 1000}")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().isCreated())
//                .andExpect(header()
//                        .string("location", contains("item")))
//                .andReturn();
//    }
}