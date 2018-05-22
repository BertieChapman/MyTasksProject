package com.bertrandechapman.mytasksproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bertrandechapman.mytasksproject.TaskListFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link FirestoreTask} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.ViewHolder> implements TaskProvider.TaskUpdateListener {

    private final OnListFragmentInteractionListener mListener;

    private final TaskProvider taskProvider;

    public TaskRecyclerViewAdapter(OnListFragmentInteractionListener listener, TaskProvider taskProvider) {

        this.taskProvider = taskProvider;

        this.taskProvider.addTaskUpdateListener(this);

        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = taskProvider.getTasks().get(position);
        holder.mContentView.setText(taskProvider.getTasks().get(position).getTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskProvider.getTasks().size();
    }

    @Override
    public void onNewTask(Task task) {
        this.notifyDataSetChanged();
    }

    @Override
    public void onRemovedTask(Task task) {
        this.notifyDataSetChanged();
    }

    @Override
    public void onTasksRetrieved(List<Task> tasks) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Task mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
