package com.example.wastemanagement;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class adminStaffAdapter extends RecyclerView.Adapter<adminStaffAdapter.adminStaffViewHolder> {


    @NonNull

    Context context;
    ArrayList<AddNewStaff> staffs ;



    public adminStaffAdapter(@NonNull Context context, ArrayList<AddNewStaff> staff) {
        this.context = context;
        this.staffs = staff;
    }

    public adminStaffAdapter.adminStaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_allstaff_page,parent,false);

        return new adminStaffViewHolder(view);

    }


    public void onBindViewHolder(@NonNull adminStaffViewHolder holder, int position) {
        AddNewStaff nStaff = staffs.get(position);
        holder.name.setText(nStaff.getStaff_name());
        holder.phone.setText(nStaff.getStaff_phone());
        holder.email.setText(nStaff.getStaff_emailid());
        holder.type.setText(nStaff.getStaff_type());
        holder.location.setText(nStaff.getStaff_location());
        holder.status.setText(nStaff.getStaff_status());


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("AddNewStaff");
        holder.delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context)
                        .setTitle("Delete Staff")
                        .setMessage("Are you sure you want to delete this staff")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                staffs.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                return true;

            }
        });
    }

    @Override
    public int getItemCount() {
        return staffs.size();
    }

    public class  adminStaffViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone,email,type,location,status;
        Button delete;


        public adminStaffViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.SName);
            phone = itemView.findViewById(R.id.SPhone);
            email=itemView.findViewById(R.id.SEmail);
            type=itemView.findViewById(R.id.SType);
            location=itemView.findViewById(R.id.S_Location);
            status=itemView.findViewById(R.id.S_Status);
            delete=itemView.findViewById(R.id.delStaffBtn);



        }


    }
}
