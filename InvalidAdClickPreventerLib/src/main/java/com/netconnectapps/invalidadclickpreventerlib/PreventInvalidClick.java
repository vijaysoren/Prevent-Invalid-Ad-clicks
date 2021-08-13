package com.netconnectapps.invalidadclickpreventerlib;

import android.content.Context;
import android.content.SharedPreferences;

public class PreventInvalidClick {

    private static final String AD_CLICKED_TIMESTAMP = "timestamp";

    public static void  checkIfAdIsBlocked(Context context){
        // unblock ad if time is more than 60 min
        long currentTime = System.currentTimeMillis();
        long timeDifferenceFromBlocking = currentTime - readAdClickedTimestampValue(context);
        if (timeDifferenceFromBlocking > 3600000 ){
            unblockAd(context);
        }

    }


    public static void registerOnAdClick(Context context){
        long timestamp = System.currentTimeMillis();

        if (readAdClickedTimestampValue(context) == 0){
            saveAdClickedTimestampValue(context, timestamp);
        }

        long timeDifference = timestamp - readAdClickedTimestampValue(context);

        if (timeDifference <= 3600000){ // 1 sec = 1000 milli sec, 3600000 = 1 hr
            saveAdBlocking(context);
        }
    }

    private static SharedPreferences adSharedPreferences(Context context){
        return context.getSharedPreferences(AD_CLICKED_TIMESTAMP, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor adSharedPreferencesEditor(Context context){
        SharedPreferences pref = context.getSharedPreferences(AD_CLICKED_TIMESTAMP, Context.MODE_PRIVATE);
        return pref.edit();
    }

    private static long readAdClickedTimestampValue(Context context){
        return  adSharedPreferences(context).getLong("clicked", 0);
    }

    private static void saveAdClickedTimestampValue(Context context, long timestamp){
        adSharedPreferencesEditor(context).putLong("clicked", timestamp).commit();
    }


    // save blocking data
    private static SharedPreferences blockAdSharedPreferences(Context context){
        return context.getSharedPreferences("BLOCK_AD_REQUEST", Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor blockAdSharedPreferencesEditor(Context context){
        SharedPreferences blockAdRef = context.getSharedPreferences("BLOCK_AD_REQUEST", Context.MODE_PRIVATE);
        return  blockAdRef.edit();
    }

    private static long adIsBlocked(Context context){
        return blockAdSharedPreferences(context).getInt("blocked", 0);
    }

    private static void saveAdBlocking(Context context){
        blockAdSharedPreferencesEditor(context).putInt("blocked", 1).commit();
    }

    private static void unblockAd(Context context){
        blockAdSharedPreferencesEditor(context).putInt("blocked", 0).commit();
    }

    public static boolean isAdBlocked(Context context){
        return adIsBlocked(context) == 1;
        //returns true if ad is blocked
    }
}
