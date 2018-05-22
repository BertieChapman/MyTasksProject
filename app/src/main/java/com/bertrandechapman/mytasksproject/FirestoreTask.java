package com.bertrandechapman.mytasksproject;

import java.util.ArrayList;
import java.util.Date;

public class FirestoreTask extends Task {

    public final static ArrayList<FirestoreTask> DUMMY_ITEMS = new ArrayList<>();

    private String Id;

    public FirestoreTask(String Id, String title, String desc, Date createdOn) {
        super(title, desc, createdOn);
    }

    public FirestoreTask(String Id, String title, String desc) {
        super(title, desc);
    }

    public String getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "FirestoreTask{" +
                "Id='" + Id + '\'' +
                "Task{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}' +
                '}';
    }
}
