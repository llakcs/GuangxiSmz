package com.th.guangxismz.Bean;

import com.google.gson.annotations.SerializedName;

public class AttendanceBo {
    @SerializedName("person_type")
    private String person_type;
    @SerializedName("person_id")
    private String person_id;
    @SerializedName("person_name")
    private String person_name;
    @SerializedName("passed_time")
    private String passed_time;
    @SerializedName("direction")
    private String direction;
    @SerializedName("way")
    private String way;
    @SerializedName("site_photo")
    private String site_photo;

    public String getPerson_type() {
        return person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPassed_time() {
        return passed_time;
    }

    public void setPassed_time(String passed_time) {
        this.passed_time = passed_time;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getSite_photo() {
        return site_photo;
    }

    public void setSite_photo(String site_photo) {
        this.site_photo = site_photo;
    }
}
