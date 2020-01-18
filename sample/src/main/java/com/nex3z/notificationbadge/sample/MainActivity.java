package com.nex3z.notificationbadge.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nex3z.notificationbadge.NotificationBadge;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NotificationBadge badge = findViewById(R.id.badge);

        Button increase = findViewById(R.id.increase);
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                badge.setNumber(++mCount);
            }
        });

        Button many = findViewById(R.id.many);
        many.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount = 98;
                badge.setNumber(mCount);
            }
        });

        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount = 0;
                badge.setNumber(mCount);
            }
        });

        Button showTab = findViewById(R.id.btn_show_tab);
        showTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabActivity.class);
                startActivity(intent);
            }
        });
    }
}
