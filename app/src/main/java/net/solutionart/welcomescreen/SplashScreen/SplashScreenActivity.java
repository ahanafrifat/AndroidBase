package net.solutionart.welcomescreen.SplashScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import net.solutionart.welcomescreen.MainActivity;
import net.solutionart.welcomescreen.R;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView imageViewAppLogo;
    TextView textViewAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Animation animation = AnimationUtils.loadAnimation(this ,R.anim.mytransition);

        imageViewAppLogo = (ImageView)findViewById(R.id.imageViewAppIcon);
        textViewAppName = (TextView) findViewById(R.id.textViewAppName);
        imageViewAppLogo.setAnimation(animation);
        textViewAppName.setAnimation(animation);
        final Intent intent = new Intent(this , MainActivity.class);
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
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
