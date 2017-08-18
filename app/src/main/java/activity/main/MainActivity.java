package activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import activity.BaseActivity;
import adapter.main.MainRecAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.AppModule;
import dagger.DaggerAppComponent;
import dagger.module.MainModule;
import javabean.ActivityData;
import javabean.AppData;
import javabean.RecData;
import javabean.TestData1;
import view.main.IMainView;
import wlf.mvpdagger.R;

public class MainActivity extends BaseActivity implements IMainView {

    @Inject
    TestData1 testData1;
    //    @Inject
//    MainPresenterImp presenterImp;
    @Inject
    AppData appData1;
    @Inject
    AppData appData2;
//    @Inject
//    ActivityData activityData1;
//    @Inject
//    ActivityData activityData2;

    @BindView(R.id.rec_items)
    RecyclerView recItems;
    @BindView(R.id.test)
    Button test ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        DaggerMainComponent.builder().mainModule(new MainModule()).build().inject(this);//这里完成注入
          getAppComponent().addSub(new MainModule()).inject(this);
//        recItems = (RecyclerView) findViewById(R.id.rec_items);
//        recItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        recItems.addItemDecoration(new RecMainItemDecoration(this));
//        getAppComponent().addSub(new MainModule(this)).inject(this);//MainComponent 为SubComponent 通过这边addsub 使得到的MainComponent 可以注入AppData
//        Log.d("LOG", "test data is " + testData1.getTestString());
        //Log.d("LOG", "activity data 1 is " + activityData1 + " activity data 2 is " + activityData2);//由于scope的作用activityData1,activityData2 是同一个实例
          Log.d("LOG", " data 1 is " + appData1 + "  data 2 is " + appData2);//由于scope的作用activityData1,activityData2 是同一个实例
//        presenterImp.getData();
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TestActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public void showRec(List<RecData> dataList) {
        MainRecAdapter adapter = (MainRecAdapter) recItems.getAdapter();
        if (adapter == null) {
            adapter = new MainRecAdapter(this, dataList);
            recItems.setAdapter(adapter);
            adapter.setListener(new MainRecAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Log.d("LOG", "position is " + position);
//                    presenterImp.changeDefault();
                    Intent intent=new Intent(MainActivity.this,TestActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            });
        } else {
            adapter.setDataList(dataList);
            adapter.notifyDataSetChanged();
        }

    }


    @Override
    public void showDataLenth(int dataLenth) {
        Toast.makeText(this, "datalenth is " + dataLenth, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showError(String error) {
        Toast.makeText(this, "error is  " + error, Toast.LENGTH_SHORT).show();
    }


}
