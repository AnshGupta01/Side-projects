package com.unit.Business;

import com.unit.Data.DataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class BusinessImpl {

    private DataService dataService;
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum(int[] data){
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
//        int sum = 0;
//        for(int value:data){
//            sum += value;
//        }
//        return sum;
    }

    public int calculateSumUsingDataService(){
        int sum = 0;
        int[] data =  dataService.retrieveAllData();
        for(int value:data){
            sum += value;
        }
        return sum;
        //We use verification in case this return statement is something like this
        //return dataservice.saveAlldata(sum);
    }
}

