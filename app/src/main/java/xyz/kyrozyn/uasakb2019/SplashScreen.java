package xyz.kyrozyn.uasakb2019;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/*NIM : 10116320
Nama : Satria Dwi Rizqi
Kelas : IF-7
Tanggal Pembuatan : 4 Agustus 2019
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        goToMain();
        initRealm();
    }

    protected void goToMain() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashScreen.this, Login.class);
                startActivity(home);
                finish();
            }
        };
        int time = 1000;
        new Handler().postDelayed(r, time);
    }

    protected void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("database.realm").schemaVersion(1).migration(new MyMigration()).build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}