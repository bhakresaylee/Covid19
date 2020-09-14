package com.example.covid.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.Models.Statewisemodel;
import com.example.covid.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statewiseadaptor extends RecyclerView.Adapter<Statewiseadaptor.ViewHolder>  {

    private Context mContext;
    private ArrayList<Statewisemodel> stateWiseModelArrayList;
    private String searchText = "";
    private SpannableStringBuilder sb;
    public void StateWiseAdapter(Context mContext, ArrayList<Statewisemodel> arrayList) {
        this.mContext = mContext;
        this.stateWiseModelArrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layoutstatewise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Statewisemodel currentItem = stateWiseModelArrayList.get(position);
        String stateName = currentItem.getState();
        String stateTotal = currentItem.getConfirmed();
        holder.tv_stateTotalCases.setText(NumberFormat.getInstance().format(Integer.parseInt(stateTotal)));
        //holder.tv_stateName.setText(stateName);
        if(searchText.length()>0){
            //color your text here
            sb = new SpannableStringBuilder(stateName);
            Pattern word = Pattern.compile(searchText.toLowerCase());
            Matcher match = word.matcher(stateName.toLowerCase());
            while(match.find()){
                ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(52, 195, 235)); //specify color here
                sb.setSpan(fcs, match.start(), match.end(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            }
            holder.tv_stateName.setText(sb);

        }else{
            holder.tv_stateName.setText(stateName);
        }

    }

    public void filterList(ArrayList<Statewisemodel> filteredList, String text) {
        stateWiseModelArrayList = filteredList;
        this.searchText = text;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return stateWiseModelArrayList==null ? 0 : stateWiseModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_stateName, tv_stateTotalCases;
        LinearLayout lin_state_wise;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stateName = itemView.findViewById(R.id.statewise_layout_name_textview);
            tv_stateTotalCases = itemView.findViewById(R.id.statewise_layout_confirmed_textview);
            lin_state_wise = itemView.findViewById(R.id.layout_state_wise_lin);
        }
    }
}
