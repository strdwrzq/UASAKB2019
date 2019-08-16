package xyz.kyrozyn.uasakb2019;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmList;
import xyz.kyrozyn.uasakb2019.model.Teman;
import xyz.kyrozyn.uasakb2019.model.User;

/*NIM : 10116320
Nama : Satria Dwi Rizqi
Kelas : IF-7
Tanggal Pembuatan : 5 Agustus 2019
 */
public class SignUp extends AppCompatActivity {
    Realm realm;
    EditText username, password, confirmpassword;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        initLayout();
    }

    protected void beginRealm() {
        realm = Realm.getDefaultInstance();

    }

    protected void initLayout() {
        username = findViewById(R.id.eusername);
        password = findViewById(R.id.epassword);
        confirmpassword = findViewById(R.id.epassword2);
    }

    public void daftaronclick(View view) {
        beginRealm();
        String strusername, strpassword, strconfirmpassword;
        strusername = username.getText().toString();
        strpassword = password.getText().toString();
        strconfirmpassword = confirmpassword.getText().toString();

        if (strusername.equals("") || strpassword.equals("")) {
            Toast.makeText(this, "Maaf, mohon isi semua field!", Toast.LENGTH_SHORT).show();
        } else {
            //check user is exist
            User check = realm.where(User.class)
                    .equalTo("username", strusername)
                    .findFirst();
            if (check == null) {
                if (strpassword.equals(strconfirmpassword)) {
                    realm.beginTransaction();
                    User user = realm.createObject(User.class, strusername);
                    user.setPassword(strpassword);
                    RealmList<Teman> t = new RealmList<>();
                    user.setTeman(t);
                    realm.commitTransaction();
                    Toast.makeText(this, "Anda berhasil daftar!", Toast.LENGTH_LONG).show();
                    onBackPressed();
                } else {
                    Toast.makeText(this, "Maaf password tidak sama", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Maaf, username sudah ada!", Toast.LENGTH_LONG).show();
            }
        }
    }
}