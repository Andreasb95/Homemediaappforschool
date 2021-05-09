package com.example.homemediaapp;

import android.content.Context;

import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


//CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID
public class CastOptionsProvider implements OptionsProvider {
    @Override
    public CastOptions getCastOptions(Context context) {

        NotificationOptions notificationOptions = new NotificationOptions.Builder()
                .setTargetActivityClassName(ExpandedControlsActivity.class.getName())
                .build();
        CastMediaOptions mediaOptions = new CastMediaOptions.Builder()
                .setNotificationOptions(notificationOptions)
                .setExpandedControllerActivityClassName(ExpandedControlsActivity.class.getName())
                .build();
        CredentialsData credentialsData = new CredentialsData.Builder()
                .setCredentials("{\"userId\": \"abc\"}")
                .build();
        LaunchOptions launchOptions = new LaunchOptions.Builder()
                .setAndroidReceiverCompatible(false)
                .setCredentialsData(credentialsData)
                .build();
        return new CastOptions.Builder()
                .setLaunchOptions(launchOptions)
                .setReceiverApplicationId(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID)
                .setCastMediaOptions(mediaOptions)
                .build();
    }

    @Override
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }
}
