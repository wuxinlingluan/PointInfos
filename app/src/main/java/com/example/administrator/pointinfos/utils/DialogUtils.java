package com.example.administrator.pointinfos.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by ${sheldon} on 2017/6/6.
 */

public class DialogUtils {
    private ProgressDialog mProgressDialog;
    private Context mContext;

    public DialogUtils(Context context){
        mContext = context;
        mProgressDialog = new ProgressDialog(context);
    }

    public void showProgressDialog(boolean show,String message){
        if (show){
            mProgressDialog.setMessage(message);
            mProgressDialog.show();
        }else {
            mProgressDialog.hide();
        }
    }

    public void showProgressDialog(boolean show){
        showProgressDialog(show,"");
    }

    public void dismiss(){
        mProgressDialog.dismiss();
    }
}
