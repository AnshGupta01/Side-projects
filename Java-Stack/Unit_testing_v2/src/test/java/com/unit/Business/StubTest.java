package com.unit.Business;

import com.unit.Data.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceStub implements DataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}
public class StubTest {
    @Test
    public void calculateSum() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[]{2, 3, 1});
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void calculateSumUsingDataService() {
        BusinessImpl business = new BusinessImpl();
        business.setDataService(new DataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }
}