package com.example.hiennv.loigiaihay.ui.listclass.listsubject;

import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

public interface ListSubjectContract {
    interface ListSubjectView extends BaseView{
        void loadListSubjectSuccess(SubjectResponse subjectResponse);

        void loadListSubjectError();
    }

    interface ListSubjectPresenter{
        void loadListSubject(String tagId);
    }
}
