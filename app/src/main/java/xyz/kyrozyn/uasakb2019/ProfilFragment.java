package xyz.kyrozyn.uasakb2019;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


/*NIM : 10116320
Nama : Satria Dwi Rizqi
Kelas : IF-7
Tanggal Pembuatan : 15 Agustus 2019
 */
public class ProfilFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_profil, container, false);
        ImageView i = view.findViewById(R.id.photoatas);
        Glide.with(view)
                .load("https://raw.githubusercontent.com/Kyrozyn/UASAKB2019/master/image/q.jpg")
                .apply(new RequestOptions().override(150, 150))
                .into(i);
        return view;
    }

}
