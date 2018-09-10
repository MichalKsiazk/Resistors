package com.example.mihalke.resistors;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mihalek on 2016-08-28.
 */
public class Calculator {
    int defaultColor;
    Button band1;
    Button band2;
    Button band3;
    Button band4;
    Button band5;
    TextView text;
    TextView text2;
    static final int codes[] =
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

    public Calculator(MainActivity man) {
        band1 = (Button) man.findViewById(R.id.band1);
        band2 = (Button) man.findViewById(R.id.band2);
        band3 = (Button) man.findViewById(R.id.band3);
        band4 = (Button) man.findViewById(R.id.band4);
        band5 = (Button) man.findViewById(R.id.band5);
        text = (TextView) man.findViewById(R.id.text1);
        text2 = (TextView) man.findViewById(R.id.text2);
    }

    void SetResult(double finD){
        String sm = "";
        String om = "\u03A9";
        if(finD >= 1000000000) {
            finD = (finD / 1000000000);
            sm = " G" + om;
        }
        else if(finD >= 1000000) {
            finD = (finD / 1000000);
            sm = " M" + om;
        }
        else if(finD >= 1000) {
            finD = (finD / 1000);
            sm = " K" + om;
        }
        else
            sm = om;

        finD = Math.round(finD * 100.0) / 100.0;
        text.setText(Double.toString(finD) + sm);
    }

    void doMath() {

        String b1 = bandf(band1);
        String b2 = bandf(band2);
        String b3 = bandf(band3);
        String b5 = toleranceF(band5);
        double mtx = multiply(band4);
        int tog;
        text2.setText(b5);
        if(b1 != "null" && b2 != "null" && mtx != 0 && b3 != "null")
        {
            String fin = b1+b2+b3;
            double finD = Double.parseDouble(fin)*mtx;
            SetResult(finD);
        }
        else if(b1 != "null" && b2 != "null" && mtx != 0 && b3 == "null")
        {
            String fin = b1+b2;
            double finD = Double.parseDouble(fin)*mtx;
            SetResult(finD);
        }
        else
        text.setText("-");


    }
    String bandf(Button bt)
    {
        defaultColor = Color.rgb(210, 200, 160);
        ColorDrawable cl= (ColorDrawable) bt.getBackground();
        int col = cl.getColor();
        if(col == defaultColor && bt == band3)
        {
            return "null";
        }
        if(col == Color.rgb(255,226,153) && bt == band3)
        {
            return "null";
        }
        if(col == defaultColor && bt == band1 )
        {
            return "null";
        }
        if(col == codes[10] && (bt == band3 || bt == band1))
        {
            bt.setBackgroundColor(defaultColor);
            return "null";
        }
        if(col == codes[11] && (bt == band3 ||bt == band1))
    {
        bt.setBackgroundColor(defaultColor);
        return "null";
    }

        if(col == defaultColor)
            return "0";
        else if(col == codes[0])
            return "0";
        else if(col == codes[1])
            return "1";
        else if(col == codes[2])
            return "2";
        else if(col == codes[3])
            return "3";
        else if(col == codes[4])
            return "4";
        else if(col == codes[5])
            return "5";
        else if(col == codes[6])
            return "6";
        else if(col == codes[7])
            return "7";
        else if(col == codes[8])
            return "8";
        else if(col == codes[9])
        {return "9";}
        else if(col == codes[10])
        {
            bt.setBackgroundColor(defaultColor);
            return "0";
        }
        else if(col == codes[11])
        {
            bt.setBackgroundColor(defaultColor);
            return "0";
        }
        return "0";
    }
    double multiply(Button bt)
    {
        defaultColor = Color.rgb(210, 200, 160);
        ColorDrawable cl= (ColorDrawable) bt.getBackground();
        int col = cl.getColor();
        if(col == defaultColor)
        {
            return 0;
        }
        else if(col == codes[0])
        {
            return 1;
        }
        else if(col == codes[1])
        {
            return 10;
        }
        else if(col == codes[2])
        {
            return 100;
        }
        else if(col == codes[3])
        {
            return 1000;
        }
        else if(col == codes[4])
        {
            return 10000;
        }
        else if(col == codes[5])
        {
            return 100000;
        }
        else if(col == codes[6])
        {
            return 1000000;
        }
        else if(col == codes[7])
        {
            return 10000000;
        }
        else if(col == codes[8])
        {
            return 100000000;
        }
        else if(col == codes[9])
        {
            return 1000000000;
        }
        else if(col == codes[10])
        {
            return 0.1;
        }
        else if(col == codes[11])
        {
            return 0.01;
        }
        return 0;
    }
    String toleranceF(Button bt)
    {
        defaultColor = Color.rgb(210, 200, 160);
        ColorDrawable cl= (ColorDrawable) bt.getBackground();
        int col = cl.getColor();

        String pm =  "\u00B1 ";
        if(col == defaultColor)
        {
            return "Tolerance";
        }
        else if (col == codes[0] || col == codes[4] || col == codes[3] || col == codes[9])
        {
            bt.setBackgroundColor(defaultColor);
            return "-";
        }
        else if(col == codes[1])
            return pm + "1%";
        else if(col == codes[2])
            return pm + "12%";
        else if(col == codes[5])
            return pm + "0.5%";
        else if(col == codes[6])
            return pm + "0.25%";
        else if(col == codes[7])
            return pm + "0.10%";
        else if(col == codes[8])
            return pm + "0.05%";
        else if(col == codes[10])
            return pm + "5%";
        else if(col == codes[11])
            return pm + "10%";

        return "-";
    }
}
