package com.essejose.a13mobincrivelfirebase.Firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static  android.content.ContentValues.TAG;

/**
 * Created by logonrm on 05/08/2017.
 */

public class MeuFirebaseInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh(){
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refresh token:"+ refreshedToken );
        sendRegistrationToServer(refreshedToken);
    }

    private  void sendRegistrationToServer(String token){
        //Todo implement it

        Log.d("TokeN", token);

    }
}
