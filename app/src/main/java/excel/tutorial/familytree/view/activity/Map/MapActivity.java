package excel.tutorial.familytree.view.activity.Map;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import excel.tutorial.familytree.R;
import excel.tutorial.familytree.app.Application;
import excel.tutorial.familytree.custom.DrawView;
import excel.tutorial.familytree.custom.ZoomLinearLayout;
import excel.tutorial.familytree.di.module.MapModule;
import excel.tutorial.familytree.utilities.Constants;
import excel.tutorial.familytree.view.activity.BaseActivity;
import excel.tutorial.familytree.view.fragment.map.FragmentNode;

public class MapActivity extends BaseActivity implements MapView {

    @Inject
    Context mContext;

    @Inject
    MapActivity mActivity;

    @BindView(R.id.mainView)
    RelativeLayout mainView;

    @BindView(R.id.imv1)
    ImageView imv1;

    @BindView(R.id.imv2)
    ImageView imv2;

    @BindView(R.id.fabNode)
    FloatingActionButton fabNode;

    @Inject
    FragmentNode mFragmentNode;

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
        mFragmentNode.setParentFragment(mContext, this);
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

        mFragmentNode.attachEventInterface(new FragmentNode.InterfaceRecipeFragment() {
            @Override
            public void addRecipe(Object recipe) {
                // TODO
            }
        });
    }

    @OnClick(R.id.fabNode)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabNode:
                showDialogNode();
                break;
        }
    }

    @Override
    public void showDialogNode() {
        mFragmentNode.show(mActivity.getFragmentManager(), Constants.TAG_NODE);
    }
}