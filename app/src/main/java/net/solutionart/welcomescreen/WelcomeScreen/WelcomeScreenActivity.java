package net.solutionart.welcomescreen.WelcomeScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import net.solutionart.welcomescreen.MainActivity;
import net.solutionart.welcomescreen.R;

public class WelcomeScreenActivity extends AppCompatActivity {

    CardView cardView_banking;
    CardView cardView_Ideas;
    CardView cardView_Add;
    CardView cardView_Links;
    CardView cardView_Wifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cardView_banking = (CardView) findViewById(R.id.cardViewbanking);
        cardView_banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cardView_Ideas = (CardView) findViewById(R.id.cardViewIdeas);
        cardView_Ideas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cardView_Add = (CardView) findViewById(R.id.cardViewAdd);
        cardView_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cardView_Links = (CardView) findViewById(R.id.cardViewLinks);
        cardView_Links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cardView_Wifi = (CardView) findViewById(R.id.cardViewWifi);
        cardView_Wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
