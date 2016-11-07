package com.example.administrator.jianzhimao.adapter;

/**
 * Created by Administrator on 2016/11/6.
 */

public class Job {
    private String type,typebg,title,local,data,pushtime,money;

    public String getType() {
        return type;
    }

    public String getTypebg() {
        return typebg;
    }

    public String getTitle() {
        return title;
    }

    public String getLocal() {
        return local;
    }

    public String getData() {
        return data;
    }

    public String getPushtime() {
        return pushtime;
    }

    public String getMoney() {
        return money;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPushtime(String pushtime) {
        this.pushtime = pushtime;
    }

    public void setTypebg(String typebg) {
        this.typebg = typebg;
    }
    public Job(String type,String typebg,String title,String local,String data,String pushtime ,String money){
        super();
        this.type = type;
        this.typebg = typebg;
        this.title = title;
        this.local = local;
        this.data = data;
        this.pushtime = pushtime;
        this.money = money;
    }
}
