package com.yu.mutidialog;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_UI_FRAGMENT = "UIFragment";
    private CharSequence[] mItems = {"apple","banana","grape"};
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UIFragment fragment = new UIFragment();
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.id_fragment_container, fragment, TAG_UI_FRAGMENT).commit();
    }


    public void simpleDialogClick(View view) {
        Utils.showSimpleDialog(this);
    }

    public void singleChooiceClick(View view) {
        Utils.showSingleChooiceDialog(this,mItems);
    }

    public void multiChooiceClick(View view) {
        Utils.showMultiChooiceDialog(this,mItems);
    }

    public void showDialogFragmentClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        DateDialogFragment dialog = new DateDialogFragment();
        // 设置目标fragment
        dialog.setTargetFragment(fm.findFragmentByTag(TAG_UI_FRAGMENT),UIFragment.REQUEST_CAOD_UI);
        dialog.show(fm, "DateDialogFragment");
    }
}
