package com.example.uki.disafter;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class LogIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Setting Pointers

            //EditText
        final EditText editTextUsername = (EditText)findViewById(R.id.editTextUsername);
        final EditText editTextPassword = (EditText)findViewById(R.id.editTextPassword);


            //Buttons
        TextView btnSignUp = (TextView)findViewById(R.id.btnSignUp);
        Button btnLoginIn = (Button)findViewById(R.id.btnLogIn);

        //


        final SessionManagement sessionManagement = new SessionManagement();

        sessionManagement.SessionManager(this);








       //Button ClickListeners





        // Login
        btnLoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = String.valueOf(editTextUsername.getText());
                final String password = String.valueOf(editTextPassword.getText());


                Toast.makeText(LogIn.this, username + password, Toast.LENGTH_LONG).show();
                if(sessionManagement.validateCredentials(username, password)){

                    sessionManagement.createLogInSession(username,password);
                    Intent i = new Intent(LogIn.this, volunteerMain.class);



                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(i);



                }
                else {
                    Toast.makeText(LogIn.this, "Invalid Username and Password Combination! Please try again.", Toast.LENGTH_LONG).show();
                }




            }

        });



                //SignUp

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogIn.this, SignUp.class);
                startActivity(i);
            }
        });
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
