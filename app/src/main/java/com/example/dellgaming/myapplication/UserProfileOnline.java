package com.example.dellgaming.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dellgaming.myapplication.CreditPackage.kredit;
import com.example.dellgaming.myapplication.ExchangeMoney.otqizmalar;
import com.example.dellgaming.myapplication.MoneyOperation.valyutaOperatsiya;
import com.example.dellgaming.myapplication.OmonatPackage.omonat;
import com.example.dellgaming.myapplication.SettingsPackage.SettingsActivity;
import com.example.dellgaming.myapplication.creditcard.plastik;
import com.example.dellgaming.myapplication.extra.CHatFragment;
import com.example.dellgaming.myapplication.extra.branches_map;
import com.example.dellgaming.myapplication.extra.contacts;
import com.example.dellgaming.myapplication.extra.faq;

public class UserProfileOnline extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_online);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnlineHomeFragment fragment = new OnlineHomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

        Intent intent = getIntent();
        String token = intent.getStringExtra("token");

       final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag = true;
                if(flag == true){
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_send_white_24dp));
                    CHatFragment fragment = new CHatFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.commit();

                }

//                else if(flag == false){
//
//                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.icon1));
//                    flag = true;
//
//                }




//                Snackbar.make(view, "Chat va qongiroq qilish funksiyasi", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_profile_online, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {




            omonat fragment = new omonat();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        } else if (id == R.id.nav_gallery) {

            kredit fragment = new kredit();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        } else if (id == R.id.nav_slideshow) {
            plastik fragment = new plastik();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();


        } else if (id == R.id.nav_manage) {
            otqizmalar fragment = new otqizmalar();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        } else if (id == R.id.nav_operation) {
            valyutaOperatsiya fragment = new valyutaOperatsiya();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        } else if (id == R.id.nav_share) {
            contacts fragment = new contacts();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        } else if (id == R.id.nav_send) {
            branches_map fragment = new branches_map();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        } else if (id == R.id.nav_faq) {
            faq fragment = new faq();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        } else if (id == R.id.nav_settings) {
//            Intent myIntent = new Intent(offline.this, SettingsActivity.class);
//////            myIntent.putExtra("key", value); //Optional parameters
//            offline.this.startActivity(myIntent);
            Intent intent = new Intent(UserProfileOnline.this,
                    SettingsActivity.class);
            startActivity(intent);
//            SettingsFragment fragment = new SettingsFragment();
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.fragment_container, fragment);
//            transaction.commit();

        } else if (id == R.id.nav_share_app) {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String sAux = "\nLet me recommend you this application\n\n";
                sAux = sAux + "https:universalbank.uz\n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch (Exception e) {
                //e.toString();
            }

        } else if (id == R.id.nav_home) {
            OnlineHomeFragment fragment = new OnlineHomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
