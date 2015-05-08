package com.example.uki.disafter;

import android.content.Context;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uki on 06/05/15.
 */
public class connectionChecker {

    Context context;


    public connectionChecker(Context _context){this.context = _context;}

    public boolean checkConnection(){

        Log.d("ALU BUG", "Connecion checker reached.");

        List<NameValuePair> params  = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("uki", "uki"));

        String url = "http://bandsnepal.com/disafter/checkServerConnection.php";

        Log.d("ALU BUG", "handler created");

        httpHandler httpHandler = new httpHandler(context);

        Log.d("ALU BUG", "POSTING THE SHITTT");

        httpHandler.postThisShit(params,url);

        Log.d("ALU BUG", "GETTING RESPONSEEE");

        String response = httpHandler.getResponse();

        if(response.equals("Server Up")){
            return true;
        }
        else {return false;}




    }














}
