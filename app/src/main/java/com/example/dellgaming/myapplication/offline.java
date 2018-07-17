package com.example.dellgaming.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dellgaming.myapplication.SettingsPackage.SettingsFragment;
import com.example.dellgaming.myapplication.extra.AboutBankFragment;
import com.example.dellgaming.myapplication.extra.branches_map;
import com.example.dellgaming.myapplication.extra.contacts;
import com.example.dellgaming.myapplication.extra.faq;
import com.example.dellgaming.myapplication.CreditPackage.kredit;
import com.example.dellgaming.myapplication.OmonatPackage.omonat;
import com.example.dellgaming.myapplication.ExchangeMoney.otqizmalar;
import com.example.dellgaming.myapplication.creditcard.plastik;
import com.example.dellgaming.myapplication.MoneyOperation.valyutaOperatsiya;
import com.example.dellgaming.myapplication.register.activity.Register;
import com.example.dellgaming.myapplication.register.model.SignModel;
import com.example.dellgaming.myapplication.register.response.TokenResponse;

public class offline extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SignModel Sign;
    private ActionBar toolbar;
    private TokenResponse tokenresponse;
    public ImageButton register;
    private LinearLayout logo, logotext;


    private final static String API_KEY = "e315ce3850142a73a684b03aac892ae3";
    private String SIG = "98b3b38cf27ea990d86e448a69c936c2";
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Registratsiya activityga otish
        register = (ImageButton) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Registrastiya bosilganda shu activtyga o'tkazish kerak
                Intent intent = new Intent(offline.this,
                        Register.class);
                startActivity(intent);
            }
        });

//        ImageView imageViewed = (ImageView)findViewById(R.id.imageView);
        //        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
//        String token = pref.getString("token","");
//        Log.e("sad",token);

//        LinearLayout logo = (LinearLayout) findViewById(R.id.offline_logo);
////        LinearLayout logotext = (LinearLayout)findViewById(R.id.offline_logo_text);
//        imageViewed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AboutBankFragment fragment = new AboutBankFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, fragment);
//                transaction.commit();
//            }
//        });
//        View headerView = navigationView.inflateHeaderView(R.layout.navigation_header);
//        headerView.findViewById(R.id.navigation_header_text);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Chat va qongiroq qilish funksiyasi", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        getMenuInflater().inflate(R.menu.offline, menu);
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
//            Intent myIntent = new Intent(offline.this, SettingsActivity.class);
////            myIntent.putExtra("key", value); //Optional parameters
//            offline.this.startActivity(myIntent);
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
//            kredit newFragment = new kredit();
////            final kredit f = new kredit();
////            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,f).commit();
////            // Handle the camera action
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//            // Replace whatever is in the fragment_container view with this fragment,
//            // and add the transaction to the back stack so the user can navigate back
//            transaction.replace(R.id.fragment_container, newFragment);
//           // transaction.addToBackStack(null);
//
//            // Commit the transaction
//            transaction.commit();
            omonat fragment = new omonat();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
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
            SettingsFragment fragment = new SettingsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

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
            OfflineHomeFragment fragment = new OfflineHomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
