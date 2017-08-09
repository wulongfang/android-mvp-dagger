package module.main;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import adapter.main.MainRecAdapter;
import javabean.RecData;
import wlf.mvpdagger.R;

/**
 * Created by win10 on 2017/8/3.
 */

public class RecDataGenerator {
    List<RecData> dataList;

    public RecDataGenerator() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            dataList.add(new RecData(R.mipmap.panda_default, "this is defaut " + i + "item"));
        }

    }

    public RecDataGenerator(String text) {
        dataList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            dataList.add(new RecData(R.mipmap.panda_not_default, text + " " + i));
        }
    }

    public void generateData(final OnGenDataListener listener) {
        try {
            Thread.sleep(500);//模拟耗时操作
            listener.onSucess(dataList);
        } catch (Exception e) {
            listener.onFailed(e.toString());
        }
    }


    public interface OnGenDataListener {
        void onSucess(List<RecData> data);

        void onFailed(String String);
    }
}
