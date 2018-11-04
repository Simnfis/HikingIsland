package com.fran.hikingisland.hikingisland;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    Button buttonOK;
    Button buttonREG;
    Button buttonLOG;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;





        Button buttonREG = (Button) findViewById(R.id.register_button);
        buttonREG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Registration_form.class);
                startActivity(intent);
            }
        });

        Button buttonLOG = (Button) findViewById(R.id.login_button);
        buttonLOG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Login.class);
                startActivity(intent);
            }
        });
    }
}
