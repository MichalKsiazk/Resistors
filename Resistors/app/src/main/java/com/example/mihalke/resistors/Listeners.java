package com.example.mihalke.resistors;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnDragListener;
import android.widget.Button;
import android.widget.TextView;

public class Listeners {
    int _w;
    int _h;
    final int codes[] =
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

    final int idList[] = {
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

    void SetOnOff(Button[]b, int[]i, int state){
        for(int l : i) {
            b[l].setVisibility(state);
        }
    }

    Listeners(int w) {
        _w = w;
    }

    void addEvents(MainActivity man)
    {
        final Calculator clc = new Calculator(man);
        final Button bands[] = {
            (Button)man.findViewById(R.id.band1),
            (Button)man.findViewById(R.id.band2),
            (Button)man.findViewById(R.id.band3),
            (Button)man.findViewById(R.id.band4),
            (Button)man.findViewById(R.id.band5),
        };


        final TextView txt = (TextView) man.findViewById(R.id.info);


        OnLongClickListener longListen = new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txt.setText("");
                int i = view.getId();
                if(i == idList[10] || i == idList[11])
                    SetOnOff(bands, new int[] {0,1,2}, View.INVISIBLE);
                if(i == idList[0] || i == idList[3] || i == idList[4]|| i == idList[9])
                    SetOnOff(bands, new int[] {4}, View.INVISIBLE);
                ClipData data = ClipData.newPlainText("","");
                DragShadow shadow = new DragShadow(view);
                view.startDrag(data, shadow, view,0);

                return false;
            }
        };
        OnDragListener DropListener = new OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                int dg = dragEvent.getAction();
                boolean t = true;
                //System.out.println(dragEvent.getResult());
                switch (dg)
                {
                    case DragEvent.ACTION_DROP:
                        //SetVisible(bands,new int[]{0,1,2}, View.VISIBLE);
                        System.out.println("DROP");
                        t = true;
                        Button target = (Button) view;
                        Button dragged = (Button) dragEvent.getLocalState();
                        int r = dragged.getId();
                        int c = choseColor(r);
                        target.setBackgroundColor(c);
                        clc.doMath();
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        for(final Button b : bands) {
                            b.post(new Runnable() {
                                @Override
                                public void run() {
                                    b.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                        System.out.println("ENDED");
                        return false;
                }
                return true;
            }
        };
        for(Button b : bands)
            b.setOnDragListener(DropListener);

        for (int n = 0; n <= 11; n++) {
            Button bn = (Button) man.findViewById(idList[n]);
            bn.setOnLongClickListener(longListen);
        }
    }

    int choseColor(int numer) {

        for(int i = 0; i <= 11;i++)
        {
            if(numer == idList[i])
                return codes[i];
        }
        return 0;
    }
    private class DragShadow extends View.DragShadowBuilder
    {
        GradientDrawable gd;
        public DragShadow(View view) {
            super(view);
            gd = new GradientDrawable();
        }

        @Override
        public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {

            super.onProvideShadowMetrics(outShadowSize, outShadowTouchPoint);
            View v = getView();
            int width = _w / 4;
            int r = v.getId();
            int c = choseColor(r);
            gd.setColor(c);
            gd.setBounds(0,0,width,width);
            gd.setCornerRadius(width/2);
            outShadowSize.set(width,width);
            outShadowTouchPoint.set(width/2,width/2);

        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            //super.onDrawShadow(canvas);
            gd.draw(canvas);

        }
    }
}
