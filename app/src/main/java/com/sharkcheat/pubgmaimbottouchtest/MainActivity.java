package com.sharkcheat.pubgmaimbottouchtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;

import com.topjohnwu.superuser.Shell;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private int REQUEST_OVERLAY = 5500;
    private File daemonPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShellUtils.checkRoot(this);

            initDaemon();
            MyService.Start(this);

    }

    private void initDaemon() {
        daemonPath = new File(getFilesDir().getPath(), "libPUBGMDaemon.so");
        FileCommons.copyFromAssets(this, getFilesDir().getPath(), "libPUBGMDaemon.so");
        if (daemonPath.exists())
            daemonPath.setExecutable(true, true);
    }

}