package activity;

import android.app.Application;

import dagger.AppComponent;
import dagger.AppModule;
import dagger.DaggerAppComponent;

/**
 * Created by win10 on 2017/8/8.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public AppComponent getAppComponent(){
         if (appComponent==null){
             appComponent=DaggerAppComponent.builder().appModule(new AppModule()).build();
         }
        return appComponent;
    }
}
