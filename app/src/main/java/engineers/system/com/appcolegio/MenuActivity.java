package engineers.system.com.appcolegio;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import engineers.system.com.appcolegio.fragment.AjustesFragment;
import engineers.system.com.appcolegio.fragment.ChatFragment;
import engineers.system.com.appcolegio.fragment.InformacionFragment;
import engineers.system.com.appcolegio.fragment.InicioFragment;


public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                    ChatFragment.OnFragmentInteractionListener,
                    AjustesFragment.OnFragmentInteractionListener,
                    InformacionFragment.OnFragmentInteractionListener,
                    InicioFragment.OnFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Fragment fragmentInicial = new InicioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contenedor, fragmentInicial).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        getSupportActionBar().setDisplayShowTitleEnabled(false);
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


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.accion_actividad) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment muestraFragmentPulsado = null;
        boolean iniciarFragment = false;

        if (id == R.id.nav_inicio) {
            muestraFragmentPulsado = new InicioFragment();
            iniciarFragment = true;
        } else if (id == R.id.nav_chat) {
            muestraFragmentPulsado = new ChatFragment();
            iniciarFragment = true;
        } else if (id == R.id.nav_ajustes) {
            muestraFragmentPulsado = new AjustesFragment();
            iniciarFragment = true;
        } else if (id == R.id.nav_informacion) {
            muestraFragmentPulsado = new InformacionFragment();
            iniciarFragment = true;
        } else if (id == R.id.nav_facebook) {

        } else if (id == R.id.nav_twitter) {

        }  else if (id == R.id.nav_snapchat) {

        } else if (id == R.id.nav_youtube) {

        }

        if(iniciarFragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contenedor, muestraFragmentPulsado).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
