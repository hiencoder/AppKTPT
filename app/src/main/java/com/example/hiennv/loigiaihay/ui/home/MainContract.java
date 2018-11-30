package com.example.hiennv.loigiaihay.ui.home;

import com.example.hiennv.loigiaihay.network.pojo.category.Event;

import java.util.List;

public interface MainContract {
    interface MainView{
        void loadListSessionSuccess(List<Event> events);

        void loadListSessionError();
    }

    interface MainPresenter{
        void loadListSession(String subjectId);
    }
}
