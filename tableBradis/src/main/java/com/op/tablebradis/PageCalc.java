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

import com.op.tablebradis.help.AlertWindow;
import com.op.tablebradis.help.DateTime;
import com.op.tablebradis.help.Format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PageCalc extends Activity implements OnClickListener {
    TextView textView;
    Animation alpha;
    String[] jcCalcBuffer = {"","",""};

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

    public void onClickButtonNumber(View view, String number, TextView textView){
        view.startAnimation(alpha);
        textView.setText(textView.getText() + number);
    }

    public void onClickButtonStrFunction(View view, String function, TextView textView){
        view.startAnimation(alpha);
        if (function.equals(String.valueOf(R.string.label_clear))) {
            if (textView.getText().toString().length() == 0){
                textView.setText("0");
                Toast.makeText(this, R.string.alert_clear, Toast.LENGTH_SHORT).show();
            }else{
                textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1));
            }



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

    public void onClickButtonFunFunction(View view, String function, TextView textView){
        view.startAnimation(alpha);
        if (textView.getText().length() != 0){
            String record = "";
            Double result = 0.0d;
            jcCalcBuffer[0] = textView.getText().toString();

            if (function.equals(String.valueOf(R.string.label_sin))) {
                jcCalcBuffer[1] = String.valueOf(R.string.label_sin);
                result = Math.sin(Double.parseDouble(jcCalcBuffer[0].toString()));
            }else if (function.equals(String.valueOf(R.string.label_cos))){
                jcCalcBuffer[1] = String.valueOf(R.string.label_cos);
                result = Math.cos(Double.parseDouble(jcCalcBuffer[0].toString()));
            }else if (function.equals(String.valueOf(R.string.label_tg))){
                jcCalcBuffer[1] = String.valueOf(R.string.label_tg);
                result = Math.tan(Double.parseDouble(jcCalcBuffer[0].toString()));
            }else if (function.equals(String.valueOf(R.string.label_ctg))){
                jcCalcBuffer[1] = String.valueOf(R.string.label_ctg);
                result = Math.atan(Double.parseDouble(jcCalcBuffer[0].toString()));

            }else if (function.equals(String.valueOf(R.string.label_x_2))){
                jcCalcBuffer[1] = String.valueOf(R.string.label_x_2);
                result =  (Double.parseDouble(jcCalcBuffer[0].toString()))
                        * (Double.parseDouble(jcCalcBuffer[0].toString()));
            }else if (function.equals(String.valueOf(R.string.label_x_3))){
                jcCalcBuffer[1] = String.valueOf(R.string.label_x_3);
                result =  (Double.parseDouble(jcCalcBuffer[0].toString()))
                        * (Double.parseDouble(jcCalcBuffer[0].toString()))
                        * (Double.parseDouble(jcCalcBuffer[0].toString()));

            }else if (function.equals(String.valueOf(R.string.label_length))){
                jcCalcBuffer[1] = String.valueOf(R.string.label_length);
                result =  Math.PI * Double.parseDouble(jcCalcBuffer[0].toString());
            }else if (function.equals(String.valueOf(R.string.label_area))){
                jcCalcBuffer[1] = String.valueOf(R.string.label_area);
                result =  (Math.PI * Double.parseDouble(jcCalcBuffer[0].toString())
                                   * Double.parseDouble(jcCalcBuffer[0].toString())) / 4.0d;
            }else if (function.equals(String.valueOf(R.string.label_one_to_x))){
                if (Double.parseDouble(jcCalcBuffer[0])==0.0d){
                    new AlertWindow().createAlertWindow(getString(R.string.alert_div_zero)
                            , getString(R.string.alert_name_button), PageCalc.this);
                }else {
                    jcCalcBuffer[1] = String.valueOf(R.string.label_one_to_x);
                    result = 1 / Double.parseDouble(jcCalcBuffer[0]);
                }
            }else{}
            record = new Format().createRecord(new DateTime().getCurDate()
                    , jcCalcBuffer[0].toString()
                    , jcCalcBuffer[1].toString()
                    , "0.0d"
                    , result.toString());
            textView.setText(String.valueOf(result));
            saveCache(record);
        }else{
            Toast.makeText(this, R.string.alert_enter, Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickButtonRegularFunction(View view, String function, TextView textView){
        view.startAnimation(alpha);
        jcCalcBuffer[0] = textView.getText().toString();
        if (function.equals(String.valueOf(R.string.label_plus))) {
            jcCalcBuffer[1] = String.valueOf(R.string.label_plus);
        }else if (function.equals(String.valueOf(R.string.label_minus))){
            jcCalcBuffer[1] = String.valueOf(R.string.label_minus);
        }else if (function.equals(String.valueOf(R.string.label_multi))){
            jcCalcBuffer[1] = String.valueOf(R.string.label_multi);
        }else if (function.equals(String.valueOf(R.string.label_dev))){
            jcCalcBuffer[1] = String.valueOf(R.string.label_dev);
        }
        textView.setText("");
    }

    public  void onClickButtonEqual(View view, TextView textView){
        view.startAnimation(alpha);
        jcCalcBuffer[2] = textView.getText().toString();
        String record = "";
        Double result = 0.0d;
        if (jcCalcBuffer[0].equals("")) {
            new AlertWindow().createAlertWindow(getString(R.string.alert_enter)
                    , getString(R.string.alert_name_button), PageCalc.this);
        }else if (jcCalcBuffer[1].length()==0) {
            new AlertWindow().createAlertWindow(getString(R.string.alert_enter_operation)
                    , getString(R.string.alert_name_button), PageCalc.this);
        }else if (jcCalcBuffer[1].equals(String.valueOf(R.string.label_minus)) &&
                jcCalcBuffer[2].equals("")){
            new AlertWindow().createAlertWindow(getString(R.string.alert_enter)
                    , getString(R.string.alert_name_button), PageCalc.this);
        }else if (jcCalcBuffer[1].equals(String.valueOf(R.string.label_dev)) &&
                jcCalcBuffer[2].equals("")) {
            new AlertWindow().createAlertWindow(getString(R.string.alert_enter)
                    , getString(R.string.alert_name_button), PageCalc.this);

        }else {
            if (jcCalcBuffer[1].equals(String.valueOf(R.string.label_plus)) &&
                    jcCalcBuffer[2].equals("")) {
                result = Double.parseDouble(jcCalcBuffer[0]) + Double.parseDouble(jcCalcBuffer[0]);
            } else if (jcCalcBuffer[1].equals(String.valueOf(R.string.label_multi)) &&
                    jcCalcBuffer[2].equals("")) {
                result = Double.parseDouble(jcCalcBuffer[0]) * Double.parseDouble(jcCalcBuffer[0]);
            } else if (jcCalcBuffer[1].equals(String.valueOf(R.string.label_plus))) {
                result = Double.parseDouble(jcCalcBuffer[0]) + Double.parseDouble(jcCalcBuffer[2]);
            } else if (jcCalcBuffer[1].equals(String.valueOf(R.string.label_minus))) {
                result = Double.parseDouble(jcCalcBuffer[0]) - Double.parseDouble(jcCalcBuffer[2]);
            } else if (jcCalcBuffer[1].equals(String.valueOf(R.string.label_multi))) {
                result = Double.parseDouble(jcCalcBuffer[0]) * Double.parseDouble(jcCalcBuffer[2]);
            } else if (jcCalcBuffer[1].equals(String.valueOf(R.string.label_dev))) {
                if (Double.parseDouble(jcCalcBuffer[2])==0.0d){
                    new AlertWindow().createAlertWindow(getString(R.string.alert_div_zero)
                            , getString(R.string.alert_name_button), PageCalc.this);
                }else {
                    result = Double.parseDouble(jcCalcBuffer[0]) / Double.parseDouble(jcCalcBuffer[2]);
                }
            }
            record = new Format().createRecord(new DateTime().getCurDate()
                    , jcCalcBuffer[0].toString()
                    , jcCalcBuffer[1].toString()
                    , jcCalcBuffer[2].toString()
                    , result.toString());
            textView.setText(String.valueOf(result));
            saveCache(record);
        }
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.calc_button_one:
                onClickButtonNumber(view, getString(R.string.label_one), textView);
                break;
            case R.id.calc_button_two:
                onClickButtonNumber(view, getString(R.string.label_two), textView);
                break;
            case R.id.calc_button_three:
                onClickButtonNumber(view, getString(R.string.label_three), textView);
                break;
            case R.id.calc_button_four:
                onClickButtonNumber(view, getString(R.string.label_four), textView);
                break;
            case R.id.calc_button_five:
                onClickButtonNumber(view, getString(R.string.label_five), textView);
                break;
            case R.id.calc_button_six:
                onClickButtonNumber(view, getString(R.string.label_six), textView);
                break;
            case R.id.calc_button_seven:
                onClickButtonNumber(view, getString(R.string.label_seven), textView);
                break;
            case R.id.calc_button_eight:
                onClickButtonNumber(view, getString(R.string.label_eight), textView);
                break;
            case R.id.calc_button_nine:
                onClickButtonNumber(view, getString(R.string.label_nine), textView);
                break;
            case R.id.calc_button_zero:
                onClickButtonNumber(view, getString(R.string.label_zero), textView);
                break;
            case R.id.calc_button_clear:
                onClickButtonStrFunction(view, String.valueOf(R.string.label_clear), textView);
                break;
            case R.id.calc_button_clear_all:
                onClickButtonStrFunction(view, String.valueOf(R.string.label_clear_all), textView);
                break;
            case R.id.calc_button_dot:
                onClickButtonStrFunction(view, String.valueOf(R.string.label_dot), textView);
                break;
            case R.id.calc_button_round4:
                onClickButtonStrFunction(view, String.valueOf(R.string.label_round4), textView);
                break;

            case R.id.calc_button_sin:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_sin), textView);
                break;
            case R.id.calc_button_cos:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_cos), textView);
                break;
            case R.id.calc_button_tg:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_tg), textView);
                break;
            case R.id.calc_button_ctg:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_ctg), textView);
                break;

            case R.id.calc_button_one_to_x:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_one_to_x), textView);
                break;

            case R.id.calc_button_x_2:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_x_2), textView);
                break;
            case R.id.calc_button_x_3:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_x_3), textView);
                break;

            case R.id.calc_button_length:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_length), textView);
                break;
            case R.id.calc_button_area:
                onClickButtonFunFunction(view, String.valueOf(R.string.label_area), textView);
                break;

            case R.id.calc_button_plus:
                onClickButtonRegularFunction(view, String.valueOf(R.string.label_plus), textView);
                break;
            case R.id.calc_button_minus:
                onClickButtonRegularFunction(view, String.valueOf(R.string.label_minus), textView);
                break;
            case R.id.calc_button_multi:
                onClickButtonRegularFunction(view, String.valueOf(R.string.label_multi), textView);
                break;
            case R.id.calc_button_dev:
                onClickButtonRegularFunction(view, String.valueOf(R.string.label_dev), textView);
                break;

            case R.id.calc_button_result:
                onClickButtonEqual(view, textView);
                break;

            default:
                break;
        }
    }

    public void saveCache(String s) {
        File cachefile = new File(this.getCacheDir(), String.valueOf(R.string.name_file_cache));
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
}