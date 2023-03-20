package com.example.wastemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adminAdapter extends RecyclerView.Adapter<adminAdapter.adminViewHolder> {


    @NonNull

    Context context;
    ArrayList<UserComplaint> usercomplaint;
    Button approve,disapprove;


    public adminAdapter(@NonNull Context context, ArrayList<UserComplaint> usercomplaint) {
        this.context = context;
        this.usercomplaint = usercomplaint;
    }

    public adminAdapter.adminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_allcomplaint_page,parent,false);
        
        return new adminViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull adminViewHolder holder, int position) {
        UserComplaint complaint=usercomplaint.get(position);
        holder.username.setText(complaint.getUname());
        holder.cDes.setText(complaint.getComplaint_des());
        holder.cArea.setText(complaint.getComplaint_area());
        holder.cLandmark.setText(complaint.getComplaint_land());
    }

    @Override
    public int getItemCount() {
        return usercomplaint.size();
    }

    public class  adminViewHolder extends RecyclerView.ViewHolder {
        TextView cDes,cArea,cLandmark,username;

        public adminViewHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.CuName);
            cDes = itemView.findViewById(R.id.CDes);
            cArea=itemView.findViewById(R.id.CArea);
            cLandmark=itemView.findViewById(R.id.CLandmark);
            approve=itemView.findViewById(R.id.approveBtn);
            disapprove=itemView.findViewById(R.id.disapproveBtn);


        }


    }
}
