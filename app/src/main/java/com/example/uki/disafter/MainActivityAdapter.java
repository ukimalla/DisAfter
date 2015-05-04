package com.example.uki.disafter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivityAdapter extends ArrayAdapter<String> {





    public MainActivityAdapter(Context context, String[] values) {
            super(context, R.layout.adapter_main_layout, values);

        }




    private int getPictureRes(int position){
        switch(position) {
            case 0 :
                return R.drawable.img1 ;
            case 1:
                return R.drawable.img2;
            case 2:
                return R.drawable.img3;
            case 3:
                return R.drawable.img4;
            case 4:
                return R.drawable.img5;
            default:
                return R.drawable.img1;
        }
     }


    public int getBgColor(int position) {
        switch (position) {
            case 0:
                return R.color.item1;
            case 1:
                return R.color.item2;
            case 2:
                return R.color.item3;
            case 3:
                return R.color.item4;
            case 4:
                return R.color.item5;
            default:
                return 0;
        }
    }




    @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater theInflater = LayoutInflater.from(getContext());

            View theView = theInflater.inflate(R.layout.adapter_main_layout, parent, false);


            String itemText = getItem(position);
            TextView theTextView = (TextView) theView.findViewById(R.id.textView1);
            theTextView.setText(itemText);

            ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);
            theImageView.setImageResource(getPictureRes(position));

            LinearLayout theLinearLayout = (LinearLayout) theView.findViewById(R.id.background);

            theLinearLayout.setBackgroundResource(getBgColor(position));



            return theView;
        }
    }

