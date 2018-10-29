package com.example.hiennv.loigiaihay.ui.changeclass;

import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

import java.util.List;

public interface ChangeClassContract {
    interface ChangeClassView extends BaseView{
        void loadSuccess(List<ClassEntity> list);

        void loadError();
    }

    interface ChangeClassPresenter{
        void loadListClass();
    }
}
