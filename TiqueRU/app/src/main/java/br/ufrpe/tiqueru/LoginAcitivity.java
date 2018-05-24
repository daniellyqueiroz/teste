package br.ufrpe.tiqueru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;

public class LoginAcitivity extends AppCompatActivity implements OnClickListener{

    private Button btnAvaa;
    private EditText username;
    private EditText password;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences preferences = getSharedPreferences("usuario",0);
        if (!preferences.getString("token", "").equals("")) {
            Intent i = new Intent(LoginAcitivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        this.btnAvaa =  (Button) findViewById(R.id.btnAva);
        this.username = (EditText) findViewById(R.id.username);
        this.password = (EditText) findViewById(R.id.password);
        this.btnAvaa.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent i = new Intent(LoginAcitivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
