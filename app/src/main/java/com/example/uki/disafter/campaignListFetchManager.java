package com.example.uki.disafter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by uki on 18/05/15.
 */
public class campaignListFetchManager {

     String[][] theList = null;
     String cnameList[] = null;

    HttpEntity httpEntity = null;
    InputStream inputStream = null;

    String response = null;
    Context context;
    int mtypeOfFetch = 300;
    String mcid;



    String url = "http://bandsnepal.com/disafter/campaignList.php";

    public campaignListFetchManager(Context _context, int typeOfFetch){
        context=_context;
        mtypeOfFetch = typeOfFetch;
    }

    public campaignListFetchManager(Context _context, int typeOfFetch, String cid){
        context=_context;
        mtypeOfFetch = typeOfFetch;
        mcid = cid;
    }





    public void executeFetch(){






        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);


            if(mtypeOfFetch==0) {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("cid", mcid));
                httpPost.setEntity(new UrlEncodedFormEntity(params));
            }

            HttpResponse httpResponse = httpClient.execute(httpPost);


            httpEntity = httpResponse.getEntity();

            inputStream = httpEntity.getContent();

        }catch(Exception e){
            Log.d("campaingList", e.toString());
        }





        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line;


            while((line = bufferedReader.readLine()) != null){
                sb.append(line+"\n");
            }
            inputStream.close();
            response = sb.toString();
        }
        catch (Exception e){

            Log.d("campaignList", e.toString());
        }




if (mtypeOfFetch==1) {
    try {
        Log.d("campaignList", "trying campaignlist");

        JSONArray jsonArray = new JSONArray(response);

        JSONObject jsonObject;

        theList = new String[jsonArray.length()][9];
        cnameList = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            jsonObject = jsonArray.getJSONObject(i);


            theList[i][0] = jsonObject.getString("id");
            theList[i][1] = jsonObject.getString("cid");
            cnameList[i] = jsonObject.getString("cname");
            theList[i][3] = jsonObject.getString("type");
            theList[i][4] = jsonObject.getString("startdate");
            theList[i][5] = jsonObject.getString("enddate");
            theList[i][6] = jsonObject.getString("volreq");
            theList[i][7] = jsonObject.getString("location");
            theList[i][8] = jsonObject.getString("organization");
        }

    } catch (Exception e) {

        Log.d("campaignList", e.toString());
        Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
    }
}
else if(mtypeOfFetch == 0){
    try {
        Log.d("campaignList", "trying campaignlist");

        JSONArray jsonArray = new JSONArray(response);

        JSONObject jsonObject;

        theList = new String[1][15];
        cnameList = new String[jsonArray.length()];


            int i = 0;
            jsonObject = jsonArray.getJSONObject(i);



            theList[i][0] = jsonObject.getString("id");
            theList[i][1] = jsonObject.getString("cid");
            theList[i][2] = jsonObject.getString("cname");
            theList[i][3] = jsonObject.getString("type");
            theList[i][4] = jsonObject.getString("startdate");
            theList[i][5] = jsonObject.getString("enddate");
            theList[i][6] = jsonObject.getString("volreq");
            theList[i][7] = jsonObject.getString("location");
            theList[i][8] = jsonObject.getString("organization");
            theList[i][9] = jsonObject.getString("description");
            theList[i][10] = jsonObject.getString("cphno1");
            theList[i][11] = jsonObject.getString("cphno2");
            theList[i][12] = jsonObject.getString("cphno3");
            theList[i][13] = jsonObject.getString("engreq");
            theList[i][14] = jsonObject.getString("medreq");


    } catch (Exception e) {

        Log.d("campaignList", e.toString());
        Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
    }






        }




    }

    public String[] getCnameList() {
        return cnameList;
    }

    public String[][] getTheList() {
        return theList;
    }
}
