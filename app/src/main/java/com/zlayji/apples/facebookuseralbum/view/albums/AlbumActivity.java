package com.zlayji.apples.facebookuseralbum.view.albums;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zlayji.apples.facebookuseralbum.R;
import com.zlayji.apples.facebookuseralbum.mApplication;
import com.zlayji.apples.facebookuseralbum.model.Album;
import com.zlayji.apples.facebookuseralbum.view.adapter.AlbumAdapter;

import java.util.List;

import javax.inject.Inject;

public class AlbumActivity extends AppCompatActivity implements AlbumContract.View {

    @Inject
    AlbumPresenter presenter;

    RecyclerView listalbum;

    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        DaggerAlbumComponent.builder()
                .appComponent(((mApplication)getApplicationContext()).getAppComponent())
                .albumModule(new AlbumModule(this))
                .build()
                .inject(this);

        listalbum = findViewById(R.id.album_list);

        if(getIntent().getStringExtra("userID") != null){
            presenter.getAlbums(getIntent().getStringExtra("userID"));
        }
    }

    @Override
    public void displayAlbum(List<Album> listAlbum) {
        albumAdapter = new AlbumAdapter(listAlbum, this);
        LinearLayoutManager layoutManager =  new GridLayoutManager(getApplicationContext(), 2);
        listalbum.setLayoutManager(layoutManager);
        listalbum.setAdapter(albumAdapter);
    }
}
