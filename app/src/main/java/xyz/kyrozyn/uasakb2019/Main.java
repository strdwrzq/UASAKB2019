package xyz.kyrozyn.uasakb2019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import xyz.kyrozyn.uasakb2019.model.MySharedPreferences;

/*NIM : 10116320
Nama : Satria Dwi Rizqi
Kelas : IF-7
Tanggal Pembuatan : 5 Agustus 2019
 */
public class Main extends AppCompatActivity {
    TextView username;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        username = findViewById(R.id.txtusername);
        sharedPreferences = getSharedPreferences(MySharedPreferences.key, Context.MODE_PRIVATE);
        String usernamepreferences = sharedPreferences.getString(MySharedPreferences.username, "tidak login");
        username.setText(usernamepreferences);
    }

    public void logout(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MySharedPreferences.username);
        editor.commit();
        Toast.makeText(this, "Anda berhasil Logout!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Main.this, Login.class);
        startActivity(i);
        finish();
    }
}
