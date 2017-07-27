package com.yu.mutidialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by D22436 on 2017/7/27.
 */
public class Utils {
    /**
     * 显示多选框
     * @param context
     */
    public static void showMultiChooiceDialog(final Context context, final CharSequence[] mItems) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final boolean[] checkedItems=new boolean[mItems.length] ; // 统计选中状态
        builder.setMultiChoiceItems(mItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(context,"current choice is:"+ mItems[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<mItems.length;i++) {
                    if (checkedItems[i]) {
                        sb.append(mItems[i]+" ");
                    }
                }
                Toast.makeText(context,"your choice is: "+ sb.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    /**
     * 显示多选框
     * @param context
     */
    public static void showSingleChooiceDialog(final Context context,final CharSequence[] mItems) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setSingleChoiceItems(mItems, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,"your choice is:"+ mItems[which],Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.create().show();

    }

    public static void showSimpleDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("dear,this is title!");
        builder.setMessage("you know this is text");
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "you click confirm", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "you click cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
