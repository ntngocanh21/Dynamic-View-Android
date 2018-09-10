package excel.tutorial.familytree.view.activity.Home;

import android.annotation.SuppressLint;
import android.content.Intent;

import excel.tutorial.familytree.R;
import excel.tutorial.familytree.app.Application;
import excel.tutorial.familytree.di.module.HomeModule;
import excel.tutorial.familytree.view.activity.BaseActivity;
import excel.tutorial.familytree.view.activity.Map.MapActivity;

@SuppressLint("Registered")
public class HomeActivity extends BaseActivity implements HomeView {

    private HomePresenter mHomePresenter;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance().getAppComponent().plus(new HomeModule(this, this)).inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void initViews() {
        mHomePresenter = new HomePresenterImpl(this);
        mHomePresenter.getMapTreeFamily();
        startActivity(new Intent(HomeActivity.this, MapActivity.class));
    }
}
