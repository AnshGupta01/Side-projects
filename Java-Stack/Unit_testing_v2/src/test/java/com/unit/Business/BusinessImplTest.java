package com.unit.Business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessImplTest {

    @Test
    public void calculateSum() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[]{2, 3, 1});
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }
}