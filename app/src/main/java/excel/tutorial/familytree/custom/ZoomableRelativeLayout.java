package excel.tutorial.familytree.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.RelativeLayout;

public class ZoomableRelativeLayout extends RelativeLayout {

    private float scale = 1;
    private float mPivotX;
    private float mPivotY;
    private int _xDelta;
    private int _yDelta;

    private ScaleGestureDetector mScaleGestureDetector;

    public ZoomableRelativeLayout(Context context) {
        super(context);
        init(context);
    }

    public ZoomableRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ZoomableRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setOnTouchListener(new MyTouchListeners());
        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        float currentSpan;
        float startFocusX;
        float startFocusY;

        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Log.i("TAG", "onScaleBegin: "+detector.getCurrentSpan());
            currentSpan = detector.getCurrentSpan();
            startFocusX = detector.getFocusX();
            startFocusY = detector.getFocusY();
            return true;
        }

        public boolean onScale(ScaleGestureDetector detector) {
            scale(detector.getCurrentSpan()/ currentSpan, startFocusX, startFocusY);
            Log.i("TAG", "onScale: "+currentSpan);
            Log.i("TAG", "startFocusX: " +startFocusX);
            Log.i("TAG", "startFocusY: " +startFocusY);
            return true;
        }
    }

    private class MyTouchListeners implements View.OnTouchListener {

        MyTouchListeners() {
            super();
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mScaleGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.scale(scale, scale, mPivotX, mPivotY);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void scale(float scaleFactor, float pivotX, float pivotY) {
        scale = scaleFactor;
        mPivotX = pivotX;
        mPivotY = pivotY;
        this.invalidate();
    }
}
