package com.rivvana.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText title,  message;
    private Button insertData;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(getApplicationContext());

        title = findViewById(R.id.title);
        message = findViewById(R.id.message);
        insertData = findViewById(R.id.insertData);

        insertData.setOnClickListener(v -> {
            databaseHelper.insertData(new Data("Hevin", "Cool"));
        });
    }
}