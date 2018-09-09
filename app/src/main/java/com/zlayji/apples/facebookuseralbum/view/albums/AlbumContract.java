package com.zlayji.apples.facebookuseralbum.view.albums;

import com.zlayji.apples.facebookuseralbum.model.Album;

import java.util.List;

public class AlbumContract {

    interface View {
        void displayAlbum(List<Album> listAlbum);

    }

    interface Presenter {
        void getAlbums(String userId);
    }
}
