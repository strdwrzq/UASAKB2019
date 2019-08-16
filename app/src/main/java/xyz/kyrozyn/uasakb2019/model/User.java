package xyz.kyrozyn.uasakb2019.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {
    @PrimaryKey
    private String username;
    @Required
    private String password;
    private RealmList<Teman> teman;

    public RealmList<Teman> getTeman() {
        return teman;
    }

    public void setTeman(RealmList<Teman> teman) {
        this.teman = teman;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}