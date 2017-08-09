package activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import dagger.AppComponent;

/**
 * Created by win10 on 2017/8/3.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    protected AppComponent getAppComponent(){
        AppComponent component=((MyApplication)getApplication()).getAppComponent();//获取整个项目的AppComonet 这里可以注入一些通用的类，如访问网络的类等
       return  component;
    }
}
