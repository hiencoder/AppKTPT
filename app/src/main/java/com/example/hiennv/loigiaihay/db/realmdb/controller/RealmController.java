package com.example.hiennv.loigiaihay.db.realmdb.controller;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.hiennv.loigiaihay.db.model.History;
import com.example.hiennv.loigiaihay.db.model.OrderId;
import com.example.hiennv.loigiaihay.db.realmdb.realmobject.HistoryRealm;
import com.example.hiennv.loigiaihay.db.realmdb.realmobject.NotifyRealm;
import com.example.hiennv.loigiaihay.db.realmdb.realmobject.OrderIdRealm;
import com.example.hiennv.loigiaihay.utils.LogUtils;

import org.w3c.dom.DocumentFragment;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmController {
    private static final String TAG = RealmController.class.getSimpleName();
    private static RealmController instance;
    private final Realm realm;

    /**
     * @param application
     */
    public RealmController(Application application) {
        this.realm = Realm.getDefaultInstance();
    }

    /**
     * Create in fragment
     *
     * @param fragment
     * @return
     */
    public static RealmController with(Fragment fragment) {
        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    /**
     * create in activity
     *
     * @param activity
     * @return
     */
    public static RealmController with(Activity activity) {
        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    /**
     * @param application
     * @return
     */
    public static RealmController with(Application application) {
        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    //Refresh the real instance
    public void refresh() {
        realm.refresh();
    }

    //Table HistoryRealm
    //Clear all objects from HistoryRealm.class
    public void clearAllHistory() {
        realm.beginTransaction();
        realm.delete(HistoryRealm.class);
        realm.commitTransaction();
    }

    //Find all object in the HistoryRealm
    public RealmResults<HistoryRealm> getAllHistory() {
        return realm.where(HistoryRealm.class).findAll();
    }

    //Query a single item with the given id
    public HistoryRealm getHistoryById(String id) {
        return realm.where(HistoryRealm.class).equalTo("historyId", id).findFirst();
    }

    //Check if HistoryRealm.class is empty
    public boolean hasHistory() {
        return !realm.where(HistoryRealm.class).findAll().isEmpty();
    }

    //Query History
    public RealmResults<HistoryRealm> queryHistory(String query) {
        return realm.where(HistoryRealm.class)
                .contains("historyName", query)
                .or()
                .contains("historyIntro", query)
                .findAll();
    }

    //Insert new History
    public void insertHistory(HistoryRealm historyRealm) {
        realm.insert(historyRealm);
    }

    //Update history
    public void updateHistory(String id, HistoryRealm newHistory) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                HistoryRealm history = realm.where(HistoryRealm.class).equalTo("historyId", id).findFirst();
                history.setHistoryName(newHistory.getHistoryName());
                history.setHistoryIntro(newHistory.getHistoryIntro());
                history.setHistoryArticleId(newHistory.getHistoryArticleId());
                history.setHistoryAvatar(newHistory.getHistoryAvatar());
                history.setHistoryUrl(newHistory.getHistoryUrl());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "onSuccess: ");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.d(TAG, "onError: " + error.getMessage());
            }
        });
    }

    //Delete History
    public void deleteHistory(String id) {
        RealmResults<HistoryRealm> results = realm.where(HistoryRealm.class).findAll();
        HistoryRealm history = results.where().equalTo("historyId", id).findFirst();
        if (history != null) {
            realm.beginTransaction();
        }
        history.deleteFromRealm();
        realm.commitTransaction();
    }


    //TABLE NOTIFY
    public void clearNotify() {
        realm.beginTransaction();
        realm.delete(NotifyRealm.class);
        realm.commitTransaction();
    }

    public RealmResults<NotifyRealm> getAllNotify() {
        return realm.where(NotifyRealm.class).findAll();
    }

    public NotifyRealm getNotifyById(String id) {
        return realm.where(NotifyRealm.class).equalTo("notifyId", id).findFirst();
    }

    public boolean hasNotify() {
        return realm.where(NotifyRealm.class).findAll().isEmpty();
    }

    public RealmResults<NotifyRealm> queryNotify(String query) {
        return realm.where(NotifyRealm.class)
                .contains("notifyTitle", query)
                .or()
                .contains("notifyContent", query)
                .findAll();
    }

    public void insertNotify(NotifyRealm notifyRealm) {
        realm.insert(notifyRealm);
    }

    public void updateNotify(String notifyId, NotifyRealm notifyRealm) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                NotifyRealm notify = realm.where(NotifyRealm.class).equalTo("notifyId", notifyId).findFirst();
                //Update
                notify.setNotifyTitle(notifyRealm.getNotifyTitle());
                notify.setNotifyContent(notifyRealm.getNotifyContent());
                notify.setNotifyDate(notifyRealm.getNotifyDate());
                notify.setNotifyStatus(notifyRealm.getNotifyStatus());
                notify.setNotifyUrl(notifyRealm.getNotifyUrl());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                LogUtils.i(TAG, "Success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                LogUtils.e(TAG, error.getMessage());
            }
        });
    }

    public void deleteNotify(String notifyId) {
        RealmResults<NotifyRealm> results = realm.where(NotifyRealm.class).findAll();
        NotifyRealm notifyRealm = results.where().equalTo("notifyId", notifyId).findFirst();
        if (notifyRealm != null) {
            realm.beginTransaction();
        }
        notifyRealm.deleteFromRealm();
        realm.commitTransaction();
    }

    //TABLE ORDERID
    public void clearOrderId() {
        realm.beginTransaction();
        realm.delete(OrderIdRealm.class);
        realm.commitTransaction();
    }

    public RealmResults<OrderIdRealm> getAllOrderId() {
        return realm.where(OrderIdRealm.class).findAll();
    }

    public OrderIdRealm getOrderIdById(String orderId) {
        return realm.where(OrderIdRealm.class).equalTo("orderId", orderId).findFirst();
    }

    public boolean hasOrderId() {
        return realm.where(OrderIdRealm.class).findAll().isEmpty();
    }

    public void insertOrderId(OrderIdRealm orderIdRealm) {
        realm.insert(orderIdRealm);
    }

    public void updateOrderId(String orderId, OrderIdRealm orderIdRealm) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                LogUtils.e(TAG, error.getMessage());
            }
        });
    }
}
