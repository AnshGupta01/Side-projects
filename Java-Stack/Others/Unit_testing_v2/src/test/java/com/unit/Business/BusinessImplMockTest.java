package com.unit.Business;

import com.unit.Data.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusinessImplMockTest {
    @InjectMocks
    BusinessImpl business;
    @Mock
    DataService dataServiceMock;
    @BeforeEach
    public void before(){
        business.setDataService(dataServiceMock);
    }
    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6,business.calculateSumUsingDataService());
    }
    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0,business.calculateSumUsingDataService());
    }
    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5,business.calculateSumUsingDataService());
    }
}