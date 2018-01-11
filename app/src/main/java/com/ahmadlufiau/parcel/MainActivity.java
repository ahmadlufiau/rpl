package com.ahmadlufiau.parcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ahmadlufiau.parcel.fragment.HomeFragment;
import com.ahmadlufiau.parcel.fragment.PengirimanFragment;
import com.ahmadlufiau.parcel.fragment.ProfilFragment;
import com.ahmadlufiau.parcel.fragment.StatusFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG_STATUS = "status";
    private static final String TAG_HOME = "beranda";
    //private static final String TAG_RIWAYAT_PEMBAYARAN = "Riwayat Pembayaran";
    private static final String TAG_PENGIRIMAN = "Pengiriman";
    private static final String TAG_PROFIL = "Profil";
    public static String CURRENT_TAG = TAG_STATUS;
    public static int navItemIndex = 0;

    private String[] activityTitles;
    private Handler mHandler;

    boolean shouldLoadHomeFragOnBackPress=true;

    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeSearchFragment();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
        if (shouldLoadHomeFragOnBackPress) {
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeSearchFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        if (id == R.id.action_settings) {
            Intent mIntent = new Intent(this, SettingActivity.class);
            startActivity(mIntent);
        }
        */

        return super.onOptionsItemSelected(item);
    }

    private void loadHomeSearchFragment(){
        selectNavMenu();
        setToolbarTitle();
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null){
            drawer.closeDrawers();
            return;
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = goToFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame_container,fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        if (runnable !=null){
            mHandler.post(runnable);
        }

        drawer.closeDrawers();
        invalidateOptionsMenu();
    }

    private Fragment goToFragment(){
        switch (navItemIndex){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                StatusFragment statusFragment = new StatusFragment();
                return statusFragment;
            case 2:
                //RiwayatPembayaranActivity rpFragment = new RiwayatPembayaranActivity();
                //return rpFragment;

            case 3:
                PengirimanFragment pengirimanFragment = new PengirimanFragment();
                return pengirimanFragment;
            case 4:
                ProfilFragment profilFragment = new ProfilFragment();
                return profilFragment;
            default:
                return new HomeFragment();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        // Handle navigation view item clicks here.
        int id = menuItem.getItemId();

        switch (id){
            case R.id.nav_home:
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                break;
            case R.id.nav_status:
                navItemIndex = 1;
                CURRENT_TAG = TAG_STATUS;
                break;
            case R.id.nav_rp:
                Intent moveIntent = new Intent(MainActivity.this, RiwayatPembayaranActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.nav_pengiriman:
                navItemIndex = 3;
                CURRENT_TAG = TAG_PENGIRIMAN;
                break;
            case R.id.nav_profil:
                navItemIndex = 4;
                CURRENT_TAG = TAG_PROFIL;
                break;
            default:
                navItemIndex = 0;
        }
        if (menuItem.isChecked()) {
            menuItem.setChecked(false);
        } else {
            menuItem.setChecked(true);
        }
        menuItem.setChecked(true);

        loadHomeSearchFragment();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}