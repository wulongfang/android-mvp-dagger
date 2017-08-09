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
import module.main.RecDataGenerator;
import presenter.main.MainPresenterImp;
import view.main.IMainView;

/**
 * Created by win10 on 2017/8/4.
 */
@Module
public class MainModule {
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
    public RecDataGenerator getDefault() {//provide和name 使用
        return new RecDataGenerator();
    }


    @Provides
    @Named(MainPresenterImp.NOTDEFAULT)
    public RecDataGenerator getNotDefault() {
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
}
