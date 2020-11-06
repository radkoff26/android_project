package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class input_name extends AppCompatActivity {

    public static final String MSG = "Message";

    private EditText editText;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);

        editText = (EditText) findViewById(R.id.editTextTextPersonName);

        btn = (Button) findViewById(R.id.button);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER, weight REAL, height REAL)");
        Cursor account = db.rawQuery("SELECT * FROM users;", null);
        if (account.moveToFirst()) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        Intent intent = new Intent(getApplicationContext(), input_data.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("") || editText.getText().toString().equals(" ")) {
                    Toast.makeText(getApplicationContext(), "Вы не ввели имя!", Toast.LENGTH_SHORT).show();
                } else {
                    String name = editText.getText().toString();
                    intent.putExtra(MSG, name);
                    startActivity(intent);
                }
            }
        });
    }
}