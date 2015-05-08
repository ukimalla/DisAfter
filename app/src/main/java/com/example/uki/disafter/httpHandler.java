package com.example.uki.disafter;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by uki on 05/05/15.
 */
public class httpHandler {

    private Context context;

    public httpHandler(Context _context){ context = _context;}


    public String response ="";





    public void postThisShit(List<NameValuePair> params, String url){



        Log.d("HTTP_HANDLER", "httpEntity initialization");


        StrictMode.enableDefaults();

        //Initializing httpEntity

           HttpEntity httpEntity = null;





        Log.d("HTTP_HANDLER", "about to try");

        try
        {
            Log.d("HTTP_HANDLER", "trying");



            // Setting up httpClient


            Log.d("HTTP_HANDLER", "client setup");
            DefaultHttpClient httpClient = new DefaultHttpClient();


            //Setting up httpPost and executing it with httpResponse

            Log.d("HTTP_HANDLER", "post setup");

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            Log.d("HTTP_HANDLER", "posting and fetching response");

            HttpResponse httpResponse = httpClient.execute(httpPost);


            Log.d("HTTP_HANDLER", "saving response");
            //Getting response from server if any.

            httpEntity = httpResponse.getEntity();
           response = EntityUtils.toString(httpEntity);

            //To ensure the code was executed successfully

            Log.d("HTTP_HANDLER", "successful");

           Toast.makeText(context, " Success! :)" + response, Toast.LENGTH_LONG).show();





        } catch (ClientProtocolException e){
            Log.d("HTTP_HANDLER", "fail 1");

            e.printStackTrace();

            //Toast for Fail
           // Toast.makeText(context,"fail", Toast.LENGTH_LONG).show();


        }catch (IOException e){

            Log.d("HTTP_HANDLER", "fail 2");
            e.printStackTrace();

            //Toast for Fail
          //  Toast.makeText(context,"fail", Toast.LENGTH_LONG).show();

        }


    }

    public String getResponse() {
        return response;
    }
}
