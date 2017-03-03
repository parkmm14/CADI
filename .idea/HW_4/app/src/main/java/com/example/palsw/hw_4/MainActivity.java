package com.example.palsw.hw_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editAge;
    private Button btnEnrol;
    private Intent sIntent;
    private static final int RequestCode=1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       editName = (EditText) findViewById(R.id.editName);
        editAge = (EditText) findViewById(R.id.editAge);
        btnEnrol = (Button) findViewById(R.id.btnEnroll);

        btnEnrol.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                sIntent = new Intent(MainActivity.this, SecondpageActivity.class);
                sIntent.putExtra("name",editName.getText().toString());
                sIntent.putExtra("age", editAge.getText().toString());
                startActivityForResult(sIntent, 1001);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1001:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(getApplicationContext(), data.getStringExtra("send"), Toast.LENGTH_LONG).show();
                }
        }


    }}
