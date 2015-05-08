package com.example.uki.disafter;

import android.app.Activity;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;


public class SignUp extends Activity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Setting up pointers
        final RadioButton eng = (RadioButton)findViewById(R.id.radioEng);
        final RadioButton med = (RadioButton)findViewById(R.id.radioMedic);
        final RadioButton neither = (RadioButton)findViewById(R.id.radioNeither);

        final EditText username = (EditText)findViewById(R.id.editTextUsername_sup);
        final EditText password = (EditText)findViewById(R.id.editTextPassword_sup);
        final EditText fname = (EditText)findViewById(R.id.editTextFirstName);
        final EditText lname = (EditText)findViewById(R.id.editTextLastName);
        final EditText phno1 = (EditText)findViewById(R.id.editTextPhone1);
        final EditText phno2 = (EditText)findViewById(R.id.editTextPhone2);
        final EditText email = (EditText)findViewById(R.id.editTextEmail);


        Button btnSignUp = (Button) findViewById(R.id.btnSignUpSubmit);

        //Enabling StrictMode as the http methods don't work without it








        //SignUp OnClickListener

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Getting skill value
               String skill = getSkill();


                // Initializing param NameValuePar to store SignUp Details
                List<NameValuePair> params = new ArrayList<NameValuePair>();



                //Fetching values from form and putting it in params


                params.add(new BasicNameValuePair("username", String.valueOf(username.getText())));
                params.add(new BasicNameValuePair("password", String.valueOf(password.getText())));
                params.add(new BasicNameValuePair("fname", String.valueOf(fname.getText())));
                params.add(new BasicNameValuePair("lname", String.valueOf(lname.getText())));
                params.add(new BasicNameValuePair("phno1",String.valueOf(phno1.getText())));
                params.add(new BasicNameValuePair("phno2", String.valueOf(phno2.getText())));
                params.add(new BasicNameValuePair("email", String.valueOf(email.getText())));
                params.add(new BasicNameValuePair("skill", skill));


                // URL


                String url = "http://bandsnepal.com/disafter/signup.php";

                httpHandler httpHandler = new httpHandler(SignUp.this);

                httpHandler.postThisShit(params, url);












            }
        });






        // Managing the radio buttons


        // Eng radio button

        eng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    med.setChecked(false);
                    neither.setChecked(false);
                }

            }
        });


        //Med radio button

        med.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    eng.setChecked(false);
                    neither.setChecked(false);
                }

            }
        });

        //Neither radio button

        neither.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    eng.setChecked(false);
                    med.setChecked(false);
                }

            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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

// Get Skill method
    private String getSkill(){

        RadioButton eng = (RadioButton)findViewById(R.id.radioEng);
        RadioButton med = (RadioButton)findViewById(R.id.radioMedic);


        if(eng.isChecked()){
            return "1";
        }
        else if (med.isChecked()){
            return "2";
        }
        else{return "0";}

    }




}
