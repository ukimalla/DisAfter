package com.example.uki.disafter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class campaignList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_list);

        final String CAMPAIGN_ID = "CAMPAIGN_ID";

        String[] cnameList;
        final String[][]theList;

        campaignListFetchManager campaignListFetchManager = new campaignListFetchManager(campaignList.this, 1);

        campaignListFetchManager.executeFetch();
        theList = campaignListFetchManager.getTheList();
        cnameList = campaignListFetchManager.getCnameList();

            ListView theListView = (ListView) findViewById(R.id.theListView);

            ArrayAdapter theAdapter = new campaignListActivityAdapter(campaignList.this, cnameList, theList);

            theListView.setAdapter(theAdapter);



        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String cid = theList[position][1];

                Intent i = new Intent(campaignList.this, CampaignInfo.class);
                i.putExtra(CAMPAIGN_ID, cid);
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_campaign_list, menu);
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
