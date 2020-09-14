package com.example.covid.Models;

import android.app.Activity;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.StateData;

import java.util.ArrayList;

public class Statewisemodel extends RecyclerView.Adapter {
    private String state;
    private String confirmed;
    private String confirmed_new;
    private String active;
    private String death;
    private String death_new;
    private String recovered;
    private String recovered_new;
    private String lastupdate;

    public Statewisemodel(String str_state, String str_confirmed, String str_confirmed_new, String str_active, String str_death, String str_death_new, String str_recovered, String str_recovered_new, String str_lastupdatedate) {
    }

    public Statewisemodel(StateData stateData, ArrayList<Statewisemodel> stateWiseModelArrayList) {
    }


    public void StateWiseModel(String state, String confirmed, String confirmed_new, String active,
                               String death, String death_new, String recovered, String recovered_new, String lastupdate) {
        this.state = state;
        this.confirmed = confirmed;
        this.confirmed_new = confirmed_new;
        this.active = active;
        this.death = death;
        this.death_new = death_new;
        this.recovered = recovered;
        this.recovered_new = recovered_new;
        this.lastupdate = lastupdate;
    }

    public String getState() {
        return state;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getConfirmed_new() {
        return confirmed_new;
    }

    public String getActive() {
        return active;
    }

    public String getDeath() {
        return death;
    }

    public String getDeath_new() {
        return death_new;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getRecovered_new() {
        return recovered_new;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
