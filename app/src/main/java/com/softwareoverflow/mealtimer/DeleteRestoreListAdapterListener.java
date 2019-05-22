package com.softwareoverflow.mealtimer;

public interface DeleteRestoreListAdapterListener<T1> {
    void onItemRestored(T1 item);
    void onItemDeleted(T1 item);
}
