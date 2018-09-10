package com.example.mihalke.resistors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class CreateColors extends MainActivity {
    ArrayList<Button> custArr = new ArrayList<Button>();


    protected int codes[] =
    {
        Color.BLACK,
        Color.rgb(69, 56, 35),
        Color.RED,
        Color.rgb(226, 83, 0),
        Color.YELLOW,
        Color.GREEN,
        Color.BLUE,
        Color.rgb(185, 76, 225),
        Color.GRAY,
        Color.WHITE,
        Color.rgb(204, 153, 0),
        Color.LTGRAY
    };
    final int idList[] =
    {
        R.id.col0,
        R.id.col1,
        R.id.col2,
        R.id.col3,
        R.id.col4,
        R.id.col5,
        R.id.col6,
        R.id.col7,
        R.id.col8,
        R.id.col9,
        R.id.col10,
        R.id.col11,
    };

    protected void CreateColors(RelativeLayout l, Context c, int w, int h) {


        for (int i = 0; i <= 11; i++) {

            custArr.add(i, new Button(c));

            custArr.get(i).setBackgroundColor(codes[i]);
            GradientDrawable shape = new GradientDrawable();

            shape.setColor(codes[i]);
            declareID(custArr.get(i), i);
            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            int defRes = w/10;
            int defHeight = h;
            params1.height = defRes+1;
            params1.width = defRes+1;
            shape.setCornerRadius(defRes/2+1);
            custArr.get(i).setBackground(shape);
            if(i <= 6) {
                params1.setMargins(i * (defRes + 4) + w/16, h/3, 0, 0);
            }
            else
            {
                params1.setMargins((i - 6) * (defRes + 4)+ w/16, h/3 + defRes + 6, 0, 0);
            }
            l.addView(custArr.get(i), params1);
        }
        return;

    }

    private void declareID(Button btn, int numer) {
        for(int i = 0; i <= 11; i++)
        {
            if(numer == i)
                btn.setId(idList[i]);
        }


        return;
    }
}