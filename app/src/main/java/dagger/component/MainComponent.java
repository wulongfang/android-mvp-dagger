package dagger.component;

import activity.main.MainActivity;
import activity.main.TestActivity;
import dagger.Component;
import dagger.Subcomponent;
import dagger.module.MainModule;
import dagger.scope.ActivityScope;

/**
 * Created by win10 on 2017/8/4.
 */
@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
    void inject(TestActivity testActivity);
}
