package com.op.tablebradis.help;

import java.text.DecimalFormat;

public class Format {
    public String formatDouble(double tmp_double){
        DecimalFormat df = new DecimalFormat("#########################.#########################");
        return df.format(tmp_double);
    }

    public String formatDouble4(double tmp_double){
        DecimalFormat df = new DecimalFormat("#########################.####");
        return df.format(tmp_double).replaceAll(",",".");
    }
}
