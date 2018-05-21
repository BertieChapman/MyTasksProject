package com.bertrandechapman.mytasksproject;

import java.util.Date;

public class Task {

    String title;
    String desc;
    Date createdOn;
    Date modifiedOn;

    public Task(String title, String desc, Date createdOn) {

        this.title = title;
        this.desc = desc;
        this.createdOn = createdOn;
        this.modifiedOn = createdOn;
    }

    public Task(String title, String desc) {
        this(title, desc, new Date());
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

        taskModified();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;

        taskModified();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;

        taskModified();
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public void taskModified() {
        setModifiedOn(new Date());
    }
}
