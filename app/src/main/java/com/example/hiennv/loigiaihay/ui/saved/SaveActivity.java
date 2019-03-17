package com.example.hiennv.loigiaihay.ui.saved;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.adapter.ArticleOfflineAdaper;
import com.example.hiennv.loigiaihay.adapter.RecyclerItemTouchHelper;
import com.example.hiennv.loigiaihay.callback.ItemArticleOfflineListener;
import com.example.hiennv.loigiaihay.callback.RecyclerItemTouchHelperListener;
import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.ui.articleoffline.ArticleOfflineActivity;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.customview.MyAutoCompleteTextView;
import com.example.hiennv.loigiaihay.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.grantland.widget.AutofitTextView;
import timber.log.Timber;

public class SaveActivity extends BaseActivity implements SaveContract.SaveView, RecyclerItemTouchHelperListener,
        ItemArticleOfflineListener {

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.atv_title)
    AutofitTextView atvTitle;
    @BindView(R.id.mact_search)
    MyAutoCompleteTextView mactSearch;
    @BindView(R.id.iv_drop)
    ImageView ivDrop;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_lesson_offline)
    RecyclerView rvLessonOffline;
    @BindView(R.id.cl_main)
    ConstraintLayout clMain;
    @BindView(R.id.btn_delete_all)
    FloatingActionButton btnDeleteAll;

    private SavePresenterImpl savePresenter;
    private List<Save> listSaves;
    private ArticleOfflineAdaper articleOfflineAdaper;

    //Dung luong app
    private float dataApp;
    private float internalData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_saved;
    }

    @Override
    protected void initData() {
        listSaves = new ArrayList<>();
        articleOfflineAdaper = new ArticleOfflineAdaper(this, listSaves);
        rvLessonOffline.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvLessonOffline.setItemAnimator(new DefaultItemAnimator());
        rvLessonOffline.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvLessonOffline.setAdapter(articleOfflineAdaper);

        // adding item touch helper
        // only ItemTouchHelper.LEFT added to detect Right to Left swipe
        // if you want both Right -> Left and Left -> Right
        // add pass ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT as param
        ItemTouchHelper.SimpleCallback itemHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this::onSwiped);
        new ItemTouchHelper(itemHelperCallback).attachToRecyclerView(rvLessonOffline);
        savePresenter = new SavePresenterImpl(this, this);
        savePresenter.loadAllSave();
    }

    @Override
    protected void setUpToolbar() {
        setSupportActionBar(toolbar);
        atvTitle.setText(getResources().getString(R.string.txt_title_save_offline));
        btnBack.setVisibility(View.VISIBLE);
        atvTitle.setVisibility(View.VISIBLE);
        ivDrop.setVisibility(View.INVISIBLE);
        ivSearch.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initEvents() {
        articleOfflineAdaper.setListener(this);
    }

    @Override
    public void loadAllSaveSuccess(List<Save> saves) {
        if (saves.size() > 0) {
            listSaves.clear();
            listSaves.addAll(saves);
            /*ItemTouchHelper.SimpleCallback itemTouchHelperCallback1 = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP) {
                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                    // Row is swiped from recycler view
                    // remove it from adapter
                }

                @Override
                public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                }
            };

            // attaching the touch helper to recycler view
            new ItemTouchHelper(itemTouchHelperCallback1).attachToRecyclerView(rvLessonOffline);*/
            articleOfflineAdaper.notifyDataSetChanged();
        }
    }

    @Override
    public void loadAllSaveError() {
        Timber.e("%s", "Error");
    }

    @Override
    public void deleteSaveSuccess() {
        articleOfflineAdaper.notifyDataSetChanged();
    }

    @Override
    public void deleteSaveError() {

    }

    @Override
    public void deleteAllSaveSuccess() {

    }

    @Override
    public void deleteAllSaveError() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * callback when recycler view is swiped
     * item will be removed on swiped
     * undo option will be provided in snackbar to restore the item
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        Timber.i("%s", "Onswiped: " + direction);
        if (viewHolder instanceof ArticleOfflineAdaper.ArticleOfflineHolder) {
            // get the removed item name to display it in snack bar
            String name = listSaves.get(viewHolder.getAdapterPosition()).getSaveName();

            // backup of removed item for undo purpose
            final Save deletedItem = listSaves.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();
            int id = deletedItem.getSaveId();
            // remove the item from recycler view
            articleOfflineAdaper.removeItem(deletedIndex);
            handleDialogDelete(id, deletedIndex, deletedItem);
            // showing snack bar with Undo option
           /* Snackbar snackbar = Snackbar
                    .make(clMain, name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    articleOfflineAdaper.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();*/
        }
    }


    /**
     * Xử lý dialog xóa
     */
    private void handleDialogDelete(int id, int deleteIndex, Save deleteItem) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(getResources().getString(R.string.txt_message_dialog));
        dialog.setPositiveButton("Xóa", (dialog1, which) -> {
            dialog1.cancel();
            savePresenter.deleteSaveById(id);
        });
        dialog.setNegativeButton("Đóng", ((dialog1, which) -> {
            dialog1.cancel();
            articleOfflineAdaper.restoreItem(deleteItem, deleteIndex);
        }));
        dialog.create().show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @OnClick({R.id.btn_back,R.id.btn_delete_all})
    public void doClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_delete_all:
                handleDeleteAll();
                break;
        }
    }

    //Delete all
    private void handleDeleteAll() {
        //savePresenter.deleteAllSave();
    }

    @Override
    public void itemArticleOfflineClick(int id) {
        Intent intent = new Intent(this, ArticleOfflineActivity.class);
        intent.putExtra(AppConstants.KEY_ARTICLE_OFFLINE_ID, id);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    //K cho lưu quá 50 bài
    /*  public void showCharData() {
        float folderSize = (((float) ActivityBase.getFolderSize(new File(Constants.folderSave))) / 1024.0f) / 1024.0f;
        List arrayList = new ArrayList();
        arrayList.add(new Entry(folderSize, 0));
        arrayList.add(new Entry(MainActivity.useExternalValue, 1));
        arrayList.add(new Entry(MainActivity.freeExternalValue, 2));
        int[] iArr = new int[]{Color.parseColor("#4763b2"), Color.parseColor("#666666"), Color.parseColor("#BDBDBD")};
        List arrayList2 = new ArrayList();
        for (int valueOf : iArr) {
            arrayList2.add(Integer.valueOf(valueOf));
        }
        Object pieDataSet = new PieDataSet(arrayList, "");
        pieDataSet.setDrawValues(false);
        arrayList = new ArrayList();
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        if (MainActivity.freeExternalValue > 1024.0f) {
            this.dungLuongTrong = MainActivity.freeExternalValue / 1024.0f;
            this.dungLuongTrong = ((float) Math.round(this.dungLuongTrong * 100.0f)) / 100.0f;
            this.tvChuaDung = " Gb";
        } else {
            this.dungLuongTrong = MainActivity.freeExternalValue;
            this.tvChuaDung = " Mb";
        }
        if (MainActivity.useExternalValue > 1024.0f) {
            this.dungLuongDaDung = MainActivity.useExternalValue / 1024.0f;
            this.dungLuongDaDung = ((float) Math.round(this.dungLuongDaDung * 100.0f)) / 100.0f;
            this.tvDaDung = " Gb";
        } else {
            this.dungLuongDaDung = MainActivity.useExternalValue;
            this.tvDaDung = " Mb";
        }
        folderSize = ((float) Math.round(folderSize * 100.0f)) / 100.0f;
        this.tvDadung.setText("Khác " + this.dungLuongDaDung + this.tvDaDung);
        this.tvChuadung.setText("Còn trống " + this.dungLuongTrong + this.tvChuaDung);
        this.tvPhantram.setText((((MainActivity.freeExternalValue * 100.0f) / MainActivity.totalExternalValue) + "").substring(0, 3) + "%");
        this.tvLGH.setText("Lời Giải Hay: " + folderSize + " Mb");
        ChartData pieData = new PieData(arrayList, pieDataSet);
        pieData.setValueTextColor(-16776961);
        pieData.setValueFormatter(new PercentFormatter());
        pieDataSet.setColors(arrayList2);
        this.pieChart.setDescription("");
        this.pieChart.setData(pieData);
        this.pieChart.setUsePercentValues(false);
        this.pieChart.animateY(1000);
        this.pieChart.getLegend().setEnabled(false);
    }
*/
}
