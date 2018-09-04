package excel.tutorial.familytree.di.component;

import javax.inject.Singleton;

import dagger.Component;
import excel.tutorial.familytree.di.module.AppModule;
import excel.tutorial.familytree.di.module.HomeModule;
import excel.tutorial.familytree.di.module.MapModule;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
        HomeComponent plus(HomeModule module);
        MapComponent plus(MapModule module);
}
