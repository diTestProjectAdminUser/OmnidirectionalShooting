package jp.co.di_system.android.omnidirectionalshooting.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import jp.co.di_system.android.omnidirectionalshooting.R;
import jp.co.di_system.android.omnidirectionalshooting.activity.base.BaseActivity;
import jp.co.di_system.android.omnidirectionalshooting.activity.GameActivity;

public class TitleActivity extends BaseActivity implements View.OnClickListener {

    Button startBtn;
    Button settingBtn;


    @Override
    /**
     * ここでXMLとクラスを緋も付ける
     */
    protected void retainXML() {
        setContentView(R.layout.activity_title);
        startBtn = (Button) findViewById(R.id.startBtn);
        settingBtn = (Button) findViewById(R.id.settingBtn);

        startBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
    }

    @Override
    /**
     *ボタン押下時の処理
     */
    public void onClick(View v) {
        if(v == startBtn) {
            Intent intent = new Intent(TitleActivity.this,GameActivity.class);
            int resultCd = 1000; //リザルトコードを任意で設定
            this.transitionGO(intent,resultCd);
        } else {
            Intent intent = new Intent(TitleActivity.this,SettingActivity.class);
            int resultCd = 2000; //リザルトコードを任意で設定
            this.transitionGO(intent,resultCd);
        }
    }
}
