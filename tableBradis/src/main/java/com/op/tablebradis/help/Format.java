package com.op.tablebradis.help;

import com.op.tablebradis.R;
import java.text.DecimalFormat;

public class Format {
    public String formatDouble(double tmp_double){
        DecimalFormat df = new DecimalFormat("#########################.#########################");
        return df.format(tmp_double);
    }

    public String formatDouble4(double tmp_double){
        DecimalFormat df = new DecimalFormat("#########################.####");
        return df.format(tmp_double).replaceAll(",", ".");
    }

    public String createRecord(String curdate, String value1, String oper, String value2, String result){
        String str_result;
        if (oper.equals(String.valueOf(R.string.label_sin))){
            str_result = curdate + ": sin" + "( " + value1 + " ) = " + result;
        }else if (oper.equals(String.valueOf(R.string.label_cos))){
            str_result = curdate + ": cos" + "( " + value1 + " ) = " + result;
        }else if (oper.equals(String.valueOf(R.string.label_tg))){
            str_result = curdate + ": tg"  + "( " + value1 + " ) = " + result;
        }else if (oper.equals(String.valueOf(R.string.label_ctg))) {
            str_result = curdate + ": ctg" + "( " + value1 + " ) = " + result;
        }else if(oper.equals(String.valueOf(R.string.label_one_to_x))){
            str_result = curdate + ": " + "1/ " + value1 + " = " + result;
        }else if(oper.equals(String.valueOf(R.string.label_x_2))){
            str_result = curdate + ": " + "( " + value1 + " )" + "\u00B2" + " = " + result;
        }else if(oper.equals(String.valueOf(R.string.label_x_3))){
            str_result = curdate + ": " + "( " + value1 + " )" + "\u00B3" + " = " + result;
        }else if(oper.equals(String.valueOf(R.string.label_length))){
            str_result = curdate + ": L(d)" + " = PI *  " + value1 + " = " + result;
        }else if(oper.equals(String.valueOf(R.string.label_area))){
            str_result = curdate + ": S(d)" + " = ( PI *  " + value1 + "\u00B2" + ") / 4 = " + result;

        }else if(oper.equals(String.valueOf(R.string.label_plus))){
            str_result = curdate + ": " + value1 + " +  " + value2 + " = " + result;
        }else if(oper.equals(String.valueOf(R.string.label_minus))){
            str_result = curdate + ": " + value1 + " - " + value2 + " = " + result;
        }else if(oper.equals(String.valueOf(R.string.label_multi))){
            str_result = curdate + ": " + value1 + " * " + value2 + " = " + result;
        }else if(oper.equals(String.valueOf(R.string.label_dev))){
            str_result = curdate + ": " + value1 + " / " + value2 + " = " + result;
        }else {
            str_result = curdate + ": " + String.valueOf(R.string.alert_non_correct);
        }
        return  str_result;
    }
}
