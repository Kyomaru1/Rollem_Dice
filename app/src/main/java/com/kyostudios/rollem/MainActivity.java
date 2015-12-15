package com.kyostudios.rollem;


import android.support.v4.app.FragmentTransaction;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    static int[] currentFragmentPosition = {0};


    public static void MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_test);
        if (savedInstanceState == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }

            String[] choices = getResources().getStringArray(R.array.choice_list);
            final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_drawer);
            Log.d("Testing", "Toolbar setup complete");

            final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
                public void onDrawerClosed(View view) {
                    super.onDrawerClosed(view);
                    invalidateOptionsMenu();
                }

                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                    invalidateOptionsMenu();
                }
            };

            drawerLayout.setDrawerListener(drawerToggle);


            final ListView drawerList = (ListView) findViewById(R.id.drawer_content);
            drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, choices));
            drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            if (currentFragmentPosition[0] != 0) {
                                drawerLayout.closeDrawer(drawerList);
                                SimpleRoller srFrag = new SimpleRoller();
                                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.fragment_landing, srFrag)
                                        .addToBackStack(srFrag.getFragTitle())
                                        .commit();
                                currentFragmentPosition[0] = 0;
                                getSupportActionBar().setTitle(srFrag.getFragTitle());
                                toolbar.setTitleTextColor(ContextCompat.getColor(MainActivity.this, R.color.textDark));
                            } else {
                                drawerLayout.closeDrawer(drawerList);
                            }

                            break;
                        case 1:
                            if (currentFragmentPosition[0] != 1) {
                                drawerLayout.closeDrawer(drawerList);
                                AdvancedRoller adFrag = new AdvancedRoller();
                                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.fragment_landing, adFrag)
                                        .addToBackStack(adFrag.getFragTitle())
                                        .commit();
                                currentFragmentPosition[0] = 1;
                                getSupportActionBar().setTitle(adFrag.getFragTitle());
                                toolbar.setTitleTextColor(ContextCompat.getColor(MainActivity.this, R.color.textDark));

                            } else {
                                drawerLayout.closeDrawer(drawerList);
                            }

                            break;
                        case 2:
                            if (currentFragmentPosition[0] != 2) {
                                drawerLayout.closeDrawer(drawerList);
                                ModRoller modFrag = new ModRoller();
                                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.fragment_landing, modFrag)
                                        .addToBackStack(ModRoller.getFragTitle())
                                        .commit();
                                currentFragmentPosition[0] = 2;
                                getSupportActionBar().setTitle(modFrag.getFragTitle());
                                toolbar.setTitleTextColor(ContextCompat.getColor(MainActivity.this, R.color.textDark));
                            } else {

                                drawerLayout.closeDrawer(drawerList);
                            }

                            break;

                        case 3:
                            if (currentFragmentPosition[0] != 3) {
                                drawerLayout.closeDrawer(drawerList);
                                AdvantageRoller advFrag = new AdvantageRoller();
                                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.fragment_landing, advFrag)
                                        .addToBackStack(AdvantageRoller.getFragTitle())
                                        .commit();
                                currentFragmentPosition[0] = 3;
                                getSupportActionBar().setTitle(advFrag.getFragTitle());
                                toolbar.setTitleTextColor(ContextCompat.getColor(MainActivity.this, R.color.textDark));
                            } else {
                                drawerLayout.closeDrawer(drawerList);
                            }

                            break;
                        case 4:
                            if (currentFragmentPosition[0] != 4) {
                                drawerLayout.closeDrawer(drawerList);
                                MultiRoller mtFrag = new MultiRoller();
                                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.fragment_landing, mtFrag)
                                        .addToBackStack(MultiRoller.getFragTitle())
                                        .commit();
                                getSupportActionBar().setTitle(mtFrag.getFragTitle());
                                toolbar.setTitleTextColor(ContextCompat.getColor(MainActivity.this, R.color.textDark));
                                currentFragmentPosition[0] = 3;
                            } else {
                                drawerLayout.closeDrawer(drawerList);
                            }
                            drawerLayout.closeDrawer(drawerList);
                            break;
                    }
                }
            });
            SimpleRoller startFragment = new SimpleRoller();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragment_landing, startFragment)
                    .commit();
            getSupportActionBar().setTitle("Simple Roller");
            if(currentFragmentPosition[0]==4){
                toolbar.inflateMenu(R.menu.multi_menu);
            }
            else{
                toolbar.inflateMenu(R.menu.menu_main);
            }
            Log.d("Testing", "Version code is: " + Build.VERSION.SDK_INT + " Lollipop version code is: " + Build.VERSION_CODES.LOLLIPOP);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_clearLog:
                EditText output = (EditText) findViewById(R.id.output);
                output.setText("");
                Toast toast = Toast.makeText(getApplicationContext(), "Log cleared.", Toast.LENGTH_SHORT);
                toast.show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
