package com.op.tablebradis.help;

import android.content.Context;

import com.op.tablebradis.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cache{
    Context context;
    String cache = String.valueOf(R.string.name_file_cache);

    public void saveCache(String s) {
        File cachefile = new File(context.getCacheDir(), cache);
        FileWriter fw = null;
        try {
            fw = new FileWriter(cachefile,true);
            fw.write(s + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readCache() {
        List list = new ArrayList();
        String str_cache = " ";
        File cachefile = new File(context.getCacheDir(), cache);
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
        File cachefile = new File(context.getCacheDir(), cache);
        try {
            cachefile.delete();
            cachefile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

