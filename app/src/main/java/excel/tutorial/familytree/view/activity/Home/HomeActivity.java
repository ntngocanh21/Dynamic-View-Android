package excel.tutorial.familytree.view.activity.Home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import excel.tutorial.familytree.R;
import excel.tutorial.familytree.app.Application;
import excel.tutorial.familytree.di.module.HomeModule;
import excel.tutorial.familytree.view.activity.BaseActivity;
import excel.tutorial.familytree.view.activity.Map.MapActivity;

@SuppressLint("Registered")
public class HomeActivity extends BaseActivity implements HomeView {

    @BindView(R.id.edtName)
    EditText edtName;

    @BindView(R.id.edtNumber)
    EditText edtNumber;

    @BindView(R.id.btnProcess)
    Button btnProcess;

    private HomePresenter mHomePresenter;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule(this, this))
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void initViews() {
        mHomePresenter = new HomePresenterImpl(this);
        mHomePresenter.getMapTreeFamily();
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MapActivity.class));
            }
        });
    }
}
