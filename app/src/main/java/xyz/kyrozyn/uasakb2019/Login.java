package xyz.kyrozyn.uasakb2019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import xyz.kyrozyn.uasakb2019.model.MySharedPreferences;
import xyz.kyrozyn.uasakb2019.model.User;

/*NIM : 10116320
Nama : Satria Dwi Rizqi
Kelas : IF-7
Tanggal Pembuatan : 4 Agustus 2019
 */
public class Login extends AppCompatActivity {
    Realm realm;
    EditText username, password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Login Aplikasi UAS 10116281");
        sharedPreferences = getSharedPreferences(MySharedPreferences.key, Context.MODE_PRIVATE);
        checkSharedPreferences();
        try {
            realm = Realm.getDefaultInstance();
        } catch (Exception e) {
            Log.e("Realm Error : ", e.getMessage());
        }
    }

    public void signup(View view) {
        Intent signup = new Intent(Login.this, SignUp.class);
        startActivity(signup);
    }

    public void login(View view) {
        String strusername, strpassword;
        username = findViewById(R.id.eusername);
        password = findViewById(R.id.epassword);
        strusername = username.getText().toString();
        strpassword = password.getText().toString();
        //check user is exist
        User check = realm.where(User.class)
                .equalTo("username", strusername)
                .equalTo("password", strpassword)
                .findFirst();
        if (check == null) {
            Toast.makeText(this, "Gagal Login. Username/Password Salah!", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(MySharedPreferences.username, check.getUsername());
            editor.apply();
            Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show();
            goToMain();
        }
    }

    protected void checkSharedPreferences() {
        String usernamepreferences = sharedPreferences.getString(MySharedPreferences.username, null);
        if (usernamepreferences == null) {
            //Toast.makeText(this, "Anda Belum Login", Toast.LENGTH_SHORT).show();
        } else {
            goToMain();
            //Toast.makeText(this, "Anda Sudah Login! Username = "+usernamepreferences, Toast.LENGTH_SHORT).show();
        }
    }

    protected void goToMain() {
        Intent i = new Intent(Login.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}