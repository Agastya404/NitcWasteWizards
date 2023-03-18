package com.example.wastemanagement;

public class UserComplaint {

    public String complaint_des,complaint_area,complaint_land;

    public UserComplaint(){}

    public UserComplaint(String complaint_des,String complaint_area,String complaint_land)
    {
        this.complaint_des = complaint_des;
        this.complaint_area = complaint_area;
        this.complaint_land = complaint_land;
    }

    public String getComplaint_des() {
        return complaint_des;
    }

    public String getComplaint_area() {
        return complaint_area;
    }

    public String getComplaint_land() {
        return complaint_land;
    }


}

