package com.example.intent;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends Activity {
    TextView name;
    Bundle extras;
    String newString = "";
    Button email,phone,web,map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        name = findViewById(R.id.displayname);
        map =  findViewById(R.id.maps);
        web =  findViewById(R.id.website);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);

        if (savedInstanceState == null)
        {
            extras = getIntent().getExtras();
            if(extras == null)
            {
                newString= null;
            }
            else
            {
                newString= extras.getString("Key");
            }
        }
        name.setText(newString);
    }
    public void sendEmail(View v)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));
        String[] s={"kavitha.r@science.christuniversity.in","ashutosh.roy@science.christuniversity.in"};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.putExtra(Intent.EXTRA_SUBJECT,"Welcome "+name.getText());
        i.putExtra(Intent.EXTRA_TEXT,"Hi, \n\n This is the email sent as an INTENT from my app.\n\nRegards\nAshutosh Roy");
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Choose An APP for sending EMAIL");
        startActivity(chooser);
    }
    public void Dial(View view)
    {
        String phone = "+919883623156";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
    public void Open(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW,  Uri.parse("https://www.myntra.com/"));
        startActivity(i);
    }
    public void Map(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW,  Uri.parse("https://goo.gl/maps/jLFdb5JxdVG4oKDn7"));
        startActivity(i);
    }
}
