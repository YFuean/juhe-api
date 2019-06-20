package com.juhe.work2.entity;

import java.util.Date;

/**
 * 黄历 时辰
 */
public class Almanac {
    private Date yangli;
    private String hours;
    private String des;
    private String yi;
    private String ji;

    public Date getYangli() {
        return yangli;
    }

    public void setYangli(Date yangli) {
        this.yangli = yangli;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getYi() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }

    @Override
    public String toString() {
        return "Almanac{" +
                "yangli='" + yangli + '\'' +
                ", hours='" + hours + '\'' +
                ", des='" + des + '\'' +
                ", yi='" + yi + '\'' +
                ", ji='" + ji + '\'' +
                '}';
    }
}
