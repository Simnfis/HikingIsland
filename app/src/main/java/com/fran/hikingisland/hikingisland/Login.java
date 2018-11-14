package com.fran.hikingisland.hikingisland;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    Button buttonLOG;
    EditText editTextName;
    EditText editTextPassword;
    int Validado=0;

    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextName = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);


        context=this;


        Button buttonLOG = (Button) findViewById(R.id.email_sign_in_button);
        buttonLOG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();

                if (Validado==1){
                    EditText editText = (EditText) findViewById(R.id.email);
                    String name = editText.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), Main_login.class);
                    intent.putExtra("name", name);
                    startActivity(intent);}
                }

        });

    }

    private void validate() {
        editTextName.setError(null);
        editTextPassword.setError(null);

        String name = editTextName.getText().toString();
        String pass1 = editTextPassword.getText().toString();


        //Campos Obligatorios
        if(TextUtils.isEmpty(name)){
            editTextName.setError(getString(R.string.obligatory_field));
            editTextName.requestFocus();
            return;
        }else{
            if (TextUtils.isEmpty(pass1)) {
                editTextPassword.setError(getString(R.string.obligatory_field));
                editTextPassword.requestFocus();
                return;
            }else{
                Validado=1;
            }
        }
        //Fin Campos obligatorios


        Toast.makeText(getApplicationContext(),"Login Correct",Toast.LENGTH_SHORT).show();
    }

}
