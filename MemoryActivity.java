package com.example.test;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MemoryActivity extends AppCompatActivity {

    private ArrayList<MemoryItem> memoriesList;
    private ArrayAdapter<MemoryItem> memoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        ListView memorylist = findViewById(R.id.memorylist);
        memoriesList = new ArrayList<>();
        memoriesAdapter = new ArrayAdapter<>(this, R.layout.memory_item, memoriesList);
        memorylist.setAdapter(memoriesAdapter);

        // MainActivity에서 전달받은 데이터를 가져와 사용기록에 추가
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            MemoryItem recordItem = (MemoryItem) extras.getSerializable("memory");
            if (recordItem != null) {
                memoriesList.add(recordItem);
                memoriesAdapter.notifyDataSetChanged();


//        int count;
//        count = adapter.getCount();
//
//        // 아이템 추가.
//        items.add("LIST" + Integer.toString(count + 1));
//
//        // listview 갱신
//        adapter.notifyDataSetChanged();
            }
        }
    }
}