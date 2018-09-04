package excel.tutorial.familytree.di.module;

import dagger.Module;
import excel.tutorial.familytree.view.activity.Home.HomeActivity;
import excel.tutorial.familytree.view.activity.Home.HomeView;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class HomeModule {

    private HomeActivity mActivity;
    private HomeView mView;

    public HomeModule(HomeActivity activity, HomeView view) {
        mActivity = activity;
        mView = view;
    }
}
