package com.th.guangxismz.Bean;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AttendanceBo {
    @Id(autoincrement = true)
    private Long id;
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


    @Generated(hash = 2076570261)
    public AttendanceBo(Long id, String person_type, String person_id,
            String person_name, String passed_time, String direction, String way,
            String site_photo) {
        this.id = id;
        this.person_type = person_type;
        this.person_id = person_id;
        this.person_name = person_name;
        this.passed_time = passed_time;
        this.direction = direction;
        this.way = way;
        this.site_photo = site_photo;
    }

    @Generated(hash = 1506789062)
    public AttendanceBo() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
