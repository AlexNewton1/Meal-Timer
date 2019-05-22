package com.softwareoverflow.mealtimer.ui.listAdapters;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.softwareoverflow.mealtimer.DeleteRestoreListAdapterListener;

import java.util.List;

public abstract class DeleteRestoreListAdapter<T1, T2 extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T2> {

    private Context context;
    protected List<T1> dataset;
    private ViewGroup rootViewGroup;
    private Snackbar undoSnackbar;

    private DeleteRestoreListAdapterListener<T1> listener;

    private T1 recentlyDeletedItem;
    private int recentlyDeletedItemPosition;

    protected DeleteRestoreListAdapter(Activity activity, List<T1> dataset) {
        this(activity, dataset, null);
    }

    protected DeleteRestoreListAdapter(Activity activity, List<T1> dataset, DeleteRestoreListAdapterListener<T1> listener) {
        this.context = activity;
        this.dataset = dataset;
        this.listener = listener;

        rootViewGroup = (ViewGroup) ((ViewGroup) activity
                .findViewById(android.R.id.content)).getChildAt(0);

        undoSnackbar = Snackbar.make(rootViewGroup, "Item Deleted", Snackbar.LENGTH_LONG)
                .setAction("Undo", v -> undoDelete());
    }

    public void deleteItem(int position) {
        recentlyDeletedItemPosition = position;
        recentlyDeletedItem = dataset.get(position);
        dataset.remove(position);
        notifyItemRemoved(position);
        undoSnackbar.show();

        if (listener != null) listener.onItemDeleted(recentlyDeletedItem);
    }
    private void undoDelete() {
        if(recentlyDeletedItem == null) return; // Handle the case where the user hits undo in very quick succession

        undoSnackbar.dismiss();
        dataset.add(recentlyDeletedItemPosition, recentlyDeletedItem);
        notifyItemInserted(recentlyDeletedItemPosition);

        if(listener != null) listener.onItemRestored(recentlyDeletedItem);
        recentlyDeletedItem = null;
    }

    public Context getContext() {
        return context;
    }
}
