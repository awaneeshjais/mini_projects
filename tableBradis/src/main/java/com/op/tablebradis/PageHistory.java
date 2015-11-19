package com.op.tablebradis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.op.tablebradis.help.Cache;

public class PageHistory extends Activity{
    Cache cache = new Cache();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        final TextView jcHistoryText = (TextView) findViewById(R.id.history_textView);
        final Button jcHistoryButton = (Button) findViewById(R.id.history_button_erase_history);
        final Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        jcHistoryText.setText(cache.readCache());

        jcHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(alpha);
                AlertDialog.Builder builder = new AlertDialog.Builder(PageHistory.this);
                builder.setTitle(R.string.alert_message)
                        .setMessage(R.string.alert_do_you_real);
                builder.setNegativeButton(R.string.alert_no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                builder.setPositiveButton(R.string.alert_yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                cache.deleteCache();
                                jcHistoryText.setText(" ");
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ret;
        if (item.getItemId() == R.id.action_menu_calc) {
            ret = true;
            Intent intent = new Intent(this, PageCalc.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_menu_history){
            ret = true;
            Intent intent = new Intent(this, PageHistory.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_menu_bradis){
            ret = true;
            Uri uri = Uri.parse(String.valueOf(R.string.link_bradis));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else {
            ret = super.onOptionsItemSelected(item);
        }
        return ret;
    }
}

