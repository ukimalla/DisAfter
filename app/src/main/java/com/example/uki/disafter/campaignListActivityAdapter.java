package com.example.uki.disafter;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by uki on 15/05/15.
 */


public class campaignListActivityAdapter extends ArrayAdapter<String> {

    String theList[][];

    public campaignListActivityAdapter(Context context, String[] values, String[][] subValues) {
        super(context, R.layout.campaign_list_array_adapter, values);
        theList = subValues;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.campaign_list_array_adapter, parent, false);


        String campaignName, organization,location, volunteersRequired, startDate, endDate;



        campaignName = getItem(position);
        organization = theList[position][8];
        location = theList[position][7];
        volunteersRequired = "Volunteers Required: " + theList[position][6];
        startDate = "Start Date: " + theList[position][4];
        endDate = "End Date: " + theList[position][5];



        TextView textViewCampaignName = (TextView) theView.findViewById(R.id.textViewCampaignName);
        textViewCampaignName.setText(campaignName);

        TextView textViewOrganization = (TextView) theView.findViewById(R.id.textViewOrganization);
        textViewOrganization.setText(organization);

        TextView textViewLocation= (TextView) theView.findViewById(R.id.textViewLocation);
        textViewLocation.setText(location);

        TextView textViewVolunteersRequired= (TextView) theView.findViewById(R.id.textViewVolunteersRequired);
        textViewVolunteersRequired.setText(volunteersRequired);

        TextView textViewStartDate = (TextView) theView.findViewById(R.id.textViewStartDate);
        textViewStartDate.setText(startDate);

        TextView textViewEndDate = (TextView) theView.findViewById(R.id.textViewENdDate);
        textViewEndDate.setText(endDate);



        return theView;

    }
}
