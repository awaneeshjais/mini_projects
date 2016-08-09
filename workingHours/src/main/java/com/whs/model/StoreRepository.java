package com.whs.model;

import java.util.UUID;
import io.realm.Realm;
import io.realm.RealmResults;

public class StoreRepository implements IStoreRepository{
    @Override
    public void addStore(Store store){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
            Store s = realm.createObject(Store.class);
            s.setId(UUID.randomUUID().toString());

            s.setName(store.getName());
            s.setPhone(store.getPhone());
            s.setAddress(store.getAddress());

            s.setNonStop(store.getNonStop());

            s.setLatitude(store.getLatitude());
            s.setLongitude(store.getLongitude());

            s.setDayOff1(store.getDayOff1());
            s.setDayOff2(store.getDayOff2());
            s.setDayOff3(store.getDayOff3());
            s.setDayOff4(store.getDayOff4());
            s.setDayOff5(store.getDayOff5());
            s.setDayOff6(store.getDayOff6());
            s.setDayOff7(store.getDayOff7());

            s.setDay1Start(store.getDay1Start());
            s.setDay1End(store.getDay1End());
            s.setDay2Start(store.getDay2Start());
            s.setDay2End(store.getDay2End());
            s.setDay3Start(store.getDay3Start());
            s.setDay3End(store.getDay3End());
            s.setDay4Start(store.getDay4Start());
            s.setDay4End(store.getDay4End());
            s.setDay5Start(store.getDay5Start());
            s.setDay5End(store.getDay5End());
            s.setDay6Start(store.getDay6Start());
            s.setDay6End(store.getDay6End());
            s.setDay7Start(store.getDay7Start());
            s.setDay7End(store.getDay7End());
        realm.commitTransaction();
        /*if (callback != null)
            callback.onSuccess();*/
    };

    @Override
    public void updateStore(String idStore, Store store){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Store s = realm.where(Store.class).equalTo("id", idStore).findFirst();
        //s.setId(UUID.randomUUID().toString());

        s.setName(store.getName());
        s.setPhone(store.getPhone());
        s.setAddress(store.getAddress());

        s.setNonStop(store.getNonStop());

        s.setLatitude(store.getLatitude());
        s.setLongitude(store.getLongitude());

        s.setDayOff1(store.getDayOff1());
        s.setDayOff2(store.getDayOff2());
        s.setDayOff3(store.getDayOff3());
        s.setDayOff4(store.getDayOff4());
        s.setDayOff5(store.getDayOff5());
        s.setDayOff6(store.getDayOff6());
        s.setDayOff7(store.getDayOff7());

        s.setDay1Start(store.getDay1Start());
        s.setDay1End(store.getDay1End());
        s.setDay2Start(store.getDay2Start());
        s.setDay2End(store.getDay2End());
        s.setDay3Start(store.getDay3Start());
        s.setDay3End(store.getDay3End());
        s.setDay4Start(store.getDay4Start());
        s.setDay4End(store.getDay4End());
        s.setDay5Start(store.getDay5Start());
        s.setDay5End(store.getDay5End());
        s.setDay6Start(store.getDay6Start());
        s.setDay6End(store.getDay6End());
        s.setDay7Start(store.getDay7Start());
        s.setDay7End(store.getDay7End());
        realm.commitTransaction();
        /*if (callback != null)
            callback.onSuccess();*/
    };

    @Override
    public void deleteStoreById(String idStore){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
            Store store = realm.where(Store.class)
                    .equalTo("id",idStore)
                    .findFirst();
            store.removeFromRealm();
        realm.commitTransaction();
        /*if (callback != null)
        callback.onSuccess();*/
    };
    @Override
    public void deleteStoreByName(String name){
        /*Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
            RealmResults<Store> results = realm.where(Store.class)
                    .contains("name",name)
                    .findAll();
            for (Store u : results) {
                results.remove(u);
            }
        realm.commitTransaction();
        /*if (callback != null)
        callback.onSuccess();*/
    };
    @Override
    public int countStore(){
        int count = 0;
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Store> results = realm.where(Store.class).findAll();
            count = results.size();
        realm.commitTransaction();
        return count;
        /*if (callback != null)
        callback.onSuccess();*/
    };
    @Override
    public boolean isStore(String s){
        int count = 0;
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Store> results = realm.where(Store.class)
                .contains("name",s)
                .or()
                .contains("id",s)
                .findAll();
        count = results.size();
        realm.commitTransaction();
        if (count != 0){
            return true;
        }else{
            return false;
        }
        /*if (callback != null)
        callback.onSuccess();*/
    };

    @Override
    public RealmResults<Store> getStoreAll(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Store> results = realm.where(Store.class).findAll();
        realm.commitTransaction();
        return results;
        /*if (callback != null)
        callback.onSuccess();*/
    };

    @Override
    public Store getStoreById(String id){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Store store = realm.where(Store.class)
                .equalTo("id",id)
                .findFirst();
        realm.commitTransaction();
        return store;
    };
}
