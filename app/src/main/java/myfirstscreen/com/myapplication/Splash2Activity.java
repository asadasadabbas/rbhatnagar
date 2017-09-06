package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        int SPLASH_DISPLAY_LENGTH = 1000;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent mainIntent= new Intent(Splash2Activity.this,RegisterActivity.class);
                startActivity(mainIntent);
                finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }


}
