package com.example.doodhwalatest.customer;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import com.example.doodhwalatest.model.Customer_Add_Provider_model;
import com.example.doodhwalatest.provider.EndPoints;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class home_customer extends AppCompatActivity {
    ArrayList<Customer_Add_Provider_model> provider_selections=new ArrayList<Customer_Add_Provider_model>();
     RecyclerView recyclerView;
    Provider_Selection_Adapter adapter_fb;
 ImageView profile;
 Toolbar toolbar;
 SearchView searchView;

    ConnectionDetector cd;
    Boolean isInternetPresent=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);

        toolbar=findViewById(R.id.HomeToolbar);
        setSupportActionBar(toolbar);

        if(getApplicationContext()!=null){
            getSupportActionBar().setTitle("Home");
        }
        adapter_fb = new Provider_Selection_Adapter(this,new ArrayList<Customer_Add_Provider_model>());

        // here handle the search

        searchView=findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //fileList(s);

                return false;
            }
        });




        // it for customer
   

        profile=findViewById(R.id.Profile);
        recyclerView=findViewById(R.id.recyycleViewOfHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter_fb);
        findcustomer(this);
      //  Customer_Add_Provider_model customer_add_provider_mode=new Customer_Add_Provider_model("Mayank","2","3","2","0","0","0","false");
       // provider_selections.add(customer_add_provider_mode);
      /*  provider_selections.add(new Customer_Add_Provider_model("Darshil","2","3","5","0","0","0","false"));
        provider_selections.add(new Customer_Add_Provider_model("Umang","2","3","5","0","0","0","false"));
        provider_selections.add(new Customer_Add_Provider_model("Nikhil","2","3","5","0","0","0","false"));
        provider_selections.add(new Customer_Add_Provider_model("Jayesh","2","3","5","0","0","0","false"));
        provider_selections.add(new Customer_Add_Provider_model("Manoj","2","3","5","0","0","0","false"));*/
       // provider_selection_adapter=new Provider_Selection_Adapter(this,provider_selections);
       // recyclerView.setAdapter(provider_selection_adapter);


        /*notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Notification();
            }

            private void open_Notification() {
                Intent intent=new Intent(getApplicationContext(),customer_notification.class);
                startActivity(intent);
            }
        });*/


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile();
            }

            private void profile() {
                Intent intent=new Intent(getApplicationContext(),customer_profile.class);
                startActivity(intent);
            }
        });



        // It is for notification




        // setting select contact listener
        findViewById(R.id.select_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickContact();
            }
        });
        int REQUEST_READ_CONTACTS_PERMISSION = 0;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_READ_CONTACTS_PERMISSION);
        }

    }

    // dont not modify
    private static final int PICK_CONTACT_REQUEST_CODE = 101;
    private static final String TAG = home_customer.class.getSimpleName();

    // contact intent
    private void pickContact() {
        Intent contactIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        contactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(contactIntent, PICK_CONTACT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST_CODE && data != null) {
            Uri contactData = data.getData();
            if (contactData != null) {
                Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    String num = cursor.getString(phoneIndex);

                    int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                    String name = cursor.getString(nameIndex);

                    String contactId = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));

                    for (String column : cursor.getColumnNames()) {
                        Log.i(TAG, "ContactPicked column " + column + " : " + cursor.getString(cursor.getColumnIndexOrThrow(column)));
                    }

                    Toast.makeText(home_customer.this, "Name= " + name + " Number= " + num , Toast.LENGTH_LONG).show();

                    // setting contact number
                    searchView.setQuery(num.toString(), false);

                    //Close cursor to prevent from memory leak
                    cursor.close();



                    //For getting contact Email use below cursor
                    //For below cursor: need permission of "android.permission.READ_CONTACTS"
                    Cursor emailCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?", new String[]{contactId}, null);

                    if (emailCursor != null && emailCursor.getCount() > 0) {
                        emailCursor.moveToFirst();
                        String email = emailCursor.getString(emailCursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Email.DATA));
                        Toast.makeText(home_customer.this, "Name= " + name + " Number= " + num + " Email: " + email, Toast.LENGTH_LONG).show();
                        //Close cursor to prevent from memory leak
                        emailCursor.close();
                    }
                }
            }
        }
    }

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
                                if (!randomuserObj.getString("customer_id").equals("0")) {
                                    ObjUsr.setCustomer_id(randomuserObj.getString("customer_id"));
                                    ObjUsr.setCustomer_vacation_mode(randomuserObj.getString("customer_vacation_mode"));

                                    ObjUsr.setCustomer_morning_cow_volume(randomuserObj.getString("customer_morning_cow_volume"));
                                    ObjUsr.setCustomer_morning_buffelo_volume(randomuserObj.getString("customer_morning_buffelo_volume"));

                                    ObjUsr.setCustomer_morning_other_volume(randomuserObj.getString("customer_morning_other_volume"));
                                    ObjUsr.setCustomer_evening_cow_volume(randomuserObj.getString("customer_evening_cow_volume"));

                                    ObjUsr.setCustomer_evening_buffelo_volume(randomuserObj.getString("customer_evening_buffelo_volume"));
                                    ObjUsr.setCustomer_evening_other_volume(randomuserObj.getString("customer_evening_other_volume"));

                                    ObjUsr.setCustomer_provider_is_active(randomuserObj.getString("customer_provider_is_active"));
                                    ObjUsr.setProvider_name(randomuserObj.getString("provider_name"));

                                    ObjUsr.setProvider_id(randomuserObj.getString("provider_id"));
                                    ObjUsr.setProvider_vacation_mode(randomuserObj.getString("provider_vacation_mode"));

                                    ObjUsr.setProvider_customer_associated(randomuserObj.getString("provider_customer_associated"));
                                    ObjUsr.setCustomer_id(randomuserObj.getString("customer_id"));

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



}