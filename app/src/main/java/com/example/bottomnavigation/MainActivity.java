package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. implementation 'com.google.android.material:material:1.0.0'
        //2. new android res dierctory -> menu
        //3. new andriod resource file in menu
        //4. add items in menu resource
        //5. Relative Layout -> tempat taro navigation
        //6. Add below code di tempat taro nav design
        /*<FrameLayout
            android:id="@+id/fragment_container"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_above="@id/bottom_navigation"/>

        <com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/bottom_navigation"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            app:menu="@menu/bottom_nav"
            android:background="?android:attr/windowBackground"/> */

        //7. make fragment classes (superclass : fragment)
        //8. Make layouts for fragment
        //9. connect fragmentclass dengan layout fragment (in oncreateview class,
             //return inflater.inflate()
        //10.

        BottomNavigationView bottomNav =findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentHome()).commit(); //DEFAULT FRAGMENT

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new FragmentHome();
                            break;
                        case R.id.nav_menu:
                            selectedFragment = new FragmentMenu();
                            break;
                        case R.id.nav_shop:
                            selectedFragment = new FragmentOrder();
                            break;
                        case R.id.nav_mail:
                            selectedFragment = new FragmentInbox();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new FragmentProfile();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
