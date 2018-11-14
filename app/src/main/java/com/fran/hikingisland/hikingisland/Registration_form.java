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

public class Registration_form extends AppCompatActivity {
    Button buttonREG;
    EditText editTextName;
    EditText editTextNick;
    EditText editTextAge;
    EditText editTextPassword1;
    EditText editTextPassword2;

    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        editTextName = (EditText) findViewById(R.id.text_name);
        editTextNick = (EditText) findViewById(R.id.text_nick);
        editTextAge = (EditText) findViewById(R.id.text_age);
        editTextPassword1 = (EditText) findViewById(R.id.password_1);
        editTextPassword2 = (EditText) findViewById(R.id.password_2);

        context=this;

        RadioGroup radioGroupSex = (RadioGroup) findViewById(R.id.radioGroupSex);
        radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String seleccion = null;
                switch (checkedId){
                    case R.id.radioHombre:
                        seleccion="Hombre";
                        break;
                    case R.id.radioMujer:
                        seleccion="Mujer";
                        break;
                }
                Toast.makeText(context,"Ha seleccionado: " + seleccion, Toast.LENGTH_SHORT).show();
            }
        });

        final CheckBox checkbox_basic = (CheckBox) findViewById(R.id.checkbox_basic);
        checkbox_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox_basic.isChecked()==true){                  Toast.makeText(context,"You have selected: To participate", Toast.LENGTH_SHORT).show();}
                else { Toast.makeText(context,"You have deselected: To participate", Toast.LENGTH_SHORT).show();}

            }
        });

        final CheckBox checkbox_medium = (CheckBox) findViewById(R.id.checkbox_medium);
        checkbox_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox_medium.isChecked()==true){                  Toast.makeText(context,"You have selected: To organize", Toast.LENGTH_SHORT).show();}
                else { Toast.makeText(context,"You have deselected: To organize", Toast.LENGTH_SHORT).show();}

            }
        });

        final CheckBox checkbox_high = (CheckBox) findViewById(R.id.checkbox_high);
        checkbox_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox_high.isChecked()==true){                Toast.makeText(context,"You have selected: To create", Toast.LENGTH_SHORT).show();}
                else { Toast.makeText(context,"You have deselected: To create", Toast.LENGTH_SHORT).show();}
            }
        });

        //Borrar valores por defecto.
    editTextName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editTextName.setText("");
        }
    });


        editTextNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNick.setText("");
            }
        });
        editTextAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextAge.setText("");
            }
        });


        //Fin borrado datos por defecto.

    Button buttonREG = (Button) findViewById(R.id.button_singup);
    buttonREG.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validate();
        }
    });

    }

    private void validate() {
        editTextName.setError(null);
        editTextNick.setError(null);
        editTextAge.setError(null);
        editTextPassword1.setError(null);
        editTextPassword2.setError(null);

        String name = editTextName.getText().toString();
        String age = editTextAge.getText().toString();
        String pass1 = editTextPassword1.getText().toString();
        String pass2 = editTextPassword2.getText().toString();
        String nick = editTextNick.getText().toString();

        //Campos Obligatorios
        if(TextUtils.isEmpty(name)){
            editTextName.setError(getString(R.string.obligatory_field));
            editTextName.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(age)){
            editTextAge.setError(getString(R.string.obligatory_field));
            editTextAge.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(nick)){
            editTextNick.setError(getString(R.string.obligatory_field));
            editTextNick.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(pass1)){
            editTextPassword1.setError(getString(R.string.obligatory_field));
            editTextPassword1.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(pass2)){
            editTextPassword2.setError(getString(R.string.obligatory_field));
            editTextPassword2.requestFocus();
            return;
        }
        //Fin Campos obligatorios
        //Comparando contraseñas
        if (!pass1.equals(pass2)){
            editTextPassword1.setError(getString(R.string.compare_field));
            editTextPassword1.requestFocus();
            return;
        }
        //Fin Comparando contraseñas
        //Campos numéricos
        int ageInt = Integer.parseInt(age);

        if (ageInt<16){
            editTextAge.setError(getString(R.string.numeric_field));
            editTextAge.requestFocus();
            return;
        }

        Toast.makeText(getApplicationContext(),"Se ha registrado correctamente",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, Main.class);
        startActivity(intent);

        };
    }

