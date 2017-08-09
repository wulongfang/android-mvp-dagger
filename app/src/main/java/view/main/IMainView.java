package view.main;

import java.util.List;

import javabean.RecData;

/**
 * Created by win10 on 2017/8/3.
 */

public interface IMainView {
    void showRec(List<RecData> dataList) ;
    void showDataLenth(int dataLenth);
    void showError(String error);
}
