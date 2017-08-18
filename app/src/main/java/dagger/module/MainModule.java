package dagger.module;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.inject.Named;

import adapter.main.MainRecAdapter;
import dagger.Module;
import dagger.Provides;
import dagger.scope.ActivityScope;
import javabean.ActivityData;
import javabean.TestData1;
import module.main.RecDataGenerator;
import presenter.main.MainPresenterImp;
import view.main.IMainView;

/**
 * Created by win10 on 2017/8/4.
 */
@Module
public class MainModule {
    @Provides
    public TestData1 getTestData(){
        return new TestData1();
    }

    public MainModule() {
    }

    IMainView view;

    public MainModule(IMainView view) {
        this.view = view;
    }

    @Provides
    IMainView providesView() {
        return view;
    }

    @Provides
    @Named(MainPresenterImp.DEFAULT)
    public RecDataGenerator getDefault() {//通过注解Named 来获取不同的实例
        return new RecDataGenerator();
    }



    @Provides
    @Named(MainPresenterImp.NOTDEFAULT)
    public RecDataGenerator getNotDefault() {//通过注解Named 来获取不同的实例
        return new RecDataGenerator("this is not defualt ");
    }

    @Provides
    public MainRecAdapter.OnItemClickListener getListener() {//接口注入
        return new MainRecAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Context context = view.getContext();
                Toast.makeText(context, "position " + position + " is click", Toast.LENGTH_LONG).show();
            }
        };
    }
    @ActivityScope
    @Provides
    public ActivityData providesActivityData(){
        return new ActivityData();
    }
}
