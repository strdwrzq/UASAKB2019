package xyz.kyrozyn.uasakb2019;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import io.realm.Realm;
import io.realm.RealmList;
import xyz.kyrozyn.uasakb2019.model.Teman;
import xyz.kyrozyn.uasakb2019.model.User;

public class DetailTeman extends AppCompatActivity {
    TextView nim, nama, kelas, telp, email;
    ImageView instagram, twitter;
    Teman teman;
    int id;
    RealmList<Teman> t;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Detail Teman");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teman);
        //teman = new Teman();
        setText();
        Glide.with(getBaseContext())
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/instagram.png")
                .apply(new RequestOptions().override(150, 150))
                .into(instagram);
        Glide.with(getBaseContext())
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/twitter.png")
                .apply(new RequestOptions().override(150, 150))
                .into(twitter);
    }

    private void setText() {
        getRealmTeman();
        id = getIntent().getIntExtra("id", 0);
        teman = t.get(getIntent().getIntExtra("id", 0));
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        kelas = findViewById(R.id.kelas);
        telp = findViewById(R.id.telp);
        email = findViewById(R.id.email);
        instagram = findViewById(R.id.instagram);
        twitter = findViewById(R.id.twitter);
        nim.setText(teman.getNim());
        nama.setText(teman.getNama());
        kelas.setText(teman.getKelas());
        telp.setText(teman.getTelepon());
        email.setText(teman.getEmail());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setText();
    }

    public void instagramOnClicked(View view) {
        Intent uriIntent = new Intent(Intent.ACTION_VIEW);
        uriIntent.setData(Uri.parse("https://instagram.com/" + teman.getInstagram()));
        startActivity(uriIntent);
    }


    public void twitterOnClicked(View view) {
        Intent uriIntent = new Intent(Intent.ACTION_VIEW);
        uriIntent.setData(Uri.parse("https://twitter.com/" + teman.getTwitter()));
        startActivity(uriIntent);
    }

    public void deleteOnClicked(View view) {
        realm.beginTransaction();
        t.deleteFromRealm(id);
        realm.commitTransaction();
        Toast.makeText(this, "Teman berhasil dihapus!", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    void getRealmTeman() {
        realm = Realm.getDefaultInstance();
        User check = realm.where(User.class)
                .equalTo("username", MainActivity.usernamePreference)
                .findFirst();
        t = check.getTeman();
    }

    public void editOnClicked(View view) {
        Intent i = new Intent(view.getContext(), TambahTeman.class);
        i.putExtra("edited", true);
        i.putExtra("id", id);
        startActivity(i);
        finish();
    }
}