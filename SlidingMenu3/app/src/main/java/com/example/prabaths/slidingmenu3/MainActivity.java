package com.example.prabaths.slidingmenu3;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.prabaths.Adapter.NavListAdapter;
import com.example.prabaths.Fragments.About;
import com.example.prabaths.Fragments.Home;
import com.example.prabaths.Fragments.Settings;
import com.example.prabaths.models.NavItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    RelativeLayout profile_box;
    ListView nav_list;
    List<NavItem> navItemList;
    List<Fragment> fragmentList;
    private static ImageView iv;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navItemList=new ArrayList<NavItem>();
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerPane=(RelativeLayout)findViewById(R.id.drawer_pane);
        nav_list=(ListView)findViewById(R.id.nav_list);
        navItemList.add(new NavItem(R.drawable.home, "Home page", "Home"));
        navItemList.add(new NavItem(R.drawable.settings, "Settings page", "Settings"));
        navItemList.add(new NavItem(R.drawable.about, "About page", "About"));

        NavListAdapter navListAdapter=new NavListAdapter(getApplicationContext(),R.layout.item_nav_list,navItemList);
        nav_list.setAdapter(navListAdapter);

        fragmentList=new ArrayList<>();
        fragmentList.add(new Home());
        fragmentList.add(new Settings());
        fragmentList.add(new About());
        FragmentManager fragmentManager= getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content,fragmentList.get(0)).commit();
        setTitle(navItemList.get(0).getTitle());
        nav_list.setItemChecked(0, true);
        drawerLayout.closeDrawer(drawerPane);


        nav_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, fragmentList.get(position)).commit();
                setTitle(navItemList.get(position).getTitle());
                nav_list.setItemChecked(position, true);
                drawerLayout.closeDrawer(drawerPane);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_opened,R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

       // iv=(ImageView)findViewById(R.id.profPicImView);
        int v=R.id.changeProfileBtn;

        //Button btn1=(Button)findViewById(R.id.changeProfileBtn);
       // Toast.makeText(MainActivity.this,btn1.toString(), Toast.LENGTH_SHORT).show();
        /*btn1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_PICK);
                        //Toast.makeText(this, "insidedddd111", Toast.LENGTH_LONG).show();
                        startActivityForResult(intent, 20);
                        //iv.setImageURI(intent.getData());
                        //Toast.makeText(getActivity(), iv.toString(), Toast.LENGTH_LONG).show();
                    }
                });*/
    }


   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode== RESULT_OK){
            if(requestCode==20){

                iv.setImageURI(data.getData());
                //Toast.makeText(getActivity(),"success",Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        Button btn1=(Button)findViewById(R.id.changeProfileBtn);

        if(resultCode==RESULT_OK){

                ImageView iv=(ImageView)findViewById(R.id.profPicImView);

                iv.setImageURI(data.getData());
                Toast.makeText(MainActivity.this,data.getData().toString(), Toast.LENGTH_SHORT).show();

        }

        super.onActivityResult(requestCode,resultCode,data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            Toast.makeText(MainActivity.this, "inside main", Toast.LENGTH_LONG).show();
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        //noinspection SimplifiableIfStatement
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
