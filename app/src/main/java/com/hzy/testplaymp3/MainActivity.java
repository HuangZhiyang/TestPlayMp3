package com.hzy.testplaymp3;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TestPlayMp3";
    private Button btnPlay;
    private Button btnStartIperf;
    private Button btnStopPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void  initViews(){
        btnPlay = findViewById(R.id.button_play);
        btnStartIperf = findViewById(R.id.button_start_iperf);
        btnStopPlay = findViewById(R.id.button_stop);
    }

    private void initListeners(){
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MusicService.class);
                startService(intent);
            }
        });

        btnStopPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MusicService.class);
                stopService(intent);
            }
        });


        btnStartIperf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                   intent.setClassName("com.magicandroidapps.iperf","com.magicandroidapps.iperf.iperf");
                    //ComponentName componentName = new ComponentName("com.magicandroidapps.iperf","com.magicandroidapps.iperf.iperf");
                    //intent.setComponent(componentName);
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }catch (Exception e){
                    Log.e(TAG,e.toString());
                }
            }
        });


    }

}
