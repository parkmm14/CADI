package com.example.palsw.hw_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondpageActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent gIntent;
    private String name, age;
    private Intent sIntent2;
    private LayoutInflater inflater;
    private FrameLayout frame;
    private ImageView mImage;
    View itemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);


        gIntent = getIntent();
        name = gIntent.getStringExtra("name");
        age = gIntent.getStringExtra("age");

        Toast.makeText(SecondpageActivity.this, name + " / " + age + "입니다.", Toast.LENGTH_LONG).show();
        findViewById(R.id.showImage).setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {


        sIntent2 = new Intent(SecondpageActivity.this, MainActivity.class);
        sIntent2.putExtra("send", "잘 받았습니다.");
        setResult(RESULT_OK, sIntent2);
        super.onBackPressed();
    }


    @Override
     public void onClick(View v) {
        if (v.getId() == R.id.showImage) {
              frame= (FrameLayout)findViewById(R.id.mainFrame);
              inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

              itemView = inflater.inflate(R.layout.main_image, frame, true);
              mImage = (ImageView)findViewById(R.id.mainImage);
        }

    }

}