package jp.co.di_system.android.omnidirectionalshooting.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import jp.co.di_system.android.omnidirectionalshooting.R;
import jp.co.di_system.android.omnidirectionalshooting.activity.base.BaseActivity;

public class TitleActivity extends BaseActivity implements View.OnClickListener {

    // 難易度
    private  static final int TYPE_EASY = 1;
    private  static final int TYPE_NORMAL = 2;
    private  static final int TYPE_HARD = 3;

    // result cord
    private  static final int RESULT_CORD_EASY = 1000;
    private  static final int RESULT_CORD_NORMAL = 2000;
    private  static final int RESULT_CORD_HARD = 3000;
    private  static final int RESULT_CORD_CONFIG = 5000;

    // ボタン
    private Button easyBtn;
    private Button normalBtn;
    private Button hardBtn;
    private Button configBtn;


    @Override
    /**
     * ここでXMLとクラスを関連付ける
     */
    protected void retainXML() {

        setContentView(R.layout.activity_title);

        easyBtn = (Button) findViewById(R.id.easyBtn);
        normalBtn = (Button) findViewById(R.id.normalBtn);
        hardBtn = (Button) findViewById(R.id.hardBtn);
        configBtn = (Button) findViewById(R.id.configBtn);

        easyBtn.setOnClickListener(this);
        normalBtn.setOnClickListener(this);
        hardBtn.setOnClickListener(this);
        configBtn.setOnClickListener(this);

    }

    @Override
    /**
     *ボタン押下時の処理
     */
    public void onClick(View v) {

        if (v == easyBtn) {

            touchedEasyBtn(easyBtn);

        } else if (v == normalBtn) {

            touchedNormalBtn(normalBtn);

        } else if (v == hardBtn) {

            touchedHardBtn(hardBtn);

        }else if (v == configBtn) {

            touchedConfigBtn(configBtn);

        }
    }

    /**
     * EASYボタン押下時
     */
    private void touchedEasyBtn(Button btn) {

        int resultCd = RESULT_CORD_EASY; //リザルトコードを任意で設定
        startGame(resultCd,TYPE_EASY);

    }

    /**
     * NORMALボタン押下時
     */
    private  void touchedNormalBtn(Button btn) {

        int resultCd = RESULT_CORD_NORMAL; //リザルトコードを任意で設定
        startGame(resultCd,TYPE_NORMAL);

    }

    /**
     * HARDボタン押下時
     */
    private void touchedHardBtn(Button btn) {

        int resultCd = RESULT_CORD_HARD; //リザルトコードを任意で設定
        startGame(resultCd,TYPE_HARD);

    }

    /**
     * 設定ボタン押下時
     */
    private void touchedConfigBtn(Button btn) {

        Intent intent = new Intent(TitleActivity.this, SettingActivity.class);
        int resultCd = RESULT_CORD_CONFIG; //リザルトコードを任意で設定
        this.transitionGO(intent, resultCd);

    }

    /**
     * ゲーム画面に遷移する
     * @param  resultCd リザルトコード
     * @param  type 難易度
     */
    private void startGame(int resultCd, int type) {

        Intent intent = new Intent(TitleActivity.this, GameActivity.class);
        intent.putExtra("Type",type);
        this.transitionGO(intent, resultCd);

    }
}
