package com.zlayji.apples.facebookuseralbum.view.albums;

import com.zlayji.apples.facebookuseralbum.util.ActivityScope;
import com.zlayji.apples.facebookuseralbum.util.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = AlbumModule.class)
public interface AlbumComponent {

    void inject(AlbumActivity activity);

}
