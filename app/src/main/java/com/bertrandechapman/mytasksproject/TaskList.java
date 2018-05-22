package com.bertrandechapman.mytasksproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TaskList extends AppCompatActivity implements TaskListFragment.OnListFragmentInteractionListener {

    private TaskListFragment taskListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        taskListFragment = (TaskListFragment) getSupportFragmentManager().findFragmentById(R.id.fragTaskList);

    }

    @Override
    public void onListFragmentInteraction(Task item) {

        Log.i("Item touched!", item.toString());

        Intent intent = new Intent(this, TaskDetailActivity.class);


        intent.putExtra(TaskDetailFragment.PARCELABLE_KEY, item);

        startActivity(intent);
    }
}
