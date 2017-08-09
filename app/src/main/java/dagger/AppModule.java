package dagger;

import javax.inject.Singleton;

import javabean.AppData;

/**
 * Created by win10 on 2017/8/8.
 */
@Module
public class AppModule {
    @Singleton
    @Provides
    AppData providesData() {
        return new AppData();
    }
}
