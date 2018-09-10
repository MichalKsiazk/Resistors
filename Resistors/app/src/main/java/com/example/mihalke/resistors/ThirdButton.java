package com.example.mihalke.resistors;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;

/**
 * Created by mihalek on 2016-09-01.
 */
public class ThirdButton {

    int defColor = Color.rgb(210,200,160);
    int hideColor = Color.rgb(255,226,153);
    public void ShowAndHide(MainActivity man,RelativeLayout act, Context ctx, int w, int h)
    {
        final Button thirdButton = (Button) act.findViewById(R.id.band3);
        final Calculator clc = new Calculator(man);

        OnClickListener longListen = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(thirdButton.isEnabled() == false) {
                    thirdButton.setEnabled(true);
                    thirdButton.setBackgroundColor(defColor);
                    clc.doMath();
                }
                else if(thirdButton.isEnabled() == true) {
                    thirdButton.setEnabled(false);
                    thirdButton.setBackgroundColor(hideColor);
                    clc.doMath();
                }

                return;
            }
        };


        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params1.setMargins(0,h/7*5,0,0);


        thirdButton.setEnabled(false);
        thirdButton.setBackgroundColor(hideColor);
        Switch sw = new Switch(ctx);
        sw.setText("Third band");
        sw.setTextColor(Color.GRAY);
        sw.setOnClickListener(longListen);
        act.addView(sw, params1);




    }

}
