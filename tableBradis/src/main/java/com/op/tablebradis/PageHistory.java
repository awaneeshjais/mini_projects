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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PageHistory extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        final TextView jcHistoryText = (TextView) findViewById(R.id.history_textView);
        final Button jcHistoryButton = (Button) findViewById(R.id.history_button_erase_history);
        final Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        jcHistoryText.setText(readCache());

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
                                deleteCache();
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu_calc:
                Intent intent = new Intent(this, PageCalc.class);
                startActivity(intent);
                return true;
            case R.id.action_menu_history:
                Intent intentHistory = new Intent(this, PageHistory.class);
                startActivity(intentHistory);
                return true;
            case R.id.action_menu_bradis:
                Uri uri = Uri.parse(getString(R.string.link_bradis));
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentBrowser);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public String readCache() {
        List list = new ArrayList();
        String str_cache = " ";
        File cachefile = new File(this.getCacheDir(), String.valueOf(R.string.name_file_cache));
        try {
            Scanner in = new Scanner(new FileReader(cachefile));
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
            for (int i = 0; i<list.size();i++){
                str_cache = list.get(i) + "\n" + str_cache;
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return str_cache;
    }

    public void deleteCache(){
        File cachefile = new File(this.getCacheDir(), String.valueOf(R.string.name_file_cache));
        try {
            cachefile.delete();
            cachefile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

