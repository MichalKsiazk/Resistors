package com.example.mihalke.resistors;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mihalke.resistors.R;


public class MainActivity extends AppCompatActivity {
    RelativeLayout layOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layOut = (RelativeLayout) findViewById(R.id.activity_main);
        Context appContext = getApplicationContext();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        showOutput(layOut,height,width);


        CreateColors cc = new CreateColors();
        cc.CreateColors(layOut, appContext,width, height);
        Listeners ln = new Listeners(width);
        setContentView(layOut);
        ResistorLayout rl = new ResistorLayout();
        rl.CreateResistor(layOut, appContext,width,height);
        ln.addEvents(this);
        ThirdButton tb = new ThirdButton();
        tb.ShowAndHide(this ,layOut, appContext,width, height);
    }



    void showOutput(RelativeLayout l,int h, int w)
    {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0,h/5*3, 0, 0);

        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp2.setMargins(w/5*3,h/5*3, 0, 0);


        RelativeLayout.LayoutParams cp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        cp.setMargins(w/2 - w/7,h/12*3, 0, 0);

        TextView t6 = new TextView(this);
        t6.setText("hold to pickup");
        t6.setId(R.id.info);
        l.addView(t6,cp);

        TextView t1 = new TextView(this);
        t1.setId(R.id.text1);
        t1.setText("Resistance");
        l.addView(t1,lp);
        TextView t2 = new TextView(this);
        t2.setId(R.id.text2);
        t2.setText("Tolerance");
        l.addView(t2,lp2);
    }
}

















