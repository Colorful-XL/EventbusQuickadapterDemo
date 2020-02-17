package com.example.intsigdemo.Avtivity;


import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.intsigdemo.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class PermissionActivity extends BaseActivity implements View.OnClickListener {
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        button = this.findViewById(R.id.permissionButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.permissionButton){
            PermissionActivityPermissionsDispatcher.requestPermissionWithPermissionCheck(PermissionActivity.this);
        }
    }


    @NeedsPermission({Manifest.permission.CALL_PHONE,Manifest.permission.CAMERA})
    public void requestPermission(){
        Log.d(TAG,"------------授权成功--------");
        Toast.makeText(this,"授权成功!",Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale({Manifest.permission.CALL_PHONE,Manifest.permission.CAMERA})
    public void showDialog(final PermissionRequest request){
        new AlertDialog.Builder(this)
                .setMessage("是否授权手机权限？")
                .setPositiveButton("授权", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .show();
    }

    /**
     * 拒绝授权
     */
    @OnPermissionDenied({Manifest.permission.CALL_PHONE,Manifest.permission.CAMERA})
    public void deniedPermission(){
        Log.d(TAG,"拒绝授权");
        Toast.makeText(this,"授权失败!",Toast.LENGTH_SHORT).show();

    }

    /**
     * 不再询问
     */
    @OnNeverAskAgain({Manifest.permission.CALL_PHONE,Manifest.permission.CAMERA})
    public void neverAskAgain(){
        Log.d(TAG,"不再询问");
        Toast.makeText(this,"需要授权!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Log.i(TAG, "onRequestPermissionsResult requestCod = " + requestCode + ", grantResults = " + grantResults);
        PermissionActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

}
