package xyz.kyrozyn.uasakb2019.model;

import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import xyz.kyrozyn.uasakb2019.MainActivity;

public class TemanData {
    public static ArrayList<Teman> getListData() {
        ArrayList<Teman> list = new ArrayList<>();
        Realm realm = Realm.getDefaultInstance();
        User check = realm.where(User.class)
                .equalTo("username", MainActivity.usernamePreference)
                .findFirst();
        RealmList<Teman> t = check.getTeman();
        Log.d("List cleared@TemanData", "!!");
        list.clear();
        for (Teman result : t) {
            Log.d("List added", result.getNim());
            list.add(result);
        }
        return list;
    }
}
