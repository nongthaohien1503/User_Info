package com.example.userinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText editText_name;
    EditText editText_phone;
    Switch aSwitch_gender;
    Spinner spinner_education;
    SeekBar seekBar_age;
    CheckBox checkBox_sports;
    RadioButton rdBtnRock;
    RadioButton rdBtnRap;
    RadioButton rdBtnPop;

    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.name);
        editText_phone = findViewById(R.id.phone);
        aSwitch_gender = findViewById(R.id.gender);

        spinner_education = findViewById(R.id.education);
        String[] values = new String[]{"Cao đẳng", "Đại học", "Cao học"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_education.setAdapter(adapter);

        seekBar_age = findViewById(R.id.age);
        checkBox_sports = findViewById(R.id.sports);
        rdBtnRock = findViewById(R.id.rock);
        rdBtnRap = findViewById(R.id.classic);
        rdBtnPop = findViewById(R.id.pop);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText_name.getText().toString();
                String phone = editText_phone.getText().toString();
                String gender = "";
                if(aSwitch_gender.isChecked()) {
                    gender="Nữ";
                }
                else {
                    gender = "Nam";
                };
                String education = spinner_education.getSelectedItem().toString();
                int age = seekBar_age.getProgress();
                String sports = "";
                if(checkBox_sports.isChecked()) {
                    sports = "Có";
                }
                else {
                    sports = "Không";
                };
                String music = "";
                if (rdBtnPop.isChecked()) {
                    music = "Pop";
                } else if (rdBtnRap.isChecked()) {
                    music = "Rap";
                } else if (rdBtnRock.isChecked()) {
                    music = "Rock";
                }

                User_Info User = new User_Info(name, phone, gender, education, age, sports, music);
                Intent intent = new Intent(MainActivity.this, com.example.userinfo.SubActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("gender", gender);
                intent.putExtra("education", education);
                intent.putExtra("age", age);
                intent.putExtra("sports", sports);
                intent.putExtra("music", music);
                startActivity(intent);
            }
        });
    }
}