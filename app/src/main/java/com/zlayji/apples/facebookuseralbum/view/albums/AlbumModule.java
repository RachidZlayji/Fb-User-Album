package com.zlayji.apples.facebookuseralbum.view.albums;

import com.zlayji.apples.facebookuseralbum.util.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AlbumModule {

    private AlbumContract.View view;


    public AlbumModule(AlbumContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public AlbumContract.View provideContext(){
        return view;
    }

}
