package excel.tutorial.familytree.di.component;

import dagger.Subcomponent;
import excel.tutorial.familytree.di.module.MapModule;
import excel.tutorial.familytree.di.scope.ActivityScope;
import excel.tutorial.familytree.view.activity.Map.MapActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@ActivityScope
@Subcomponent(

        modules = {
                MapModule.class
        }
)
public interface MapComponent {
    MapActivity inject(MapActivity activity);
}


