package com.example.uki.disafter;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class createCampaign extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_campaign);



        // Setting up pointers
        final RadioButton construction = (RadioButton)findViewById(R.id.radioBtnConstruction);
        final RadioButton distribution = (RadioButton)findViewById(R.id.radioBtnDistribution);
        final RadioButton healthCamp = (RadioButton)findViewById(R.id.radioBtnHealthCamp);
        final RadioButton other = (RadioButton) findViewById(R.id.radioBtnOther);

        final EditText cname = (EditText)findViewById(R.id.editTextCampaignName);
        final EditText description = (EditText)findViewById(R.id.editTextDescription);
        final EditText startDate = (EditText)findViewById(R.id.editTextStartDate);
        final EditText endDate = (EditText)findViewById(R.id.editTextEndDate);
        final EditText volReq = (EditText)findViewById(R.id.editTextVolunteersRequired);
        final EditText medReq = (EditText)findViewById(R.id.editTextDoctorsRequired);
        final EditText engReq = (EditText)findViewById(R.id.editTextEngineersRequired);
        final EditText phno1 = (EditText)findViewById(R.id.editTextPhone1);
        final EditText phno2 = (EditText)findViewById(R.id.editTextPhone2);
        final EditText phno3 = (EditText)findViewById(R.id.editTextPhone3);
        final EditText location = (EditText)findViewById(R.id.editTextLocation);
        final EditText organization = (EditText)findViewById(R.id.editTextOrganizationName);

        Button btnCreateCampaign = (Button) findViewById(R.id.btnCreateCampaign);

        //Enabling StrictMode as the http methods don't work without it


        StrictMode.enableDefaults();






        //SignUp OnClickListener

    btnCreateCampaign.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


                // Getting skill value
                String skill = getType();


                // Initializing param NameValuePar to store SignUp Details
                List<NameValuePair> params = new ArrayList<NameValuePair>();



                //Fetching values from form and putting it in params


                params.add(new BasicNameValuePair("cname", String.valueOf(cname.getText())));
                params.add(new BasicNameValuePair("type", skill));
                params.add(new BasicNameValuePair("description", String.valueOf(description.getText())));
                params.add(new BasicNameValuePair("startdate", String.valueOf(startDate.getText())));
                params.add(new BasicNameValuePair("enddate",String.valueOf(endDate.getText())));
                params.add(new BasicNameValuePair("cphno1", String.valueOf(phno1.getText())));
                params.add(new BasicNameValuePair("cphno2", String.valueOf(phno2.getText())));
                params.add(new BasicNameValuePair("cphno3", String.valueOf(phno3.getText())));
                params.add(new BasicNameValuePair("volreq", String.valueOf(volReq.getText())));
                params.add(new BasicNameValuePair("medreq", String.valueOf(medReq.getText())));
                params.add(new BasicNameValuePair("location", String.valueOf(location.getText())));
                params.add(new BasicNameValuePair("organization", String.valueOf(organization.getText())));
                params.add(new BasicNameValuePair("engreq", String.valueOf(engReq.getText())));

                // URL


                String url = "http://disafter.hostei.com/createCampaign.php";



                //Initializing httpEntity

                HttpEntity httpEntity = null;

                // Toast to ensure app has run till this point
                Toast.makeText(createCampaign.this, "entering", Toast.LENGTH_LONG).show();





                try
                {

                    // Toast to ensure "trying"

                    Toast.makeText(createCampaign.this, "trying", Toast.LENGTH_LONG).show();


                    // Setting up httpClient

                    DefaultHttpClient httpClient = new DefaultHttpClient();


                    //Setting up httpPost and executing it with httpResponse

                    HttpPost httpPost = new HttpPost(url);
                    httpPost.setEntity(new UrlEncodedFormEntity(params));

                    HttpResponse httpResponse = httpClient.execute(httpPost);


                    //Getting response from server if any.

                    httpEntity = httpResponse.getEntity();
                    String response = EntityUtils.toString(httpEntity);

                    //To ensure the code was executed successfully

                    Toast.makeText(createCampaign.this, " Success! :)" + response, Toast.LENGTH_LONG).show();





                } catch (ClientProtocolException e){
                    e.printStackTrace();

                    //Toast for Fail
                    Toast.makeText(createCampaign.this,"fail", Toast.LENGTH_LONG);


                }catch (IOException e){
                    e.printStackTrace();

                    //Toast for Fail
                    Toast.makeText(createCampaign.this,"fail", Toast.LENGTH_LONG);

                }
            }
        });






        // Managing the radio buttons


        // Eng radio button

        construction.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    distribution.setChecked(false);
                    healthCamp.setChecked(false);
                    other.setChecked(false);
                }

            }
        });


        //Med radio button

        distribution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    construction.setChecked(false);
                    healthCamp.setChecked(false);
                    other.setChecked(false);
                }

            }
        });

        //Neither radio button

        other.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    distribution.setChecked(false);
                    healthCamp.setChecked(false);
                    construction.setChecked(false);
                }

            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_campaign, menu);
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

// Get Type
    public String getType(){

        RadioButton construction = (RadioButton)findViewById(R.id.radioBtnConstruction);
        RadioButton distribution = (RadioButton)findViewById(R.id.radioBtnDistribution);
        RadioButton healthCamp = (RadioButton)findViewById(R.id.radioBtnHealthCamp);


        if(construction.isChecked()){
            return "1";
        }
        else if (distribution.isChecked()){
            return "2";
        }
        else if(healthCamp.isChecked()){
            return "3";

        }
        else{return "0";}

    }


}
