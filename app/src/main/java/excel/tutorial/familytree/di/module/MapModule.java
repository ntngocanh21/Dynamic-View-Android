package excel.tutorial.familytree.di.module;

import dagger.Module;
import excel.tutorial.familytree.view.activity.Map.MapActivity;
import excel.tutorial.familytree.view.activity.Map.MapView;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class MapModule {

    private MapActivity mActivity;
    private MapView mView;

    public MapModule(MapActivity activity, MapView view) {
        mActivity = activity;
        mView = view;
    }
}
