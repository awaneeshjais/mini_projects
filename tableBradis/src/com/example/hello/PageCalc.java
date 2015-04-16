package com.example.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Date;

public class PageCalc extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);

        final TextView jc_calc_enter_text = (TextView) findViewById(R.id.calc_textView);
        final String[] jc_calc_buffer = {"","",""};
        final Button jc_calc_one = (Button) findViewById(R.id.calc_button_one);
        final Button jc_calc_two = (Button) findViewById(R.id.calc_button_two);
        final Button jc_calc_three = (Button) findViewById(R.id.calc_button_three);
        final Button jc_calc_plus = (Button) findViewById(R.id.calc_button_plus);
        final Button jc_calc_one_to_x = (Button) findViewById(R.id.calc_button_one_to_x);

        final Button jc_calc_four = (Button) findViewById(R.id.calc_button_four);
        final Button jc_calc_five = (Button) findViewById(R.id.calc_button_five);
        final Button jc_calc_six = (Button) findViewById(R.id.calc_button_six);
        final Button jc_calc_minus = (Button) findViewById(R.id.calc_button_minus);
        final Button jc_calc_x_2 = (Button) findViewById(R.id.calc_button_x_2);

        final Button jc_calc_seven = (Button) findViewById(R.id.calc_button_seven);
        final Button jc_calc_eight = (Button) findViewById(R.id.calc_button_eight);
        final Button jc_calc_nine = (Button) findViewById(R.id.calc_button_nine);
        final Button jc_calc_multi = (Button) findViewById(R.id.calc_button_multi);
        final Button jc_calc_x_3 = (Button) findViewById(R.id.calc_button_x_3);

        final Button jc_calc_clear = (Button) findViewById(R.id.calc_button_clear);
        final Button jc_calc_zero = (Button) findViewById(R.id.calc_button_zero);
        final Button jc_calc_dot = (Button) findViewById(R.id.calc_button_dot);
        final Button jc_calc_dev = (Button) findViewById(R.id.calc_button_dev);
        final Button jc_calc_length = (Button) findViewById(R.id.calc_button_length);

        final Button jc_calc_clear_all = (Button) findViewById(R.id.calc_button_clear_all);
        final Button jc_calc_result = (Button) findViewById(R.id.calc_button_result);
        final Button jc_calc_area = (Button) findViewById(R.id.calc_button_area);

        final Button jc_calc_sin = (Button) findViewById(R.id.calc_button_sin);
        final Button jc_calc_cos = (Button) findViewById(R.id.calc_button_cos);
        final Button jc_calc_tg = (Button) findViewById(R.id.calc_button_tg);
        final Button jc_calc_ctg = (Button) findViewById(R.id.calc_button_ctg);
        final Button jc_calc_round4 = (Button) findViewById(R.id.calc_button_round4);
        //11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
        View.OnClickListener onClick_calc_one = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_1 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_1 + "1");
                add_1 = "";
            }
        };
        jc_calc_one.setOnClickListener(onClick_calc_one);

        View.OnClickListener onClick_calc_two = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_2 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_2 + "2");
                add_2 = "";
            }
        };
        jc_calc_two.setOnClickListener(onClick_calc_two);

        View.OnClickListener onClick_calc_three = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_3 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_3 + "3");
                add_3 = "";
            }
        };
        jc_calc_three.setOnClickListener(onClick_calc_three);

        View.OnClickListener onClick_calc_plus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jc_calc_buffer[0] = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_buffer[1] = "+";
                jc_calc_enter_text.setText("");
            }
        };
        jc_calc_plus.setOnClickListener(onClick_calc_plus);

        View.OnClickListener onClick_calc_one_to_x = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_one_to_x = String.valueOf(jc_calc_enter_text.getText());
                double tmp_one_to_x;
                if (add_one_to_x.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                    if (Double.parseDouble(add_one_to_x)==0.0d){
                        new AlertWindow().createAlertWindow("На '0' делить запрещено", "OK", PageCalc.this);
                    }else {
                        tmp_one_to_x = 1 / Double.parseDouble(add_one_to_x);
                        jc_calc_enter_text.setText(String.valueOf(tmp_one_to_x));
                        saveCache(createRecord(getCurDate(),Double.parseDouble(add_one_to_x),"1/x",0.0d,tmp_one_to_x));
                    }
                }
                tmp_one_to_x = 0.0d;
                add_one_to_x = "";
            }
        };
        jc_calc_one_to_x.setOnClickListener(onClick_calc_one_to_x);
        //22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
        View.OnClickListener onClick_calc_four = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_4 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_4 + "4");
                add_4 = "";
            }
        };
        jc_calc_four.setOnClickListener(onClick_calc_four);

        View.OnClickListener onClick_calc_five = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_5 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_5 + "5");
                add_5 = "";
            }
        };
        jc_calc_five.setOnClickListener(onClick_calc_five);

        View.OnClickListener onClick_calc_six = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_6 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_6 + "6");
                add_6 = "";
            }
        };
        jc_calc_six.setOnClickListener(onClick_calc_six);

        View.OnClickListener onClick_calc_minus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jc_calc_buffer[0] = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_buffer[1] = "-";
                jc_calc_enter_text.setText("");
            }
        };
        jc_calc_minus.setOnClickListener(onClick_calc_minus);

        View.OnClickListener onClick_calc_x_2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_x_2 = String.valueOf(jc_calc_enter_text.getText());
                double tmp_x_2;
                if (add_x_2.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else{
                    tmp_x_2 = Double.parseDouble(add_x_2) * Double.parseDouble(add_x_2);
                    jc_calc_enter_text.setText(String.valueOf(tmp_x_2));
                    saveCache(createRecord(getCurDate(),Double.parseDouble(add_x_2),"x2",0.0d,tmp_x_2));
                }
                tmp_x_2 = 0.0d;
                add_x_2 = "";
            }
        };
        jc_calc_x_2.setOnClickListener(onClick_calc_x_2);
        //33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
        View.OnClickListener onClick_calc_seven = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_7 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_7 + "7");
                add_7 = "";
            }
        };
        jc_calc_seven.setOnClickListener(onClick_calc_seven);

        View.OnClickListener onClick_calc_eight = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_8 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_8 + "8");
                add_8 = "";
            }
        };
        jc_calc_eight.setOnClickListener(onClick_calc_eight);

        View.OnClickListener onClick_calc_nine = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_9 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_9 + "9");
                add_9 = "";
            }
        };
        jc_calc_nine.setOnClickListener(onClick_calc_nine);

        View.OnClickListener onClick_calc_multi = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jc_calc_buffer[0] = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_buffer[1] = "*";
                jc_calc_enter_text.setText("");
            }
        };
        jc_calc_multi.setOnClickListener(onClick_calc_multi);

        View.OnClickListener onClick_calc_x_3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_x_3 = String.valueOf(jc_calc_enter_text.getText());
                double tmp_x_3;
                if (add_x_3.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                    tmp_x_3 = Double.parseDouble(add_x_3) * Double.parseDouble(add_x_3) * Double.parseDouble(add_x_3);
                    jc_calc_enter_text.setText(String.valueOf(tmp_x_3));
                    saveCache(createRecord(getCurDate(),Double.parseDouble(add_x_3),"x3",0.0d,tmp_x_3));
                }
                tmp_x_3 = 0.0d;
                add_x_3 = "";
            }
        };
        jc_calc_x_3.setOnClickListener(onClick_calc_x_3);
        //44444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
        View.OnClickListener onClick_calc_clear = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_clear = String.valueOf(jc_calc_enter_text.getText());
                int length_clear = add_clear.length();
                if (length_clear==0){
                new AlertWindow().createAlertWindow("Поле ввода очищено", "OK", PageCalc.this);
                }else {
                    add_clear = String.valueOf(add_clear.subSequence(0,length_clear-1));
                    jc_calc_enter_text.setText(add_clear);
                }
                length_clear = 0;
                add_clear = "";
            }
        };
        jc_calc_clear.setOnClickListener(onClick_calc_clear);

        View.OnClickListener onClick_calc_zero = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_0 = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_enter_text.setText(add_0 + "0");
                add_0 = "";
            }
        };
        jc_calc_zero.setOnClickListener(onClick_calc_zero);

        View.OnClickListener onClick_calc_dot = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_dot = String.valueOf(jc_calc_enter_text.getText());
                if (add_dot.length()==0){
                    jc_calc_enter_text.setText("0.");
                }else {
                    if (add_dot.indexOf(".")>-1){
                        new AlertWindow().createAlertWindow("Точка введена", "OK", PageCalc.this);
                    }else {
                        add_dot = String.valueOf(add_dot + ".");
                        jc_calc_enter_text.setText(add_dot);
                    }
                }
                add_dot = "";
            }
        };
        jc_calc_dot.setOnClickListener(onClick_calc_dot);

        View.OnClickListener onClick_calc_dev = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jc_calc_buffer[0] = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_buffer[1] = "/";
                jc_calc_enter_text.setText("");
            }
        };
        jc_calc_dev.setOnClickListener(onClick_calc_dev);

        View.OnClickListener onClick_calc_length = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_length = String.valueOf(jc_calc_enter_text.getText());
                double tmp_length;
                if (add_length.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                    tmp_length = Math.PI * Double.parseDouble(add_length);
                    jc_calc_enter_text.setText(String.valueOf(tmp_length));
                    saveCache(createRecord(getCurDate(),Double.parseDouble(add_length),"Ld",0.0d,tmp_length));
                }
                tmp_length = 0.0d;
                add_length = "";
            }
        };
        jc_calc_length.setOnClickListener(onClick_calc_length);
        //55555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555
        View.OnClickListener onClick_calc_clear_all = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_clear_all = String.valueOf(jc_calc_enter_text.getText());
                int length_clear_all = add_clear_all.length();
                if (length_clear_all==0){
                    new AlertWindow().createAlertWindow("Поле ввода очищено", "OK", PageCalc.this);
                }else {
                    jc_calc_enter_text.setText("0");
                    deleteBuffer(jc_calc_buffer);
                }
                length_clear_all = 0;
                add_clear_all = "";
            }
        };
        jc_calc_clear_all.setOnClickListener(onClick_calc_clear_all);

        View.OnClickListener onClick_calc_result = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jc_calc_buffer[2] = String.valueOf(jc_calc_enter_text.getText());
                double tmp_value1 = 0.0d;
                double tmp_value2 = 0.0d;
                double tmp_resultat = 0.0d;
                if (jc_calc_buffer[0].length()==0){
                    tmp_value1 = 0.0d;
                } else{
                    tmp_value1 = Double.parseDouble(jc_calc_buffer[0]);
                }
                if (jc_calc_buffer[2].length()==0){
                    tmp_value2 = 0.0d;
                } else{
                    tmp_value2 = Double.parseDouble(jc_calc_buffer[2]);
                }
                if (jc_calc_buffer[0].equals("")) {
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else{
                    if (jc_calc_buffer[1].equals("+") && jc_calc_buffer[2].equals("")) {
                        tmp_resultat = tmp_value1 + tmp_value1;
                        saveCache(createRecord(getCurDate(),tmp_value1,"+",tmp_value1,tmp_resultat));
                        jc_calc_enter_text.setText(String.valueOf(formatDouble(tmp_resultat)));
                        deleteBuffer(jc_calc_buffer);
                        jc_calc_buffer[0] = String.valueOf(tmp_resultat);
                        tmp_resultat = 0.0d;
                    } else if (jc_calc_buffer[1].equals("*") && jc_calc_buffer[2].equals("")) {
                        tmp_resultat = tmp_value1 * tmp_value1;
                        saveCache(createRecord(getCurDate(),tmp_value1,"*",tmp_value1,tmp_resultat));
                        jc_calc_enter_text.setText(String.valueOf(formatDouble(tmp_resultat)));
                        deleteBuffer(jc_calc_buffer);
                        jc_calc_buffer[0] = String.valueOf(tmp_resultat);
                        tmp_resultat = 0.0d;
                    } else if (jc_calc_buffer[1].equals("+")) {
                        tmp_resultat = tmp_value1 + tmp_value2;
                        saveCache(createRecord(getCurDate(),tmp_value1,"+",tmp_value2,tmp_resultat));
                        jc_calc_enter_text.setText(String.valueOf(formatDouble(tmp_resultat)));
                        deleteBuffer(jc_calc_buffer);
                        jc_calc_buffer[0] = String.valueOf(tmp_resultat);
                        tmp_resultat = 0.0d;
                    } else if (jc_calc_buffer[1].equals("*")) {
                        tmp_resultat = tmp_value1 * tmp_value2;
                        saveCache(createRecord(getCurDate(),tmp_value1,"*",tmp_value2,tmp_resultat));
                        jc_calc_enter_text.setText(String.valueOf(formatDouble(tmp_resultat)));
                        deleteBuffer(jc_calc_buffer);
                        jc_calc_buffer[0] = String.valueOf(tmp_resultat);
                        tmp_resultat = 0.0d;
                    } else if (jc_calc_buffer[1].equals("-")) {
                        tmp_resultat = tmp_value1 - tmp_value2;
                        saveCache(createRecord(getCurDate(),tmp_value1,"-",tmp_value2,tmp_resultat));
                        jc_calc_enter_text.setText(String.valueOf(formatDouble(tmp_resultat)));
                        deleteBuffer(jc_calc_buffer);
                        jc_calc_buffer[0] = String.valueOf(tmp_resultat);
                        tmp_resultat = 0.0d;
                    } else if (jc_calc_buffer[1].equals("/")) {
                        tmp_resultat = tmp_value1 / tmp_value2;
                        saveCache(createRecord(getCurDate(),tmp_value1,"/",tmp_value2,tmp_resultat));
                        jc_calc_enter_text.setText(String.valueOf(formatDouble(tmp_resultat)));
                        deleteBuffer(jc_calc_buffer);
                        jc_calc_buffer[0] = String.valueOf(tmp_resultat);
                        tmp_resultat = 0.0d;
                    } else {
                        saveCache(getCurDate());
                    }
                }
            }
        };
        jc_calc_result.setOnClickListener(onClick_calc_result);

        View.OnClickListener onClick_calc_area = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_area = String.valueOf(jc_calc_enter_text.getText());
                double tmp_area;
                if (add_area.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                    tmp_area = (Math.PI * Double.parseDouble(add_area) * Double.parseDouble(add_area)) / 4.0d;
                    jc_calc_enter_text.setText(String.valueOf(tmp_area));
                    saveCache(createRecord(getCurDate(),Double.parseDouble(add_area),"Sd",0.0d,tmp_area));
                }
                tmp_area = 0.0d;
                add_area = "";
            }
        };
        jc_calc_area.setOnClickListener(onClick_calc_area);
        //66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666
        View.OnClickListener onClick_calc_sin = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_sin = String.valueOf(jc_calc_enter_text.getText());
                double tmp_sin;
                if (add_sin.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                     tmp_sin = Math.sin(Double.parseDouble(add_sin));
                     jc_calc_enter_text.setText(String.valueOf(tmp_sin));
                     saveCache(createRecord(getCurDate(),Double.parseDouble(add_sin),"sin",0.0d,tmp_sin));
                }
                tmp_sin = 0.0d;
                add_sin = "";
            }
        };
        jc_calc_sin.setOnClickListener(onClick_calc_sin);

        View.OnClickListener onClick_calc_cos = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_cos = String.valueOf(jc_calc_enter_text.getText());
                double tmp_cos;
                if (add_cos.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                     tmp_cos = Math.cos(Double.parseDouble(add_cos));
                     jc_calc_enter_text.setText(String.valueOf(tmp_cos));
                     saveCache(createRecord(getCurDate(),Double.parseDouble(add_cos),"cos",0.0d,tmp_cos));
                }
                tmp_cos = 0.0d;
                add_cos = "";
            }
        };
        jc_calc_cos.setOnClickListener(onClick_calc_cos);

        View.OnClickListener onClick_calc_tg = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_tg = String.valueOf(jc_calc_enter_text.getText());
                double tmp_tg;
                if (add_tg.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                    tmp_tg = Math.tan(Double.parseDouble(add_tg));
                    jc_calc_enter_text.setText(String.valueOf(tmp_tg));
                    saveCache(createRecord(getCurDate(),Double.parseDouble(add_tg),"tg",0.0d,tmp_tg));
                }
                tmp_tg = 0.0d;
                add_tg = "";
            }
        };
        jc_calc_tg.setOnClickListener(onClick_calc_tg);

        View.OnClickListener onClick_calc_ctg = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_ctg = String.valueOf(jc_calc_enter_text.getText());
                double tmp_ctg;
                if (add_ctg.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                    tmp_ctg = Math.atan(Double.parseDouble(add_ctg));
                    jc_calc_enter_text.setText(String.valueOf(tmp_ctg));
                    saveCache(createRecord(getCurDate(),Double.parseDouble(add_ctg),"ctg",0.0d,tmp_ctg));
                }
                tmp_ctg = 0.0d;
                add_ctg = "";
            }
        };
        jc_calc_ctg.setOnClickListener(onClick_calc_ctg);

        View.OnClickListener onClick_calc_round4 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_round4 = String.valueOf(jc_calc_enter_text.getText());
                if (add_round4.length()==0){
                    new AlertWindow().createAlertWindow("Введите значение", "OK", PageCalc.this);
                }else {
                    jc_calc_enter_text.setText(formatDouble4(Double.parseDouble(add_round4)));
                }
            }
        };
        jc_calc_round4.setOnClickListener(onClick_calc_round4);
        //77777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
    }

    public void saveCache(String s) {
        File cachefile = new File(getCacheDir(), "TBradis.cache");
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

    public String getCurDate() {
        DecimalFormat df = new DecimalFormat("00");
        String str_current_date = String.valueOf(
                df.format(new Date().getDate()) + "." +
                df.format(new Date().getMonth()) + "." +
                (new Date().getYear() + 1900) + " " +
                df.format(new Date().getHours()) + ":" +
                df.format(new Date().getMinutes()) + ":" +
                df.format(new Date().getSeconds()));
        return str_current_date;
    }

    public String createRecord(String tmp_curdate,Double tmp_value1,String tmp_oper,Double tmp_value2,Double tmp_result){
       String str_result = "";
       if (tmp_oper.equals("+")){
           str_result = tmp_curdate + ": " + tmp_value1 + " " + tmp_oper + " " + tmp_value2 + " = " + tmp_result;
       }else if(tmp_oper.equals("-")){
           str_result = tmp_curdate + ": " + tmp_value1 + " " + tmp_oper + " " + tmp_value2 + " = " + tmp_result;
       }else if(tmp_oper.equals("/")){
           str_result = tmp_curdate + ": " + tmp_value1 + " " + tmp_oper + " " + tmp_value2 + " = " + tmp_result;
       }else if(tmp_oper.equals("*")){
           str_result = tmp_curdate + ": " + tmp_value1 + " " + tmp_oper + " " + tmp_value2 + " = " + tmp_result;
       }else if(tmp_oper.equals("1/x")){
           str_result = tmp_curdate + ": " + "1/ " + tmp_value1 + " = " + tmp_result;
       }else if(tmp_oper.equals("x2")){
           str_result = tmp_curdate + ": " + "( " + tmp_value1 + " )" + "\u00B2" + " = " + tmp_result;
       }else if(tmp_oper.equals("x3")){
           str_result = tmp_curdate + ": " + "( " + tmp_value1 + " )" + "\u00B3" + " = " + tmp_result;
       }else if(tmp_oper.equals("Ld")){
           str_result = tmp_curdate + ": " + "L(d) = PI * " + tmp_value1 + " = " + tmp_result;
       }else if(tmp_oper.equals("Sd")){
           str_result = tmp_curdate + ": " + "S(d) = (PI * " + tmp_value1 + "\u00B2" + ") / 4 = " + tmp_result;
       }else if(tmp_oper.equals("sin")){
           str_result = tmp_curdate + ": " + "sin( " + tmp_value1 + " ) = " + tmp_result;
       }else if(tmp_oper.equals("cos")){
           str_result = tmp_curdate + ": " + "cos( " + tmp_value1 + " ) = " + tmp_result;
       }else if(tmp_oper.equals("tg")){
           str_result = tmp_curdate + ": " + "tg( " + tmp_value1 + " ) = " + tmp_result;
       }else if(tmp_oper.equals("ctg")){
           str_result = tmp_curdate + ": " + "ctg( " + tmp_value1 + " ) = " + tmp_result;
       }else {
           str_result = tmp_curdate + ": " + "Не корректная операция";
       }
        return  str_result;
    }

    public void deleteBuffer(String[] tmp_buffer){
        for(int i=0;i<tmp_buffer.length;i++){
            tmp_buffer[i] = "";
        }
    }

    public String formatDouble(double tmp_double){
        DecimalFormat df = new DecimalFormat("#########################.#########################");
        return df.format(tmp_double);
    }

    public String formatDouble4(double tmp_double){
        DecimalFormat df = new DecimalFormat("#########################.####");
        return df.format(tmp_double);
    }
}


