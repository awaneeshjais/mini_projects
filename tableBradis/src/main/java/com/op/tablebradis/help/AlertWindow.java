package com.op.tablebradis.help;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.op.tablebradis.PageHistory;
import com.op.tablebradis.R;

public class AlertWindow {
    public void createAlertWindow(String message, String name_button, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.alert_message)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton(name_button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
