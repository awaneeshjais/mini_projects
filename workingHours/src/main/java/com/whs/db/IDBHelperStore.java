package com.whs.db;

import java.util.List;

public interface IDBHelperStore {
    public void addStore(Store store);
    public Store getStore(int id);
    public List<Store> getAllStores();
    public int getStoresCount();
    public int updateStore(Store store);
    public void deleteStore(Store store);
    public void deleteAllStores();
}
