package com.example.uki.disafter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by uki on 05/05/15.
 */
public class SessionManagement {


    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    Context _context;



    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "Level0";

    private static final String IS_LOGIN = "IsLoggedIn";

    private static final String KEY_USER = "username";

    private static final String KEY_PASS = "pass";


    ConnectionDetector connectionDetector = new ConnectionDetector(_context);


    public void SessionManager(Context context){
        this._context = context;
        sharedPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }





    public void createLogInSession(String username, String password){


        ConnectionDetector newConnection = new ConnectionDetector(_context);

        newConnection.loggedIn();



            editor.putBoolean(IS_LOGIN, true);

            editor.putString(KEY_USER, username);

            editor.putString(KEY_PASS, password);

            editor.commit();



    }




    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();

        user.put(KEY_USER, sharedPreferences.getString(KEY_USER, null));
        user.put(KEY_PASS, sharedPreferences.getString(KEY_PASS, null));

        return user;
    }





    public void checkLogin() {

        if (!sharedPreferences.getBoolean(IS_LOGIN, false)) {
            terminateSession();


        }
        else if(connectionDetector.checkIfNeedRecheckCredentials(connectionDetector.isConnectingToInternet())){


            if (!validateCredentials(sharedPreferences.getString(KEY_USER, null), sharedPreferences.getString(KEY_PASS, null))){
                terminateSession();
            }


        }
    }

     public void logOutUser(){

         editor.clear();
         editor.commit();

         Intent i = new Intent(_context, MainActivity.class);

         i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

         i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

         _context.startActivity(i);


    }


    public void terminateSession(){


        Intent i = new Intent(_context, MainActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Toast.makeText(_context,"Your Session has expired. Please Log In again", Toast.LENGTH_LONG).show();

        _context.startActivity(i);

    }

    public boolean validateCredentials(String username, String password){

        // Initializing
        List<NameValuePair> param = new ArrayList<NameValuePair>();


        param.add(new BasicNameValuePair("username",username ));
        param.add(new BasicNameValuePair("password",  password));


        String url = "http://disafter.hostei.com/login.php";

        httpHandler httpHandler = new httpHandler();

        httpHandler.postThisShit(_context, param, url);

       String response = httpHandler.getResponse();

        if(response.equals("Valid User")){
            return true;
        }
        else {return false;}





    }



















}
