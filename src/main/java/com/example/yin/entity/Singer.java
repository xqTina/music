package com.example.yin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

public class Singer {
   private Integer id;
   private String name;
   private String sex;
   private int pic;
    @JsonFormat(pattern = "yyyy--MM--dd",timezone="GMT+8")
   private Data birth;
   private String location;
   private String introduction;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public Data getBirth() {
        return birth;
    }

    public void setBirth(Data birth) {
        this.birth = birth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}
