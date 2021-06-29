package com.princekin.sims.entity;

import java.util.Date;

public class Notice {
    private String topic;
    private String text;
    private Date date;
    private int index;

    public Notice(String topic, String text, Date date, int index) {
        this.topic = topic;
        this.text = text;
        this.date = date;
        this.index = index;
    }

    public Notice(String topic, String text, Date date) {
        this.topic = topic;
        this.text = text;
        this.date = date;
    }

    public Notice(String topic,String text){
        Date date=new Date();
        this.topic = topic;
        this.text = text;
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public int getIndex() {
        return index;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        String s="topic:"+this.topic+"\n"+"text:"+this.text+"\n"+getDate()+"\n";
        return s;
    }
}
