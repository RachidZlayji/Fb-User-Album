package com.zlayji.apples.facebookuseralbum.view.photos;

import com.zlayji.apples.facebookuseralbum.model.Photo;

import java.util.List;

public class PhotoContract {

    interface View {
        void displayPhoto(List<Photo> listphoto);

    }

    interface Presenter {
        void getPhotos(String albumid);
    }
}
