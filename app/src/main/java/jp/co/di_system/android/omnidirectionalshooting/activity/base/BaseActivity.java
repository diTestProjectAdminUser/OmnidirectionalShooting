package jp.co.di_system.android.omnidirectionalshooting.activity.base;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import jp.co.di_system.android.omnidirectionalshooting.R;

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.retainXML();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return false;
    }

    /** XML�ƃ\�[�X���֘A�t����*/
    protected abstract void retainXML();

    protected void transitionGO(Intent intent, int resultCd){
        this.startActivityForResult(intent, resultCd);
    }

    /**
     *�f�[�^��j�����đO�̉�ʂɖ߂�B
     */
    protected void backActivity(){
        Intent data = new Intent();
        setResult(RESULT_CANCELED, data);
        finish();
    }

    /**
     * �f�[�^��ێ����đO�̉�ʂɖ߂�B
     */
    protected void backActivityResult(Intent intent){
        setResult(RESULT_OK, intent);
        finish();
    }
}