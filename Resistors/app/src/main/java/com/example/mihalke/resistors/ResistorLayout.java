package com.example.mihalke.resistors;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by mihalek on 2016-09-10.
 */
public class ResistorLayout {

    int color = Color.rgb(210,200,160);
    void CreateResistor(RelativeLayout l, Context c, int deviceWidth,int deviceHeight)
    {

        RelativeLayout.LayoutParams cable = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        cable.addRule(RelativeLayout.CENTER_HORIZONTAL);
        cable.height = deviceHeight /40;
        cable.width = deviceWidth /5 * 4;
        cable.setMargins(0, deviceHeight /12, 0, 0);

        TextView cb = new TextView(c);
        cb.setBackgroundColor(Color.GRAY);
        l.addView(cb, cable);



        RelativeLayout.LayoutParams mainPanelparam = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mainPanelparam.addRule(RelativeLayout.CENTER_HORIZONTAL);
        mainPanelparam.height = deviceHeight /5;
        mainPanelparam.width = deviceWidth /3 * 2;

        TextView mainPanel = new TextView(c);
        mainPanel.setBackgroundColor(Color.rgb(255,226,153));
        l.addView(mainPanel, mainPanelparam);



        RelativeLayout.LayoutParams band1 = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        band1.height = deviceHeight /5;
        band1.width = deviceWidth /16;
        band1.setMargins(deviceWidth/6, 0, 0, 0);

        Button b1 = new Button(c);
        b1.setBackgroundColor(color);
        b1.setId(R.id.band1);
        l.addView(b1, band1);

        RelativeLayout.LayoutParams band2 = new RelativeLayout.LayoutParams(
         RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        band2.height = deviceHeight /5;
        band2.width = deviceWidth /16;
        band2.setMargins(deviceWidth/4,0, 0, 0);

        Button b2 = new Button(c);
        b2.setBackgroundColor(color);
        b2.setId(R.id.band2);
        l.addView(b2, band2);

        RelativeLayout.LayoutParams band3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        band3.height = deviceHeight /5;
        band3.width = deviceWidth /16;
        band3.setMargins(deviceWidth/3,0, 0, 0);

        Button b3 = new Button(c);
        b3.setBackgroundColor(color);
        b3.setId(R.id.band3);
        l.addView(b3, band3);

        RelativeLayout.LayoutParams band4 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        band4.height = deviceHeight /5;
        band4.width = deviceWidth /16;
        band4.setMargins(deviceWidth/4*2,0, 0, 0);

        Button b4 = new Button(c);
        b4.setBackgroundColor(color);
        b4.setId(R.id.band4);
        l.addView(b4, band4);


        RelativeLayout.LayoutParams band5 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        band5.height = deviceHeight /5;
        band5.width = deviceWidth /16;
        band5.setMargins(deviceWidth/7*5,0, 0, 0);

        Button b5 = new Button(c);
        b5.setBackgroundColor(color);
        b5.setId(R.id.band5);
        l.addView(b5, band5);

    }
}
