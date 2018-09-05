package excel.tutorial.familytree.view.activity.Map;

import android.widget.ImageView;

import butterknife.BindView;
import excel.tutorial.familytree.R;
import excel.tutorial.familytree.app.Application;
import excel.tutorial.familytree.custom.ZoomView;
import excel.tutorial.familytree.di.module.MapModule;
import excel.tutorial.familytree.view.activity.BaseActivity;

public class MapActivity extends BaseActivity implements MapView {

//    DrawView drawView;

//    @BindView(R.id.zoomLayout)
    ZoomView mZoomableRelativeLayout;

    /*@BindView(R.id.mainView)
    RelativeLayout mainView;*/

//    @BindView(R.id.imv1)
//    ImageView imv1;
//
//    @BindView(R.id.imv2)
//    ImageView imv2;

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
        mZoomableRelativeLayout = this.findViewById(R.id.zoomLayout);
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