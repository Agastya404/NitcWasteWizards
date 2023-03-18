package com.example.wastemanagement;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserComplaint {

    public String complaint_des,complaint_area,complaint_land;

    public UserComplaint(){}

    public UserComplaint(String complaint_des,String complaint_area,String complaint_land)
    {
        this.complaint_des = complaint_des;
        this.complaint_area = complaint_area;
        this.complaint_land = complaint_land;
    }



    public String getArticle_title() {return complaint_des;
    }

    public void setComplaint_des(String complaint_des) {
        this.complaint_des = complaint_des;
    }

    public String getAuthor_email() {
        return complaint_area;
    }

    public void setComplaint_area(String complaint_area) {
        this.complaint_area = complaint_area;
    }

    public String getAuthor_name() {
        return complaint_land;
    }

    public void setComplaint_land(String complaint_land) {
        this.complaint_land = complaint_land;
    }
}

