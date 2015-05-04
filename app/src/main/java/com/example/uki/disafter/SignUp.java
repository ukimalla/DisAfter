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

        StrictMode.enableDefaults();

        Button btnSignUp = (Button) findViewById(R.id.btnSignUpSubmit);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


      //  String[] formDetail = getFormDetails();



        String skill = getSkill();

        List<NameValuePair> params = new ArrayList<NameValuePair>();


        params.add(new BasicNameValuePair("username", "ukimalla"));
        params.add(new BasicNameValuePair("password", "pikachu101"));
        params.add(new BasicNameValuePair("fname", "Uki"));
        params.add(new BasicNameValuePair("lname", "Malla"));
        params.add(new BasicNameValuePair("phno1", "9851064321"));
        params.add(new BasicNameValuePair("phno2", "014112406"));
        params.add(new BasicNameValuePair("email", "uki.malla@gmail.com"));
        params.add(new BasicNameValuePair("skill", skill));

        String url = "http://disafter.hostei.com/signup.php";


        HttpEntity httpEntity = null;


                Toast.makeText(SignUp.this, "entering", Toast.LENGTH_LONG).show();





        try
        {
            Toast.makeText(SignUp.this, "trying", Toast.LENGTH_LONG).show();

            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpPost  httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse httpResponse = httpClient.execute(httpPost);



            httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity);

            Toast.makeText(SignUp.this, "Success! :)" + response, Toast.LENGTH_LONG).show();





        } catch (ClientProtocolException e){
            e.printStackTrace();
            Toast.makeText(SignUp.this,"fail", Toast.LENGTH_LONG);


        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(SignUp.this,"fail", Toast.LENGTH_LONG);

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

    private String[] getFormDetails(){

        String[] formData= new String[6];

        EditText username = (EditText)findViewById(R.id.editTextUsername_sup);
        EditText password = (EditText)findViewById(R.id.editTextPassword_sup);
        EditText fname = (EditText)findViewById(R.id.editTextFirstName);
        EditText lname = (EditText)findViewById(R.id.editTextLastName);
        EditText phno1 = (EditText)findViewById(R.id.editTextPhone1);
        EditText phno2 = (EditText)findViewById(R.id.editTextPhone2);
        EditText email = (EditText)findViewById(R.id.editTextEmail);

/*
        formData[0] = String.valueOf(username.getText());
        formData[1] = String.valueOf(password.getText());
        formData[2] = String.valueOf(fname.getText());
        formData[3] = String.valueOf(lname.getText());
        formData[4] = String.valueOf(phno1.getText());
        formData[5] = String.valueOf(phno2.getText());
        formData[6] = String.valueOf(email.getText());
*/

        formData[0] = "a";
        formData[1] = "a";
        formData[2] = "a";
        formData[3] = "a";
        formData[4] = "a";
        formData[5] = "a";
        formData[6] = "a";


        return formData;



    }

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
