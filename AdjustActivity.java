package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdjustActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private SeekBar seekBar;
    private ArrayList<MemoryItem> memoriesList;
    private ArrayAdapter<Object> memoriesAdapter;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust);

        timePicker = findViewById(R.id.timePicker);

        Button button =findViewById(R.id.MemoryButton);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(), MemoryActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"user의 사용기록을 확인합니다.",Toast.LENGTH_LONG).show();
            }
        });

        tv = findViewById(R.id.textView);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

               tv.setText(String.format("온도는 %d도 입니다.", seekBar.getProgress()));
            }
        });
    }
    public void BoilingButtonClick(View view) {
        // 사용자가 설정한 시간과 온도 가져오기
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        int temperature = seekBar.getProgress();

        String time = String.format("%02d:%02d", hour, minute); // 시간을 "hh:mm" 형태로 변환
        MemoryItem memoryItem = new MemoryItem(time, temperature);

        memoriesList.add(memoryItem);
        memoriesAdapter.notifyDataSetChanged();
    }
}