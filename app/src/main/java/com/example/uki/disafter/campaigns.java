package com.example.uki.disafter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class campaigns extends Activity {

    //Open Activity Method

    private void openActivity(int position){
        switch (position){
            case 1:
                Intent bacteria_intent = new Intent(campaigns.this, createCampaign.class);
                startActivity(bacteria_intent);
                break;

            default:
                Toast.makeText(campaigns.this, "Cannot open activity", Toast.LENGTH_LONG).show();

        }


    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaigns);


        SessionManagement sessionManagement = new SessionManagement();

        sessionManagement.SessionManager(this);

        sessionManagement.checkLogin();

        // Setting up ListView
        String theList[] = {"Search", "Create", "Manage"};

        ListView theListView = (ListView)findViewById(R.id.theListView);

        ArrayAdapter theAdapter = new MainActivityAdapter(campaigns.this, theList, 2);

        theListView.setAdapter(theAdapter);



        // Setting up OnClickListener for ListView

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
        getMenuInflater().inflate(R.menu.menu_campaigns, menu);
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
