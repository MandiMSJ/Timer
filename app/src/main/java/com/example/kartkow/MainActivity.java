package com.example.kartkow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button start;
    Button stop;
    Button restart;
    Button zapisz;
    TextView czas;
    TextView zapisy;
    boolean running;
    int sekundy;
    int minuty;
    int godziny;
    String s;
    String m;
    String h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        czas  = findViewById(R.id.czas);
        start = findViewById(R.id.button);
        stop = findViewById(R.id.button2);
        restart = findViewById(R.id.button3);
        zapisz = findViewById(R.id.button4);
        zapisy = findViewById(R.id.textView2);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(running){
                    sekundy++;
                }
                if(sekundy >= 60){
                    minuty = minuty + 1;
                    sekundy = 0;
                }
                if(minuty >= 60){
                    godziny = godziny + 1;
                    minuty = 0;
                }
                //tekst
                if(sekundy<10){
                    s = "0"+Integer.toString(sekundy);
                }else{
                    s = Integer.toString(sekundy);
                }
                if(minuty<10){
                    m = "0"+Integer.toString(minuty);
                }else{
                    m = Integer.toString(minuty);
                }
                if(godziny<10){
                    h = "0"+Integer.toString(godziny);
                }else{
                    h = Integer.toString(godziny);
                }

                czas.setText(h + ":" + m + ":" + s);
                handler.postDelayed(this,1000);
            }
        });


        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        running = true;

                    }});

        stop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        running = false;

                    }});



        restart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sekundy = 0;
                        minuty = 0;
                        godziny = 0;
                        running = false;
                    }});

        zapisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        zapisy.setText(h + ":" + m + ":" + s + "\n" + zapisy.getText());
                    }});

    }

}
