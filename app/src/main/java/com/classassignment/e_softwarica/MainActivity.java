package com.classassignment.e_softwarica;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.classassignment.e_softwarica.R;

public class MainActivity extends AppCompatActivity {
    private EditText edname, edpwd;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edname = findViewById(R.id.etname);
        edpwd = findViewById(R.id.etpwd);
        btn = findViewById(R.id.btnlogin);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edname.getText().toString().trim();
                String pass = edpwd.getText().toString().trim();

                if (TextUtils.isEmpty(edname.getText().toString())){edname.setError("Input Username"); return;}
                if (TextUtils.isEmpty(edpwd.getText().toString())){edpwd.setError("Input Password"); return;}

                if (user.equals("shrawan") && pass.equals("admin")){
                    Toast toast = Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this,Dashboard.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();

                    return;
                }
                edpwd.setText(null);
                edname.setText(null);

            }
        });
    }
}