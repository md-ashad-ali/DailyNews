
package com.example.worldnews;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class NewsDetels extends AppCompatActivity {

    TextView Ntitle,Ndes;
    ImageView Nimagesview;
    FloatingActionButton febs;

    public static String TITLE ="";
    public static String DESCRIPTION ="";
    public  static Bitmap MYBITMAP = null;
    TextToSpeech textToSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detels);

        Ntitle = findViewById(R.id.news_title);
        Ndes = findViewById(R.id.news_des);
        Nimagesview = findViewById(R.id.news_images);
        febs = findViewById(R.id.news_fab);

        textToSpeech= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        Ntitle.setText(TITLE);
        Ndes.setText(DESCRIPTION);
        if(MYBITMAP != null) Nimagesview.setImageBitmap(MYBITMAP);

        febs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textToSpeech.speak(""+Ndes.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

            }
        });

        Ndes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textToSpeech.stop();
            }
        });




    }
}