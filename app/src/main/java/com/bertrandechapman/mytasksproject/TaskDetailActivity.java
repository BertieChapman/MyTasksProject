package com.bertrandechapman.mytasksproject;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TaskDetailActivity extends AppCompatActivity implements TaskDetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        TaskDetailFragment fragment = new TaskDetailFragment();

        Bundle data = getIntent().getExtras();

        // Check if data was passed
        if (data.containsKey(TaskDetailFragment.PARCELABLE_KEY)) {

            Log.i("Data passed", data.get(TaskDetailFragment.PARCELABLE_KEY).toString());

            fragment.setArguments(data);
        }

        getSupportFragmentManager().beginTransaction().add(R.id.fragContainer, fragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.i("i", "Unused interaction event");
    }
}
