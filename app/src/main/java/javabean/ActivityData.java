package javabean;

import javax.inject.Inject;

import dagger.scope.ActivityScope;

/**
 * Created by win10 on 2017/8/8.
 */
@ActivityScope
public class ActivityData {
    @Inject
    public ActivityData() {
    }
}
