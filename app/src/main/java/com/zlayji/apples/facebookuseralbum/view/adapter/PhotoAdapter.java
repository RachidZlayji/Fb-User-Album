package com.zlayji.apples.facebookuseralbum.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zlayji.apples.facebookuseralbum.R;
import com.zlayji.apples.facebookuseralbum.model.Photo;

import java.util.List;

public class PhotoAdapter extends BaseAdapter {

    private List<Photo> photoList;
    private Context context;

    public PhotoAdapter(List<Photo> photoList, Context context) {
        this.context = context;
        this.photoList = photoList;
    }

    @Override
    public int getCount() {
        if(photoList != null){
            return photoList.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View mView, ViewGroup parent) {

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.photo_item, null);
        ImageView photo = mView.findViewById(R.id.photo);

        Glide.with(context).load(photoList.get(position).getPictureUrl()).into(photo);

        return mView;
    }
}
