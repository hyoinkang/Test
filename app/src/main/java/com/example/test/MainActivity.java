package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button StartButton =findViewById(R.id.StartButton);

        StartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);//버튼 클릭시 다음 페이지(MainActivity->MainActivity2)
                Toast.makeText(getApplicationContext(),"버튼1 클릭",Toast.LENGTH_LONG).show();
            }
        });
    }
}