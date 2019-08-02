package com.telusko;

// POJO

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
//@Table(name = "alien_table")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class Alien {

    @Id
    private int aid;
    //@Transient // Veritabani kismina gorunmez yapiyor yani veritabani boyle bir seye sahip olmuyor.
    private String aname;
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
