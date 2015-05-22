package com.example.uki.disafter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class CampaignInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_info);

        String CAMPAIGN_ID = "CAMPAIGN_ID";

        String theList[][];

        Intent i = getIntent();
        String cid = i.getStringExtra(CAMPAIGN_ID);

        TextView textViewCampaignName = (TextView)findViewById(R.id.textViewCampaignName);
        TextView textViewOrganization = (TextView)findViewById(R.id.textViewOrganization);
        TextView textViewType = (TextView)findViewById(R.id.textViewType);
        TextView textViewLocation = (TextView)findViewById(R.id.textViewLocation);
        TextView textViewStartDate = (TextView)findViewById(R.id.textViewStartDate);
        TextView textViewEndDate = (TextView)findViewById(R.id.textViewEndDate);
        TextView textViewEngineersRequired = (TextView)findViewById(R.id.textViewEngineersRequired);
        TextView textViewMedsRequired = (TextView)findViewById(R.id.textViewMedsRequired);
        TextView textViewVolunteersRequired = (TextView)findViewById(R.id.textViewVolunteersRequired);
        TextView textViewPhone1 = (TextView)findViewById(R.id.textViewPhone1);
        TextView textViewPhone2 = (TextView)findViewById(R.id.textViewPhone2);
        TextView textViewPhone3 = (TextView)findViewById(R.id.textViewPhone3);
        TextView textViewDescription = (TextView)findViewById(R.id.textViewDescription);

        campaignListFetchManager campaignListFetchManager = new campaignListFetchManager(CampaignInfo.this, 0, cid);
        campaignListFetchManager.executeFetch();

        theList = campaignListFetchManager.getTheList();



        int pos = 0;

        textViewCampaignName.setText(theList[pos][2]);
        textViewType.setText(theList[pos][3]);
        textViewStartDate.setText(theList[pos][4]);
        textViewEndDate.setText(theList[pos][5]);
        textViewVolunteersRequired.setText(theList[pos][6]);
        textViewLocation.setText(theList[pos][7]);
        textViewOrganization.setText(theList[pos][8]);
        textViewDescription.setText(theList[pos][9]);
        textViewPhone1.setText(theList[pos][10]);
        textViewPhone2.setText(theList[pos][11]);
        textViewPhone3.setText(theList[pos][12]);
        textViewMedsRequired.setText(theList[pos][13]);
        textViewEngineersRequired.setText(theList[pos][14]);















    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_campaign_info, menu);
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
