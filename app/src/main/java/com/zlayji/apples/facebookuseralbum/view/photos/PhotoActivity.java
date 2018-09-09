package com.zlayji.apples.facebookuseralbum.view.photos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.zlayji.apples.facebookuseralbum.R;
import com.zlayji.apples.facebookuseralbum.mApplication;
import com.zlayji.apples.facebookuseralbum.model.Photo;
import com.zlayji.apples.facebookuseralbum.view.adapter.PhotoAdapter;

import java.util.List;

import javax.inject.Inject;

public class PhotoActivity extends AppCompatActivity implements PhotoContract.View {

    @Inject
    PhotoPresenter presenter;

    GridView photoGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        DaggerPhotoComponent.builder()
                .appComponent(((mApplication)getApplicationContext()).getAppComponent())
                .photoModule(new PhotoModule(this))
                .build()
                .inject(this);

        photoGrid = findViewById(R.id.photo_grid);


        if(getIntent().getStringExtra("albumid") != null){
            presenter.getPhotos(getIntent().getStringExtra("albumid"));
        }

    }


    @Override
    public void displayPhoto(List<Photo> listphoto) {
        photoGrid.setAdapter(new PhotoAdapter(listphoto,this));
    }
}
