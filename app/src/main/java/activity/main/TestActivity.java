package activity.main;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import javax.inject.Inject;

import activity.BaseActivity;
import dagger.AppModule;
import dagger.DaggerAppComponent;
import dagger.module.MainModule;
import javabean.ActivityData;
import javabean.AppData;

/**
 * Created by win10 on 2017/8/17.
 */

public class TestActivity extends BaseActivity {

    @Inject
    AppData data, data2;
//    @Inject
//    ActivityData activityData1,activityData2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       DaggerAppComponent.builder().build().inject(this);
        Log.d("LOG", "test data --- data2 is " + data + "---" + data2);
//        Log.d("LOG","activity data1 and data2 is "+activityData1+"      "+activityData2);
    }
}
