package com.example.table_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableList;

    public void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timeTableContent = new ArrayList<String>();

        for (int i=1; i<= 100; i++){
            timeTableContent.add(Integer.toString(i * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeTableContent);

        timesTableList.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    final SeekBar timesTableSeekBar = findViewById(R.id.numberSeekBar);

    timesTableList = findViewById(R.id.tableSeekBar);

    int max = 20;
    int startingPosition = 10;

    timesTableSeekBar.setMax(max);
    timesTableSeekBar.setProgress(startingPosition);

    generateTimesTable(startingPosition);

    timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int j, boolean b) {
            int min = 1;
            int timesTablenumber;

            if (j<min){
                timesTablenumber = min;
                timesTableSeekBar.setProgress(min);
            }else{
                timesTablenumber = j;
            }
            Log.i(("SeekBar Value"),Integer.toString(timesTablenumber));

            generateTimesTable(timesTablenumber);

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });

    }
}