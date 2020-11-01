package dt.prot.bottom_menu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

        //Поля Авторизации
//        public EditText loginLogin;
//        public EditText loginPassword;
//
//        //Поля регистрации
//        public EditText regName;
//        public EditText regNumber;
//        public EditText regEmail;
//        public EditText regPassword;

        //String rule;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
        }

        //кнопка регистрации
        public void onButtonRegist(View view) {
//            regName = findViewById(R.id.regName);
//            regNumber = findViewById(R.id.regNumber);
//            regEmail = findViewById(R.id.regEmail);
//            regPassword = findViewById(R.id.regPassword);
            setContentView(R.layout.activity_auntif);
        }

        //кнопка авторизации
        public void onButtonLogin(View view) {
            try {
//                loginLogin = findViewById(R.id.loginLogin);
//                loginPassword = findViewById(R.id.loginPassword);

                  Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                  startActivity(intent);
//                } else {
//                    Toast.makeText(this, "Hеверные пароль", Toast.LENGTH_SHORT).show();
//                }
            } catch (Exception e) {
                Log.i("Login Activity", "Hеверные данные  :  " + e.toString());
            }
        }

        //переход с регистрации на авторизацию
        public void onButtonMoveRegist(View view) {
            setContentView(R.layout.activity_login);
        }

        //переход с авторизации на регистрацию
        public void onButtonMoveLogin(View view) {
            setContentView(R.layout.activity_register);
        }

        //забытый пароль
        public void viewForgotPAssword(View view) {
            Toast.makeText(this, "Дешевки", Toast.LENGTH_SHORT).show();
        }
}
