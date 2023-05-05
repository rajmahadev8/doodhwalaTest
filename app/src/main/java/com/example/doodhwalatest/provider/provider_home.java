package com.example.doodhwalatest.provider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.doodhwalatest.Adapter.Provider_Selection_Adapter;
import com.example.doodhwalatest.ConnectionDetector;
import com.example.doodhwalatest.MyApplication_OnlineTransfer;
import com.example.doodhwalatest.R;
import com.example.doodhwalatest.model.Custom_Provider_Home;
import com.example.doodhwalatest.model.Customer_Add_Provider_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class provider_home extends AppCompatActivity {

    String URL="http://meteorrider.socialstuf.com/milkmantra/v1/index_v2.php/get_provider_details";

    Toolbar toolbar;
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<Custom_Provider_Home> customer_list=new ArrayList<>();
    ImageView more;

    Provider_Selection_Adapter adapter_fb;
    ConnectionDetector cd;
    Boolean isInternetPresent=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_home);

        toolbar=findViewById(R.id.ProviderHomeToolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Home");
        }


        // handle search

        searchView=findViewById(R.id.search_view);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
             //   fileList(s);
                return false;
            }
        });

        // it for customer
        recyclerView=findViewById(R.id.ProviderHomeRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // adapter_fb=new Provider_Selection_Adapter(this,customer_list);
        recyclerView.setAdapter(adapter_fb);
      //  findcustomer(this);


        // it for more

        more=findViewById(R.id.More);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),provider_more.class);
                startActivity(intent);
            }
        });

    }


    // it for loading customer
    private void findcustomer(Context context) {

        adapter_fb.clear();
        //CAll If Internet is available
        cd = new ConnectionDetector(context);
        isInternetPresent = cd.isConnectingToInternet();

        // check for Internet status
        if (isInternetPresent) {

            // Toast.makeText(context, "Name " + name + "Email " + email + " phonenumber " + phonenumber + " maincity " + maincity, Toast.LENGTH_SHORT).show();
            StringRequest strReq = new StringRequest(Request.Method.POST,
                  EndPoints.LATEST_VALUES_NEW, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    //UPDATE PROPETIES

                    try {

                        JSONObject obj = new JSONObject(response);
                        //txtmessage.setText(obj.getString("message"));

                        // check for error flag
                        if (obj.getBoolean("error") == false) {
                            //Get random_users And show it in Top Horizontal View
                            JSONArray random_usersarray = obj.getJSONArray("random_users");

                            for (int i = 0; i < random_usersarray.length(); i++) {
                                JSONObject randomuserObj = (JSONObject) random_usersarray.get(i);
                                Customer_Add_Provider_model ObjUsr = new Customer_Add_Provider_model();
                                //id, name, email, dob, home_Address, phone_number, current_place,
                                // transplace1, transplace2, transplace3, transplace4, transplace5,
                                if (!randomuserObj.getString("id").equals("0")) {
                                    ObjUsr.setCustomer_id(randomuserObj.getString("id"));
                                    ObjUsr.setCustomer_vacation_mode(randomuserObj.getString("id"));

                                    ObjUsr.setCustomer_morning_cow_volume(randomuserObj.getString("id"));
                                    ObjUsr.setCustomer_morning_buffelo_volume(randomuserObj.getString("id"));

                                    ObjUsr.setCustomer_morning_other_volume(randomuserObj.getString("id"));
                                    ObjUsr.setCustomer_evening_cow_volume(randomuserObj.getString("id"));

                                    ObjUsr.setCustomer_evening_buffelo_volume(randomuserObj.getString("id"));
                                    ObjUsr.setCustomer_evening_other_volume(randomuserObj.getString("id"));

                                    ObjUsr.setCustomer_provider_is_active(randomuserObj.getString("id"));
                                    ObjUsr.setProvider_name(randomuserObj.getString("id"));

                                    ObjUsr.setProvider_id(randomuserObj.getString("id"));
                                    ObjUsr.setProvider_vacation_mode(randomuserObj.getString("id"));

                                    ObjUsr.setProvider_customer_associated(randomuserObj.getString("id"));
                                    ObjUsr.setCustomer_id(randomuserObj.getString("id"));



                                    adapter_fb.add(ObjUsr);
                                } else {
                                    Toast.makeText(context, "No more data available.", Toast.LENGTH_SHORT).show();

                                }

                                // data_user.add(new Data(R.drawable.user_top, randomuserObj.getString("user_id") + "#" + randomuserObj.getString("name") + "\nLast seen :" +randomuserObj.getString("last_online") + "#" + randomuserObj.getString("institute") + "#" + randomuserObj.getString("batch") + "#" + randomuserObj.getString("branch") + "#" + randomuserObj.getString("likes") +"#"+ randomuserObj.getString("isinterested")));
                            }
                            adapter_fb.notifyDataSetChanged();
                            /////////////////////////////////////////////////////////
                        } else {
                            // error in fetching chat rooms
                            Toast.makeText(context, "Check Internet Connection.#1", Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e)
                    {
                        Toast.makeText(context, "Check Internet Connection.#2" + e.toString(), Toast.LENGTH_SHORT).show();
                    }


                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    NetworkResponse networkResponse = error.networkResponse;
                    Toast.makeText(context, "Check Internet Connection.#3" + error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("provider_phone_number","9924343883");
                    params.put("customer_id","3");
                    return params;
                }

                ;
            };
            // disabling retry policy so that it won't make
            // multiple http calls
            int socketTimeout = 0;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

            strReq.setRetryPolicy(new DefaultRetryPolicy(0, -1, 0));
            //Adding request to request queue
            MyApplication_OnlineTransfer.getInstance().addToRequestQueue(strReq);

        } else {
            // txtsent_0_row.setText("Check Internet connection & Retry.");
            //btnrequestsent_retry.setVisibility(View.VISIBLE);
            Toast.makeText(context, "Check Internet connection & Retry.", Toast.LENGTH_SHORT).show();
        }

    }

    private void fileList(String s) {
        List<Custom_Provider_Home> fileterList=new ArrayList<>();
        for(Custom_Provider_Home item:customer_list){
            if(item.getNo().contains(s)){
                fileterList.add(item);
            }

        }
       if(fileterList.isEmpty()){
           Toast.makeText(this,"No Data found",Toast.LENGTH_LONG).show();
       }
       else{

           //provider_customer_adapter.setFilteredList(fileterList,s);
          // recyclerView.scrollToPosition(0);
       }


    }
}