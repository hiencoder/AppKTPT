package com.example.hiennv.loigiaihay.ui.changesubject;

import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

public interface ChangeSubjectContract {
    interface ChangeSubjectView extends BaseView{
        void loadListSubjectSuccess(SubjectResponse subjectResponse);

        void loadListSubjectError(String message);
    }

    interface ChangeSubjectPresenter{
        void loadListSubject(String tagId);

        void loadSubjectDetail(int itemId);
    }
}
