package presenter.main;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import javabean.RecData;
import module.main.RecDataGenerator;
import view.main.IMainView;

/**
 * Created by win10 on 2017/8/3.
 */

public class MainPresenterImp implements IMainPresenter {
    boolean isdefault = true;
    List<RecData> dataList;
    public static final String DEFAULT = "default";
    public static final String NOTDEFAULT = "notdefault";
    @Inject
    @Named(NOTDEFAULT)
    RecDataGenerator notDefaultgenerator;//通过named 产生两个不同的实例

    @Inject
    @Named(DEFAULT)
    RecDataGenerator defaultgenerator;
    @Inject
    IMainView view;


    @Inject
    public MainPresenterImp(IMainView view) {
        this.view = view;
    }

    @Override
    public void getData() {//业务数据处理
        defaultgenerator.generateData(new GenDataListenerImpl());
    }

    class GenDataListenerImpl implements RecDataGenerator.OnGenDataListener {

        @Override
        public void onSucess(List<RecData> data) {
            dataList = data;
            view.showRec(dataList);
            if (is10MoreData()) {
                view.showDataLenth(dataList.size());
            }
        }

        @Override
        public void onFailed(String error) {
            view.showError(error);
        }
    }

    public void changeDefault() {
        isdefault = !isdefault;
        GenDataListenerImpl listener = new GenDataListenerImpl();
        if (isdefault) {
            defaultgenerator.generateData(listener);
        } else {
            notDefaultgenerator.generateData(listener);
        }

    }

    @Override
    public boolean is10MoreData() {//业务相关判断
        return dataList.size() > 10;
    }
}
