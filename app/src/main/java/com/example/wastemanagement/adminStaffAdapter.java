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

public class adminStaffAdapter extends RecyclerView.Adapter<adminStaffAdapter.adminStaffViewHolder> {


    @NonNull

    Context context;
    ArrayList<AddNewStaff> staff ;



    public adminStaffAdapter(@NonNull Context context, ArrayList<AddNewStaff> staff) {
        this.context = context;
        this.staff = staff;
    }

    public adminStaffAdapter.adminStaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_allstaff_page,parent,false);

        return new adminStaffViewHolder(view);

    }


    public void onBindViewHolder(@NonNull adminStaffViewHolder holder, int position) {
        AddNewStaff nStaff=staff.get(position);
        holder.name.setText(nStaff.getStaff_name());
        holder.phone.setText(nStaff.getStaff_phone());
        holder.email.setText(nStaff.getStaff_emailid());
        holder.type.setText(nStaff.getStaff_type());
    }

    @Override
    public int getItemCount() {
        return staff.size();
    }

    public class  adminStaffViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone,email,type;

        public adminStaffViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.SName);
            phone = itemView.findViewById(R.id.SPhone);
            email=itemView.findViewById(R.id.SEmail);
            type=itemView.findViewById(R.id.SType);



        }


    }
}
