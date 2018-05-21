package com.bertrandechapman.mytasksproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TaskList extends AppCompatActivity implements TaskFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
    }

    @Override
    public void onListFragmentInteraction(Task item) {

        Log.i("Item touched!", item.toString());
    }
}
