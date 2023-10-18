package com.unit.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {

    String str = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssert_strict_exactmatch_except_spaces() throws JSONException {
        //when using strict check, all attributes should exist, hence this wont work
        //String expected = "{\"id\": 1,\"name\":\"Ball\"}";
        String expected = "{\"id\" :1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 100}";
        JSONAssert.assertEquals(expected, str, true);
    }
    @Test
    public void jsonAssert_strict_false() throws JSONException {
        //using strict as false; all attributes may not exist
        String expected = "{\"id\" :1,\"name\": \"Ball\"}";
        JSONAssert.assertEquals(expected, str, false);
    }

    @Test
    public void jsonAssert_without_escape_chars() throws JSONException {
        //using strict as false; all attributes may not exist
        //also spacing and using \ is not mandatory
        String expected = "{id :1,name:\"Ball\", price: 10}";
        JSONAssert.assertEquals(expected, str, false);
    }
}
