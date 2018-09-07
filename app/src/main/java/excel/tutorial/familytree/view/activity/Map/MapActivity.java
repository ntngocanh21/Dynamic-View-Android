package excel.tutorial.familytree.view.activity.Map;

import android.view.MotionEvent;
import android.view.View;

import excel.tutorial.familytree.R;
import excel.tutorial.familytree.app.Application;
import excel.tutorial.familytree.custom.ZoomLinearLayout;
import excel.tutorial.familytree.di.module.MapModule;
import excel.tutorial.familytree.view.activity.BaseActivity;

public class MapActivity extends BaseActivity implements MapView {

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
    }
}