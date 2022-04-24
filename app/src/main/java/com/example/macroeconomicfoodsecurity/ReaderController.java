package com.example.macroeconomicfoodsecurity;

import android.content.Context;
import android.util.Log;

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
    private List<Result> getResults(String country, String se, String ey, List<Model> gdpPercent){
        List<Result> results = null;
        try {
            Log.e("reader controller", String.valueOf(gdpPercent.size()));
            int startYear = Integer.parseInt(se);
            int endYear = Integer.parseInt(ey);
            Log.e("reader controller", se + " " + ey);
            for (Model m : gdpPercent
                 ) {
                Log.e("reader controller", m.year + " : " + String.valueOf( m.year.isEmpty()));
            }
            gdpPercent=  gdpPercent.stream().filter(g -> !g.year.isEmpty() && Integer.parseInt(g.year) >= startYear && Integer.parseInt(g.year) <= endYear).collect(Collectors.toList());
            Log.e("reader controller", String.valueOf(gdpPercent.size()));

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
            Log.e("reader controller err", e.getMessage());
            //log the exception
        }
        return results;
    }
    public  List<Result>   getGDPPercent(String country, String se, String ey) {
        List<Result> results = null;
        try {
            List<Model> gdpPercent =  this.dbHandler.readGDPPercentages();
            results = getResults(country, se, ey, gdpPercent);


        } catch (Exception e) {
            Log.e("reader controller err", e.getMessage());
            //log the exception
        }
        return   results;
    }
    public  List<Result>   getFDIInFlowsPercent(String country, String se, String ey) {
        List<Result> results = null;
        try {
            List<Model> gdpPercent =  this.dbHandler.readFDIInFlowsPercentValues();
            results = getResults(country, se, ey, gdpPercent);


        } catch (Exception e) {
            Log.e("reader controller err", e.getMessage());
            //log the exception
        }
        return   results;
    }
    public  List<Result>   getFDIOutFlowsPercent(String country, String se, String ey) {
        List<Result> results = null;
        try {
            List<Model> gdpPercent =  this.dbHandler.readFDIOutFlowsPercentValues();
            results = getResults(country, se, ey, gdpPercent);


        } catch (Exception e) {
            Log.e("reader controller err", e.getMessage());
            //log the exception
        }
        return   results;
    }
    public  List<Result>   getFertlizerConsump(String country, String se, String ey) {
        List<Result> results = null;
        try {
            List<Model> gdpPercent =  this.dbHandler.readFertiliserConsump();
            results = getResults(country, se, ey, gdpPercent);


        } catch (Exception e) {
            Log.e("reader controller err", e.getMessage());
            //log the exception
        }
        return   results;
    }
    public  List<Result>   getGDPAgri(String country, String se, String ey) {
        List<Result> results = null;
        try {
            List<Model> gdpPercent =  this.dbHandler.readGDPAgriValues();
            results = getResults(country, se, ey, gdpPercent);


        } catch (Exception e) {
            Log.e("reader controller err", e.getMessage());
            //log the exception
        }
        return   results;
    }

}
