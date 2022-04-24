package com.example.macroeconomicfoodsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DashboardGraphActivity extends AppCompatActivity implements OnChartGestureListener, OnChartValueSelectedListener {

    private LineChart lineChart;
    ArrayList<Entry> yVal = new ArrayList<>();
    ReaderController readerController;
    DBHandler dbHandler;
    private ArrayList<String> yearGDP;
    private ArrayList<String> percentGDP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_graph);
        Intent i = getIntent();
        ArrayList<String> year = i.getStringArrayListExtra("year");
        //ArrayListExtra("year");
        ArrayList<String> percent = i.getStringArrayListExtra("percent");
        SharedPreferences sp = getApplicationContext().getSharedPreferences("type", Context.MODE_PRIVATE);
        Button btn = (Button) findViewById(R.id.annotateButton);
        Button apply = (Button) findViewById(R.id.button5);


        // displayChart(year,percent,sd,ed);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayChart();

            }
        });


        Log.i("sp-->", String.valueOf(sp));
        String type = sp.getString("usertype", "");
        Log.i("type from sp", type);
        if (type.equals(" Government official")) {
            btn.setVisibility(View.GONE);

        }

//
        lineChart = (LineChart) findViewById(R.id.linechart);
        lineChart.setOnChartGestureListener(DashboardGraphActivity.this);
        lineChart.setOnChartValueSelectedListener(DashboardGraphActivity.this);
        lineChart.setScaleEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.getXAxis().setGranularity(2f);


        for (int k = 0; k < year.size(); k++) {
            yVal.add(new Entry(Float.parseFloat(year.get(k)), Float.parseFloat(percent.get(k))));
            Log.i("yval-->", String.valueOf(yVal.get(k)));
        }


        LineDataSet set1 = new LineDataSet(yVal, "Data Set 1");
        set1.setFillAlpha(110);
        ArrayList<ILineDataSet> dataset = new ArrayList<>();
        dataset.add(set1);
        LineData data = new LineData(dataset);
        lineChart.setData(data);
        Button applybtn = (Button) findViewById(R.id.button5);
        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText start = (EditText) findViewById(R.id.editTextNumber);
                EditText end = (EditText) findViewById(R.id.editTextNumberDecimal);
                String sd = start.getText().toString();
                String ed = end.getText().toString();

                display(sd, ed);
            }
        });

    }


    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    public void display(String sd, String ed) {

        Log.i("click", sd);
        dbHandler = new DBHandler(getApplicationContext());
        Log.i("dbHandler-->", String.valueOf(dbHandler));
        readerController = new ReaderController(dbHandler);
        //dbHandler.addNewGDPPercent("1995", "34", "35", "33");
        //SharedPreferences sp= getContext().getSharedPreferences("type", Context.MODE_PRIVATE);
        //type=sp.getString("usertype","");
        try {
            WriterController.seedData(getApplicationContext(), dbHandler);
        } catch (IOException e) {
            // e.printStackTrace();
            Log.i("printstacktrace", "errorrr");
        }
        List<Result> courseModalArrayList = readerController.getFDIInFlowsPercent("india", "2010", "2022");
        // List<Result> courseModalOutFlowArrayList = readerController.getFDIOutFlowsPercent("india","2010","2022");

        Log.i("size--->", String.valueOf(courseModalArrayList.size()));
        yearGDP = new ArrayList<String>();
        percentGDP = new ArrayList<String>();
        //yearFDIOutput=new ArrayList<String>();
        //percentFDIOutput=new ArrayList<String>();
        for (Result m : courseModalArrayList
        ) {
            Log.e("Main Graph ", m.percent);
            yearGDP.add(m.year);
            if (m.percent.length() > 0) {
                percentGDP.add(m.percent);
            } else {
                percentGDP.add("5");
            }

        }
        lineChart.notifyDataSetChanged();
        lineChart.invalidate();
        for (int k = 0; k < yearGDP.size(); k++) {
           // yVal.clear();
            yVal.add(new Entry(Float.parseFloat(yearGDP.get(k)), Float.parseFloat(percentGDP.get(k))));
            Log.i("yval-->", String.valueOf(yVal.get(k)));
        }


        LineDataSet set1 = new LineDataSet(yVal, "Data Set 1");
        set1.setFillAlpha(110);
        ArrayList<ILineDataSet> dataset = new ArrayList<>();
        dataset.add(set1);
        LineData data = new LineData(dataset);
        lineChart.setData(data);

    }






}
