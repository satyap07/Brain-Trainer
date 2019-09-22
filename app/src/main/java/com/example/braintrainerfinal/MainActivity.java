package com.example.braintrainerfinal;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    int count=0;
    int answer;
    boolean gameMode=true;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  void start(View view){
        Button button=(Button) view;
        if(gameMode) {
        if(Integer.parseInt(button.getText().toString())==answer){
            count=count+1;
            textView4.setText("corret :)");
            textView2.setText(Integer.toString(count));


        }else{
            textView4.setText("wrong :(");
        }
        textView2.setText(Integer.toString(count));

            final int min = 1;
            final int max = 4;
            final int random = new Random().nextInt((max - min) + 1) + min;
            setOption(random);
        }



    }
    public  void  playAgain(View view){
        gameMode=true;
        button5.setVisibility(View.INVISIBLE);
        setTimer();
        textView2.setText("0");
        textView4.setText(" ");
        count=0;
    }
    public void setTimer(){
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView1.setText(Integer.toString((int)millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                music();
                gameMode=false;
                button5.setVisibility(View.VISIBLE);


            }
        }.start();
    }
    public  void music(){
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.airhorn);
        mediaPlayer.start();

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public int randomNumber(){

        final int min = 0;
        final int max = 100;
        final int random = new Random().nextInt((max - min) + 1) + min;
        return  random;

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public int questionOption(){
        int x=randomNumber();
        int y=randomNumber();
        int z=x+y;
        textView3.setText(Integer.toString(x)+"+"+Integer.toString(y));
        answer=z;
        return z;

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  void setOption(int x){
        int z=questionOption();

        if(x==1){
            button1.setText(Integer.toString(z));
            button2.setText(Integer.toString(randomNumber()));
            button3.setText(Integer.toString(randomNumber()));
            button4.setText(Integer.toString(randomNumber()));
        }
        if(x==2){
            button2.setText(Integer.toString(z));
            button1.setText(Integer.toString(randomNumber()));
            button3.setText(Integer.toString(randomNumber()));
            button4.setText(Integer.toString(randomNumber()));
        }
        if(x==3){
            button3.setText(Integer.toString(z));
            button2.setText(Integer.toString(randomNumber()));
            button1.setText(Integer.toString(randomNumber()));
            button4.setText(Integer.toString(randomNumber()));
        }
        if(x==4){
            button4.setText(Integer.toString(z));
            button2.setText(Integer.toString(randomNumber()));
            button3.setText(Integer.toString(randomNumber()));
            button1.setText(Integer.toString(randomNumber()));
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        setTimer();
        final int min = 1;
        final int max = 4;
        final int random = new Random().nextInt((max - min) + 1) + min;
        setOption(random);
        button5.setVisibility(View.INVISIBLE);
        //textView2.setText(Integer.toString(count));


    }
}
