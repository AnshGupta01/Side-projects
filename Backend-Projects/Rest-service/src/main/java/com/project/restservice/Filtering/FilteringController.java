package com.project.restservice.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean somebean = new SomeBean("field1","f2","f3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(somebean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","f2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeFilter", filter);

        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-all")
    public MappingJacksonValue filteringList() {

        List<SomeBean> list = Arrays.asList(new SomeBean("field1","f2","f3"),
                new SomeBean("f1","f22","f333"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("f3","f2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}