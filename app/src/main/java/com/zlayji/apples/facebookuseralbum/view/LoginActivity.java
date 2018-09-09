package com.zlayji.apples.facebookuseralbum.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.zlayji.apples.facebookuseralbum.R;
import com.zlayji.apples.facebookuseralbum.view.albums.AlbumActivity;

public class LoginActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    AccessToken accessToken;


    LoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callbackManager = CallbackManager.Factory.create();
        accessToken = AccessToken.getCurrentAccessToken();


        loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_photos");

        if(accessToken != null && !accessToken.isExpired()) {
            Intent i = new Intent(LoginActivity.this, AlbumActivity.class);
            i.putExtra("userID", accessToken.getUserId());
            startActivity(i);
        }


            // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                accessToken = loginResult.getAccessToken();
                if (accessToken.getUserId() != null) {
                    Intent i = new Intent(LoginActivity.this, AlbumActivity.class);
                    i.putExtra("userID", accessToken.getUserId());
                    startActivity(i);
                }

            }
            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
