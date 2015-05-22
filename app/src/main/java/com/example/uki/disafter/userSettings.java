package com.example.uki.disafter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;





public class userSettings extends Activity {











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        SessionManagement sessionManagement = new SessionManagement(userSettings.this);

        ListView theListView = (ListView)findViewById(R.id.theListView);

        String theList[] = {"Change Password", "Delete Account", "Log Out"};

        ArrayAdapter theAdapter = new MainActivityAdapter(userSettings.this, theList, 3);


        theListView.setAdapter(theAdapter);

        sessionManagement.checkLogin(this);




        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                openActivity(position);

            }
        });









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_settings, menu);
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





    private void openActivity(int position){
        switch (position){

            case 2:

                SessionManagement sessionManagement = new SessionManagement(userSettings.this);
                sessionManagement.logOutUser();
                break;

            default:
                Toast.makeText(userSettings.this, "Cannot open activity", Toast.LENGTH_LONG).show();

        }


    }




}
