package com.example.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        jc_history_text.setText(readCache());

        View.OnClickListener onClick_button_erase = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteCache();
                jc_history_text.setText(" ");
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
}

