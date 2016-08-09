package com.whs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
//import com.edmodo.rangebar.RangeBar;
import com.vi.swipenumberpicker.OnValueChangeListener;
import com.vi.swipenumberpicker.SwipeNumberPicker;
import com.whs.model.Store;
import com.whs.model.StoreRepository;


public class ActivityAdd extends AppCompatActivity implements View.OnClickListener
                                                      , CompoundButton.OnCheckedChangeListener
                                                      , OnValueChangeListener{
    EditText editTextName;
    EditText editTextPhone;
    EditText editTextAddress;
    Switch switchDayNight;
    SwipeNumberPicker[]  snp = new SwipeNumberPicker[14];
    CheckBox [] checkBox = new CheckBox[7];
    Button buttonSaveStore;

    String idStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        buttonSaveStore = (Button) findViewById(R.id.buttonSaveStore);
        switchDayNight = (Switch) findViewById(R.id.switchDayNight);
        checkBox[0] = (CheckBox) findViewById(R.id.checkbox1);
        checkBox[1] = (CheckBox) findViewById(R.id.checkbox2);
        checkBox[2] = (CheckBox) findViewById(R.id.checkbox3);
        checkBox[3] = (CheckBox) findViewById(R.id.checkbox4);
        checkBox[4] = (CheckBox) findViewById(R.id.checkbox5);
        checkBox[5] = (CheckBox) findViewById(R.id.checkbox6);
        checkBox[6] = (CheckBox) findViewById(R.id.checkbox7);

        snp[0] = (SwipeNumberPicker) findViewById(R.id.number_picker_1_start);
        snp[1] = (SwipeNumberPicker) findViewById(R.id.number_picker_1_end);

        switchDayNight.setChecked(false);
        if (switchDayNight != null) {
            switchDayNight.setOnCheckedChangeListener(this);
        }

        for (int i = 0; i < 6; i++) {
            checkBox[i].setChecked(false);
        }
        checkBox[6].setChecked(true);

        snp[0].setOnValueChangeListener(this);
        snp[1].setOnValueChangeListener(this);
        /*rangeBar[0] = (RangeBar) findViewById(R.id.rangeBar1);
        rangeBar[1] = (RangeBar) findViewById(R.id.rangeBar2);
        rangeBar[2] = (RangeBar) findViewById(R.id.rangeBar3);
        rangeBar[3] = (RangeBar) findViewById(R.id.rangeBar4);
        rangeBar[4] = (RangeBar) findViewById(R.id.rangeBar5);
        rangeBar[5] = (RangeBar) findViewById(R.id.rangeBar6);
        rangeBar[6] = (RangeBar) findViewById(R.id.rangeBar7);*/
        /*for (int i = 0; i < 7; i++) {
            rangeBar[i].setBarWeight(2);
            rangeBar[i].setConnectingLineWeight(4);
            rangeBar[i].setPinRadius(30);
        }
        for (int i = 0; i < 5; i++) {
            rangeBar[i].setRangePinsByValue(Preferences.getStoreIntLeft()
                    ,Preferences.getStoreIntRight());
        }
        rangeBar[5].setRangePinsByValue(Preferences.getStoreIntLeft(), 14);
        rangeBar[6].setRangePinsByValue(Preferences.getStoreIntLeft(), 12);*/

        idStore = getIntent().getStringExtra(Preferences.getIntentExtra());
        if (idStore != null) {
            StoreRepository repository = new StoreRepository();
            Store currStore = repository.getStoreById(idStore);
            editTextName.setText(currStore.getName());
            editTextPhone.setText(currStore.getPhone());
            editTextAddress.setText(currStore.getAddress());
            switchDayNight.setChecked(currStore.getNonStop());
            if (!currStore.getNonStop()){

            }
        }

        buttonSaveStore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSaveStore:

                Store s = new Store();
                s.setName(editTextName.getText().toString());
                s.setPhone(editTextPhone.getText().toString());
                s.setAddress(editTextAddress.getText().toString());

                s.setNonStop(switchDayNight.isChecked());

                s.setLatitude(Preferences.getStoreLatitude(this));
                s.setLongitude(Preferences.getStoreLongitude(this));

                //...

                StoreRepository repository = new StoreRepository();
                if (idStore == null) {
                    repository.addStore(s);
                 }else{
                    repository.updateStore(idStore,s);
                }
                Toast.makeText(ActivityAdd.this
                        , String.valueOf(s.getName())
                                + " "
                                + getString(R.string.toast_saved)
                        , Toast.LENGTH_LONG).show();

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }

                Intent mainIntent = new Intent(getApplicationContext(), ActivityMain.class);
                startActivity(mainIntent);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            for (int i = 0; i < 7; i++) {
                checkBox[i].setVisibility(View.INVISIBLE);
            }
        } else {
            for (int i = 0; i < 7; i++) {
                checkBox[i].setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean onValueChange(SwipeNumberPicker view, int oldValue, int newValue) {
        switch (view.getId()) {
            case R.id.number_picker_1_start:
                snp[0].setValue(newValue, false);
                return true;
            case R.id.number_picker_1_end:
                snp[1].setValue(newValue, false);
                return true;
        }
        return true;
    }
}