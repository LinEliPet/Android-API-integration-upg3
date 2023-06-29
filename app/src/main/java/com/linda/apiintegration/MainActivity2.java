package com.linda.apiintegration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {
    Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            //Button to Activity 3
            button = findViewById(R.id.activity3);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivity3();
                }
            });

            //Button to Activity 4
            button = findViewById(R.id.activity4);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivity4();
                }
            });
        }

    public void openActivity3() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void openActivity4() {
            Intent intent = new Intent(this, MainActivity4.class);
            startActivity(intent);
    }
}


