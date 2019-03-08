package com.tp.loigiaihay.activitys;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Html;
import android.text.Layout.Alignment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.BadTokenException;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.crashlytics.android.Crashlytics;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lidroid.xutils.exception.DbException;
import com.tp.loigiaihay.R;
import com.tp.loigiaihay.adapter.BannerAdapter;
import com.tp.loigiaihay.adapter.DetailLessonAdapter;
import com.tp.loigiaihay.data.DatabaseHandlerLGH;
import com.tp.loigiaihay.download.downloads.DownloadManager;
import com.tp.loigiaihay.download.downloads.DownloadRequestCallBack;
import com.tp.loigiaihay.download.downloads.DownloadService;
import com.tp.loigiaihay.network.DataServices;
import com.tp.loigiaihay.network.NetworkListener;
import com.tp.loigiaihay.object.Article;
import com.tp.loigiaihay.object.ArticleInfo;
import com.tp.loigiaihay.object.Banner;
import com.tp.loigiaihay.object.History;
import com.tp.loigiaihay.ultils.AppConfig;
import com.tp.loigiaihay.ultils.ApplicationController;
import com.tp.loigiaihay.ultils.Constants;
import com.tp.loigiaihay.ultils.XoaThuMucCoThuMucConLib;
import com.tp.loigiaihay.view.MyFixedListView;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailLessonActivity extends ActivityBase implements OnClickListener {
    public static String fromWeb;
    public static int numRowBanner;
    public static String xbookType;
    private String ADMOB_AD_UNIT_ID_BOTTOM;
    private String ADMOB_AD_UNIT_ID_TOP;
    private String ADMOB_APP_ID;
    private String ADMOB_APP_ID_INTERESTIAL;
    private final int REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 1;
    NativeExpressAdView adView;
    DetailLessonAdapter adapterInfo = null;
    ArrayList<Article> arrListInfo = null;
    Article article;
    ArticleInfo articleInfo;
    ArticleInfo articleInfoNew;
    BannerAdapter bannerAdapter;
    private ArrayList<Banner> bannerArrayList;
    String bottomUnitId;
    private AlphaAnimation buttonClick;
    int[] coords = new int[]{0, 0};
    int countInterestial = 0;
    DatabaseHandlerLGH dbHelper;
    DatabaseHandlerLGH dbSavePost;
    private DownloadManager downloadManager;
    boolean fistOpent;
    FrameLayout frameLayout;
    FrameLayout frameLayoutBottom;
    String fromSearch;
    GridView gvBannerTuyenSinh;
    ViewGroup header;
    int heightScreen;
    History history;
    String id_ar;
    ImageView imArrow;
    ImageView imSave;
    ImageView imgBack;
    LayoutInflater inflater;
    JSONArray jaBanner;
    JSONArray jaList;
    JSONObject jsArticleInfo;
    RelativeLayout layout;
    MyFixedListView listViewIntro;
    LinearLayout llComment;
    LinearLayout llGopY;
    RelativeLayout llNextPost;
    LinearLayout llSave;
    LinearLayout llShare;
    LinearLayout ll_time_info;
    private InterstitialAd mInterstitialAd;
    ProgressBar progressBar;
    RecyclerView rvBanner;
    boolean showcaseview = true;
    String storedUserError;
    String strFirst;
    String strTitleDetail;
    String textForWebview;
    String title_ar;
    TextView tvComment;
    TextView tvIntro;
    TextView tvLienquan;
    TextView tvNoConnect;
    TextView tvSave;
    TextView tvTitle;
    TextView tvTitleBanner;
    TextView tvTitleDetail;
    String url;
    MathJaxWebView wvBody;
    String zipLink;

    class DetailViewClient extends WebViewClient {
        private DetailViewClient() {
        }

        @RequiresApi(api = 21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            DetailLessonActivity.this.startActivity(new Intent("android.intent.action.VIEW", webResourceRequest.getUrl()));
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            DetailLessonActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            final Animation loadAnimation = AnimationUtils.loadAnimation(DetailLessonActivity.this, R.anim.hieuung_webview);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    DetailLessonActivity.this.listViewIntro.setSelection(0);
                    DetailLessonActivity.this.listViewIntro.startAnimation(loadAnimation);
                    DetailLessonActivity.this.listViewIntro.setVisibility(0);
                    DetailLessonActivity.this.progressBar.setVisibility(8);
                }
            }, 600);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            DetailLessonActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            DetailLessonActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (DetailLessonActivity.this.header.getHeight() >= displayMetrics.heightPixels * 2) {
                DetailLessonActivity.this.adsNativeTop(true, true);
                DetailLessonActivity.this.frameLayout.setVisibility(0);
                return;
            }
            DetailLessonActivity.this.adsNativeTop(false, false);
            DetailLessonActivity.this.frameLayout.setVisibility(8);
        }
    }

    @TargetApi(12)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_detail_lesson);
        MobileAds.initialize(this, this.ADMOB_APP_ID);
        this.mInterstitialAd = new InterstitialAd(this);
        this.ADMOB_APP_ID_INTERESTIAL = AppConfig.getSPStringValue(this, Constants.ADMOB_AD_INTERSTITIAL_ID);
        this.mInterstitialAd.setAdUnitId(this.ADMOB_APP_ID_INTERESTIAL);
        this.ADMOB_APP_ID = AppConfig.getSPStringValue(this, Constants.ADMOB_APP_ID);
        this.ADMOB_AD_UNIT_ID_TOP = AppConfig.getSPStringValue(this, Constants.ADMOB_AD_UNIT_ID_DETAIL_TOP);
        this.ADMOB_AD_UNIT_ID_BOTTOM = AppConfig.getSPStringValue(this, Constants.ADMOB_AD_UNIT_ID_DETAIL_BOTTOM);
        System.out.println("át móp át bót tòm: " + this.ADMOB_AD_UNIT_ID_BOTTOM);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar_Detail);
        this.imgBack = (ImageView) findViewById(R.id.img_back);
        this.imgBack.setOnClickListener(this);
        this.imArrow = (ImageView) findViewById(R.id.im_arrow);
        this.imArrow.setOnClickListener(this);
        this.tvTitleDetail = (TextView) findViewById(R.id.tv_name_detail);
        this.tvTitleDetail.setOnClickListener(this);
        this.buttonClick = new AlphaAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.5f);
        this.tvNoConnect = (TextView) findViewById(R.id.tv_noconect_in_detail);
        checkNetWork();
        if (this.netWork) {
            this.fistOpent = true;
            this.bottomUnitId = getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, 0).getString("ad.adsense.detail_bottom.unit_id", "0");
            this.progressBar.setVisibility(0);
            this.tvNoConnect.setVisibility(4);
            this.listViewIntro = (MyFixedListView) findViewById(R.id.lv_intro);
            this.inflater = getLayoutInflater();
            try {
                this.header = (ViewGroup) this.inflater.inflate(R.layout.header_detail_lesson, this.listViewIntro, false);
                this.listViewIntro.addHeaderView(this.header, null, false);
                this.frameLayout = (FrameLayout) this.header.findViewById(R.id.fl_adplaceholder_top);
                this.frameLayoutBottom = (FrameLayout) this.header.findViewById(R.id.fl_adplaceholder);
                this.tvLienquan = (TextView) this.header.findViewById(R.id.tv_lq);
                this.llShare = (LinearLayout) this.header.findViewById(R.id.ll_share);
                this.llShare.setOnClickListener(this);
                this.tvSave = (TextView) this.header.findViewById(R.id.tv_save);
                this.llSave = (LinearLayout) this.header.findViewById(R.id.ll_save);
                this.llSave.setOnClickListener(this);
                this.imSave = (ImageView) this.header.findViewById(R.id.im_icon_save);
                this.tvTitle = (TextView) this.header.findViewById(R.id.tv_title_lesson);
                this.tvComment = (TextView) this.header.findViewById(R.id.tv_comment);
                this.llComment = (LinearLayout) this.header.findViewById(R.id.ll_comment);
                this.llNextPost = (RelativeLayout) this.header.findViewById(R.id.ll_next_post);
                this.llNextPost.setOnClickListener(this);
                this.rvBanner = (RecyclerView) this.header.findViewById(R.id.rv_banner_tuyensinh);
                this.tvTitleBanner = (TextView) this.header.findViewById(R.id.tv_title_banner);
                this.bannerArrayList = new ArrayList();
                this.tvIntro = (TextView) this.header.findViewById(R.id.tv_intro_lesson);
                this.wvBody = (MathJaxWebView) this.header.findViewById(R.id.tv_body_lesson);
                ((RelativeLayout) this.header.findViewById(R.id.rl_intro)).setBackgroundColor(0);
                this.ll_time_info = (LinearLayout) this.header.findViewById(R.id.ll_button_detail);
                this.ll_time_info.setVisibility(8);
                this.llGopY = (LinearLayout) this.header.findViewById(R.id.ll_gopy);
                this.llGopY.setOnClickListener(this);
            } catch (InflateException e) {
            }
            this.arrListInfo = new ArrayList();
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.id_ar = extras.getString("articleId");
                this.title_ar = extras.getString(SettingsJsonConstants.PROMPT_TITLE_KEY);
                fromWeb = extras.getString("pre_disable_select");
                xbookType = extras.getString("xbookTypeFromWeb");
                if (this.id_ar != null) {
                    AppConfig.setSPStringValue(this, Constants.strIdAr, this.id_ar);
                }
                this.fromSearch = extras.getString("fromSearch");
            }
            this.adapterInfo = new DetailLessonAdapter(this, R.layout.item_row_detail_lesson, this.arrListInfo);
            this.listViewIntro.setAdapter(this.adapterInfo);
            this.adapterInfo.notifyDataSetChanged();
            if (this.bannerAdapter != null) {
                this.bannerAdapter.notifyDataSetChanged();
            }
            loadData();
            extras = getIntent().getExtras();
            if (extras != null) {
                CharSequence string = extras.getString("title_lesson");
                if (string != null) {
                    this.tvTitleDetail.setText(string);
                } else {
                    this.tvTitleDetail.setText(this.strTitleDetail);
                }
            }
            if (this.tvTitleDetail.getText().toString().equals("Xem lại bài cũ") || this.tvTitleDetail.getText().toString().equals("Xem bài đã lưu")) {
                this.imArrow.setVisibility(8);
            } else {
                this.imArrow.setVisibility(0);
            }
            this.textForWebview = "<html><body style=\"text-align:justify\"> %s </body></Html>";
            if (VERSION.SDK_INT < 16) {
                this.wvBody.setBackgroundColor(0);
            } else {
                try {
                    this.wvBody.setBackgroundColor(Color.argb(1, 0, 0, 0));
                } catch (RuntimeException e2) {
                    Log.d("ngoaile", "khong set dc bg cho wv");
                }
            }
            if (this.llComment != null) {
                this.llComment.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        view.startAnimation(DetailLessonActivity.this.buttonClick);
                        Intent intent = new Intent(DetailLessonActivity.this, LoadComment.class);
                        intent.putExtra("comment_url", DetailLessonActivity.this.articleInfo.getCommentUrl());
                        DetailLessonActivity.this.startActivity(intent);
                        ApplicationController.getInstance().trackEvent("User-interact", "Click", "Click-comment");
                    }
                });
            }
            this.listViewIntro.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    DetailLessonActivity.this.frameLayout.removeAllViews();
                    DetailLessonActivity.this.fistOpent = true;
                    int i2 = i - 1;
                    if (i2 >= 0) {
                        DetailLessonActivity.this.article = (Article) DetailLessonActivity.this.arrListInfo.get(i2);
                        DetailLessonActivity.this.id_ar = DetailLessonActivity.this.article.getArticleId();
                        if (!"1".equals(DetailLessonActivity.this.article.getSrtLink())) {
                            if (DetailLessonActivity.this.id_ar != null) {
                                AppConfig.setSPStringValue(DetailLessonActivity.this, Constants.strIdAr, DetailLessonActivity.this.id_ar);
                            }
                            DetailLessonActivity.this.tvSave.setText("Tải offline");
                            DetailLessonActivity.this.llSave.setBackgroundResource(R.drawable.boder_layout_chiase);
                            DetailLessonActivity.this.progressBar.setVisibility(0);
                            DetailLessonActivity.this.listViewIntro.setVisibility(4);
                            DetailLessonActivity detailLessonActivity = DetailLessonActivity.this;
                            detailLessonActivity.countInterestial++;
                            if (DetailLessonActivity.this.countInterestial == 3) {
                                DetailLessonActivity.this.mInterstitialAd.loadAd(new Builder().build());
                                DetailLessonActivity.this.showInterstitial();
                                DetailLessonActivity.this.countInterestial = 0;
                            }
                            DetailLessonActivity.this.bannerAdapter.notifyDataSetChanged();
                            DetailLessonActivity.this.loadData();
                            DetailLessonActivity.this.adsNativeBottom(true, true);
                        } else if (DetailLessonActivity.this.article.getRedirect_link() != null) {
                            DetailLessonActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(DetailLessonActivity.this.article.getRedirect_link())));
                        }
                    }
                }
            });
            adsNativeBottom(true, true);
        } else {
            this.tvNoConnect.setVisibility(0);
        }
        if (this.listViewIntro != null) {
            this.listViewIntro.setOnScrollListener(new OnScrollListener() {
                public void onScrollStateChanged(AbsListView absListView, final int i) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (i == 0 && DetailLessonActivity.this.coords != null) {
                                DetailLessonActivity.this.imSave.getLocationOnScreen(DetailLessonActivity.this.coords);
                                int i = DetailLessonActivity.this.coords[1];
                                DisplayMetrics displayMetrics = new DisplayMetrics();
                                DetailLessonActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                                DetailLessonActivity.this.heightScreen = displayMetrics.heightPixels;
                                DetailLessonActivity.this.strFirst = AppConfig.getSPStringValueClassAndObject(DetailLessonActivity.this, Constants.strFirst, "");
                                if ("".equals(DetailLessonActivity.this.strFirst) && i < DetailLessonActivity.this.heightScreen && DetailLessonActivity.this.showcaseview && DetailLessonActivity.this.heightScreen - i < DetailLessonActivity.this.heightScreen) {
                                    DetailLessonActivity.this.huongDanLuuBai();
                                    AppConfig.setSPStringValue(DetailLessonActivity.this, Constants.strFirst, "true");
                                    DetailLessonActivity.this.showcaseview = false;
                                }
                            }
                        }
                    }, 100);
                }

                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                }
            });
        }
    }

    public void loadData() {
        DataServices.getDetailLesson(this, new NetworkListener() {
            public void onNetworkError() {
                DetailLessonActivity.this.checkErrorData();
            }

            public boolean onNetworkSuccess(JSONObject jSONObject) {
                if (DetailLessonActivity.this.ll_time_info != null) {
                    DetailLessonActivity.this.ll_time_info.setVisibility(0);
                }
                try {
                    int i;
                    DetailLessonActivity.this.jsArticleInfo = jSONObject.getJSONObject("articleInfo");
                    DetailLessonActivity.this.strTitleDetail = DetailLessonActivity.this.jsArticleInfo.getString("catTitle");
                    DetailLessonActivity.this.tvTitleDetail.setText(DetailLessonActivity.this.strTitleDetail);
                    DetailLessonActivity.this.articleInfo = new ArticleInfo(DetailLessonActivity.this.jsArticleInfo);
                    DetailLessonActivity.this.tvTitle.setText(DetailLessonActivity.this.articleInfo.getTitle());
                    DetailLessonActivity.this.checkSavePost();
                    DetailLessonActivity.this.history = new History(DetailLessonActivity.this.jsArticleInfo);
                    DetailLessonActivity.this.dbHelper = DatabaseHandlerLGH.getInstance(DetailLessonActivity.this);
                    if (DetailLessonActivity.this.dbHelper.existArticleInHistory(DetailLessonActivity.this.history.getArticleId())) {
                        DetailLessonActivity.this.dbHelper.deleteHistoryByName(DetailLessonActivity.this.history);
                        DetailLessonActivity.this.dbHelper.insertHistory(DetailLessonActivity.this.history);
                    } else {
                        DetailLessonActivity.this.dbHelper.insertHistory(DetailLessonActivity.this.history);
                    }
                    DetailLessonActivity.this.tvIntro.setText(Html.fromHtml(DetailLessonActivity.this.articleInfo.getIntroText()));
                    if (VERSION.SDK_INT >= 19 && (DetailLessonActivity.this.getApplicationInfo().flags & 2) != 0) {
                        WebView.setWebContentsDebuggingEnabled(true);
                    }
                    if (DetailLessonActivity.this.wvBody != null) {
                        DetailLessonActivity.this.wvBody.getSettings().setDefaultFontSize(18);
                        DetailLessonActivity.this.wvBody.getSettings().setJavaScriptEnabled(true);
                        DetailLessonActivity.this.wvBody.clearCache(true);
                        DetailLessonActivity.this.wvBody.setText(DetailLessonActivity.this.articleInfo.getBody());
                    }
                    DetailLessonActivity.this.wvBody.setWebViewClient(new DetailViewClient());
                    DetailLessonActivity.this.jaList = jSONObject.getJSONArray("othersInCat");
                    if (DetailLessonActivity.this.arrListInfo != null) {
                        DetailLessonActivity.this.arrListInfo.clear();
                    }
                    for (i = 0; i < DetailLessonActivity.this.jaList.length(); i++) {
                        JSONObject jSONObject2 = DetailLessonActivity.this.jaList.getJSONObject(i);
                        DetailLessonActivity.this.article = new Article(jSONObject2);
                        DetailLessonActivity.this.arrListInfo.add(DetailLessonActivity.this.article);
                    }
                    if (DetailLessonActivity.this.jaList.length() < 1) {
                        DetailLessonActivity.this.llNextPost.setVisibility(8);
                        DetailLessonActivity.this.tvLienquan.setVisibility(8);
                    } else {
                        DetailLessonActivity.this.llNextPost.setVisibility(0);
                        DetailLessonActivity.this.tvLienquan.setVisibility(0);
                    }
                    if (DetailLessonActivity.this.bannerArrayList.size() > 0) {
                        DetailLessonActivity.this.bannerArrayList.clear();
                    }
                    DetailLessonActivity.this.jaBanner = jSONObject.getJSONArray("banner");
                    for (int i2 = 0; i2 < DetailLessonActivity.this.jaBanner.length(); i2++) {
                        if (DetailLessonActivity.this.jaBanner.getJSONObject(i2).getString(Param.TYPE).equals("simple_html")) {
                            Banner banner = new Banner();
                            banner.setTitleBanner(DetailLessonActivity.this.jaBanner.getJSONObject(i2).getString(FirebaseAnalytics.Param.CONTENT));
                            banner.setType(0);
                            DetailLessonActivity.this.bannerArrayList.add(banner);
                        } else {
                            JSONArray jSONArray = DetailLessonActivity.this.jaBanner.getJSONObject(i2).getJSONArray("list_row");
                            int length = jSONArray.getJSONArray(0).length();
                            for (i = 0; i < jSONArray.length(); i++) {
                                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                                Banner banner2;
                                switch (jSONArray2.length()) {
                                    case 1:
                                        banner2 = new Banner();
                                        banner2.setImgBanner(jSONArray2.getJSONObject(0).getString("img_src"));
                                        banner2.setLinkBanner(jSONArray2.getJSONObject(0).getString("link"));
                                        banner2.setType(length);
                                        banner2.setCoutClumnBanner(length);
                                        DetailLessonActivity.this.bannerArrayList.add(banner2);
                                        break;
                                    case 2:
                                        banner2 = new Banner();
                                        banner2.setImgBanner(jSONArray2.getJSONObject(0).getString("img_src"));
                                        banner2.setImgBanner2(jSONArray2.getJSONObject(1).getString("img_src"));
                                        banner2.setLinkBanner(jSONArray2.getJSONObject(0).getString("link"));
                                        banner2.setLinkBanner2(jSONArray2.getJSONObject(1).getString("link"));
                                        banner2.setType(length);
                                        banner2.setCoutClumnBanner(length);
                                        DetailLessonActivity.this.bannerArrayList.add(banner2);
                                        break;
                                    case 3:
                                        banner2 = new Banner();
                                        banner2.setImgBanner(jSONArray2.getJSONObject(0).getString("img_src"));
                                        banner2.setImgBanner2(jSONArray2.getJSONObject(1).getString("img_src"));
                                        banner2.setImgBanner3(jSONArray2.getJSONObject(2).getString("img_src"));
                                        banner2.setLinkBanner(jSONArray2.getJSONObject(0).getString("link"));
                                        banner2.setLinkBanner2(jSONArray2.getJSONObject(1).getString("link"));
                                        banner2.setLinkBanner3(jSONArray2.getJSONObject(2).getString("link"));
                                        banner2.setType(length);
                                        banner2.setCoutClumnBanner(length);
                                        DetailLessonActivity.this.bannerArrayList.add(banner2);
                                        break;
                                    case 4:
                                        banner2 = new Banner();
                                        banner2.setImgBanner(jSONArray2.getJSONObject(0).getString("img_src"));
                                        banner2.setImgBanner2(jSONArray2.getJSONObject(1).getString("img_src"));
                                        banner2.setImgBanner3(jSONArray2.getJSONObject(2).getString("img_src"));
                                        banner2.setImgBanner4(jSONArray2.getJSONObject(3).getString("img_src"));
                                        banner2.setLinkBanner(jSONArray2.getJSONObject(0).getString("link"));
                                        banner2.setLinkBanner2(jSONArray2.getJSONObject(1).getString("link"));
                                        banner2.setLinkBanner3(jSONArray2.getJSONObject(2).getString("link"));
                                        banner2.setLinkBanner4(jSONArray2.getJSONObject(3).getString("link"));
                                        banner2.setType(length);
                                        banner2.setCoutClumnBanner(length);
                                        DetailLessonActivity.this.bannerArrayList.add(banner2);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                    DetailLessonActivity.this.bannerAdapter = new BannerAdapter(DetailLessonActivity.this, DetailLessonActivity.this.bannerArrayList);
                    LayoutManager linearLayoutManager = new LinearLayoutManager(DetailLessonActivity.this);
                    linearLayoutManager.setOrientation(1);
                    DetailLessonActivity.this.rvBanner.setLayoutManager(linearLayoutManager);
                    DetailLessonActivity.this.rvBanner.setAdapter(DetailLessonActivity.this.bannerAdapter);
                    DetailLessonActivity.this.rvBanner.setNestedScrollingEnabled(false);
                    DetailLessonActivity.this.articleInfoNew = new ArticleInfo(DetailLessonActivity.this.jsArticleInfo);
                    int parseInt = Integer.parseInt(DetailLessonActivity.this.articleInfoNew.getCmtCout());
                    String cmtCout = DetailLessonActivity.this.articleInfoNew.getCmtCout();
                    String str = " bình luận";
                    if (parseInt == 0) {
                        cmtCout = "";
                        str = "Bình luận";
                    }
                    if (parseInt > 9) {
                        str = " B.Luận";
                    }
                    if (parseInt > 1000 && parseInt < 2000) {
                        cmtCout = "1k";
                    }
                    if (parseInt > 2000) {
                        cmtCout = "2k";
                    }
                    DetailLessonActivity.this.tvComment.setText(cmtCout + str);
                    ApplicationController.getInstance().trackScreenView("DETAIL: Lớp " + DetailLessonActivity.this.strTitleDetail + " - " + DetailLessonActivity.this.tvTitle.getText().toString());
                    if (jSONObject.has(AppConfig.CFG_KEY_CONFIG_INFO)) {
                        DetailLessonActivity.this.updateAppConfig(jSONObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (NullPointerException e2) {
                    Log.d("null phan button", "vao null");
                }
                return false;
            }

            public boolean onNetworkSuccess(JSONArray jSONArray) {
                return false;
            }

            public void onNetworkReload() {
            }
        });
    }

    @TargetApi(16)
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ll_gopy:
                view.startAnimation(this.buttonClick);
                startActivity(new Intent(this, AcBaoLoi.class));
                return;
            case R.id.img_back:
                finish();
                return;
            case R.id.tv_name_detail:
                if (!this.tvTitleDetail.getText().toString().equals("Xem lại bài cũ") && !this.tvTitleDetail.getText().toString().equals("Xem bài đã lưu") && this.imArrow.getVisibility() == 0 && !"true".equals(fromWeb)) {
                    intent = new Intent(this, AcSlideChangeObject.class);
                    intent.putExtra("from_detail", "true");
                    startActivityForResult(intent, 2);
                    overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                    return;
                }
                return;
            case R.id.im_arrow:
                if (!this.tvTitleDetail.getText().toString().equals("Xem lại bài cũ") && !this.tvTitleDetail.getText().toString().equals("Xem bài đã lưu") && !"true".equals(fromWeb)) {
                    intent = new Intent(this, AcSlideChangeObject.class);
                    intent.putExtra("from_detail", "true");
                    startActivityForResult(intent, 2);
                    overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                    return;
                }
                return;
            case R.id.ll_next_post:
                this.countInterestial++;
                this.frameLayout.removeAllViews();
                if (this.countInterestial == 3) {
                    this.mInterstitialAd.loadAd(new Builder().build());
                    showInterstitial();
                    this.countInterestial = 0;
                }
                this.fistOpent = false;
                this.progressBar.setVisibility(0);
                if (this.jaList != null && this.jaList.length() > 0) {
                    this.article = (Article) this.arrListInfo.get(0);
                    this.id_ar = this.article.getArticleId();
                    if (this.id_ar != null) {
                        AppConfig.setSPStringValue(this, Constants.strIdAr, this.id_ar);
                    }
                    this.listViewIntro.setVisibility(4);
                    this.bannerAdapter.notifyDataSetChanged();
                    loadData();
                    adsNativeBottom(true, true);
                    return;
                }
                return;
            case R.id.ll_save:
                view.startAnimation(this.buttonClick);
                checkNetWork();
                if (this.netWork) {
                    showPhoneStatePermission();
                    ApplicationController.getInstance().trackEvent("User-interact", "Click", "Click-lưu bài");
                    this.countInterestial++;
                    if (this.countInterestial == 3) {
                        this.countInterestial = 0;
                        return;
                    }
                    return;
                }
                Toast.makeText(this, "Để lưu bài viết cần có kết nối internet!", 0).show();
                return;
            case R.id.ll_share:
                view.startAnimation(this.buttonClick);
                checkNetWork();
                if (this.netWork && this.articleInfo.getAlias() != null && this.articleInfo.getCatId() != null && this.articleInfo.getArticleId() != null) {
                    String sPStringValue = AppConfig.getSPStringValue(this, Constants.strXbookType);
                    String str = "";
                    boolean z = true;
                    switch (sPStringValue.hashCode()) {
                        case 113669:
                            if (sPStringValue.equals("sbt")) {
                                z = false;
                                break;
                            }
                            break;
                        case 113815:
                            if (sPStringValue.equals("sgk")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            str = "https://sachbaitap.com/" + this.articleInfo.getAlias() + "-c" + this.articleInfo.getCatId() + "a" + this.articleInfo.getArticleId() + ".html?utm_source=Loigiaihay&utm_medium=AppShare&utm_campaign=Loigiahay_Android";
                            break;
                        case true:
                            str = "https://loigiaihay.com/" + this.articleInfo.getAlias() + "-c" + this.articleInfo.getCatId() + "a" + this.articleInfo.getArticleId() + ".html?utm_source=Loigiaihay&utm_medium=AppShare&utm_campaign=Loigiahay_Android";
                            break;
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.TEXT", str);
                    for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(intent2, 0)) {
                        if (resolveInfo.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
                            intent2.setPackage(resolveInfo.activityInfo.packageName);
                        }
                    }
                    try {
                        startActivity(intent2);
                        return;
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(this, "Không tìm thấy ứng dụng có thể thực hiện điều này!", 0).show();
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public void checkErrorData() {
        if (this.title_ar != null) {
            this.dbHelper = DatabaseHandlerLGH.getInstance(getBaseContext());
            this.storedUserError = this.dbHelper.Exist(this.title_ar);
            if (this.title_ar.equals(this.storedUserError)) {
                this.dbHelper.deleteErrorByName(this.storedUserError);
            }
        }
    }

    public void checkSavePost() {
        this.dbSavePost = DatabaseHandlerLGH.getInstance(this);
        String ExistSave = this.dbSavePost.ExistSave(this.tvTitle.getText().toString());
        if (!this.tvTitle.getText().toString().equals(ExistSave) || ExistSave == "") {
            this.tvSave.setText("Tải offline");
            this.llSave.setBackgroundResource(R.drawable.boder_layout_chiase);
            return;
        }
        this.llSave.setBackgroundResource(R.drawable.boder_layout_bogoc_daluu);
        this.tvSave.setText("Đã tải");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        if ("true".equals(AppConfig.getSPStringValue(this, Constants.strFinish))) {
            AppConfig.setSPStringValue(this, Constants.strFinish, "false");
            finish();
        }
    }

    public void onDestroy() {
        if (this.wvBody != null) {
            this.wvBody.getSettings().setJavaScriptEnabled(false);
            this.wvBody.loadUrl("about:blank");
        }
        super.onDestroy();
    }

    private void huongDanLuuBai() {
        ShowcaseView build = new ShowcaseView.Builder(this).setTarget(new ViewTarget(R.id.im_icon_save, this)).setContentTitle("\tẤn vào đây để lưu bài giảng offline và xem không cần mạng !").setStyle(R.style.ShowcaseView).build();
        build.setTitleTextAlignment(Alignment.ALIGN_NORMAL);
        build.forceTextPosition(2);
    }

    private void taibaigiang() {
        if (DatabaseHandlerLGH.baiDaLuu > 50) {
            Toast.makeText(this, "Bạn đã tải quá nhiều bài viết\nVui lòng xóa các bài viết cũ trước khi tải thêm!", 1).show();
            return;
        }
        AppConfig.setSPStringValue(this, Constants.strIdAr, this.articleInfo.getArticleId());
        DataServices.getLinkBaiOffline(this, new NetworkListener() {
            public void onNetworkError() {
                Toast.makeText(DetailLessonActivity.this, "Không tìm thấy bài viết!", 0).show();
            }

            public boolean onNetworkSuccess(JSONObject jSONObject) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("zip_status");
                    DetailLessonActivity.this.url = jSONObject2.getString("zip_link");
                    String str = Constants.folderSave + jSONObject2.getString(TtmlNode.ATTR_ID) + ".zip";
                    String string = jSONObject2.getString("last_zip_time");
                    if (DetailLessonActivity.this.url != null) {
                        try {
                            DetailLessonActivity.this.downloadManager = DownloadService.getDownloadManager(DetailLessonActivity.this.getApplicationContext());
                            DetailLessonActivity.this.downloadManager.addNewDownload(DetailLessonActivity.this.url, DetailLessonActivity.this.articleInfo.getTitle(), DetailLessonActivity.this.articleInfo.getIntroText(), AppConfig.getSPStringValue(DetailLessonActivity.this, Constants.strNumberClass), str, DetailLessonActivity.this.articleInfo.getArticleId(), "2", string, "", "", "thoigianmua", AppConfig.getSPStringValue(DetailLessonActivity.this, Constants.strXbookType), true, true, new DownloadRequestCallBack());
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                    }
                    DetailLessonActivity.this.dbSavePost.insertSave(DetailLessonActivity.this.articleInfo);
                    Toast makeText = Toast.makeText(DetailLessonActivity.this, "Đã lưu thành công bài viết!\n Vào mục bài viết đã lưu để xem.", 1);
                    makeText.setGravity(17, 0, PsExtractor.VIDEO_STREAM_MASK);
                    makeText.show();
                    DetailLessonActivity.this.tvSave.setText("Đã tải");
                    DetailLessonActivity.this.llSave.setBackgroundResource(R.drawable.boder_layout_bogoc_daluu);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return false;
            }

            public boolean onNetworkSuccess(JSONArray jSONArray) {
                return false;
            }

            public void onNetworkReload() {
            }
        });
    }

    public void showPhoneStatePermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            if ("".equals(AppConfig.getSPStringValueClassAndObject(this, Constants.strFirstPermission, ""))) {
                File file;
                if ("sbt".equals(AppConfig.getSPStringValue(this, Constants.strXbookType))) {
                    file = new File(Constants.folderSave + "sbt/");
                } else {
                    file = new File(Constants.folderSave);
                }
                XoaThuMucCoThuMucConLib.rmdir(file);
                AppConfig.setSPStringValue(this, Constants.strFirstPermission, "true");
            }
            this.dbSavePost = DatabaseHandlerLGH.getInstance(this);
            String ExistSave = this.dbSavePost.ExistSave(this.tvTitle.getText().toString());
            try {
                if (!this.tvTitle.getText().toString().equals(ExistSave) || ExistSave == "") {
                    this.dbSavePost.getCountRecordSave();
                    taibaigiang();
                    ApplicationController.getInstance().trackEvent("User-interact", "Click", "Click-lưu bài");
                }
                Toast makeText = Toast.makeText(this, "Đã lưu bài viết này rồi!", 0);
                makeText.setGravity(17, 0, PsExtractor.VIDEO_STREAM_MASK);
                makeText.show();
                ApplicationController.getInstance().trackEvent("User-interact", "Click", "Click-lưu bài");
            } catch (NullPointerException e) {
            }
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            showExplanation("Để tải môn học cần cho phép điều này!", "Bạn cần cấp quyền lưu tài liệu vào bộ nhớ", "android.permission.WRITE_EXTERNAL_STORAGE", 1);
        } else {
            requestPermission("android.permission.WRITE_EXTERNAL_STORAGE", 1);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 1:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    for (String str : strArr) {
                        boolean shouldShowRequestPermissionRationale;
                        if (VERSION.SDK_INT >= 23) {
                            shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale(str);
                        } else {
                            shouldShowRequestPermissionRationale = false;
                        }
                        if (!shouldShowRequestPermissionRationale) {
                            startActivityForResult(new Intent(this, AcHDCapQuyen.class), 3);
                        }
                    }
                    return;
                } else if ("".equals(AppConfig.getSPStringValueClassAndObject(this, Constants.strFirstPermission, ""))) {
                    File file;
                    if ("sbt".equals(AppConfig.getSPStringValue(this, Constants.strXbookType))) {
                        file = new File(Constants.folderSave + "sbt/");
                    } else {
                        file = new File(Constants.folderSave);
                    }
                    XoaThuMucCoThuMucConLib.rmdir(file);
                    AppConfig.setSPStringValue(this, Constants.strFirstPermission, "true");
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private void showExplanation(String str, String str2, final String str3, final int i) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(str).setMessage(str2).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DetailLessonActivity.this.requestPermission(str3, i);
                }
            });
            builder.create().show();
        } catch (BadTokenException e) {
        }
    }

    private void requestPermission(String str, int i) {
        ActivityCompat.requestPermissions(this, new String[]{str}, i);
    }

    private void populateAppInstallAdView(NativeAppInstallAd nativeAppInstallAd, NativeAppInstallAdView nativeAppInstallAdView) {
        VideoController videoController = nativeAppInstallAd.getVideoController();
        videoController.setVideoLifecycleCallbacks(new VideoLifecycleCallbacks() {
            public void onVideoEnd() {
                super.onVideoEnd();
            }
        });
        try {
            nativeAppInstallAdView.setHeadlineView(nativeAppInstallAdView.findViewById(R.id.appinstall_headline));
            nativeAppInstallAdView.setBodyView(nativeAppInstallAdView.findViewById(R.id.appinstall_body));
            nativeAppInstallAdView.setCallToActionView(nativeAppInstallAdView.findViewById(R.id.appinstall_call_to_action));
            ((TextView) nativeAppInstallAdView.getHeadlineView()).setText(nativeAppInstallAd.getHeadline());
            ((TextView) nativeAppInstallAdView.getBodyView()).setText(nativeAppInstallAd.getBody());
            ((TextView) nativeAppInstallAdView.getCallToActionView()).setText(nativeAppInstallAd.getCallToAction());
            MediaView mediaView = (MediaView) nativeAppInstallAdView.findViewById(R.id.appinstall_media);
            ImageView imageView = (ImageView) nativeAppInstallAdView.findViewById(R.id.appinstall_image);
            if (videoController.hasVideoContent()) {
                nativeAppInstallAdView.setMediaView(mediaView);
                imageView.setVisibility(8);
            } else {
                nativeAppInstallAdView.setImageView(imageView);
                mediaView.setVisibility(8);
                List images = nativeAppInstallAd.getImages();
                if (images.size() > 0) {
                    imageView.setImageDrawable(((Image) images.get(0)).getDrawable());
                }
            }
        } catch (NullPointerException e) {
            Log.d("no content", "QC không trả về nội dung");
        }
        nativeAppInstallAdView.setNativeAd(nativeAppInstallAd);
    }

    private void populateContentAdView(NativeContentAd nativeContentAd, NativeContentAdView nativeContentAdView) {
        try {
            nativeContentAdView.setHeadlineView(nativeContentAdView.findViewById(R.id.contentad_headline));
            nativeContentAdView.setImageView(nativeContentAdView.findViewById(R.id.contentad_image));
            nativeContentAdView.setBodyView(nativeContentAdView.findViewById(R.id.contentad_body));
            nativeContentAdView.setCallToActionView(nativeContentAdView.findViewById(R.id.contentad_call_to_action));
            ((TextView) nativeContentAdView.getHeadlineView()).setText(nativeContentAd.getHeadline());
            ((TextView) nativeContentAdView.getBodyView()).setText(nativeContentAd.getBody());
            ((TextView) nativeContentAdView.getCallToActionView()).setText(nativeContentAd.getCallToAction());
            List images = nativeContentAd.getImages();
            if (images.size() > 0) {
                ((ImageView) nativeContentAdView.getImageView()).setImageDrawable(((Image) images.get(0)).getDrawable());
            }
        } catch (NullPointerException e) {
        }
        nativeContentAdView.setNativeAd(nativeContentAd);
    }

    private void adsNativeBottom(boolean z, boolean z2) {
        AdLoader.Builder builder = new AdLoader.Builder(this, this.ADMOB_AD_UNIT_ID_BOTTOM);
        if (z) {
            builder.forAppInstallAd(new OnAppInstallAdLoadedListener() {
                public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
                    NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) DetailLessonActivity.this.getLayoutInflater().inflate(R.layout.ad_app_install, null);
                    DetailLessonActivity.this.populateAppInstallAdView(nativeAppInstallAd, nativeAppInstallAdView);
                    DetailLessonActivity.this.frameLayoutBottom.removeAllViews();
                    DetailLessonActivity.this.frameLayoutBottom.addView(nativeAppInstallAdView);
                }
            });
        }
        if (z2) {
            builder.forContentAd(new OnContentAdLoadedListener() {
                public void onContentAdLoaded(NativeContentAd nativeContentAd) {
                    NativeContentAdView nativeContentAdView = (NativeContentAdView) DetailLessonActivity.this.getLayoutInflater().inflate(R.layout.ad_content, null);
                    DetailLessonActivity.this.populateContentAdView(nativeContentAd, nativeContentAdView);
                    DetailLessonActivity.this.frameLayoutBottom.removeAllViews();
                    DetailLessonActivity.this.frameLayoutBottom.addView(nativeContentAdView);
                }
            });
        }
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(int i) {
            }
        }).build().loadAd(new Builder().build());
    }

    private void adsNativeTop(boolean z, boolean z2) {
        AdLoader.Builder builder = new AdLoader.Builder(this, this.ADMOB_AD_UNIT_ID_TOP);
        if (z) {
            builder.forAppInstallAd(new OnAppInstallAdLoadedListener() {
                public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
                    NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) DetailLessonActivity.this.getLayoutInflater().inflate(R.layout.ad_app_install_top, null);
                    DetailLessonActivity.this.populateAppInstallAdView(nativeAppInstallAd, nativeAppInstallAdView);
                    DetailLessonActivity.this.frameLayout.removeAllViews();
                    DetailLessonActivity.this.frameLayout.addView(nativeAppInstallAdView);
                    DetailLessonActivity.this.frameLayout.startAnimation(AnimationUtils.loadAnimation(DetailLessonActivity.this, R.anim.fade_in_slow));
                }
            });
        }
        if (z2) {
            builder.forContentAd(new OnContentAdLoadedListener() {
                public void onContentAdLoaded(NativeContentAd nativeContentAd) {
                    NativeContentAdView nativeContentAdView = (NativeContentAdView) DetailLessonActivity.this.getLayoutInflater().inflate(R.layout.ad_content_top, null);
                    DetailLessonActivity.this.populateContentAdView(nativeContentAd, nativeContentAdView);
                    DetailLessonActivity.this.frameLayout.removeAllViews();
                    DetailLessonActivity.this.frameLayout.addView(nativeContentAdView);
                    DetailLessonActivity.this.frameLayout.startAnimation(AnimationUtils.loadAnimation(DetailLessonActivity.this, R.anim.fade_in_slow));
                }
            });
        }
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(int i) {
            }
        }).build().loadAd(new Builder().build());
    }

    private void showInterstitial() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (DetailLessonActivity.this.mInterstitialAd != null && DetailLessonActivity.this.mInterstitialAd.isLoaded()) {
                    DetailLessonActivity.this.mInterstitialAd.show();
                }
            }
        }, 1000);
    }
}