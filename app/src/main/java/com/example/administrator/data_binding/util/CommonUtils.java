package com.example.administrator.data_binding.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.data_binding.R;


/**
 */
public class CommonUtils {

    private static Toast toast;

    /**
     * 字符串为空判断
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0 || str.equalsIgnoreCase("null")
                || str.isEmpty() || str.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 显示toast
     *
     * @param context
     * @param text
     * @param isLongToast
     */
    public static void makeEventToast(Context context, String text,
                                      boolean isLongToast) {
        if (null == context || null == text)
            return;
        View v = LayoutInflater.from(context).inflate(R.layout.toast_view,
                null);
        TextView textView = (TextView) v.findViewById(R.id.text);
        textView.setText(text);
        //每次创建Toast时先做一下判断
        //如果前面已经有Toast在显示，则只是更新toast内容，而不再创建，提升用户体验
        if (toast != null) {
            textView.setText(text);
        } else {
            toast = Toast.makeText(context, text, isLongToast ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        }
        toast.setView(v);
        toast.show();
    }

    /**
     * 显示toast
     *
     * @param context
     * @param id
     * @param isLongToast
     */
    public static void makeEventToast(Context context, int id,
                                      boolean isLongToast) {
        if (null == context)
            return;
        String text = context.getResources().getString(id);
        View v = LayoutInflater.from(context).inflate(R.layout.toast_view,
                null);
        TextView textView = (TextView) v.findViewById(R.id.text);
        textView.setText(text);
        if (toast != null) {
            textView.setText(text);
        } else {
            toast = Toast.makeText(context, text, isLongToast ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        }
        toast.setView(v);
        toast.show();
    }


}
