package com.op.tablebradis.help;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTime {
    public String getCurDate() {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }
}
