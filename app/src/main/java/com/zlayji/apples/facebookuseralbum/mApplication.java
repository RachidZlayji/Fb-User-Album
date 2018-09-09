package com.zlayji.apples.facebookuseralbum;

import android.app.Application;

import com.zlayji.apples.facebookuseralbum.util.AppComponent;
import com.zlayji.apples.facebookuseralbum.util.AppModule;
import com.zlayji.apples.facebookuseralbum.util.DaggerAppComponent;

public class mApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
