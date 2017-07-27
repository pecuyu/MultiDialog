package com.yu.mutidialog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * UIFragment,接收返回的数据
 */
public class UIFragment extends Fragment {
    public static final int REQUEST_CAOD_UI = 1;
    private TextView mTvResult;
    public UIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ui, container, false);

        mTvResult = (TextView) view.findViewById(R.id.id_tv_result);
        Button btnOpenPicker = (Button) view.findViewById(R.id.id_btn_open_picker);
        btnOpenPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DateDialogFragment dialogFragment = new DateDialogFragment();
                dialogFragment.setTargetFragment(UIFragment.this, REQUEST_CAOD_UI); // 设置目标Fragment
                dialogFragment.show(fm, "DateDialogFragment");
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAOD_UI && resultCode == DateDialogFragment.RESULT_CAOD_DIALOG) {   // 接收返回的数据
            String date = data.getStringExtra("date");
            mTvResult.setText("result:"+date);
        }
    }
}
