package com.unit.controller;

import com.unit.Repo.ItemRepo;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

//This app will spin up parent packages, and launch the spring boot application totally
//This will also launch the in-memory database
//Random port is used to prevent application to fail on one port which is already occupied
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test:configuration.properties"})
public class itemControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

//    Can be used to mock external Dependencies
//    @MockBean
//    private ItemRepo itemRepo;

    @Test
    public void contextLoads() throws JSONException {
        String objects = this.restTemplate.getForObject("/all-items", String.class);
        JSONAssert.assertEquals("[{id: 10001},{id: 10002},{id: 10003}]", objects, false);
    }

}
