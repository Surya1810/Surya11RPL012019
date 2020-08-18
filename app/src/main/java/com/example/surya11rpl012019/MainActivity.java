package com.example.surya11rpl012019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText txtuser;
    EditText txtpass;
    Button btnlogin,btnregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("login", MODE_PRIVATE);
        txtuser = (EditText)findViewById(R.id.txtuser);
        txtpass = (EditText)findViewById(R.id.txtpass);
        btnlogin = (Button) findViewById(R.id.login_btn);
        btnregis = (Button) findViewById(R.id.regis) ;

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtuser.getText().toString().equalsIgnoreCase("admin")
                        && txtpass.getText().toString().equalsIgnoreCase("admin")) {
                    Toast.makeText(MainActivity.this, "I Hope You Enjoy !", Toast.LENGTH_SHORT).show();

                    editor = pref.edit();
                    editor.putString("username", txtuser.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    finish();
                }
                    if (txtuser.getText().toString().isEmpty() && txtpass.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please, Fill the Form Before Continue !", Toast.LENGTH_SHORT).show();
                    } else if (txtuser.getText().toString().isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Username is Wrong !", Toast.LENGTH_SHORT).show();
                    } else if (txtpass.getText().toString().isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Password is Wrong !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed ! Try Again", Toast.LENGTH_SHORT).show();
                    }
            }

    });
        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Registration.class));
                finish();
            }
        });
    }
}