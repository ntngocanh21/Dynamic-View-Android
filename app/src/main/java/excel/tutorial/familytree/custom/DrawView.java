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
        linePaint.setColor(Color.BLACK);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(2);
        Log.i("TAG", "Width: " + startView.getWidth()/2);
        Log.i("TAG", "Height: " + startView.getHeight()/2);
        canvas.drawLine(startView.getX()+startView.getWidth()/2, startView.getY()+startView.getHeight()/2, endView.getX()+endView.getWidth()/2, endView.getY()+endView.getHeight()/2, linePaint);
//        canvas.drawLine(startView.getX()+50, startView.getY()+50, endView.getX()+50, endView.getY(), linePaint);
    }

}
