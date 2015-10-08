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
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PageHistory extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        final TextView jc_history_text = (TextView) findViewById(R.id.history_textView);
        final Button jc_history_button = (Button) findViewById(R.id.history_button_erase_history);
        final Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        jc_history_text.setText(readCache());

        View.OnClickListener onClick_button_erase = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
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
                                jc_history_text.setText(" ");
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        };
        jc_history_button.setOnClickListener(onClick_button_erase);
    }
    public String readCache() {
        List list = new ArrayList();
        String str_cache = " ";
        File cachefile = new File(getCacheDir(), "TBradis.cache");
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
        File cachefile = new File(getCacheDir(), "TBradis.cache");
        try {
            cachefile.delete();
            cachefile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            //Toast.makeText(this, "ABOUT BRADIS", Toast.LENGTH_SHORT).show();
            Uri uri = Uri.parse("https://ru.wikipedia.org/wiki/%D0%91%D1%80%D0%B0%D0%B4%D0%B8%D1%81,_%D0%92%D0%BB%D0%B0%D0%B4%D0%B8%D0%BC%D0%B8%D1%80_%D0%9C%D0%BE%D0%B4%D0%B5%D1%81%D1%82%D0%BE%D0%B2%D0%B8%D1%87");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else {
            ret = super.onOptionsItemSelected(item);
        }
        return ret;
    }
}

