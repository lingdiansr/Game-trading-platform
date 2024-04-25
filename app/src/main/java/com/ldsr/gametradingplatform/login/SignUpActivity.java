package com.ldsr.gametradingplatform.login;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ldsr.gametradingplatform.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView signUpbutton = findViewById(R.id.signUpButton);
        EditText editTextAccount = findViewById(R.id.editTextAccount);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        EditText editTextQQ = findViewById(R.id.editTextQQ);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText editTextCaptcha = findViewById(R.id.editTextCaptcha);
        CheckBox checkBoxAgreement = findViewById(R.id.checkBoxAgreement);
        ImageView ImageReturn = findViewById(R.id.imageReturn);
        ImageReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        signUpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextAccount.getText() != null
                        && editTextPassword.getText() != null
                        && editTextConfirmPassword.getText() != null
                        && editTextQQ.getText() != null
                        && editTextPhone.getText() != null
                        && editTextCaptcha.getText() != null
                        && checkBoxAgreement.isChecked()) {
                    Handler handler = new Handler();
                    Runnable task = new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    };
                    handler.postDelayed(task, 1000);
                    Toast.makeText(SignUpActivity.this, "注册成功！请返回登录。", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(SignUpActivity.this, "注册失败！。", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}