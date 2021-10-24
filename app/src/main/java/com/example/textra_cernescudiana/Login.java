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
        btn.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View v)
        {
            Intent intent=new Intent(Login.this,Register.class);
            startActivity(intent);
            startActivityForResult(intent, mainActivityRequest);
        }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==mainActivityRequest)
        {
            if(resultCode==RESULT_OK)
            {
                if(data!=null)
                {
                    Bundle newBundle=data.getBundleExtra("RaspunsBundle");
                   user u1=(user)newBundle.getSerializable("user");
                    etEmail.setText(u1.getEmail().toString());
                    etParola.setText(u1.getParola().toString());
                }
            }
        }

    }
}