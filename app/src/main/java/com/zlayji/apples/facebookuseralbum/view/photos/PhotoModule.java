package com.zlayji.apples.facebookuseralbum.view.photos;

import com.zlayji.apples.facebookuseralbum.util.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class PhotoModule {

    private PhotoContract.View view;


    public PhotoModule(PhotoContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public PhotoContract.View provideContext(){
        return view;
    }

}
