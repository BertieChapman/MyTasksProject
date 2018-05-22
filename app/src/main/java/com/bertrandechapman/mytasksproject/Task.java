package com.bertrandechapman.mytasksproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Task implements Parcelable {

    String title;
    String desc;
    //Date createdOn;
    //Date modifiedOn;

    public static final Parcelable.Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel parcel) {

            String title = parcel.readString();
            String desc = parcel.readString();
            return new Task(title, desc);
        }

        @Override
        public Task[] newArray(int i) {
            return new Task[0];
        }
    };

    public Task(Parcel parcel) {
        this.title = parcel.readString();
        this.desc = parcel.readString();
        //this.createdOn = (Date) parcel.readSerializable();
        //this.modifiedOn = (Date) parcel.readSerializable();
    }

    public Task(String title, String desc, Date createdOn) {

        this.title = title;
        this.desc = desc;
        //this.createdOn = createdOn;
        //this.modifiedOn = createdOn;
    }

    public Task(String title, String desc) {
        this(title, desc, new Date());
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

        //taskModified();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;

        //taskModified();
    }

    /*public Date getCreatedOn() {
        return createdOn;
    }*/

    /*public void setCreatedOn(Date createdOn) {
       // this.createdOn = createdOn;

        taskModified();
    }*/

    /*public Date getModifiedOn() {
        return modifiedOn;
    }*/

    /*public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }*/

    /*public void taskModified() {
        setModifiedOn(new Date());
    }*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        //parcel.writeSerializable(this.createdOn);
        //parcel.writeSerializable(this.modifiedOn);
    }
}
