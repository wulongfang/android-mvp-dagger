package javabean;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;

/**
 * Created by win10 on 2017/8/15.
 */
@Singleton
public class TestData1 {
    private  String testString="this is test data String ";

    public String getTestString() {
        return testString;
    }

    @Inject
    public TestData1() {

    }
}
