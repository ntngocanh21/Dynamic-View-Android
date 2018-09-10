package excel.tutorial.familytree.di.module;

import dagger.Module;
import dagger.Provides;
import excel.tutorial.familytree.di.scope.ActivityScope;
import excel.tutorial.familytree.view.fragment.map.FragmentNode;

/**
 * Created by lorence on 7/9/2018.
 *
 * @author lorence
 */

@Module
public class DialogModule {

    public DialogModule() {
    }

    @Provides
    @ActivityScope
    FragmentNode provideFragmentNode() {
        return new FragmentNode();
    }
}
