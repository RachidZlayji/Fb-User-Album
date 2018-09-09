package com.zlayji.apples.facebookuseralbum.view.photos;

import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.zlayji.apples.facebookuseralbum.model.Photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.inject.Inject;

public class PhotoPresenter implements PhotoContract.Presenter{

    PhotoContract.View mView;

    @Inject
    public PhotoPresenter(PhotoContract.View mView) {
        this.mView = mView;
    }


    @Override
    public void getPhotos(String albumid) {

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/"+albumid+"/photos?fields=picture",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.i("AlbumPicture_FB",response.toString());
                        ArrayList<Photo> photos = new ArrayList<>();
                        try {
                            JSONObject dataResponse = response.getJSONObject();
                            JSONArray data = dataResponse.getJSONArray("data");
                            for (int i = 0; i < data.length(); i++) {
                                photos.add(new Photo(
                                        data.getJSONObject(i).getString("id"),
                                        data.getJSONObject(i).getString("picture")
                                ));
                            }
                            mView.displayPhoto(photos);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }                    }
                }
        ).executeAsync();
    }
}
