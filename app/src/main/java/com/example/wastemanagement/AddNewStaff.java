package com.example.wastemanagement;

import android.widget.EditText;

public class AddNewStaff {

    public String staff_name,staff_phone,staff_emailid,staff_type;

    public AddNewStaff(EditText staff_name, EditText staff_phone, EditText staff_emailid, EditText staff_type){}

    public AddNewStaff() {
    }

    public AddNewStaff(String staff_name, String staff_phone, String staff_emailid, String staffType)
    {
        this.staff_name = staff_name;
        this.staff_phone = staff_phone;
        this.staff_emailid = staff_emailid;
        this.staff_type = staffType;
    }

    public String getStaff_name() { return staff_name; }

    public String getStaff_phone() {
        return staff_phone;
    }

    public String getStaff_emailid () {
        return staff_emailid;
    }

    public String getStaff_type() {
        return staff_type;
    }
}
