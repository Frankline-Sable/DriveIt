package com.example.driveit.handler;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHandler {
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";

    public static final String KEY_USER_ID= "KEY_USER_ID";
    public static final String KEY_USER_NAME = "KEY_USER_NAME";
    public static final String KEY_USER_EMAIL = "KEY_USER_EMAIL";
    public static final String KEY_USER_TOKEN = "KEY_USER_TOKEN";
    public static final String KEY_USER_ROLE= "KEY_ROLE_ID";
    public static final String KEY_USER_ORG = "KEY_ORG_ID";
    public static final String KEY_USER_STATUS = "KEY_STATUS";
    public static final String KEY_USER_IMAGE= "KEY_IMAGE_LOCATION";

    public static final String KEY_USER_ACTIVE= "KEY_IMAGE_LO_ACTIVE";

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor prefsEditor;
    private Context mContext;

    public PreferenceHandler(Context mContext) {
        this.mContext = mContext;
        sharedPrefs = mContext.getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
    }
    public void SaveAccountState(Boolean loggedIn) {
        prefsEditor = sharedPrefs.edit();
        prefsEditor.putBoolean(KEY_USER_ACTIVE, loggedIn);
        prefsEditor.apply();
    }
    public Boolean getAccountState() {
        return sharedPrefs.getBoolean(KEY_USER_ACTIVE, false);
    }

    public Boolean saveAccountData(final String  mId,final String mName, final String mEmail, final String mToken, final String mRole, final String mOrg, final String mStatus, final String mImage) {
        prefsEditor = sharedPrefs.edit();
        prefsEditor.putString(KEY_USER_ID, mId);
        prefsEditor.putString(KEY_USER_NAME, mName);
        prefsEditor.putString(KEY_USER_EMAIL, mEmail);
        prefsEditor.putString(KEY_USER_TOKEN, mToken);
        prefsEditor.putString(KEY_USER_ROLE, mRole);
        prefsEditor.putString(KEY_USER_ORG, mOrg);
        prefsEditor.putString(KEY_USER_STATUS, mStatus);
        prefsEditor.putString(KEY_USER_IMAGE, mImage);
        prefsEditor.apply();
        return true;
    }
    public String getAccountData(String data) {
        return sharedPrefs.getString(data, "NA");
    }
}