package com.example.wastemanagement;

import android.widget.EditText;

public class AddNewStaff {

    public String staff_name,staff_phone,staff_emailid,work_location;

    public AddNewStaff(EditText staff_name, EditText staff_phone, EditText staff_emailid, EditText work_location){}

    public AddNewStaff(String staff_name,String staff_phone,String staff_emailid,String work_location)
    {
        this.staff_name = staff_name;
        this.staff_phone = staff_phone;
        this.staff_emailid = staff_emailid;
        this.work_location = work_location;
    }

    public String getStaff_name() { return staff_name; }

    public String getStaff_phone() {
        return staff_phone;
    }

    public String getStaff_emailid () {
        return staff_emailid;
    }

    public String getWork_location() {
        return work_location;
    }
}
