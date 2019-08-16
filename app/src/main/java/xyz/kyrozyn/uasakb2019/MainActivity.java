package xyz.kyrozyn.uasakb2019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import xyz.kyrozyn.uasakb2019.model.MySharedPreferences;
import xyz.kyrozyn.uasakb2019.view.viewPagerAdapter;

/*NIM : 10116320
Nama : Satria Dwi Rizqi
Kelas : IF-7
Tanggal Pembuatan : 15 Agustus 2019
 */
public class MainActivity extends AppCompatActivity {
    public static String usernamePreference;
    SharedPreferences sharedPreferences;
    MenuItem prevMenuItem;
    private ViewPager pager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    pager.setCurrentItem(0);
                    return true;
                case R.id.navigation_profil:
                    pager.setCurrentItem(1);
                    return true;
                case R.id.navigation_kontak:
                    pager.setCurrentItem(2);
                    return true;
                case R.id.navigation_teman:
                    pager.setCurrentItem(3);
                    return true;
                case R.id.navigation_logout:
                    logout();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        final BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        this.pager = findViewById(R.id.viewpager);
        sharedPreferences = getSharedPreferences(MySharedPreferences.key, Context.MODE_PRIVATE);
        String usernamepreferences = sharedPreferences.getString(MySharedPreferences.username, "tidak login");
        usernamePreference = usernamepreferences;
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                navView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setupViewPager(pager);
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());
        Fragment homeFragment = new HomeFragment();
        Fragment profilFragment = new ProfilFragment();
        Fragment kontakFragment = new KontakFragment();
        Fragment temanFragment = new DaftarTemanFragment();
        viewPagerAdapter.addFragment(homeFragment);
        viewPagerAdapter.addFragment(profilFragment);
        viewPagerAdapter.addFragment(kontakFragment);
        viewPagerAdapter.addFragment(temanFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MySharedPreferences.username);
        editor.commit();
        Toast.makeText(this, "Anda berhasil Logout!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, Login.class);
        startActivity(i);
        finish();
    }
}
