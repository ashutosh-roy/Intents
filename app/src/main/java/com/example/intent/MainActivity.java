package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText name,pw;
    Button login;
    String toast_message,e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.displayname);
        pw = findViewById(R.id.password);
        login = findViewById(R.id.login);
    }
    public void showToast(View view)
    {
        e = name.getText().toString();
        p = pw.getText().toString();

        if((e.equals("ashutosh") ||(e.equals("admin")) && p.equals("1234")))
        {
            triggerMenu(view);
            toast_message = "Logged IN Successfully";
        }
        else
        {
            toast_message = "Invalid Login Details";
        }
        Toast toast = Toast.makeText(this, toast_message,
                Toast.LENGTH_LONG);
        toast.show();
    }
    public void triggerMenu(View view)
    {
        Intent i = new Intent(this, Menu.class);
        i.putExtra("Key",e);
        startActivity(i);
    }
}
