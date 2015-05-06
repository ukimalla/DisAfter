package com.example.uki.disafter;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;


/**
 * Created by uki on 06/05/15.
 */
public class ConnectionDetector {

        SharedPreferences pref;
        SharedPreferences.Editor editor;



        Context _context;

        private final static String LAST_CONNECTION = "lastConnection";
        private final static int PRIVATE_MODE = 0;


        public ConnectionDetector(Context context){
            this._context = context;
        }

        public boolean isConnectingToInternet(){
            ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null)
            {
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                if (info != null)
                    for (int i = 0; i < info.length; i++)
                        if (info[i].getState() == NetworkInfo.State.CONNECTED)
                        {
                            return true;
                        }

            }
            return false;
        }

    public void loggedIn(){

        pref = _context.getSharedPreferences(LAST_CONNECTION, PRIVATE_MODE);


        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(LAST_CONNECTION, true);

        editor.apply();


        String asd = String.valueOf(pref.getBoolean(LAST_CONNECTION, false));




    }



        public boolean checkIfNeedRecheckCredentials(boolean connectionStatus){

         if(connectionStatus  && connectionStatus != pref.getBoolean(LAST_CONNECTION, false)) {
             editor.putBoolean(LAST_CONNECTION, true);
             return true;
         }
         else if(connectionStatus = false && connectionStatus != pref.getBoolean(LAST_CONNECTION, false)) {
             editor.putBoolean(LAST_CONNECTION, false);
                return false;
             }


            else {return false;}


            }




















}
