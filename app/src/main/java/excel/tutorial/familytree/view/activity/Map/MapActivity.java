package excel.tutorial.familytree.view.activity.Map;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
    }
}