package com.cchd.talk2me;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.cchd.talk2me.common.ActivityBase;

import java.util.ArrayList;
import java.util.List;

public class RobotFollowUp3HighNav extends ActivityBase
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "ROBOT_FOLLOW_UP_3";
    Spinner sub_category_Spinner;
    private Bundle extras;
    private ImageButton submitButton;
    private TextView freeButton, highButton, thousandNutton,
            freeButtonDown, highButtonDown, thousandNuttonDown;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences SP;
    String qString;
    private Toolbar mToolbar;
    private MediaPlayer mp;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_follow_up3_high_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mp = MediaPlayer.create(context, R.raw.click_button);
/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        submitButton = findViewById(R.id.submitButton);

        freeButton = findViewById(R.id.btnFree);
        highButton = findViewById(R.id.btnHigh);
        thousandNutton = findViewById(R.id.btnThousand);
        freeButtonDown = findViewById(R.id.btnFreeDown);
        highButtonDown = findViewById(R.id.btnHighDown);
        thousandNuttonDown = findViewById(R.id.btnThousandDown);

        loadSelectMenus();
        addListenerOnReplyButton();

        addListenerOnfreeButton();
        addListenerOnhighButton();
        addListenerOnthousandNutton();
        addListenerOnfreeButtonDown();
        addListenerOnhighButtonDown();
        addListenerOnthousandNuttonDown();
    }

    private void addListenerOnthousandNutton() {
        thousandNutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.click_button);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }

                Intent intent = new Intent(RobotFollowUp3HighNav.this, RobotFollowUp3Nav.class);
                RobotFollowUp3HighNav.this.startActivity(intent);
            }
        });
    }

    private void addListenerOnfreeButtonDown() {
        freeButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.click_button);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }

                Intent intent = new Intent(RobotFollowUp3HighNav.this, RobotFollowUp3FreeNav.class);
                RobotFollowUp3HighNav.this.startActivity(intent);
            }
        });
    }

    private void addListenerOnhighButtonDown() {
        highButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.click_button);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }

                Intent intent = new Intent(RobotFollowUp3HighNav.this, RobotFollowUp3HighNav.class);
                RobotFollowUp3HighNav.this.startActivity(intent);
            }
        });
    }

    private void addListenerOnthousandNuttonDown() {
        thousandNuttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.click_button);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }

                Intent intent = new Intent(RobotFollowUp3HighNav.this, RobotFollowUp3Nav.class);
                RobotFollowUp3HighNav.this.startActivity(intent);
            }
        });
    }

    private void addListenerOnhighButton() {
        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.click_button);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }

                Intent intent = new Intent(RobotFollowUp3HighNav.this, RobotFollowUp3HighNav.class);
                RobotFollowUp3HighNav.this.startActivity(intent);
            }
        });
    }

    private void addListenerOnfreeButton() {
        freeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.click_button);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }

                Intent intent = new Intent(RobotFollowUp3HighNav.this, RobotFollowUp3FreeNav.class);
                RobotFollowUp3HighNav.this.startActivity(intent);
            }
        });
    }

    private void addListenerOnReplyButton() {

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.click_button);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }

                Intent intent = new Intent(RobotFollowUp3HighNav.this, PaystackActivity.class);


                Log.d(TAG, "after saving object");
                RobotFollowUp3HighNav.this.startActivity(intent);

            }

        });

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    private void loadSelectMenus() {

        sub_category_Spinner = findViewById(R.id.spinnerSubCategory);
        //sub_category_Spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        List<String> subCategoryList = new ArrayList<String>();
        subCategoryList.add("---SELECT ONE---");
        extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        qString = extras.getString("service_category");
        System.out.println("qString is :" + qString);
        if (qString == null) {
            return;
        }
        switch (qString) {
            case "TRAUMA":
                subCategoryList.add("Rape");
                subCategoryList.add("Abuse");
                subCategoryList.add("Trafficking");
                subCategoryList.add("Death");
                subCategoryList.add("Pain");
                break;

            case "ADDICTION":
                subCategoryList.add("Drug");
                subCategoryList.add("Alcohol");
                subCategoryList.add("Substance");
                subCategoryList.add("Sex");
                subCategoryList.add("Internet");

                break;

            case "EMOTIONAL":
                subCategoryList.add("Depression");
                subCategoryList.add("Anxiety");
                subCategoryList.add("Anger");
                subCategoryList.add("Mood Disorder");

                break;

            case "EDUCATION/CAREER":
                subCategoryList.add("Career");
                subCategoryList.add("Self Discovery");
                break;

            case "MARRIAGE/FAMILY":
                subCategoryList.add("Couple Issues");
                subCategoryList.add("Relationship");
                subCategoryList.add("Same Sex Attraction");
                subCategoryList.add("TIN/VAT");
                subCategoryList.add("Divorce Recovery");

                break;

        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subCategoryList);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub_category_Spinner.setAdapter(adapter2);


    }


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuLogout){
            extras = null;
            prefSetDefaults();
            launchLoginActivity();
        }
        return super.onOptionsItemSelected(item);
    }*/

    private void prefSetDefaults() {
        SP = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        SharedPreferences.Editor editor = SP.edit();
        editor.remove("logged_in_status");
        editor.remove("email");
        editor.remove("displayName");
        editor.apply();
    }

    private void launchLoginActivity() {
        Intent intent = new Intent(this, AppActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.robot_follow_up3_high_nav, menu);
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
        if (id == R.id.menuLogout){
            extras = null;
            prefSetDefaults();
            launchLoginActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rate) {
            // Handle the camera action
        } else if (id == R.id.nav_tell) {

        } else if (id == R.id.nav_settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
