package com.essejose.a13mobincrivelfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.SignUpEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {


    private FirebaseAnalytics mFirebaseAnalitics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalitics = FirebaseAnalytics.getInstance(this);

        FirebaseMessaging.getInstance().subscribeToTopic("mob");


    }

    public void clickMe (View v){
        Bundle params = new Bundle();
        params.putString("NOME  ","jose");
        mFirebaseAnalitics.logEvent("clickMe", params);
        // TODO: Move this to where you establish a user session
        logUser();

    }


   // public void forcarCrash (View v){
     //  int r = 2 / 0;
    //}

    private void logUser() {

        // TODO: Use the current user's information
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("12345");
        Crashlytics.setUserEmail("user@fabric.io");
        Crashlytics.setUserName("Test User");
        Answers.getInstance().logSignUp(new SignUpEvent()
                .putMethod("Digits")
                .putSuccess(true));
    }



}
