package com.example.macroeconomicfoodsecurity;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public  class ReaderController {

    private static DBHandler dbHandler;
    public ReaderController(DBHandler inDbHandler)
    {
        this.dbHandler = inDbHandler;
    }
    public  List<Result>   getGDPPercent(String country) {
        List<Result> results = null;
        try {
            List<Model> gdpPercent =  this.dbHandler.readGDPPercentages();
            if(country == null || country.equalsIgnoreCase("china")){
                results= gdpPercent.stream().map(m -> new Result(m.year, m.china)).collect(Collectors.toList());
            }
            else if(country.equalsIgnoreCase("usa")){
                results= gdpPercent.stream().map(m -> new Result(m.year, m.usa)).collect(Collectors.toList());
            }
            else{
                results =  results= gdpPercent.stream().map(m -> new Result(m.year, m.india)).collect(Collectors.toList());
            }


        } catch (Exception e) {
            //log the exception
        }
        return   results;
    }
    public  List<Result>   getFDIInFlowsPercent(String country) {
        List<Result> results = null;
        try {
            List<Model> gdpPercent =  this.dbHandler.readFDIInFlowsPercentValues();
            if(country == null || country.equalsIgnoreCase("china")){
                results= gdpPercent.stream().map(m -> new Result(m.year, m.china)).collect(Collectors.toList());
            }
            else if(country.equalsIgnoreCase("usa")){
                results= gdpPercent.stream().map(m -> new Result(m.year, m.usa)).collect(Collectors.toList());
            }
            else{
                results = gdpPercent.stream().map(m -> new Result(m.year, m.india)).collect(Collectors.toList());
            }


        } catch (Exception e) {
            //log the exception
        }
        return   results;
    }


}
