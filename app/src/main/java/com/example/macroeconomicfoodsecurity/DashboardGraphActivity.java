package com.example.macroeconomicfoodsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class DashboardGraphActivity extends AppCompatActivity implements OnChartGestureListener, OnChartValueSelectedListener {

    private LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_graph);
        Intent i=getIntent();
        ArrayList<String> year=i.getStringArrayListExtra("year");
        ArrayList<String> percent=i.getStringArrayListExtra("percent");
        for(int j=0;j<year.size();j++){
            Log.i("yeararray", year.get(j));
        }
        lineChart=(LineChart) findViewById(R.id.linechart);
        lineChart.setOnChartGestureListener(DashboardGraphActivity.this);
        lineChart.setOnChartValueSelectedListener(DashboardGraphActivity.this);
        lineChart.setScaleEnabled(false);
        ArrayList<Entry> yVal=new ArrayList<>();
//        int val=100;
// for(int k=0;k<year.size();k++){
//    // yVal.add(new Entry(2f*i,(float) Math.sin(val*(i+1))));
//     yVal
// }
// yVal.add(new Entry(,35));
// yVal.add(new Entry(2001,60));
// yVal.add(new Entry(2002,44));




        LineDataSet set1=new LineDataSet(yVal,"Data Set 1");
        set1.setFillAlpha(110);
        ArrayList<ILineDataSet> dataset=new ArrayList<>();
        dataset.add(set1);
        LineData data=new LineData(dataset);
        lineChart.setData(data);
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
}