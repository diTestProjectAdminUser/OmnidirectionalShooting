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
import android.content.SharedPreferences;
import android.content.Context;
import jp.co.di_system.android.omnidirectionalshooting.R;

import jp.co.di_system.android.omnidirectionalshooting.activity.base.BaseActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private final String TAG = "SettingActivity";

    // 攻撃音
    boolean _isEffect;
    // BGM
    boolean _isBGM;

    Button effectButton;
    Button bgmBtn;
    Button backBtn;

    @Override
    /**
     * ここでXMLとクラスを緋も付ける
     */
    protected void retainXML() {
        setContentView(R.layout.activity_setting);
        effectButton = (Button) findViewById(R.id.effectButton);
        bgmBtn = (Button) findViewById(R.id.bgmBtn);
        backBtn = (Button) findViewById(R.id.backBtn);
        effectButton.setOnClickListener(this);
        bgmBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);

        this.setButtonText();
    }

    private void setButtonText() {
        this.setIsEffect(getIsEffect());
        this.setIsBGM(getIsBGM());
    }
    @Override
    /**
     *ボタン押下時の処理
     */
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
    private void onClickEffectSwitchButton () {
        this.setIsEffect(!_isEffect);
        effectButton.setSelected(_isEffect);

        Log.d(TAG, "onClickEffectSwitchButton");
    }

    private void onClickBgmSwitchButton () {
        this.setIsBGM(!_isBGM);
        bgmBtn.setSelected(_isBGM);

        Log.d(TAG, "onClickBgmSwitchButton");
    }

    private void onClickBackButton () {
        Log.d(TAG, "onClickBackButton");
        finish();
    }

    public void setIsEffect (boolean isEffect) {
        _isEffect = isEffect;
        SharedPreferences prefs = getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isEffect", isEffect);
        editor.apply();

        if (_isEffect) {
            effectButton.setText(" 攻撃音：ON ");
        } else {
            effectButton.setText("攻撃音：OFF");
        }

    }

    public void setIsBGM (boolean isBGM) {
        _isBGM = isBGM;
        SharedPreferences prefs = getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isBGM",isBGM);
        editor.apply();

        if (_isBGM) {
            bgmBtn.setText("BGM：ON ");
        } else {
            bgmBtn.setText("BGM：OFF");
        }

    }

    public boolean getIsEffect () {
        SharedPreferences prefs = getSharedPreferences(TAG, Context.MODE_PRIVATE);

        return prefs.getBoolean("isEffect", false);
    }

    public boolean getIsBGM () {
        SharedPreferences prefs = getSharedPreferences(TAG, Context.MODE_PRIVATE);

        return prefs.getBoolean("isBGM", false);
    }

}


