package com.example.hiennv.loigiaihay.ui.subitem;

import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

public interface SubItemContract {
    interface SubItemView extends BaseView {
        void loadSubItemSuccess(ResponseEvent responseEvent);

        void loadSubItemError(String message);
    }

    interface SubItemPresenter {
        void loadSubItem(int itemId);
    }
}
