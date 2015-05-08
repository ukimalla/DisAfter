package com.example.uki.disafter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.util.Log;
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

    private static final String PREF_NAME = "SessionManagement";

    private static final String IS_LOGIN = "IsLoggedIn";

    private static final String KEY_USER = "username";

    private static final String KEY_PASS = "pass";

    private static final String LAST_NETWORK_STATUS = "lastNetworkStatus";



    public SessionManagement(Context context){
        this._context = context;
        this.sharedPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }



    public void createLogInSession(String username, String password){



          editor.putBoolean(IS_LOGIN, true);

          editor.putString(KEY_USER, username);

          editor.putString(KEY_PASS, password);

          editor.putBoolean(LAST_NETWORK_STATUS, true);


            editor.apply();


            String asd = String.valueOf(sharedPreferences.getBoolean(IS_LOGIN, false));

        Toast.makeText(_context ,"the value of is login is" + asd,Toast.LENGTH_LONG ).show();






    }




    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();

        user.put(KEY_USER, this.sharedPreferences.getString(KEY_USER, null));
        user.put(KEY_PASS, this.sharedPreferences.getString(KEY_PASS, null));

        return user;
    }





    public void checkLogin(Context cont) {



        SharedPreferences pref = cont.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

        Boolean isLogin = pref.getBoolean(IS_LOGIN,false);




        if (!isLogin) {
            terminateSession();
        }


        if(IsRecheckCredentialsNeeded()){
            if (!validateCredentials(sharedPreferences.getString(KEY_USER, null), sharedPreferences.getString(KEY_PASS, null))){

                terminateSession();

            }

        }






    }



     public void logOutUser(){

         editor.clear();
         editor.apply();

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
        param.add(new BasicNameValuePair("password", password));




        String url = "http://bandsnepal.com/disafter/login.php";

        httpHandler httpHandler = new httpHandler(_context);

        httpHandler.postThisShit(param, url);

       String response = httpHandler.getResponse();



        if(response.equals("Valid User")){
            createLogInSession(username, password);
            return true;
        }
        else {return false;}





    }

    public boolean IsRecheckCredentialsNeeded() {


        String PREF_NAME = "SessionManagement";

        final String LAST_NETWORK_STATUS = "lastNetworkStatus";


        SharedPreferences sharedPreferences = _context.getSharedPreferences(PREF_NAME, volunteerMain.MODE_PRIVATE);

        Log.d("ALU BUG", "IsRecheckCredentialsNeeded reached");

        connectionChecker connectionChecker = new connectionChecker(_context);

        Log.d("ALU BUG", "CONNECTION CHECKER CREATED");

        if (connectionChecker.checkConnection() && !sharedPreferences.getBoolean(LAST_NETWORK_STATUS, true)) {
            Log.d("ALU BUG", "chk require");

            editor.putBoolean(LAST_NETWORK_STATUS, true);
            editor.apply();
            return true;
        } else if (!connectionChecker.checkConnection() && sharedPreferences.getBoolean(LAST_NETWORK_STATUS, true)) {

            Log.d("ALU BUG", "wtf no check required");
            sharedPreferences.edit().putBoolean(LAST_NETWORK_STATUS, false);
            editor.apply();
            return false;
        } else {

            Log.d("ALU BUG", "no check req");
            return false;
        }


    }












}












