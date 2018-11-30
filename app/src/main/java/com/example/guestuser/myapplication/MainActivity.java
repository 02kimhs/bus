package com.example.guestuser.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

WebView webView;
WebSettings webSettings;

    Car bus = new Car();

    TextView textView;

    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        textView.setOnClickListener(this);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        imageView.setImageResource(R.drawable.bus);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.barbara_gray);
        imageView2.setImageBitmap(bitmap);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://m.naver.com");


    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.button){
            bus.speedup();
            textView.setText(""+bus.speed);
            imageView3.setImageResource(R.drawable.bus);
            webView.goBack();
           }

        if(v.getId()==R.id.button2){
            bus.speeddown();
            String busspeed = String.valueOf(bus.speed);
            textView.setText(busspeed);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.barbara_gray);
            imageView3.setImageBitmap(bitmap);
        }
        if(v.getId()==R.id.button3){
            bus.breakme();
            String busspeed = String.valueOf(bus.speed);
            textView.setText(busspeed);
            Log.d("my_tag", "speed = "+bus.speed);
        }
        if(v.getId()==R.id.textView){
            bus.speed = 50;
            String text2 = "Speed";
            textView.setText(text2);

        }
        if(bus.speed<=0){
            textView.setText("정지");
            bus.speed = 0;
        }
        if(bus.speed>=200){
            textView.setText("과속");
            bus.speed=200;
        }

    }

}


class Car {
    int speed = 50;

    void speedup() {
        speed = speed + 10;
    }

    void speeddown() {
        speed = speed - 10;
    }

    void breakme() {
        speed = 0;
    }
}
