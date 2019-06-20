package com.juhe.work2.entity;

import java.util.Date;

/**
 * 黄历 日期
 */
public class Today {
    Date yangli;
    String yinli;
    String wuxing;
    String chongsha;
    String baiji;
    String yi;
    String ji;

    public Date getYangli() {
        return yangli;
    }

    public void setYangli(Date yangli) {
        this.yangli = yangli;
    }

    public String getYinli() {
        return yinli;
    }

    public void setYinli(String yinli) {
        this.yinli = yinli;
    }

    public String getWuxing() {
        return wuxing;
    }

    public void setWuxing(String wuxing) {
        this.wuxing = wuxing;
    }

    public String getChongsha() {
        return chongsha;
    }

    public void setChongsha(String chongsha) {
        this.chongsha = chongsha;
    }

    public String getBaiji() {
        return baiji;
    }

    public void setBaiji(String baiji) {
        this.baiji = baiji;
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
        return "Today{" +
                "yangli='" + yangli + '\'' +
                ", yinli='" + yinli + '\'' +
                ", wuxing='" + wuxing + '\'' +
                ", chongsha='" + chongsha + '\'' +
                ", baiji='" + baiji + '\'' +
                ", yi='" + yi + '\'' +
                ", ji='" + ji + '\'' +
                '}';
    }
}
