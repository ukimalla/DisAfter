package com.example.uki.disafter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by uki on 03/05/15.
 */
public class coloredArrayAdapter extends ArrayAdapter<String> {


    public coloredArrayAdapter(Context context, String[] values) {
        super(context, R.layout.colored_array_adapter, values);

    }


    public int getBgColor(int position) {
        int returnColor = 0;
        switch (position) {
            case 0:
                returnColor = R.color.item1;
                break;
            case 1:
                returnColor = R.color.item2;
                break;
            case 2:
                returnColor = R.color.item3;
                break;
            case 3:
                returnColor = R.color.item4;
                break;
            case 4:
                returnColor = R.color.item5;
                break;
            default:
                return 0;
        }

        return returnColor;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.colored_array_adapter, parent, false);


        String itemText = getItem(position);
        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);
        theTextView.setText(itemText);


        RelativeLayout theRelativeLayout = (RelativeLayout) theView.findViewById(R.id.background);

        theRelativeLayout.setBackgroundResource(getBgColor(position));


        return theView;
    }
}

