package xyz.kyrozyn.uasakb2019;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
/*NIM : 10116320
NIM : 10116320
Nama : Satria Dwi Rizqi
Tanggal Pembuatan : 15 Agustus 2019
 */

/**
 * A simple {@link Fragment} subclass.
 */
public class KontakFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ImageView telepon, email, github, instagram, twitter, telegram;
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_kontak, container, false);
        telepon = view.findViewById(R.id.telepon);
        email = view.findViewById(R.id.email);
        github = view.findViewById(R.id.github);
        instagram = view.findViewById(R.id.instagram);
        twitter = view.findViewById(R.id.twitter);
        telegram = view.findViewById(R.id.telegram);
        Glide.with(view)
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/telepon.png")
                .apply(new RequestOptions().override(150, 150))
                .into(telepon);
        Glide.with(view)
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/email.png")
                .apply(new RequestOptions().override(150, 150))
                .into(email);
        Glide.with(view)
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/github.png")
                .apply(new RequestOptions().override(150, 150))
                .into(github);
        Glide.with(view)
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/instagram.png")
                .apply(new RequestOptions().override(150, 150))
                .into(instagram);
        Glide.with(view)
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/twitter.png")
                .apply(new RequestOptions().override(150, 150))
                .into(twitter);
        Glide.with(view)
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/telegram.png")
                .apply(new RequestOptions().override(150, 150))
                .into(telegram);
        telepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:082240604117"));
                startActivity(intent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("mailto:arizkirizaldi@email.unikom.ac.id"));
                startActivity(intent);
            }
        });
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uriIntent = new Intent(Intent.ACTION_VIEW);
                uriIntent.setData(Uri.parse("https://github.com/Kyrozyn/"));
                startActivity(uriIntent);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uriIntent = new Intent(Intent.ACTION_VIEW);
                uriIntent.setData(Uri.parse("https://instagram.com/rizuriky"));
                startActivity(uriIntent);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uriIntent = new Intent(Intent.ACTION_VIEW);
                uriIntent.setData(Uri.parse("https://twitter.com/Kyrozyn/"));
                startActivity(uriIntent);
            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uriIntent = new Intent(Intent.ACTION_VIEW);
                uriIntent.setData(Uri.parse("https://t.me/kyrozyn"));
                startActivity(uriIntent);
            }
        });
        return view;
    }

}
