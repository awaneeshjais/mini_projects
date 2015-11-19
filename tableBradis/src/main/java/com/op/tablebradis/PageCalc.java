package com.op.tablebradis;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.op.tablebradis.help.Format;

public class PageCalc extends Activity implements OnClickListener {
    Animation alpha;
    String[] jcCalcBuffer = {"","",""};
    TextView textView;
    View calc_button_one;
    View calc_button_two;
    View calc_button_three;
    View calc_button_plus;
    View calc_button_one_to_x;

    View calc_button_four;
    View calc_button_five;
    View calc_button_six;
    View calc_button_minus;
    View calc_button_x_2;

    View calc_button_seven;
    View calc_button_eight;
    View calc_button_nine;
    View calc_button_multi;
    View calc_button_x_3;

    View calc_button_clear;
    View calc_button_zero;
    View calc_button_dot;
    View calc_button_dev;
    View calc_button_length;

    View calc_button_clear_all;
    View calc_button_result;
    View calc_button_area;

    View calc_button_sin;
    View calc_button_cos;
    View calc_button_tg;
    View calc_button_ctg;
    View calc_button_round4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        textView = (TextView) findViewById(R.id.calc_textView);

        calc_button_one = findViewById(R.id.calc_button_one);
        calc_button_two = findViewById(R.id.calc_button_two);
        calc_button_three = findViewById(R.id.calc_button_three);
        calc_button_plus = findViewById(R.id.calc_button_plus);
        calc_button_one_to_x = findViewById(R.id.calc_button_one_to_x);

        calc_button_four = findViewById(R.id.calc_button_four);
        calc_button_five = findViewById(R.id.calc_button_five);
        calc_button_six = findViewById(R.id.calc_button_six);
        calc_button_minus = findViewById(R.id.calc_button_minus);
        calc_button_x_2 = findViewById(R.id.calc_button_x_2);

        calc_button_seven = findViewById(R.id.calc_button_seven);
        calc_button_eight = findViewById(R.id.calc_button_eight);
        calc_button_nine = findViewById(R.id.calc_button_nine);
        calc_button_multi = findViewById(R.id.calc_button_multi);
        calc_button_x_3 = findViewById(R.id.calc_button_x_3);

        calc_button_clear = findViewById(R.id.calc_button_clear);
        calc_button_zero = findViewById(R.id.calc_button_zero);
        calc_button_dot = findViewById(R.id.calc_button_dot);
        calc_button_dev = findViewById(R.id.calc_button_dev);
        calc_button_length = findViewById(R.id.calc_button_length);

        calc_button_clear_all = findViewById(R.id.calc_button_clear_all);
        calc_button_result = findViewById(R.id.calc_button_result);
        calc_button_area = findViewById(R.id.calc_button_area);

        calc_button_sin = findViewById(R.id.calc_button_sin);
        calc_button_cos = findViewById(R.id.calc_button_cos);
        calc_button_tg = findViewById(R.id.calc_button_tg);
        calc_button_ctg = findViewById(R.id.calc_button_ctg);
        calc_button_round4 = findViewById(R.id.calc_button_round4);



        calc_button_one.setOnClickListener(this);
        calc_button_two.setOnClickListener(this);
        calc_button_three.setOnClickListener(this);
        calc_button_plus.setOnClickListener(this);
        calc_button_one_to_x.setOnClickListener(this);

        calc_button_four.setOnClickListener(this);
        calc_button_five.setOnClickListener(this);
        calc_button_six.setOnClickListener(this);
        calc_button_minus.setOnClickListener(this);
        calc_button_x_2.setOnClickListener(this);

        calc_button_seven.setOnClickListener(this);
        calc_button_eight.setOnClickListener(this);
        calc_button_nine.setOnClickListener(this);
        calc_button_multi.setOnClickListener(this);
        calc_button_x_3.setOnClickListener(this);

        calc_button_clear.setOnClickListener(this);
        calc_button_zero.setOnClickListener(this);
        calc_button_dot.setOnClickListener(this);
        calc_button_dev.setOnClickListener(this);
        calc_button_length.setOnClickListener(this);

        calc_button_clear_all.setOnClickListener(this);
        calc_button_result.setOnClickListener(this);
        calc_button_area.setOnClickListener(this);

        calc_button_sin.setOnClickListener(this);
        calc_button_cos.setOnClickListener(this);
        calc_button_tg.setOnClickListener(this);
        calc_button_ctg.setOnClickListener(this);
        calc_button_round4.setOnClickListener(this);

/*        //1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
        View.OnClickListener onClick_calc_plus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
                jc_calc_buffer[0] = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_buffer[1] = "+";
                jc_calc_enter_text.setText("");
            }
        };
        jc_calc_plus.setOnClickListener(onClick_calc_plus);

        View.OnClickListener onClick_calc_one_to_x = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
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
        View.OnClickListener onClick_calc_minus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
                jc_calc_buffer[0] = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_buffer[1] = "-";
                jc_calc_enter_text.setText("");
            }
        };
        jc_calc_minus.setOnClickListener(onClick_calc_minus);

        View.OnClickListener onClick_calc_x_2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
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
        View.OnClickListener onClick_calc_multi = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
                jc_calc_buffer[0] = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_buffer[1] = "*";
                jc_calc_enter_text.setText("");
            }
        };
        jc_calc_multi.setOnClickListener(onClick_calc_multi);

        View.OnClickListener onClick_calc_x_3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
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
        View.OnClickListener onClick_calc_dev = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
                jc_calc_buffer[0] = String.valueOf(jc_calc_enter_text.getText());
                jc_calc_buffer[1] = "/";
                jc_calc_enter_text.setText("");
            }
        };
        jc_calc_dev.setOnClickListener(onClick_calc_dev);

        View.OnClickListener onClick_calc_length = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
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
        View.OnClickListener onClick_calc_result = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(alpha);
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
                view.startAnimation(alpha);
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
                view.startAnimation(alpha);
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
                view.startAnimation(alpha);
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
                view.startAnimation(alpha);
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
                view.startAnimation(alpha);
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

        //77777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777*/
    }

/*
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
    }*/

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

    public void onClickButtonNumber(View view, String number, TextView textView){
        view.startAnimation(alpha);
        textView.setText(textView.getText() + number);
    }

    public void onClickButtonStrFunction(View view, String function, TextView textView){
        view.startAnimation(alpha);
        if (function.equals(String.valueOf(R.string.label_clear))) {
            textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1));
        }else if (function.equals(String.valueOf(R.string.label_clear_all))){
            textView.setText("0");
            Toast.makeText(this, R.string.alert_clear, Toast.LENGTH_SHORT).show();
        }else if (function.equals(String.valueOf(R.string.label_dot))){
            if (textView.getText().length()==0){
                textView.setText("0.");
            }else {
                if (textView.getText().toString().indexOf(".")>-1){
                    Toast.makeText(this, R.string.alert_dot, Toast.LENGTH_SHORT).show();
                }else {
                    textView.setText(textView.getText() + ".");
                }
            }
        }else if (function.equals(String.valueOf(R.string.label_round4))){
            if (textView.getText().length()==0){
                Toast.makeText(this, R.string.alert_enter, Toast.LENGTH_SHORT).show();
            }else {
                textView.setText(new Format().formatDouble4(Double.parseDouble(String.valueOf(textView.getText()))));
            }
            textView.setText(textView.getText());
        }else{}
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.calc_button_one:
                onClickButtonNumber(view,"1",textView);
                break;
            case R.id.calc_button_two:
                onClickButtonNumber(view,"2",textView);
                break;
            case R.id.calc_button_three:
                onClickButtonNumber(view,"3",textView);
                break;
            case R.id.calc_button_four:
                onClickButtonNumber(view,"4",textView);
                break;
            case R.id.calc_button_five:
                onClickButtonNumber(view,"5",textView);
                break;
            case R.id.calc_button_six:
                onClickButtonNumber(view,"6",textView);
                break;
            case R.id.calc_button_seven:
                onClickButtonNumber(view,"7",textView);
                break;
            case R.id.calc_button_eight:
                onClickButtonNumber(view,"8",textView);
                break;
            case R.id.calc_button_nine:
                onClickButtonNumber(view,"9",textView);
                break;
            case R.id.calc_button_zero:
                onClickButtonNumber(view,"0",textView);
                break;
            case R.id.calc_button_clear:
                onClickButtonStrFunction(view,String.valueOf(R.string.label_clear),textView);
                break;
            case R.id.calc_button_clear_all:
                onClickButtonStrFunction(view,String.valueOf(R.string.label_clear_all),textView);
                break;
            case R.id.calc_button_dot:
                onClickButtonStrFunction(view,String.valueOf(R.string.label_dot),textView);
                break;
            case R.id.calc_button_round4:
                onClickButtonStrFunction(view,String.valueOf(R.string.label_round4),textView);
                break;
/*
            case R.id.calc_button_:

                break;
*/
            default:
                break;
        }
    }
}