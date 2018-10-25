package com.example.hiennv.loigiaihay.ui.listclass;

import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

import java.util.List;

public interface ListClassContract {
    interface ListClassView extends BaseView{
        void loadSuccess(List<ClassEntity> list);

        void loadError();
    }

    interface ListClassPresenter{
        void loadListClass();
    }
}
