package dagger;

import javax.inject.Singleton;

import dagger.component.MainComponent;
import dagger.module.MainModule;

/**
 * Created by win10 on 2017/8/8.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    MainComponent addSub(MainModule module);
}
