package xyz.kyrozyn.uasakb2019;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*NIM : 10116320
Nama : Satria Dwi Rizqi
Kelas : IF-7
Tanggal Pembuatan : 15 Agustus 2019
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView t = view.findViewById(R.id.bawah);
        t.setText(MainActivity.usernamePreference);
        return view;
    }


}
