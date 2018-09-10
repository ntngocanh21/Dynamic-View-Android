package excel.tutorial.familytree.view.activity.Map;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import excel.tutorial.familytree.R;
import excel.tutorial.familytree.app.Application;
import excel.tutorial.familytree.custom.DrawView;
import excel.tutorial.familytree.custom.ZoomLinearLayout;
import excel.tutorial.familytree.di.module.MapModule;
import excel.tutorial.familytree.view.activity.BaseActivity;

public class MapActivity extends BaseActivity implements MapView {


    @BindView(R.id.mainView)
    RelativeLayout mainView;

    @BindView(R.id.imv1)
    ImageView imv1;

    @BindView(R.id.imv2)
    ImageView imv2;

    private DrawView drawView;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance().getAppComponent().plus(new MapModule(this, this)).inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_map;
    }

    @Override
    protected void initViews() {
        final ZoomLinearLayout zoomLinearLayout = findViewById(R.id.zoomLayout);
        zoomLinearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                zoomLinearLayout.init(MapActivity.this);
                return false;
            }
        });

        drawView = new DrawView(MapActivity.this, imv1, imv2);
        mainView.addView(drawView);
    }
}