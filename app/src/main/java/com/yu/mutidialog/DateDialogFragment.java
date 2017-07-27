package com.yu.mutidialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by D22436 on 2017/7/27.
 */

public class DateDialogFragment extends DialogFragment {

    public static final int RESULT_CAOD_DIALOG = 6;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.layout_dialog_fragment, null);
        final DatePicker picker = (DatePicker) view.findViewById(R.id.id_datePicker);
        Calendar calendar = Calendar.getInstance();
        picker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(getActivity(), year + "." + (monthOfYear+1) + "." + dayOfMonth,Toast.LENGTH_SHORT).show();
            }
        });

        return new AlertDialog.Builder(getActivity()).setTitle("please chooice").setPositiveButton("confirm", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),picker.getYear()+"."+(picker.getMonth()+1)+"."+picker.getDayOfMonth(), Toast.LENGTH_SHORT).show();
                Intent data = new Intent();
                String date = picker.getYear() + "." + (picker.getMonth() + 1) + "." + picker.getDayOfMonth();
                data.putExtra("date", date); // 设置数据
                getTargetFragment().onActivityResult(UIFragment.REQUEST_CAOD_UI,RESULT_CAOD_DIALOG,data); // 调用目标Fragment的onActivityResult方法
            }
        }).setView(view).create();  // 创建对话框
    }
}
