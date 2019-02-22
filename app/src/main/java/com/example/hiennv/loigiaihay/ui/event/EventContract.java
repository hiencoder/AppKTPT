package com.example.hiennv.loigiaihay.ui.event;

import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

public interface EventContract {
    interface EventView extends BaseView {
        void loadEventSuccess(ResponseEvent event);

        void loadEventError(String message);
    }

    interface EventPresenter {
        void loadEvent(int itemId);
    }
}
