package excel.tutorial.familytree.di.component;

import dagger.Subcomponent;
import excel.tutorial.familytree.di.module.HomeModule;
import excel.tutorial.familytree.di.scope.ActivityScope;
import excel.tutorial.familytree.view.activity.Home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@ActivityScope
@Subcomponent(

        modules = {
                HomeModule.class
        }
)
public interface HomeComponent {
    HomeActivity inject(HomeActivity activity);
}


