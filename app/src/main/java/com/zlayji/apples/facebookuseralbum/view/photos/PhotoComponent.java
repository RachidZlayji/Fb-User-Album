package com.zlayji.apples.facebookuseralbum.view.photos;

import com.zlayji.apples.facebookuseralbum.util.ActivityScope;
import com.zlayji.apples.facebookuseralbum.util.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = PhotoModule.class)
public interface PhotoComponent {

    void inject(PhotoActivity activity);

}
