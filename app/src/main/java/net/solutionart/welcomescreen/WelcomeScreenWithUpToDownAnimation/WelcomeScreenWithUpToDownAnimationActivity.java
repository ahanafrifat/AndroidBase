package net.solutionart.welcomescreen.WelcomeScreenWithUpToDownAnimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import net.solutionart.welcomescreen.R;

public class WelcomeScreenWithUpToDownAnimationActivity extends AppCompatActivity {

    LinearLayout Layout_Up , Layout_Down;
    Button button_Sub;
    Animation top_to_down , down_to_top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_with_up_to_down_animation);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Layout_Up = (LinearLayout) findViewById(R.id.LayoutUp);
        Layout_Down = (LinearLayout) findViewById(R.id.LayoutDown);

        button_Sub = (Button)findViewById(R.id.buttonSub);
        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        top_to_down = AnimationUtils.loadAnimation(this, R.anim.toptodown);
        down_to_top = AnimationUtils.loadAnimation(this, R.anim.downtotop);
        Layout_Up.setAnimation(top_to_down);
        Layout_Down.setAnimation(down_to_top);
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
