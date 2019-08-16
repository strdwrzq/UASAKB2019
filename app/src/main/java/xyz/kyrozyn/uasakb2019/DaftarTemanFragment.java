package xyz.kyrozyn.uasakb2019;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import xyz.kyrozyn.uasakb2019.model.Teman;
import xyz.kyrozyn.uasakb2019.model.TemanData;
import xyz.kyrozyn.uasakb2019.view.ListTemanAdapter;

/*NIM : 10116320
Nama : Satria Dwi Rizqi
Kelas : IF-7
Tanggal Pembuatan : 15 Agustus 2019
 */

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarTemanFragment extends Fragment {
    View view;
    private RecyclerView rvTeman;
    private ArrayList<Teman> list = new ArrayList<>();
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_daftar_teman, container, false);
        rvTeman = view.findViewById(R.id.rv_hero);
        rvTeman.setHasFixedSize(true);
        Refresh();
        fab = view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), TambahTeman.class);
                startActivity(i);
            }
        });
        return view;
    }

    public void Refresh() {
        Log.d("List cleared@", "DaftarTemanFragment");
        list.clear();
        list.addAll(TemanData.getListData());
        rvTeman.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ListTemanAdapter listTemanAdapter = new ListTemanAdapter(list);
        rvTeman.setAdapter(listTemanAdapter);
        listTemanAdapter.setOnItemClickCallback(new ListTemanAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(int data) {
                showSelectedTeman(data);
            }
        });
        Toast.makeText(view.getContext(), "Klik nama untuk melihat detail teman", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment Daftar teman", "resume");
        Refresh();
    }

    private void showSelectedTeman(int teman) {
        Intent intent = new Intent(view.getContext(), DetailTeman.class);
        intent.putExtra("id", teman);
        startActivity(intent);
    }
}
