package excel.tutorial.familytree.view.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public abstract class BaseActivity extends Activity implements BaseView {

    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        distributedDaggerComponents();
        setContentView(getLayoutRes());
        mUnbinder = ButterKnife.bind(this);
        ButterKnife.bind(this);
        initViews();
    }

    public abstract void distributedDaggerComponents();

    protected abstract int getLayoutRes();

    protected abstract void initViews();

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }
}