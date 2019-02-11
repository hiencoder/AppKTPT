package com.example.hiennv.loigiaihay.ui.home;

import com.example.hiennv.loigiaihay.network.pojo.category.Event;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

import java.util.List;

public interface MainContract {
    interface MainView extends BaseView {
        void loadListSessionSuccess(List<Event> events);

        void loadListSessionError(String message);
    }

    interface MainPresenter{
        void loadListSession(int subjectId);
    }
}
