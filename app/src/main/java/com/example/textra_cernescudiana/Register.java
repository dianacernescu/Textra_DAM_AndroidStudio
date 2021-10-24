package com.example.textra_cernescudiana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private Button btn;
    private EditText etNume;
    private EditText etPrenume;
    private EditText etTelefon;
    private EditText etEmail;
    private EditText etParola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn=(Button)findViewById(R.id.btn1Register);
        etNume=findViewById(R.id.etNume);
        etPrenume=findViewById(R.id.etPrenume);
        etTelefon=findViewById(R.id.etTelefon);
        etEmail=findViewById(R.id.et1Email);
        etParola=findViewById(R.id.et1Password);
        btn.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View v){
        {   if(DateValide())
        {
            user u=new user();
            u.setNume(etNume.getText().toString());
            u.setPrenume(etPrenume.getText().toString());
            u.setTelefon(etTelefon.getText().toString());
            u.setEmail(etEmail.getText().toString());
            u.setParola(etParola.getText().toString());
            Bundle wrapperObject=new Bundle();
            wrapperObject.putSerializable("user",u);
            Intent intent=new Intent();
            intent.putExtra("RaspunsBundle",wrapperObject);
            setResult(RESULT_OK,intent);
            finish();


        }


        }}
        });
    }

   private boolean DateValide()
    {
        if(etNume.getText().toString().isEmpty())
        {
            Toast.makeText(Register.this,"completati numele",Toast.LENGTH_SHORT).show();
            return false;}
        if(etPrenume.getText().toString().isEmpty())
        {
            Toast.makeText(Register.this,"completati preumele",Toast.LENGTH_SHORT).show();
            return false;}
        if(etTelefon.getText().toString().isEmpty())
        {
            Toast.makeText(Register.this,"completati telefonul",Toast.LENGTH_SHORT).show();
            return false;}
        if(etTelefon.getText().toString().length()!=10)
        {Toast.makeText(Register.this,"Numarul trebuie sa aiba 10 cifre",Toast.LENGTH_SHORT).show();
        return false;}
        if(etEmail.getText().toString().isEmpty())
        {
            Toast.makeText(Register.this,"completati email-ul",Toast.LENGTH_SHORT).show();
            return false;}
        if(etParola.getText().toString().isEmpty())
        {
            Toast.makeText(Register.this,"completati parola",Toast.LENGTH_SHORT).show();
            return false;}
        return true;
    }
}