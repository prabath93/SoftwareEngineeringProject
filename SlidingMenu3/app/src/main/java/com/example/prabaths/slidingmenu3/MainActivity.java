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
import com.example.prabaths.Fragments.Expenses_Fragment;
import com.example.prabaths.Fragments.Home;
import com.example.prabaths.Fragments.Personal_Fragment;
import com.example.prabaths.Fragments.Vehicle_Fragment;
import com.example.prabaths.inner.frgments.Add_Fuel_Refill_Fragment;
import com.example.prabaths.inner.frgments.Add_Other_Expense_Fragment;
import com.example.prabaths.inner.frgments.Add_Vehicle_Fragment;
import com.example.prabaths.inner.frgments.Edit_Profile_Fragment;
import com.example.prabaths.inner.frgments.Edit_Vehicle_Details;
import com.example.prabaths.inner.frgments.Vehicle_Details_Fragment;
import com.example.prabaths.inner.frgments.View_Profile_Fragment;
import com.example.prabaths.models.Item;
import com.example.prabaths.models.NavItem;
import com.example.prabaths.models.SectionItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    RelativeLayout profile_box;
    ListView nav_list;
    List<Item> navItemList;
    List<Fragment> fragmentList;
    private static ImageView iv;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //SQLiteHelper sqLiteHelper=SQLiteHelper.getInstance(this);


        navItemList=new ArrayList<Item>();
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerPane=(RelativeLayout)findViewById(R.id.drawer_pane);
        nav_list=(ListView)findViewById(R.id.nav_list);

        navItemList.add(new NavItem(R.drawable.home, "Home page", "Home"));
        navItemList.add(new SectionItem(R.drawable.ball,"","----- Expenses ----"));
        navItemList.add(new NavItem(R.drawable.fuel, "", "Add Fuel Refill"));
        navItemList.add(new NavItem(R.drawable.money, "", "Add Other Expense"));
        navItemList.add(new SectionItem(R.drawable.ball,"","----- Vehicle ----"));
        navItemList.add(new NavItem(R.drawable.view_car, "", "View Vehicle Detail"));
        navItemList.add(new NavItem(R.drawable.edit, "", "Edit Vehicle Details"));
        navItemList.add(new NavItem(R.drawable.add, "", "Add Vehicle"));
        navItemList.add(new SectionItem(R.drawable.ball, "", "----- Personal ----"));
        navItemList.add(new NavItem(R.drawable.profile, "", "View Profile"));
        navItemList.add(new NavItem(R.drawable.edit, "", "Edit Profile"));



        NavListAdapter navListAdapter=new NavListAdapter(getApplicationContext(),R.layout.item_nav_list,navItemList);
        nav_list.setAdapter(navListAdapter);

        fragmentList=new ArrayList<>();
        fragmentList.add(new Home());
        fragmentList.add(new Expenses_Fragment());
        fragmentList.add(new Add_Fuel_Refill_Fragment());
        fragmentList.add(new Add_Other_Expense_Fragment());
        fragmentList.add(new Vehicle_Fragment());
        fragmentList.add(new Vehicle_Details_Fragment());
        fragmentList.add(new Edit_Vehicle_Details());
        fragmentList.add(new Add_Vehicle_Fragment());
        fragmentList.add(new Personal_Fragment());
        fragmentList.add(new View_Profile_Fragment());
        fragmentList.add(new Edit_Profile_Fragment());
        //fragmentList.add(new Vehicle_Fragment());
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


            if(requestCode==262145){
                ImageView iv=(ImageView)findViewById(R.id.profPicImView);
                iv.setImageResource(0);
                iv.setImageURI(data.getData());
            Toast.makeText(MainActivity.this, String.valueOf(requestCode).toString(), Toast.LENGTH_SHORT).show();}
            if(requestCode==65566) {
                ImageView iv=(ImageView)findViewById(R.id.vehiclePicImView);
                iv.setImageResource(0);
                iv.setImageURI(data.getData());
                Toast.makeText(MainActivity.this, String.valueOf(requestCode).toString(), Toast.LENGTH_SHORT).show();
            }

        }

        super.onActivityResult(requestCode,resultCode,data);

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
