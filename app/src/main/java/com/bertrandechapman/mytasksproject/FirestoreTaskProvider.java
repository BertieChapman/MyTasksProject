package com.bertrandechapman.mytasksproject;

import android.util.Log;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class FirestoreTaskProvider extends TaskProvider {

    private static final String TASK_COLLECTION_NAME = "tasks";

    // Database
    private FirebaseFirestore db;

    // Registration to updates
    private ListenerRegistration listenerRegistration;

    public FirestoreTaskProvider() {
        super();

        db = FirebaseFirestore.getInstance();

        tasks.add(new Task("task1", "description 1"));
        tasks.add(new Task("task2", "description 2"));


        //populateTaskList();
    }

    private void populateTaskList() {

        Query query = db.collection(TASK_COLLECTION_NAME);

        listenerRegistration = query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                if (e != null) {
                    Log.e("Firestore error", e.getMessage());
                    e.printStackTrace();
                    return;
                }
            }
        });
    }
}
