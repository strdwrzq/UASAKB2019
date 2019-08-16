package xyz.kyrozyn.uasakb2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
Tanggal Pembuatan : 15 Agustus 2019
 */
public class TambahTeman extends AppCompatActivity {
    EditText nim, nama, kelas, no_telp, email, instagram, twitter;
    String strnim, strnama, strkelas, strno, stremail, strinstagram, strtwitter;
    Realm realm;
    RealmList<Teman> t;
    int id;
    String pesan;
    private boolean setEdited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_teman);
        realm = Realm.getDefaultInstance();
        nim = findViewById(R.id.edNIM);
        nama = findViewById(R.id.edNama);
        kelas = findViewById(R.id.edKelas);
        no_telp = findViewById(R.id.edTelp);
        email = findViewById(R.id.edEmail);
        instagram = findViewById(R.id.edInstagram);
        twitter = findViewById(R.id.edTwitter);
        id = getIntent().getIntExtra("id", 0);
        setEdited = getIntent().getBooleanExtra("edited", false);
        if (setEdited) {
            User check = realm.where(User.class)
                    .equalTo("username", MainActivity.usernamePreference)
                    .findFirst();
            t = check.getTeman();
            Teman tmn = t.get(id);
            nim.setText(tmn.getNim());
            nim.setEnabled(false);
            nama.setText(tmn.getNama());
            kelas.setText(tmn.getKelas());
            no_telp.setText(tmn.getTelepon());
            email.setText(tmn.getEmail());
            instagram.setText(tmn.getInstagram());
            twitter.setText(tmn.getTwitter());
        }
    }

    public void tambahOnClicked(View view) {
        Realm.init(this);
        strnim = nim.getText().toString();
        strnama = nama.getText().toString();
        strkelas = kelas.getText().toString();
        strno = no_telp.getText().toString();
        stremail = email.getText().toString();
        strinstagram = instagram.getText().toString();
        strtwitter = twitter.getText().toString();
        if (strnim.isEmpty() || strnama.isEmpty() || strkelas.isEmpty() || strno.isEmpty() || stremail.isEmpty() || strinstagram.isEmpty() || strtwitter.isEmpty()) {
            Toast.makeText(this, "Mohon isi semua field", Toast.LENGTH_SHORT).show();
        } else {
            if (setEdited) {
                realm.beginTransaction();
                t.deleteFromRealm(id);
                realm.commitTransaction();
                pesan = "Berhasil mengedit teman!";
            } else {
                pesan = "Berhasil menambah teman!";
            }
            realm.beginTransaction();
            User check = realm.where(User.class)
                    .equalTo("username", MainActivity.usernamePreference)
                    .findFirst();
            Log.d("Realm check", check.getUsername());
            RealmList<Teman> t = check.getTeman();
            Teman teman = new Teman();
            teman.setNim(strnim);
            teman.setNama(strnama);
            teman.setKelas(strkelas);
            teman.setTelepon(strno);
            teman.setEmail(stremail);
            teman.setInstagram(strinstagram);
            teman.setTwitter(strtwitter);
            t.add(teman);
            check.setTeman(t);
            realm.insertOrUpdate(check);
            realm.commitTransaction();
            Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }
}
