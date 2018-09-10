package excel.tutorial.familytree.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class DrawView extends View {

    View startView;
    View endView;

    public DrawView(Context context, View startView, View endView) {
        super(context);
        this.startView = startView;
        this.endView = endView;
    }

    @SuppressLint("NewApi")
    public void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation")
        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.RED);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(2);
        Log.i("TAG", "Width: " + startView.getWidth()/2);
        Log.i("TAG", "Height: " + startView.getHeight()/2);
        float x1 = startView.getX() + startView.getWidth()/2 - Math.round(startView.getWidth()/2*Math.cos(45*Math.PI/180));
        float y1 = startView.getY() + startView.getHeight()/2 + Math.round(startView.getWidth()/2*Math.cos(45*Math.PI/180.0));
        float x2 = endView.getX()+endView.getWidth()/2 + Math.round(startView.getWidth()/2*Math.cos(45*Math.PI/180.0));
        float y2 = endView.getY()+endView.getHeight()/2 - Math.round(startView.getWidth()/2*Math.cos(45*Math.PI/180.0));
        canvas.drawLine(x1, y1,
                x2, y2, linePaint);
    }

}
