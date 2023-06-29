package com.linda.apiintegration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.activity2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

                //Notification code:
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My notification");
                builder.setContentTitle("API integration");
                builder.setContentText("Hello!");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, builder.build());

            }
        });
    }

    public void openActivity2() {
        Log.d("Linda", "openActivity2");
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        Log.d("Linda", "after intent");

    }
}


//TO DO:
    // - Include KOTLIN - Import libraries
    // - Rapport: How API and app works (1/3 page)


//        // Fetch a random joke
//        GET "https://italian-jokes.vercel.app/api/jokes"
//
//        // Fetch a joke of a specific subtype
//        GET "https://italian-jokes.vercel.app/api/jokes?subtype=Observational"



