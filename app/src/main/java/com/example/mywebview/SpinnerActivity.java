package com.example.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        String[] items = {"설계","제어","시스템","정보통신","기능반"};

        Spinner spinner = findViewById(R.id.spinner_exam);

        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                String msg = position + "번쨰" + spinner.getItemAtPosition(position);
                Toast.makeText(SpinnerActivity.this,msg,Toast.LENGTH_SHORT).show();
                setTitle(name+"의 웹뷰");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}