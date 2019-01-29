package com.virjanand.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView timesTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar numberSeekBar = findViewById(R.id.numberSeekBar);
        timesTable = findViewById(R.id.timesListView);

        numberSeekBar.setMax(20);
        numberSeekBar.setProgress(10);

        numberSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    numberSeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                fillTimesList(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void fillTimesList(int progress) {

        ArrayList<String> timesList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            timesList.add(Integer.toString(i * progress));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesList);

        timesTable.setAdapter(adapter);
    }
}
