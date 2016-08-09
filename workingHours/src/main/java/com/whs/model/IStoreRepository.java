package com.whs.model;

import io.realm.RealmResults;

public interface IStoreRepository {
    public void addStore(Store store);
    public void updateStore(String id, Store store);
    public void deleteStoreById(String id);
    public void deleteStoreByName(String name);
    public int countStore();
    public boolean isStore(String s);
    public RealmResults getStoreAll();
    public Store getStoreById(String id);
}
