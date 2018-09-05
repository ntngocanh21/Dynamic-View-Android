package excel.tutorial.familytree.view.activity.Map;

import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import excel.tutorial.familytree.R;
import excel.tutorial.familytree.app.Application;
import excel.tutorial.familytree.custom.DrawView;
import excel.tutorial.familytree.custom.ZoomableRelativeLayout;
import excel.tutorial.familytree.di.module.MapModule;
import excel.tutorial.familytree.view.activity.BaseActivity;

public class MapActivity extends BaseActivity implements MapView {

    DrawView drawView;

    @BindView(R.id.zoomLayout)
    ZoomableRelativeLayout mZoomableRelativeLayout;

    /*@BindView(R.id.mainView)
    RelativeLayout mainView;*/

    @BindView(R.id.imv1)
    ImageView imv1;

    @BindView(R.id.imv2)
    ImageView imv2;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new MapModule(this, this))
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_map;
    }

    @Override
    protected void initViews() {
        /*mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView = new DrawView(MapActivity.this, imv1, imv2);
                drawView.setBackgroundColor(Color.WHITE);
                mainView.addView(drawView);
            }
        });*/

        final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(this, new OnPinchListener());
        mZoomableRelativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                scaleGestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    private class OnPinchListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        float startingSpan;
        float startFocusX;
        float startFocusY;


        public boolean onScaleBegin(ScaleGestureDetector detector) {
            startingSpan = detector.getCurrentSpan();
            startFocusX = detector.getFocusX();
            startFocusY = detector.getFocusY();
            return true;
        }


        public boolean onScale(ScaleGestureDetector detector) {
            mZoomableRelativeLayout.scale(detector.getCurrentSpan()/startingSpan, startFocusX, startFocusY);
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector) {
            Log.i("TAG", "Scale: "+detector.getScaleFactor());
            if (detector.getScaleFactor() < 1) {
                mZoomableRelativeLayout.restore();
            }
        }
    }
}