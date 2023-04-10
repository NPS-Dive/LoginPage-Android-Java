package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class SignInPage extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignInPage";
    EditText name, lastName, email, password, tellNumber;
    RadioGroup gender;
    Switch newsSwitch;
    CheckBox termsOfAgreement, readTerms;
    Button registerBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        init();
        registerBTN.setOnClickListener(this);
    }

    //Method to get variables from user
    private void init() {
        name = findViewById(R.id.input_name);
        lastName = findViewById(R.id.input_lastName);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        tellNumber = findViewById(R.id.inputTelNumber);
        gender = findViewById(R.id.genderGroup);
        newsSwitch = findViewById(R.id.newsSwitch);
        termsOfAgreement = findViewById(R.id.termsOfAgreement);
        readTerms = findViewById(R.id.readTerms);
        registerBTN = findViewById(R.id.registerBTN);
    }

    @Override
    public void onClick(View v) {
        if (check()) {
            Toast.makeText(this, "ثبت نام شما با موفقیت انجام شد", Toast.LENGTH_SHORT).show();


        }
    }

    //method to check if parameters are inserted correctly
    private boolean check() {
        boolean filled = true;
        if (name.getText().toString().trim().isEmpty()
                || lastName.getText().toString().trim().isEmpty()
                || email.getText().toString().trim().isEmpty()
                || password.getText().toString().trim().isEmpty()
                || tellNumber.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "لطفاً فیلدهای خالی را پر بفرمایید", Toast.LENGTH_SHORT).show();
            filled = false;
        } else {
            if (name.getText().toString().trim().length() < 3) {
                filled = false;
                Toast.makeText(this, "نام وارد شده کمتر از 3 حرف است", Toast.LENGTH_SHORT).show();
            }
            if (lastName.getText().toString().trim().length() < 3) {
                filled = false;
                Toast.makeText(this, "نام خانوادگی وارد شده کمتر از 3 حرف است", Toast.LENGTH_SHORT).show();
            }
            if (email.getText().toString().trim().length() < 6) {
                filled = false;
                Toast.makeText(this, "نام وارد شده کمتر از 5 حرف است", Toast.LENGTH_SHORT).show();
            } else {
                if (!email.getText().toString().trim().contains("@")) {
                    filled = false;
                    Toast.makeText(this, "لطفاً ایمیل را در قالب درست آن درج بفرمایید", Toast.LENGTH_SHORT).show();
                }
            }
            if (password.getText().toString().trim().length() < 10) {
                filled = false;
                Toast.makeText(this, "طول پسورد  وارد شده کمتر از 10 کاراکتر است", Toast.LENGTH_SHORT).show();
            }
            if (tellNumber.getText().toString().trim().length() < 11) {
                filled = false;
                Toast.makeText(this, "شماره مویابل وارد شده کوتاه تر از 11 رقم است", Toast.LENGTH_SHORT).show();
            } else if (tellNumber.getText().toString().trim().length() > 11) {
                filled = false;
                Toast.makeText(this, "شماره مویابل وارد شده بیشتر از 11 رقم است", Toast.LENGTH_SHORT).show();
            }
        }
        if (!readTerms.isChecked()) {
            filled = false;
            Toast.makeText(this, "لطفاً،  تاییدیه های مربوط به قوانین را بررسی و قبول بفرمایید", Toast.LENGTH_SHORT).show();
        }
        if (!termsOfAgreement.isChecked()) {
            filled = false;
            Toast.makeText(this, "لطفاً،  تاییدیه های مربوط به مطالعه قوانین را بررسی و قبول بفرمایید", Toast.LENGTH_SHORT).show();
        }


        return filled;
    }
}