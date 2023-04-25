package com.example.spalashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SpalashScreen extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_spalash_screen);
        progressBar=findViewById(R.id.progressbarId);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                // create method dowork
                doWork();
                //for new page
                startApp();
            }
        });
        thread.start();
    }
    public void doWork(){
           for (progree=20;progree<=100;progree=progree+20) {
               try {
                   Thread.sleep(1000);
                   progressBar.setProgress(progree);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

    }
    public void startApp()
    {
        Intent intent=new Intent(SpalashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}