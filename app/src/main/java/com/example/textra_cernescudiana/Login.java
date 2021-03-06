package com.example.textra_cernescudiana;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button btn;
    private Button btnl;
    private final int mainActivityRequest=100;
    private EditText etEmail;
    private EditText etParola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        etEmail=findViewById(R.id.etEmail);
        etParola=findViewById(R.id.etPassword);
        btn=(Button)findViewById(R.id.btnRegister);
        btnl=(Button)findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View v)
        {
            Intent intent=new Intent(Login.this,Register.class);
            startActivity(intent);
            startActivityForResult(intent, mainActivityRequest);

            }

        });
        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginValid())
                { Intent intent=new Intent(Login.this,Page1.class);
                    startActivity(intent);}
            }
        });
        }



    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == mainActivityRequest) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Bundle newBundle = data.getBundleExtra("RaspunsBundle");
                    user u1 = (user) newBundle.getSerializable("user");
                    etEmail.setText(u1.getEmail().toString());
                    etParola.setText(u1.getParola().toString());
                }
            }

        }
    }
    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean loginValid()
        {   if(etEmail.getText().toString().isEmpty() || !(isEmailValid(etEmail.getText().toString())))
            {
                Toast.makeText(Login.this,"completati email-ul",Toast.LENGTH_SHORT).show();
                return false;}
            if(etParola.getText().toString().isEmpty())
            { Toast.makeText(Login.this,"completati parola",Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }




}