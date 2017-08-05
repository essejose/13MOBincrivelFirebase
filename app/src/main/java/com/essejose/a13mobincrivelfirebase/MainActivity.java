package com.essejose.a13mobincrivelfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.InviteEvent;
import com.crashlytics.android.answers.SearchEvent;
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

    public  void contentView( View v){

        Answers.getInstance().logContentView(new ContentViewEvent()
                .putContentName("Answers setup process super easy!")
                .putContentType("Technical documentation")
                .putContentId("article-350"));

    }


    public void invite(View v){

        Answers.getInstance().logInvite(new InviteEvent()
                .putMethod("Twitter")
                .putCustomAttribute("Custom String", "My String")
                .putCustomAttribute("Custom Number", 25));

    }

    public void searchEvent(View v){
        Answers.getInstance().logSearch(new SearchEvent()
                .putQuery("mobile analytics")
                .putCustomAttribute("Custom String", "My String")
                .putCustomAttribute("Custom Number", 25));

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
