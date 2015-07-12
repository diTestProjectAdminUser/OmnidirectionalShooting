package jp.co.di_system.android.omnidirectionalshooting.activity;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import jp.co.di_system.android.omnidirectionalshooting.R;


public class SettingActivity extends PreferenceActivity {
    private final String TAG = "SettingActivity";

    // 効果音
    boolean isEffect;
    // BGM
    boolean isBGM;

    Button effectButton;
    Button bgmBtn;
    Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 画面起動時に行う処理を記述
    }

    public void onClick(View v) {
        // ボタン押下時の処理を記述
        if(v == effectButton) {
            onClickEffectSwitchButton();
        } else if (v == bgmBtn) {
            onClickBgmSwitchButton ();
        } else if (v == backBtn) {
            onClickBackButton();
        } else {
            Log.e(TAG, "onClickError");
        }
    }


    void onClickEffectSwitchButton () {
        Log.d(TAG, "onClickEffectSwitchButton");
    }

    void onClickBgmSwitchButton () {
        Log.d(TAG, "onClickBgmSwitchButton");
    }

    void onClickBackButton () {
        Log.d(TAG, "onClickBackButton");
    }



}

