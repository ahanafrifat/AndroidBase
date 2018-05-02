package net.solutionart.welcomescreen;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import net.solutionart.welcomescreen.DeashBoard.DashBoardActivity;
//import net.solutionart.welcomescreen.LogIn.LoginActivity;
import net.solutionart.welcomescreen.LogIn.LoginActivity;
import net.solutionart.welcomescreen.Map.MapActivity;
import net.solutionart.welcomescreen.NavigationDrawerWithFragment.NavigationDrawerActivity;
import net.solutionart.welcomescreen.ProgressBarOval.progressbarActivity;
import net.solutionart.welcomescreen.RecycleViewWithCardViewCustom.RecyclerViewWithCardViewActivity;
import net.solutionart.welcomescreen.SplashScreen.SplashScreenActivity;
import net.solutionart.welcomescreen.Weather.WeatherActivity;
import net.solutionart.welcomescreen.WelcomeScreen.WelcomeScreenActivity;
import net.solutionart.welcomescreen.WelcomeScreenWithUpToDownAnimation.WelcomeScreenWithUpToDownAnimationActivity;
import net.solutionart.welcomescreen.socialmedialogin.SocialLogInActivity;

public class MainActivity extends AppCompatActivity {

    Button button_Welcome;
    Button button_Deshboard;
    Button button_WelcomeScreenWithUpToDownAnimationActivity;
    Button button_SplashScreen;
    Button button_NavigationDrawer;
    Button button_LogIn;
    Button button_RecylerView;
    Button button_ProgressBar;
    Button button_SocialLogIn;
    Button button_Weather;
    Button button_GoogleMap;
    Button button_Camera;

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        button_Welcome = (Button) findViewById(R.id.buttonWelcome);
        button_Welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , WelcomeScreenActivity.class);
                startActivity(intent);
            }
        });

        button_Deshboard =(Button) findViewById(R.id.buttonDashboard);
        button_Deshboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_WelcomeScreenWithUpToDownAnimationActivity =(Button) findViewById(R.id.buttonWelcomeScreenWithUpToDownAnimationActivity);
        button_WelcomeScreenWithUpToDownAnimationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, WelcomeScreenWithUpToDownAnimationActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_SplashScreen =(Button) findViewById(R.id.buttonSplashScreen);
        button_SplashScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, SplashScreenActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_NavigationDrawer =(Button) findViewById(R.id.buttonNavigationDrawer);
        button_NavigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_LogIn =(Button) findViewById(R.id.buttonLogIn);
        button_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_RecylerView =(Button) findViewById(R.id.buttonRecylerView);
        button_RecylerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, RecyclerViewWithCardViewActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_ProgressBar =(Button) findViewById(R.id.buttonProgressBar);
        button_ProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, progressbarActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_SocialLogIn =(Button) findViewById(R.id.buttonSocialLogIn);
        button_SocialLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, SocialLogInActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_Weather =(Button) findViewById(R.id.buttonWeather);
        button_Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

        button_GoogleMap =(Button) findViewById(R.id.buttonGoogleMap);
        button_GoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(isServicesOK()){
                        Intent intent = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent);
                    }
                }
                catch (Exception ex){
                    Log.d("MapActivity" , ex.getMessage());
                }
            }
        });


        button_Camera =(Button) findViewById(R.id.buttonCamera);
        button_Camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Log.d("Deashboard" , ex.getMessage());
                }
            }
        });

    }

    public boolean isServicesOK(){

        Log.d(TAG , "Checking services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG , "google play service is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG , "an error occured");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this ,"You cant make map request", Toast.LENGTH_LONG).show();
        }

        return false;
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
