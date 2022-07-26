package butter.pizza.burger;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeBannerAdView;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.Mrec;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxBanner;
import com.tappx.sdk.android.TappxBannerListener;
import com.tappx.sdk.android.TappxInterstitial;
import com.tappx.sdk.android.TappxInterstitialListener;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.UnityBanners;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;


public class Pizza {

    public static Context Contextt;
    public static AdView mAdView, mAdView_exit;
    public static InterstitialAd Splash_InterstialAd, InterstialAd, InterstialAd1;

    public static InterstitialAd InterstialAd_Setup;
    public static int Inter_Setup, App_Open_Setup;

    public static RewardedAd mRewardedAd;
    public static RewardedInterstitialAd mrewardedInterstitialAd;

    public static RewardedInterstitialAd rewardedInterstitialAd;

    public static String Tx_ID;
    public static String Interstial, Interstial1, Interstial2;
    public static String Banner, Banner1, Banner2;


    public static String Native_ID_Exit, Native_ID1, Native_ID2;

    public static String Native_ID;

    public static String APP_ID, APP_OPEN, REWARD, INTER_REWARD, EXTRA1, EXTRA2;

    public static TappxBanner Tappxbanner;
    public static TappxInterstitial Splash_tappxInterstitial_preload, tappxInterstitial,
            tappxInterstitial_preload;

    public static StartAppAd startAppAd;
    public static StartAppAd.AdMode SO;
    public static StartAppAd.AdMode SO_FULLPAGE = StartAppAd.AdMode.FULLPAGE;
    public static StartAppAd.AdMode SO_OFFERWALL = StartAppAd.AdMode.OFFERWALL;


    public static AppOpenAd.AppOpenAdLoadCallback loadCallback;
    public static AppOpenAd.AppOpenAdLoadCallback loadCallback1;
    public static AppOpenAd.AppOpenAdLoadCallback loadCallback2;
    public static AppOpenAd.AppOpenAdLoadCallback loadCallback3;
    public static boolean isShowingAd = false;

    public static AppOpenAd appOpenAd = null;

    public static int Counterrrr = 0;

    public static String FB = "FB", AL = "AL", GL = "GL", TXX = "TX", SA = "SA";

    public static int G_Native_Type;

    public static int Server_Yes_No = 1000;

    public static int Which_Banner, Which_Banner_Max;
    public static int Which_Native_Exit;

    public static int Which_Native, Which_Native_Max;

    public static String Server = "";

    public static String TX = "", BR1 = "", BR2 = "", IN1 = "", IN2 = "";

    public static String NA1 = "", NA2 = "", AID = "", AO = "", RD = "", IRD = "", EX1 = "", EX2 = "";

    public static String B11 = "", B111 = "", B22 = "", B222 = "", B33 = "", B333 = "", I11 = "", I111 = "", I22 = "", I222 = "", I33 = "", I333 = "", N11 = "", N111 = "", N22 = "", N222 = "", N33 = "", N333 = "", AO11 = "", AO111 = "", AO22 = "", AO222 = "", AO33 = "", AO333 = "", RD11 = "", RD111 = "", RD22 = "", RD222 = "", RD33 = "", RD333 = "", IRD11 = "", IRD111 = "", IRD22 = "", IRD222 = "", IRD33 = "", IRD333 = "";

    public static String Setup = "";

    public static String B11_ID = "", B111_ID = "", B22_ID = "", B222_ID = "", B33_ID = "", B333_ID = "", I11_ID = "", I111_ID = "", I22_ID = "", I222_ID = "", I33_ID = "", I333_ID = "", N11_ID = "", N111_ID = "", N22_ID = "", N222_ID = "", N33_ID = "", N333_ID = "", AO11_ID = "", AO111_ID = "", AO22_ID = "", AO222_ID = "", AO33_ID = "", AO333_ID = "", RD11_ID = "", RD111_ID = "", RD22_ID = "", RD222_ID = "", RD33_ID = "", RD333_ID = "", IRD11_ID = "", IRD111_ID = "", IRD22_ID = "", IRD222_ID = "", IRD33_ID = "", IRD333_ID = "";

    public static String Setup_ID = "";

    public static int Inter_Failed, AL_FB_Inter_Failed;

    public static AdView Pre_Load_mAdView;
    public static int Banner_Load_Not = 5;
    public static TappxBanner Pre_Tappxbanner_Exit;

    public static TappxBanner Pre_Tappxbanner;

    public static TemplateView Pre_Load_Native_templateView_Exit;
    public static TemplateView Pre_Load_Native_templateView;
    public static int Native_Load_Not_Exit = 5;

    public static int Native_Load_Not = 5;

    public static ConnectivityManager connec;

    public static String Packages;
    public static String Name;

    public static ProgressDialog Ad_ProgressDialog;

    public static ArrayList<HashMap<String, String>> contactList;
    public static int Exit_Menu_Decided = 0, Setup_Main = 0, For_Approval = 3;
    public static Boolean doubleBackToExitPressedOnce = false;

    public static String AL_SDK_Key = "";
    public static String AL_Banner = "";
    public static String AL_MREC_Banner = "";
    public static String AL_Inter = "";
    public static String AL_Native_Small = "";
    public static String AL_Native_Medium = "";
    public static String AL_Native_Manual = "";
    public static String AL_Reward_Video = "";


    public static com.facebook.ads.InterstitialAd FBinterstitialAd, FBinterstitialAd_Splash, FBinterstitialAd_Reward;
    public static com.facebook.ads.AdView FB_adView, FB_adView_Pre, FB_adView_Decided;

    public static com.facebook.ads.NativeAd nativeAd_FB, nativeAd_FB_Pre;
    public static com.facebook.ads.NativeBannerAd nativeAd_Banner_FB, nativeAd_Banner_FB_Pre;

    public static String FB_SDK_Key = "";
    public static int FB_Setup = 1;
    public static String FB_Banner1 = "", FB_Banner2 = "", FB_Banner3 = "", FB_Banner4 = "", FB_Banner5 = "";
    public static String FB_MREC_Banner1 = "", FB_MREC_Banner2 = "", FB_MREC_Banner3 = "", FB_MREC_Banner4 = "", FB_MREC_Banner5 = "";
    public static String FB_Inter1 = "", FB_Inter2 = "", FB_Inter3 = "", FB_Inter4 = "", FB_Inter5 = "";
    public static String FB_Native_Small1 = "", FB_Native_Small2 = "", FB_Native_Small3 = "", FB_Native_Small4 = "", FB_Native_Small5 = "";
    public static String FB_Native_Medium1 = "", FB_Native_Medium2 = "", FB_Native_Medium3 = "", FB_Native_Medium4 = "", FB_Native_Medium5 = "";
    public static String FB_Reward_Video1 = "", FB_Reward_Video2 = "", FB_Reward_Video3 = "", FB_Reward_Video4 = "", FB_Reward_Video5 = "";

    public static int FB_splash_inter_id_count = 1;
    public static int FB_inter_id_count = 1;
    public static int FB_banner_id_count = 1;
    public static int FB_native_id_count = 1;
    public static int FB_native_exit_id_count = 1;
    public static int FB_banner_decided_id_count = 1;
    public static int FB_banner_loaded_id_count = 1;
    public static int FB_native_loaded_id_count = 1;

    public static GifImageView gifImageView;

    AppSetIdClient client;
    Task<AppSetIdInfo> task;


    public static interface OnRewardgetListner {
        public void OnReward(boolean b);
    }


    @SuppressWarnings("static-access")
    public Pizza(Context context, String Package, String name,
                 final String Tx_id, final String Interstial_ID,
                 final String Interstial_ID1, final String Banner_ID,
                 final String Banner_ID1, final String NativeID1, final String NativeID2,
                 final String App_id, final String App_Open, final String Reward,
                 final String Inter_Reward, final String Extra1, final String SO,
                 String server, final String Setup_Id, final String B11_Id, final String B111_Id,
                 final String B22_Id, final String B222_Id, final String B33_Id, final String B333_Id,
                 final String I11_Id, final String I111_Id, final String I22_Id, final String I222_Id,
                 final String I33_Id, final String I333_Id, final String N11_Id,
                 final String N111_Id, final String N22_Id, final String N222_Id,
                 final String N33_Id, final String N333_Id, final String AO11_Id,
                 final String AO111_Id, final String AO22_Id, final String AO222_Id,
                 final String AO33_Id, final String AO333_Id, final String RD11_Id,
                 final String RD111_Id, final String RD22_Id, final String RD222_Id,
                 final String RD33_Id, final String RD333_Id, final String IRD11_Id,
                 final String IRD111_Id, final String IRD22_Id, final String IRD222_Id,
                 final String IRD33_Id, final String IRD333_Id) {

        Contextt = context;
        Packages = Package;
        Name = name;

        Server = server;

        MobileAds.initialize(Contextt, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus
                                                         initializationStatus) {
            }
        });

        StartAppSDK.init(context, "" + SO, false);

        client = AppSet.getClient(Contextt);
        task = client.getAppSetIdInfo();
        task.addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
            @Override
            public void onSuccess(AppSetIdInfo info) {
                int scope = info.getScope();
                String id = info.getId();
            }
        });


        startAppAd = new StartAppAd(context.getApplicationContext());
        StartAppAd.disableSplash();

        connec = (ConnectivityManager) Contextt
                .getSystemService(Contextt.CONNECTIVITY_SERVICE);
        contactList = new ArrayList<HashMap<String, String>>();

        if (isNetworkConnected(Contextt) == true) {

            new GetData().execute();

        } else if (isNetworkConnected(Contextt) == false) {

            Exit_Menu_Decided = 0;
        }

        Tx_ID = Tx_id;

        Interstial1 = Interstial_ID;
        Interstial2 = Interstial_ID1;

        Banner1 = Banner_ID;
        Banner2 = Banner_ID1;

        Native_ID1 = NativeID1;
        Native_ID2 = NativeID2;

        APP_ID = App_id;
        APP_OPEN = App_Open;
        REWARD = Reward;
        INTER_REWARD = Inter_Reward;
        EXTRA1 = Extra1;
        EXTRA2 = SO;

        Setup_ID = Setup_Id;
        B11_ID = B11_Id;
        B111_ID = B111_Id;
        B22_ID = B22_Id;
        B222_ID = B222_Id;
        B33_ID = B33_Id;
        B333_ID = B333_Id;
        I11_ID = I11_Id;
        I111_ID = I111_Id;
        I22_ID = I22_Id;
        I222_ID = I222_Id;
        I33_ID = I33_Id;
        I333_ID = I333_Id;
        N11_ID = N11_Id;
        N111_ID = N111_Id;
        N22_ID = N22_Id;
        N222_ID = N222_Id;
        N33_ID = N33_Id;
        N333_ID = N333_Id;
        AO11_ID = AO11_Id;
        AO111_ID = AO111_Id;
        AO22_ID = AO22_Id;
        AO222_ID = AO222_Id;
        AO33_ID = AO33_Id;
        AO333_ID = AO333_Id;
        RD11_ID = RD11_Id;
        RD111_ID = RD111_Id;
        RD22_ID = RD22_Id;
        RD222_ID = RD222_Id;
        RD33_ID = RD33_Id;
        RD333_ID = RD333_Id;
        IRD11_ID = IRD11_Id;
        IRD111_ID = IRD111_Id;
        IRD22_ID = IRD22_Id;
        IRD222_ID = IRD222_Id;
        IRD33_ID = IRD33_Id;
        IRD333_ID = IRD333_Id;


    }

    public static void Pre_Banner_Load_Decided(final int Which_Banner_Load) {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                    if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                        Max_Banner_Preload_Decided(Which_Banner_Load);
                        return;
                    }
                    if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                        FB_Banner_Preload_Decided(Which_Banner_Load);
                        return;
                    }

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Pre_Banner_Load_Setup1(Which_Banner_Load);

                    } else if ((Butter.getSetup(Contextt)).equals("0")) {

                        Pre_Banner_Load_Normal(Which_Banner_Load);

                    }


                } else {

                    handler.postDelayed(this, 1000);

                }

            }

        }, 1000);


    }

    public static void Pre_Banner_Load_Normal(final int Which_Banner_Load) {

        if (Butter.getbanner(Contextt) == 0) {

            Banner = Butter.getbanner1(Contextt);

            Butter.setbanner(Contextt, 1);

        } else {

            Banner = Butter.getbanner2(Contextt);

            Butter.setbanner(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Load_Not = 0;


                Banner_Load_Not = 200;

            }

        });

    }

    public static void Pre_Banner_Load_Setup1(final int Which_Banner_Load) {

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Pre_Banner_Load_Setup11(Which_Banner_Load);

                if ((Butter.getSetup(Contextt)).equals("1")) {
                    Pre_Banner_Load_Setup22(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("2")) {
                    Pre_Banner_Load_Setup11111(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("3")) {
                    Pre_Banner_Load_Setup1111(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("4")) {
                    Pre_Banner_Load_Setup111(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("5")) {
                    Pre_Banner_Load_Setup11(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("6")) {
                    Pre_Banner_Load_Setup2(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("7")) {
                    Pre_Banner_Load_Setup11111(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("8")) {
                    Pre_Banner_Load_Setup1111(Which_Banner);
                }

            }

        });

    }

    public static void Pre_Banner_Load_Setup11(final int Which_Banner_Load) {

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 11;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Pre_Banner_Load_Setup111(Which_Banner_Load);

            }

        });

    }

    public static void Pre_Banner_Load_Setup111(final int Which_Banner_Load) {

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 111;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Pre_Banner_Load_Setup1111(Which_Banner_Load);

            }

        });

    }

    public static void Pre_Banner_Load_Setup1111(final int Which_Banner_Load) {

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1111;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Pre_Banner_Load_Setup11111(Which_Banner_Load);

            }

        });

    }

    public static void Pre_Banner_Load_Setup11111(final int Which_Banner_Load) {

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 11111;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Pre_Banner_Load_Setup2(Which_Banner_Load);

            }

        });

    }

    public static void Pre_Banner_Load_Setup2(final int Which_Banner_Load) {

        if (Butter.getBB2(Contextt) == 0) {

            Banner = Butter.getB22(Contextt);

            Butter.setBB2(Contextt, 1);

        } else {

            Banner = Butter.getB222(Contextt);

            Butter.setBB2(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 2;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Pre_Banner_Load_Setup22(Which_Banner_Load);

            }

        });

    }

    public static void Pre_Banner_Load_Setup22(final int Which_Banner_Load) {

        if (Butter.getBB2(Contextt) == 0) {

            Banner = Butter.getB22(Contextt);

            Butter.setBB2(Contextt, 1);

        } else {

            Banner = Butter.getB222(Contextt);

            Butter.setBB2(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 22;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Pre_Banner_Load_Setup3(Which_Banner_Load);

            }

        });

    }

    public static void Pre_Banner_Load_Setup3(final int Which_Banner_Load) {

        if (Butter.getBB3(Contextt) == 0) {

            Banner = Butter.getB33(Contextt);

            Butter.setBB3(Contextt, 1);

        } else {

            Banner = Butter.getB333(Contextt);

            Butter.setBB3(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 3;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Load_Not = 200;


            }

        });

    }

    public static void Pre_Banner_Load_Tappx_Decided(int Which_Banner_Load) {

        Pre_Tappxbanner = new TappxBanner(Contextt, Butter.gettx(Contextt));

        if (Which_Banner_Load == 4) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 3) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 2) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 1) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.SMART_BANNER);

        } else {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.SMART_BANNER);

        }

        Pre_Tappxbanner.loadAd();
        Pre_Tappxbanner.setRefreshTimeSeconds(45);

        Pre_Tappxbanner.setListener(new TappxBannerListener() {
            @Override
            public void onBannerLoaded(TappxBanner tappxBanner) {

                Butter.setsplashcount(Contextt,
                        (Butter.getsplashcount(Contextt) + 1));

            }

            @Override
            public void onBannerLoadFailed(TappxBanner tappxBanner,
                                           TappxAdError tappxAdError) {

            }

            @Override
            public void onBannerClicked(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerExpanded(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerCollapsed(TappxBanner tappxBanner) {

            }
        });

    }

    public static void Pre_Banner_Show_Normal(final RelativeLayout Ad_Layout,
                                              final int Banner_Type) {

        if (Banner_Load_Not == 1) {
            try {
                Ad_Layout.addView(Pre_Load_mAdView);
            } catch (Exception e) {

            }
        }

        if (Banner_Load_Not == 0) {
            try {
                Ad_Layout.addView(Pre_Tappxbanner);

            } catch (Exception e) {

            }
        }

        if (Banner_Load_Not == 200) {

            try {


                if (Butter.getextra2(Contextt).equals(FB)) {
                    FB_Banner(Ad_Layout, Banner_Type);
                } else if (Butter.getextra2(Contextt).equals(AL)) {
                    Max_Banner(Ad_Layout, Banner_Type);
                } else {
                    Max_Banner(Ad_Layout, Banner_Type);
                }

            } catch (Exception e) {

            }

        }

    }

    public static void Pre_Banner_Show_Setup(final RelativeLayout Ad_Layout,
                                             final int Banner_Type) {

        if (Banner_Load_Not == 1 ||
                Banner_Load_Not == 11 ||
                Banner_Load_Not == 111 ||
                Banner_Load_Not == 1111 ||
                Banner_Load_Not == 11111 ||
                Banner_Load_Not == 2 ||
                Banner_Load_Not == 22) {

            try {
                if (Pre_Load_mAdView != null) {
                    Ad_Layout.addView(Pre_Load_mAdView);
                }

            } catch (Exception e) {

            }

        }

        if (Banner_Load_Not == 0) {

            try {
                if (Pre_Tappxbanner != null) {
                    Ad_Layout.addView(Pre_Tappxbanner);
                }

            } catch (Exception e) {

            }

        }

        if (Banner_Load_Not == 200) {

            try {


                if (Butter.getextra2(Contextt).equals(FB)) {
                    FB_Banner(Ad_Layout, Banner_Type);
                } else if (Butter.getextra2(Contextt).equals(AL)) {
                    Max_Banner(Ad_Layout, Banner_Type);
                } else {
                    Max_Banner(Ad_Layout, Banner_Type);
                }

            } catch (Exception e) {

            }

        }

    }

    public static void Pre_Banner_Show_Decided(final RelativeLayout Ad_Layout,
                                               final int Banner_Type) {

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Banner_Preload_Show_Decided(Ad_Layout, Banner_Type);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Banner_Preload_Show_Decided(Ad_Layout, Banner_Type);
            return;
        }

        if ((Butter.getSetup(Contextt)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {

            Pre_Banner_Show_Setup(Ad_Layout, Banner_Type);

        } else if ((Butter.getSetup(Contextt)).equals("0")) {

            Pre_Banner_Show_Normal(Ad_Layout, Banner_Type);

        }

    }

    public static void Banner_Pre_Load(final int Which_Banner_Load) {

        Which_Banner_Max = Which_Banner_Load;

        if (Exit_Menu_Decided == 100) {
            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                            Max_Banner_Preload(Which_Banner_Max);
                            return;
                        }
                        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                            FB_Banner_Preload(Which_Banner_Max);
                            return;
                        }

                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Banner_Pre_Load_Setup1(Which_Banner_Load);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Banner_Pre_Load_Normal(Which_Banner_Load);

                        }


                    } else {
                        handler.postDelayed(this, 1000);
                    }

                }

            }, 1000);

        }


    }

    public static void Banner_Show(final RelativeLayout Ad_Layout) {

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Banner_Preload_Show(Ad_Layout);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Banner_Preload_Show(Ad_Layout);
            return;
        }

        if (Exit_Menu_Decided == 100) {
            return;
        }

        if ((Butter.getSetup(Contextt)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {

            Banner_Show_Setup(Ad_Layout);

        } else if ((Butter.getSetup(Contextt)).equals("0")) {

            Banner_Show_Normal(Ad_Layout);

        }

    }

    public static void Banner_Pre_Load_Normal(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getbanner(Contextt) == 0) {

            Banner = Butter.getbanner1(Contextt);

            Butter.setbanner(Contextt, 1);

        } else {

            Banner = Butter.getbanner2(Contextt);

            Butter.setbanner(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Load_Not = 200;


            }

        });

    }

    public static void Pre_Banner_Load_Tappx_Normal(int Which_Banner_Load) {

        Pre_Tappxbanner = new TappxBanner(Contextt, Butter.gettx(Contextt));

        if (Which_Banner_Load == 4) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 3) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 2) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.BANNER_300x250);

        } else if (Which_Banner_Load == 1) {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.SMART_BANNER);

        } else {

            Pre_Tappxbanner
                    .setAdSize(TappxBanner.AdSize.SMART_BANNER);

        }

        Pre_Tappxbanner.loadAd();
        Pre_Tappxbanner.setRefreshTimeSeconds(45);

        Pre_Tappxbanner.setListener(new TappxBannerListener() {
            @Override
            public void onBannerLoaded(TappxBanner tappxBanner) {

                Butter.setsplashcount(Contextt,
                        (Butter.getsplashcount(Contextt) + 1));

                Banner_Load_Not = 0;

            }

            @Override
            public void onBannerLoadFailed(TappxBanner tappxBanner,
                                           TappxAdError tappxAdError) {


            }

            @Override
            public void onBannerClicked(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerExpanded(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerCollapsed(TappxBanner tappxBanner) {

            }
        });

    }

    public static void Banner_Show_Normal(final RelativeLayout Ad_Layout) {


        if (Banner_Load_Not == 1) {

            try {

                if (Pre_Load_mAdView != null) {
                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }

        if (Banner_Load_Not == 0) {

            try {

                if (Pre_Tappxbanner != null) {
                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Tappxbanner);

                }


            } catch (Exception e) {

            }

        }

        if (Banner_Load_Not == 200) {

            try {


                if (Butter.getextra2(Contextt).equals(FB)) {
                    FB_Banner(Ad_Layout, Which_Banner);
                } else if (Butter.getextra2(Contextt).equals(AL)) {
                    Max_Banner(Ad_Layout, Which_Banner);
                } else {
                    Max_Banner(Ad_Layout, Which_Banner);
                }

            } catch (Exception e) {

            }

        }

        Banner_Pre_Load_Normal(Which_Banner);


    }

    public static void Banner_Pre_Load_Setup1(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);


                if ((Butter.getSetup(Contextt)).equals("1")) {
                    Banner_Pre_Load_Setup22(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("2")) {
                    Banner_Pre_Load_Setup11111(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("3")) {
                    Banner_Pre_Load_Setup1111(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("4")) {
                    Banner_Pre_Load_Setup111(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("5")) {
                    Banner_Pre_Load_Setup11(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("6")) {
                    Banner_Pre_Load_Setup2(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("7")) {
                    Banner_Pre_Load_Setup11111(Which_Banner);
                }

                if ((Butter.getSetup(Contextt)).equals("8")) {
                    Banner_Pre_Load_Setup1111(Which_Banner);
                }


            }

        });

    }

    public static void Banner_Pre_Load_Setup11(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 11;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Pre_Load_Setup111(Which_Banner);


            }

        });

    }

    public static void Banner_Pre_Load_Setup111(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 111;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Pre_Load_Setup1111(Which_Banner);


            }

        });

    }

    public static void Banner_Pre_Load_Setup1111(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 1111;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Pre_Load_Setup11111(Which_Banner);


            }

        });

    }

    public static void Banner_Pre_Load_Setup11111(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 11111;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Pre_Load_Setup2(Which_Banner);


            }

        });

    }

    public static void Banner_Pre_Load_Setup2(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getBB2(Contextt) == 0) {

            Banner = Butter.getB22(Contextt);

            Butter.setBB2(Contextt, 1);

        } else {

            Banner = Butter.getB222(Contextt);

            Butter.setBB2(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 2;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Pre_Load_Setup22(Which_Banner);


            }

        });

    }

    public static void Banner_Pre_Load_Setup22(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getBB2(Contextt) == 0) {

            Banner = Butter.getB22(Contextt);

            Butter.setBB2(Contextt, 1);

        } else {

            Banner = Butter.getB222(Contextt);

            Butter.setBB2(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 22;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Pre_Load_Setup3(Which_Banner);


            }

        });

    }

    public static void Banner_Pre_Load_Setup3(final int Which_Banner_Load) {

        Which_Banner = Which_Banner_Load;

        if (Butter.getBB3(Contextt) == 0) {

            Banner = Butter.getB33(Contextt);

            Butter.setBB3(Contextt, 1);

        } else {

            Banner = Butter.getB333(Contextt);

            Butter.setBB3(Contextt, 0);

        }

        Pre_Load_mAdView = new AdView(Contextt);

        if (Which_Banner_Load == 4) {

            Pre_Load_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);

        } else if (Which_Banner_Load == 3) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 2) {

            Pre_Load_mAdView.setAdSize(AdSize.LARGE_BANNER);

        } else if (Which_Banner_Load == 1) {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        } else {

            Pre_Load_mAdView.setAdSize(AdSize.BANNER);

        }

        Pre_Load_mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        Pre_Load_mAdView.loadAd(adore);
        Pre_Load_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {

                super.onAdLoaded();

                Butter.setsplashcount(Contextt, 0);

                Banner_Load_Not = 3;

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Banner_Load_Not = 200;


            }

        });

    }

    public static void Banner_Show_Setup(final RelativeLayout Ad_Layout) {


        if (Banner_Load_Not == 1) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }
        if (Banner_Load_Not == 11) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }
        if (Banner_Load_Not == 111) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }
        if (Banner_Load_Not == 1111) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }
        if (Banner_Load_Not == 11111) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }


        if (Banner_Load_Not == 2) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }

        if (Banner_Load_Not == 22) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }

        if (Banner_Load_Not == 3) {

            try {

                if (Pre_Load_mAdView != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Load_mAdView);

                }


            } catch (Exception e) {

            }

        }

        if (Banner_Load_Not == 0) {

            try {

                if (Pre_Tappxbanner != null) {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.addView(Pre_Tappxbanner);

                }


            } catch (Exception e) {

            }

        }

        if (Banner_Load_Not == 200) {

            try {


                if (Butter.getextra2(Contextt).equals(FB)) {
                    FB_Banner(Ad_Layout, Which_Banner);
                } else if (Butter.getextra2(Contextt).equals(AL)) {
                    Max_Banner(Ad_Layout, Which_Banner);
                } else {
                    Max_Banner(Ad_Layout, Which_Banner);
                }

            } catch (Exception e) {

            }
        }

        Banner_Pre_Load_Setup1(Which_Banner);


    }

    public static void Native_Pre_Load(final int Which_Native_Load) {

        Which_Native_Max = Which_Native_Load;

        if (Exit_Menu_Decided == 100) {
            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                            Max_Native_Pre_Load(Which_Native_Max);
                            return;
                        }
                        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                            FB_Native_Pre_Load(Which_Native_Max);
                            return;
                        }

                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Native_Pre_Load_Setup1(Which_Native_Load);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Native_Pre_Load_Normal(Which_Native_Load);

                        }


                    } else {
                        handler.postDelayed(this, 500);
                    }

                }

            }, 500);

        }
    }

    public static void Native_Pre_Load_Normal(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getnative(Contextt) == 0) {

            Native_ID = Butter.getnative1(Contextt);

            Butter.setnative(Contextt, 1);


        } else {

            Native_ID = Butter.getnative2(Contextt);

            Butter.setnative(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 1;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Load_Not = 200;


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup1(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 1;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {


                        if ((Butter.getSetup(Contextt)).equals("1")) {
                            Native_Pre_Load_Setup22(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("2")) {
                            Native_Pre_Load_Setup11111(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("3")) {
                            Native_Pre_Load_Setup1111(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("4")) {
                            Native_Pre_Load_Setup111(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("5")) {
                            Native_Pre_Load_Setup11(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("6")) {
                            Native_Pre_Load_Setup2(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("7")) {
                            Native_Pre_Load_Setup11111(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("8")) {
                            Native_Pre_Load_Setup1111(Which_Native_Load);
                        }


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup11(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 11;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup111(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup111(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 111;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup1111(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup1111(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 1111;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup11111(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup11111(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 11111;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup2(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup2(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getNN2(Contextt) == 0) {

            Native_ID = Butter.getN22(Contextt);

            Butter.setNN2(Contextt, 1);


        } else {

            Native_ID = Butter.getN222(Contextt);

            Butter.setNN2(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 2;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup22(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup22(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getNN2(Contextt) == 0) {

            Native_ID = Butter.getN22(Contextt);

            Butter.setNN2(Contextt, 1);


        } else {

            Native_ID = Butter.getN222(Contextt);

            Butter.setNN2(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 2;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup3(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup3(final int Which_Native_Load) {

        Which_Native = Which_Native_Load;

        if (Butter.getNN3(Contextt) == 0) {

            Native_ID = Butter.getN33(Contextt);

            Butter.setNN3(Contextt, 1);


        } else {

            Native_ID = Butter.getN333(Contextt);

            Butter.setNN3(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView.setStyles(styles);
                        Pre_Load_Native_templateView.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView.setVisibility(View.VISIBLE);

                        Native_Load_Not = 3;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Load_Not = 200;


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Pre_Banner_Load_Tappx_Normal_For_Native(int Which_Native_Load) {

        Pre_Tappxbanner = new TappxBanner(Contextt, Butter.gettx(Contextt));


        Pre_Tappxbanner
                .setAdSize(TappxBanner.AdSize.BANNER_300x250);


        Pre_Tappxbanner.loadAd();
        Pre_Tappxbanner.setRefreshTimeSeconds(30);

        Pre_Tappxbanner.setListener(new TappxBannerListener() {
            @Override
            public void onBannerLoaded(TappxBanner tappxBanner) {

                Butter.setsplashcount(Contextt,
                        (Butter.getsplashcount(Contextt) + 1));

                Native_Load_Not = 0;

            }

            @Override
            public void onBannerLoadFailed(TappxBanner tappxBanner,
                                           TappxAdError tappxAdError) {


            }

            @Override
            public void onBannerClicked(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerExpanded(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerCollapsed(TappxBanner tappxBanner) {

            }
        });

    }

    public static void Native_Show_Normal(final RelativeLayout Ad_Layout) {

        if (Native_Load_Not == 1) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Normal(Which_Native);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not == 0) {

            if (Pre_Tappxbanner != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Tappxbanner);
                    Native_Pre_Load_Normal(Which_Native);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not == 200) {

            if (Butter.getextra2(Contextt).equals(FB)) {
                FB_Native(Contextt, Ad_Layout, Which_Native, 0, 0, 0);
            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Native(Contextt, Ad_Layout, Which_Native, 0, 0, 0);
            } else {
                Max_Native(Contextt, Ad_Layout, Which_Native, 0, 0, 0);
            }


            Native_Pre_Load_Normal(Which_Native);

        }

    }

    public static void Native_Show_Setup(final RelativeLayout Ad_Layout) {

        if (Native_Load_Not == 1) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }
        if (Native_Load_Not == 11) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }
        if (Native_Load_Not == 111) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }
        if (Native_Load_Not == 1111) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }
        if (Native_Load_Not == 11111) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not == 2) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not == 22) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not == 3) {

            if (Pre_Load_Native_templateView != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Load_Native_templateView);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not == 0) {

            if (Pre_Tappxbanner != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    Ad_Layout.addView(Pre_Tappxbanner);
                    Native_Pre_Load_Setup1(Which_Native);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not == 200) {

            if (Butter.getextra2(Contextt).equals(FB)) {
                FB_Native(Contextt, Ad_Layout, Which_Native, 0, 0, 0);
            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Native(Contextt, Ad_Layout, Which_Native, 0, 0, 0);
            } else {
                Max_Native(Contextt, Ad_Layout, Which_Native, 0, 0, 0);
            }


            Native_Pre_Load_Setup1(Which_Native);

        }


    }

    public static void Native_Show(final RelativeLayout Ad_Layout) {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                    if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                        Max_Native_Pre_Load_Show(Ad_Layout);
                        return;
                    }
                    if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                        FB_Native_Pre_Load_Show(Ad_Layout);
                        return;
                    }

                    if (Exit_Menu_Decided == 100) {
                        return;
                    }

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Native_Show_Setup(Ad_Layout);

                    } else if ((Butter.getSetup(Contextt)).equals("0")) {

                        Native_Show_Normal(Ad_Layout);

                    }


                } else {
                    handler.postDelayed(this, 1000);
                }

            }

        }, 1000);


    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void Splash_Icon(String App_Name, int Text_Color, int icLauncher,
                                   final Context ads_context, final int animation_type) {

        if (isNetworkConnected(Contextt) == true) {


            int width = 480, Height = 800;

            final Dialog builder = new Dialog(ads_context);
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
            builder.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.BLACK));
            builder.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(builder.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;

            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {

                }
            });

            DisplayMetrics displayMetrics = new DisplayMetrics();
            builder.getWindow().getWindowManager().getDefaultDisplay()
                    .getMetrics(displayMetrics);

            width = displayMetrics.widthPixels;
            Height = displayMetrics.heightPixels;

            float[] hsv = new float[3];
            int color = Text_Color;
            Color.colorToHSV(color, hsv);
            hsv[2] *= 0.175f;
            color = Color.HSVToColor(hsv);


            final RelativeLayout RL = new RelativeLayout(ads_context);


            int colorFrom = ads_context.getResources().getColor(R.color.black);
            int colorTo = color;
            @SuppressLint("RestrictedApi") ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(2000);
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    RL.setBackgroundColor((int) animator.getAnimatedValue());
                }

            });
            colorAnimation.start();

            RL.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
            builder.addContentView(RL, new RelativeLayout.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT));


            if (animation_type != 100) {

                WebView back = new WebView(ads_context);
                back.getSettings().setJavaScriptEnabled(true);
                back.setScrollContainer(false);
                back.setVerticalScrollBarEnabled(false);
                back.setHorizontalScrollBarEnabled(false);

                if (animation_type == 0) {

                    int animation_type_Ggenrate = (new Random().nextInt((20 - 1) + 1) + 1);

                    back.loadUrl("file:///android_asset/background/a" + animation_type_Ggenrate + "/index.html");

                    if (animation_type_Ggenrate == 1) {

                        Text_Color = Color.parseColor("#4EC0E9");

                    } else if (animation_type_Ggenrate == 2) {

                        Text_Color = Color.parseColor("#386d1b");

                    } else if (animation_type_Ggenrate == 3) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type_Ggenrate == 4) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type_Ggenrate == 5) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type_Ggenrate == 6) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type_Ggenrate == 7) {

                        Text_Color = Color.parseColor("#ff56b6");

                    } else if (animation_type_Ggenrate == 8) {

                        Text_Color = Color.parseColor("#8fc800");

                    } else if (animation_type_Ggenrate == 9) {

                        Text_Color = Color.parseColor("#00b7ea");

                    } else if (animation_type_Ggenrate == 10) {

                        Text_Color = Color.parseColor("#5aa1ed");

                    } else if (animation_type_Ggenrate == 11) {

                        Text_Color = Color.parseColor("#e8eded");

                    } else if (animation_type_Ggenrate == 12) {

                        Text_Color = Color.parseColor("#24f4ff");

                    } else if (animation_type_Ggenrate == 13) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type_Ggenrate == 14) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type_Ggenrate == 15) {

                        Text_Color = Color.parseColor("#eaeaea");

                    } else if (animation_type_Ggenrate == 16) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type_Ggenrate == 17) {

                        Text_Color = Color.parseColor("#ffff88");

                    } else if (animation_type_Ggenrate == 18) {

                        Text_Color = Color.parseColor("#cdf1f7");

                    } else if (animation_type_Ggenrate == 19) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type_Ggenrate == 20) {

                        Text_Color = Color.parseColor("#000000");

                    }

                } else {
                    back.loadUrl("file:///android_asset/background/a" + animation_type + "/index.html");

                    if (animation_type == 1) {

                        Text_Color = Color.parseColor("#4EC0E9");

                    } else if (animation_type == 2) {

                        Text_Color = Color.parseColor("#386d1b");

                    } else if (animation_type == 3) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type == 4) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type == 5) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type == 6) {

                        Text_Color = Color.parseColor("#76B7F7");

                    } else if (animation_type == 7) {

                        Text_Color = Color.parseColor("#ff56b6");

                    } else if (animation_type == 8) {

                        Text_Color = Color.parseColor("#8fc800");

                    } else if (animation_type == 9) {

                        Text_Color = Color.parseColor("#00b7ea");

                    } else if (animation_type == 10) {

                        Text_Color = Color.parseColor("#5aa1ed");

                    } else if (animation_type == 11) {

                        Text_Color = Color.parseColor("#e8eded");

                    } else if (animation_type == 12) {

                        Text_Color = Color.parseColor("#24f4ff");

                    } else if (animation_type == 13) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type == 14) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type == 15) {

                        Text_Color = Color.parseColor("#eaeaea");

                    } else if (animation_type == 16) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type == 17) {

                        Text_Color = Color.parseColor("#ffff88");

                    } else if (animation_type == 18) {

                        Text_Color = Color.parseColor("#cdf1f7");

                    } else if (animation_type == 19) {

                        Text_Color = Color.parseColor("#FFFFFF");

                    } else if (animation_type == 20) {

                        Text_Color = Color.parseColor("#000000");

                    }

                }
                builder.addContentView(back, new RelativeLayout.LayoutParams(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT));
            }

            ImageView imageView = new ImageView(ads_context);
            imageView.setImageResource(icLauncher);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int image_paadding = ((int) (width / 5));
            imageView.setPadding(image_paadding, image_paadding,
                    image_paadding, image_paadding);
            imageView.setTranslationY(-(int) (Height / 7));
            builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT));


            TextView theText = new TextView(ads_context);
            theText.setText("" + App_Name);
            theText.setTextColor(Text_Color);
            theText.setTypeface(null, Typeface.BOLD);
            theText.setTextSize((int) (Height / (width / 11)));
            theText.setTranslationY(-(int) (Height / 5.5));

            theText.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
            builder.addContentView(theText, new RelativeLayout.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT));


            ProgressBar progressBar = new ProgressBar(ads_context);


            progressBar.getIndeterminateDrawable().setColorFilter(Text_Color,
                    android.graphics.PorterDuff.Mode.MULTIPLY);

            int progressBar_padding = ((int) (width / 2.5));
            progressBar.setPadding(progressBar_padding, progressBar_padding,
                    progressBar_padding, progressBar_padding);
            progressBar.setTranslationY((float) ((Height) / 2.5));
            builder.addContentView(progressBar,
                    new RelativeLayout.LayoutParams(
                            WindowManager.LayoutParams.MATCH_PARENT,
                            WindowManager.LayoutParams.MATCH_PARENT));


            int Proress_Set_Number = new Random().nextInt((13 - 0) + 1) + 0;


            int[] Progreesssss = new int[]{R.drawable.roating_loading1, R.drawable.roating_loading2, R.drawable.roating_loading3, R.drawable.roating_loading4
                    , R.drawable.roating_loading5, R.drawable.roating_loading6, R.drawable.roating_loading7, R.drawable.roating_loading8, R.drawable.roating_loading9
                    , R.drawable.roating_loading10, R.drawable.roating_loading11, R.drawable.roating_loading12, R.drawable.roating_loading13, R.drawable.roating_loading14};


            progressBar.setIndeterminateDrawable(ads_context.getResources().getDrawable(Progreesssss[Proress_Set_Number]));
            progressBar.getIndeterminateDrawable().setColorFilter(Text_Color,
                    android.graphics.PorterDuff.Mode.MULTIPLY);


            builder.show();
            builder.getWindow().setAttributes(lp);
            builder.setCancelable(false);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {


                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (Exit_Menu_Decided == 5) {
                            Splash_Popup_Dissmiss(builder);
                            return;
                        }

                        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                            Max_Inter_Splash(builder, ads_context);
                            return;
                        }
                        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                            FB_Inter_Splash(builder, ads_context);
                            return;
                        }

                        if ((Butter.getSetup(ads_context)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Splash_Interstial_Setup1(builder, ads_context);

                        } else if ((Butter.getSetup(ads_context)).equals("0")) {

                            Splash_Interstial(builder, ads_context);

                        }


                    } else {

                        handler.postDelayed(this, 1000);

                    }

                }

            }, 1000);
        }


    }

    public static void Splash_Popup_Dissmiss(final Dialog builder) {


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                try {
                    builder.dismiss();
                } catch (Exception e) {
                }


            }

        }, 200);

    }

    public static void Splash_Interstial(final Dialog builder, final Context mContext) {


        if (Exit_Menu_Decided == 100) {
            Splash_Popup_Dissmiss(builder);
            return;
        }


        if (Butter.getinter(mContext) == 0) {

            Interstial = Butter.getinter1(mContext);

            Butter.setinter(mContext, 1);

        } else {

            Interstial = Butter.getinter2(mContext);

            Butter.setinter(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();


                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;


                    if (Butter.getextra2(Contextt).equals(FB)) {
                        FB_Inter_Splash(builder, mContext);
                    } else if (Butter.getextra2(Contextt).equals(AL)) {
                        Max_Inter_Splash(builder, mContext);
                    } else {
                        Max_Inter_Splash(builder, mContext);
                    }


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Interstial_Setup1(final Dialog builder, final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            Splash_Popup_Dissmiss(builder);
            return;
        }


        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    if ((Butter.getSetup(Contextt)).equals("1")) {
                        Splash_Interstial_Setup22(builder, mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("2")) {
                        Splash_Interstial_Setup11111(builder, mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("3")) {
                        Splash_Interstial_Setup1111(builder, mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("4")) {
                        Splash_Interstial_Setup111(builder, mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("5")) {
                        Splash_Interstial_Setup11(builder, mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("6")) {
                        Splash_Interstial_Setup2(builder, mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("7")) {
                        Splash_Interstial_Setup11111(builder, mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("8")) {
                        Splash_Interstial_Setup1111(builder, mContext);
                    }


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Interstial_Setup11(final Dialog builder, final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            Splash_Popup_Dissmiss(builder);
            return;
        }


        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial_Setup111(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Interstial_Setup111(final Dialog builder, final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            Splash_Popup_Dissmiss(builder);
            return;
        }


        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial_Setup1111(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Interstial_Setup1111(final Dialog builder, final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            Splash_Popup_Dissmiss(builder);
            return;
        }


        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial_Setup11111(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Interstial_Setup11111(final Dialog builder, final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            Splash_Popup_Dissmiss(builder);
            return;
        }


        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial_Setup2(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Interstial_Setup2(final Dialog builder, final Context mContext) {


        if (Butter.getII2(mContext) == 0) {

            Interstial = Butter.getI22(mContext);

            Butter.setII2(mContext, 1);

        } else {

            Interstial = Butter.getI222(mContext);

            Butter.setII2(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial_Setup22(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Interstial_Setup22(final Dialog builder, final Context mContext) {


        if (Butter.getII2(mContext) == 0) {

            Interstial = Butter.getI22(mContext);

            Butter.setII2(mContext, 1);

        } else {

            Interstial = Butter.getI222(mContext);

            Butter.setII2(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial_Setup3(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Interstial_Setup3(final Dialog builder, final Context mContext) {


        if (Butter.getII3(mContext) == 0) {

            Interstial = Butter.getI33(mContext);

            Butter.setII3(mContext, 1);

        } else {

            Interstial = Butter.getI333(mContext);

            Butter.setII3(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            Splash_InterstialAd = new InterstitialAd(mContext);
            Splash_InterstialAd.setAdUnitId(Interstial);

            Splash_InterstialAd.loadAd(adRequest);

            Splash_InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();

                    Splash_InterstialAd.show();

                    Butter.setsplashcount(mContext, 0);

                    Splash_Popup_Dissmiss(builder);

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Splash_InterstialAd = null;

                    Splash_Interstial(builder, mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Splash_Tappx_Inter(final Dialog builder, final Context context) {

        Splash_tappxInterstitial_preload = new TappxInterstitial(context,
                Butter.gettx(context));
        Splash_tappxInterstitial_preload.loadAd();
        Splash_tappxInterstitial_preload
                .setListener(new TappxInterstitialListener() {
                    @Override
                    public void onInterstitialLoaded(
                            TappxInterstitial tappxInterstitial) {

                        tappxInterstitial.show();

                        Splash_Popup_Dissmiss(builder);

                        Butter.setsplashcount(context,
                                (Butter.getsplashcount(context) + 1));
                    }

                    @Override
                    public void onInterstitialLoadFailed(
                            TappxInterstitial tappxInterstitial,
                            TappxAdError tappxAdError) {


                        if ((new Random().nextInt((2 - 1) + 1) + 1) == 1) {
                            SO = SO_FULLPAGE;
                        } else {
                            SO = SO_OFFERWALL;
                        }

                        startAppAd.loadAd(SO, new AdEventListener() {
                            @Override
                            public void onReceiveAd(Ad ad) {

                                startAppAd.showAd();
                                Splash_Popup_Dissmiss(builder);

                            }

                            @Override
                            public void onFailedToReceiveAd(Ad ad) {
                                Splash_Popup_Dissmiss(builder);
                            }

                        });

                    }

                    @Override
                    public void onInterstitialClicked(TappxInterstitial arg0) {


                    }

                    @Override
                    public void onInterstitialDismissed(TappxInterstitial arg0) {


                    }

                    @Override
                    public void onInterstitialShown(TappxInterstitial arg0) {


                    }

                });

    }

    public static void Banner(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                            Max_Banner(Ad_Layout, Banner_Type);
                            return;
                        }

                        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                            FB_Banner(Ad_Layout, Banner_Type);
                            return;
                        }

                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Banner_Auto_Setup(Ad_Layout, Banner_Type);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Banner_Normal(Ad_Layout, Banner_Type);

                        }


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public static void Banner_Main_Linear(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                            Max_Banner(Ad_Layout, Banner_Type);
                            return;
                        }
                        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                            FB_Banner(Ad_Layout, Banner_Type);
                            return;
                        }

                        if (Exit_Menu_Decided == 100) {

                            return;
                        }

                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Banner_Auto_Setup_Main_Linear(Ad_Layout, Banner_Type);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Banner_Main_Linear_Normal(Ad_Layout, Banner_Type);

                        }

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public static void Banner_Normal(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                    AdSize Banner_Type_Size = null;

                    if (Banner_Type == 1) {

                        Banner_Type_Size = AdSize.BANNER;

                    } else if (Banner_Type == 2) {

                        Banner_Type_Size = AdSize.LARGE_BANNER;

                    } else if (Banner_Type == 3) {

                        Banner_Type_Size = AdSize.LARGE_BANNER;

                    } else if (Banner_Type == 4) {

                        Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

                    } else {

                        Banner_Type_Size = AdSize.BANNER;

                    }

                    if (Butter.getbanner(Contextt) == 0) {

                        Banner = Butter.getbanner1(Contextt);

                        Butter.setbanner(Contextt, 1);

                    } else {

                        Banner = Butter.getbanner2(Contextt);

                        Butter.setbanner(Contextt, 0);

                    }

                    mAdView = new AdView(Contextt);
                    mAdView.setAdSize(Banner_Type_Size);
                    mAdView.setAdUnitId(Banner);
                    AdRequest adore = new AdRequest.Builder().build();
                    mAdView.loadAd(adore);
                    Ad_Layout.addView(mAdView);

                    RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                            .getLayoutParams();
                    relativeParams.setMargins(0, 10, 0, 0);
                    Ad_Layout.setLayoutParams(relativeParams);

                    mAdView.setAdListener(new AdListener() {

                        @Override
                        public void onAdLoaded() {


                            Ad_Layout.setVisibility(View.VISIBLE);
                            Butter.setsplashcount(Contextt, 0);

                            super.onAdLoaded();

                        }

                        @Override
                        public void onAdFailedToLoad(int errorCode) {

                            super.onAdFailedToLoad(errorCode);

                            mAdView.destroy();


                            if (Butter.getextra2(Contextt).equals(FB)) {

                                if (G_Native_Type == 2) {

                                    FB_Native(Contextt, Ad_Layout,
                                            G_Native_Type, 0, 0, 0);

                                } else {

                                    FB_Native(Contextt, Ad_Layout,
                                            Banner_Type, 0, 0, 0);
                                }

                            } else if (Butter.getextra2(Contextt).equals(AL)) {

                                if (G_Native_Type == 2) {

                                    Max_Native(Contextt, Ad_Layout,
                                            G_Native_Type, 0, 0, 0);

                                } else {

                                    Max_Native(Contextt, Ad_Layout,
                                            Banner_Type, 0, 0, 0);
                                }

                            } else {

                                if (G_Native_Type == 2) {

                                    Max_Native(Contextt, Ad_Layout,
                                            G_Native_Type, 0, 0, 0);

                                } else {

                                    Max_Native(Contextt, Ad_Layout,
                                            Banner_Type, 0, 0, 0);
                                }

                            }


                        }
                    });

                } else {

                    handler.postDelayed(this, 500);

                }

            }

        }, 500);

    }

    public static void Banner_Main_Linear_Normal(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                    AdSize Banner_Type_Size = null;

                    if (Banner_Type == 1) {

                        Banner_Type_Size = AdSize.BANNER;

                    } else if (Banner_Type == 2) {

                        Banner_Type_Size = AdSize.LARGE_BANNER;

                    } else if (Banner_Type == 3) {

                        Banner_Type_Size = AdSize.LARGE_BANNER;

                    } else if (Banner_Type == 4) {

                        Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

                    } else {

                        Banner_Type_Size = AdSize.BANNER;

                    }

                    if (Butter.getbanner(Contextt) == 0) {

                        Banner = Butter.getbanner1(Contextt);

                        Butter.setbanner(Contextt, 1);

                    } else {

                        Banner = Butter.getbanner2(Contextt);

                        Butter.setbanner(Contextt, 0);

                    }

                    mAdView = new AdView(Contextt);
                    mAdView.setAdSize(Banner_Type_Size);
                    mAdView.setAdUnitId(Banner);
                    AdRequest adore = new AdRequest.Builder().build();
                    mAdView.loadAd(adore);
                    Ad_Layout.addView(mAdView);

                    LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                            .getLayoutParams();
                    relativeParams.setMargins(0, 10, 0, 0);

                    Ad_Layout.setLayoutParams(relativeParams);

                    mAdView.setAdListener(new AdListener() {

                        @Override
                        public void onAdLoaded() {


                            Ad_Layout.setVisibility(View.VISIBLE);
                            Butter.setsplashcount(Contextt, 0);

                            super.onAdLoaded();

                        }

                        @Override
                        public void onAdFailedToLoad(int errorCode) {

                            super.onAdFailedToLoad(errorCode);


                            if (Butter.getextra2(Contextt).equals(FB)) {

                                if (G_Native_Type == 2) {

                                    FB_Native(Contextt, Ad_Layout,
                                            G_Native_Type, 0, 0, 0);

                                } else {

                                    FB_Native(Contextt, Ad_Layout,
                                            Banner_Type, 0, 0, 0);
                                }

                            } else if (Butter.getextra2(Contextt).equals(AL)) {

                                if (G_Native_Type == 2) {

                                    Max_Native(Contextt, Ad_Layout,
                                            G_Native_Type, 0, 0, 0);

                                } else {

                                    Max_Native(Contextt, Ad_Layout,
                                            Banner_Type, 0, 0, 0);
                                }

                            } else {

                                if (G_Native_Type == 2) {

                                    Max_Native(Contextt, Ad_Layout,
                                            G_Native_Type, 0, 0, 0);

                                } else {

                                    Max_Native(Contextt, Ad_Layout,
                                            Banner_Type, 0, 0, 0);
                                }

                            }

                            mAdView.destroy();


                        }
                    });

                } else {

                    handler.postDelayed(this, 500);

                }

            }

        }, 500);

    }

    public static void Banner_Auto_Setup(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        Banner_Auto_Setup1(Ad_Layout, Banner_Type);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public static void Banner_Auto_Setup1(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                if ((Butter.getSetup(Contextt)).equals("1")) {
                    Banner_Auto_Setup22(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("2")) {
                    Banner_Auto_Setup11111(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("3")) {
                    Banner_Auto_Setup1111(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("4")) {
                    Banner_Auto_Setup111(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("5")) {
                    Banner_Auto_Setup11(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("6")) {
                    Banner_Auto_Setup2(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("7")) {
                    Banner_Auto_Setup11111(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("8")) {
                    Banner_Auto_Setup1111(Ad_Layout, Banner_Type);
                }

            }
        });
    }

    public static void Banner_Auto_Setup11(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup111(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup111(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup1111(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup1111(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup11111(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup11111(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup2(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup2(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB2(Contextt) == 0) {

            Banner = Butter.getB22(Contextt);

            Butter.setBB2(Contextt, 1);

        } else {

            Banner = Butter.getB222(Contextt);

            Butter.setBB2(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup22(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup22(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB2(Contextt) == 0) {

            Banner = Butter.getB22(Contextt);

            Butter.setBB2(Contextt, 1);

        } else {

            Banner = Butter.getB222(Contextt);

            Butter.setBB2(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup3(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup3(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB3(Contextt) == 0) {

            Banner = Butter.getB33(Contextt);

            Butter.setBB3(Contextt, 1);

        } else {

            Banner = Butter.getB333(Contextt);

            Butter.setBB3(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }


            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                Ad_Layout.removeAllViews();


                if (Butter.getextra2(Contextt).equals(FB)) {

                    if (G_Native_Type == 2) {

                        FB_Native(Contextt, Ad_Layout,
                                G_Native_Type, 0, 0, 0);

                    } else {

                        FB_Native(Contextt, Ad_Layout,
                                Banner_Type, 0, 0, 0);
                    }

                } else if (Butter.getextra2(Contextt).equals(AL)) {

                    if (G_Native_Type == 2) {

                        Max_Native(Contextt, Ad_Layout,
                                G_Native_Type, 0, 0, 0);

                    } else {

                        Max_Native(Contextt, Ad_Layout,
                                Banner_Type, 0, 0, 0);
                    }

                } else {

                    if (G_Native_Type == 2) {

                        Max_Native(Contextt, Ad_Layout,
                                G_Native_Type, 0, 0, 0);

                    } else {

                        Max_Native(Contextt, Ad_Layout,
                                Banner_Type, 0, 0, 0);
                    }

                }


                mAdView_Setup.destroy();


            }
        });
    }

    public static void Banner_Auto_Setup_Main_Linear(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        Banner_Auto_Setup_Linear1(Ad_Layout, Banner_Type);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public static void Banner_Auto_Setup_Linear1(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                if ((Butter.getSetup(Contextt)).equals("1")) {
                    Banner_Auto_Setup_Linear22(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("2")) {
                    Banner_Auto_Setup_Linear11111(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("3")) {
                    Banner_Auto_Setup_Linear1111(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("4")) {
                    Banner_Auto_Setup_Linear111(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("5")) {
                    Banner_Auto_Setup_Linear11(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("6")) {
                    Banner_Auto_Setup_Linear2(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("7")) {
                    Banner_Auto_Setup_Linear11111(Ad_Layout, Banner_Type);
                }
                if ((Butter.getSetup(Contextt)).equals("8")) {
                    Banner_Auto_Setup_Linear1111(Ad_Layout, Banner_Type);
                }

            }
        });
    }

    public static void Banner_Auto_Setup_Linear11(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup_Linear111(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup_Linear111(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup_Linear1111(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup_Linear1111(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup_Linear11111(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup_Linear11111(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB1(Contextt) == 0) {

            Banner = Butter.getB11(Contextt);

            Butter.setBB1(Contextt, 1);

        } else {

            Banner = Butter.getB111(Contextt);

            Butter.setBB1(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup_Linear2(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup_Linear2(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB2(Contextt) == 0) {

            Banner = Butter.getB22(Contextt);

            Butter.setBB2(Contextt, 1);

        } else {

            Banner = Butter.getB222(Contextt);

            Butter.setBB2(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup_Linear22(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup_Linear22(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB2(Contextt) == 0) {

            Banner = Butter.getB22(Contextt);

            Butter.setBB2(Contextt, 1);

        } else {

            Banner = Butter.getB222(Contextt);

            Butter.setBB2(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();

                Banner_Auto_Setup_Linear3(Ad_Layout, Banner_Type);

            }
        });
    }

    public static void Banner_Auto_Setup_Linear3(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if (Butter.getBB3(Contextt) == 0) {

            Banner = Butter.getB33(Contextt);

            Butter.setBB3(Contextt, 1);

        } else {

            Banner = Butter.getB333(Contextt);

            Butter.setBB3(Contextt, 0);

        }

        AdView mAdView_Setup = new AdView(Contextt);
        mAdView_Setup.setAdSize(Banner_Type_Size);
        mAdView_Setup.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView_Setup.loadAd(adore);
        Ad_Layout.addView(mAdView_Setup);

        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                .getLayoutParams();
        relativeParams.setMargins(0, 10, 0, 0);
        Ad_Layout.setLayoutParams(relativeParams);

        mAdView_Setup.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);

                super.onAdLoaded();

            }


            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView_Setup.destroy();
                Ad_Layout.removeAllViews();


                if (Butter.getextra2(Contextt).equals(FB)) {

                    if (G_Native_Type == 2) {

                        FB_Native(Contextt, Ad_Layout,
                                G_Native_Type, 0, 0, 0);

                    } else {

                        FB_Native(Contextt, Ad_Layout,
                                Banner_Type, 0, 0, 0);
                    }

                } else if (Butter.getextra2(Contextt).equals(AL)) {

                    if (G_Native_Type == 2) {

                        Max_Native(Contextt, Ad_Layout,
                                G_Native_Type, 0, 0, 0);

                    } else {

                        Max_Native(Contextt, Ad_Layout,
                                Banner_Type, 0, 0, 0);
                    }

                } else {

                    if (G_Native_Type == 2) {

                        Max_Native(Contextt, Ad_Layout,
                                G_Native_Type, 0, 0, 0);

                    } else {

                        Max_Native(Contextt, Ad_Layout,
                                Banner_Type, 0, 0, 0);
                    }

                }


            }
        });
    }

    public static void Splash_Screen(final Context mContext, boolean bool,
                                     final int When_App_Open_How_Much_Time_After) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getsplashcount(mContext) >= 10) {

            Load_Splash_Goog(mContext, When_App_Open_How_Much_Time_After);

        } else {

            if (bool == true) {

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Load_Splash_Goog(mContext,
                                When_App_Open_How_Much_Time_After);


                    }

                }, When_App_Open_How_Much_Time_After);

            } else {

            }

        }

    }

    public static void Load_Splash_Goog(final Context mContext, int splash_Screen_Time) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        Ad_Popup(mContext, "Splash Ad . . .");

        if (Butter.getinter(mContext) == 0) {

            Interstial = Butter.getinter1(mContext);

            Butter.setinter(mContext, 1);

        } else {

            Interstial = Butter.getinter2(mContext);

            Butter.setinter(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {

                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    Butter.setsplashcount(mContext,
                            (Butter.getsplashcount(mContext) + 1));
                    Tappx_Inter(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial(final Context mContext,
                                  final int How_Much_Time_After_Interstial_Milisecond) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                        Max_Inter_Show(mContext);
                        return;
                    }
                    if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                        FB_Inter_Show(mContext);
                        return;
                    }

                    Pre_Interstial_Show(mContext);

                }

            }, How_Much_Time_After_Interstial_Milisecond);

        }

    }

    public static void Interstial(final Context mContext) {

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Inter_Show(mContext);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Inter_Show(mContext);
            return;
        }

        if ((Butter.getSetup(mContext)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {

            Interstial_When_Load_Setup1(mContext);

        } else if ((Butter.getSetup(mContext)).equals("0")) {

            Interstial_When_Load_Normal(mContext);

        }


    }

    public static void Interstial_When_Load_Normal(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getinter(mContext) == 0) {

            Interstial = Butter.getinter1(mContext);

            Butter.setinter(mContext, 1);

        } else {

            Interstial = Butter.getinter2(mContext);

            Butter.setinter(mContext, 0);

        }

        Ad_Popup(mContext, "Ad Loading . . .");

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);


                    if (Butter.getextra2(Contextt).equals(FB)) {
                        FB_Inter_Show(mContext);
                    } else if (Butter.getextra2(Contextt).equals(AL)) {
                        Max_Inter_Show(mContext);
                    } else {
                        Max_Inter_Show(mContext);
                    }

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Ad_ProgressDialog.dismiss();

                        }

                    }, 1000);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial_When_Load_Setup1(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        Ad_Popup(mContext, "Ad Loading . . .");

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    if ((Butter.getSetup(Contextt)).equals("1")) {
                        Interstial_When_Load_Setup22(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("2")) {
                        Interstial_When_Load_Setup11111(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("3")) {
                        Interstial_When_Load_Setup1111(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("4")) {
                        Interstial_When_Load_Setup111(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("5")) {
                        Interstial_When_Load_Setup11(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("6")) {
                        Interstial_When_Load_Setup2(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("7")) {
                        Interstial_When_Load_Setup11111(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("8")) {
                        Interstial_When_Load_Setup1111(mContext);
                    }

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial_When_Load_Setup11(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Interstial_When_Load_Setup111(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial_When_Load_Setup111(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Interstial_When_Load_Setup1111(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial_When_Load_Setup1111(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Interstial_When_Load_Setup11111(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial_When_Load_Setup11111(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Interstial_When_Load_Setup2(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial_When_Load_Setup2(final Context mContext) {


        if (Butter.getII2(mContext) == 0) {

            Interstial = Butter.getI22(mContext);

            Butter.setII2(mContext, 1);

        } else {

            Interstial = Butter.getI222(mContext);

            Butter.setII2(mContext, 0);

        }


        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Interstial_When_Load_Setup22(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial_When_Load_Setup22(final Context mContext) {

        Max_Inter(mContext);

        if (Butter.getII2(mContext) == 0) {

            Interstial = Butter.getI22(mContext);

            Butter.setII2(mContext, 1);

        } else {

            Interstial = Butter.getI222(mContext);

            Butter.setII2(mContext, 0);

        }


        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Interstial_When_Load_Setup3(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Interstial_When_Load_Setup3(final Context mContext) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII3(mContext) == 0) {

            Interstial = Butter.getI33(mContext);

            Butter.setII3(mContext, 1);

        } else {

            Interstial = Butter.getI333(mContext);

            Butter.setII3(mContext, 0);

        }


        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd = new InterstitialAd(mContext);
            InterstialAd.setAdUnitId(Interstial);

            InterstialAd.loadAd(adRequest);

            InterstialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    InterstialAd.show();
                    Butter.setsplashcount(mContext, 0);
                    Ad_ProgressDialog.dismiss();

                    super.onAdLoaded();

                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);

                    Ad_ProgressDialog.dismiss();

                    Interstial_When_Load_Normal(mContext);

                    super.onAdFailedToLoad(errorCode);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Pre_Interstial_Show(final Context mContext) {


        if (Exit_Menu_Decided == 5) {

            if (For_Approval <= Butter.getcount_Approval(mContext)) {

                Butter.setcount_Approval(mContext, 1);

            } else {
                Butter.setcount_Approval(mContext, (Butter.getcount_Approval(mContext) + 1));
                return;
            }


        }

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Inter_Show(mContext);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Inter_Show(mContext);
            return;
        }

        if (Exit_Menu_Decided == 100) {
            return;
        }


        if ((Butter.getextra1(mContext)).equals("1")) {


            if ((Butter.getSetup(mContext)).equals("1") ||
                    (Butter.getSetup(Contextt)).equals("2") ||
                    (Butter.getSetup(Contextt)).equals("3") ||
                    (Butter.getSetup(Contextt)).equals("4") ||
                    (Butter.getSetup(Contextt)).equals("5") ||
                    (Butter.getSetup(Contextt)).equals("6") ||
                    (Butter.getSetup(Contextt)).equals("7") ||
                    (Butter.getSetup(Contextt)).equals("8") ||
                    (Butter.getSetup(Contextt)).equals("9") ||
                    (Butter.getSetup(Contextt)).equals("10")) {

                Show_Inter_Setup_Show(mContext);

            } else if ((Butter.getSetup(mContext)).equals("0")) {

                Pre_Interstial_Show_Normal(mContext);

            }

        } else if ((Butter.getextra1(mContext)).equals("2")) {

            Pre_App_Open_Show((Activity) mContext);

        } else {


            if ((Butter.getSetup(mContext)).equals("1") ||
                    (Butter.getSetup(Contextt)).equals("2") ||
                    (Butter.getSetup(Contextt)).equals("3") ||
                    (Butter.getSetup(Contextt)).equals("4") ||
                    (Butter.getSetup(Contextt)).equals("5") ||
                    (Butter.getSetup(Contextt)).equals("6") ||
                    (Butter.getSetup(Contextt)).equals("7") ||
                    (Butter.getSetup(Contextt)).equals("8") ||
                    (Butter.getSetup(Contextt)).equals("9") ||
                    (Butter.getSetup(Contextt)).equals("10")) {

                Show_Inter_Setup_Show(mContext);

            } else if ((Butter.getSetup(mContext)).equals("0")) {

                Pre_Interstial_Show_Normal(mContext);

            }

        }


    }

    public static void Pre_Interstial_Show_End(final Context mContext) {

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Inter_Show(mContext);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Inter_Show(mContext);
            return;
        }

        if (Exit_Menu_Decided == 100) {

            return;
        }


        if ((Butter.getextra1(mContext)).equals("1")) {


            if ((Butter.getSetup(mContext)).equals("1") ||
                    (Butter.getSetup(Contextt)).equals("2") ||
                    (Butter.getSetup(Contextt)).equals("3") ||
                    (Butter.getSetup(Contextt)).equals("4") ||
                    (Butter.getSetup(Contextt)).equals("5") ||
                    (Butter.getSetup(Contextt)).equals("6") ||
                    (Butter.getSetup(Contextt)).equals("7") ||
                    (Butter.getSetup(Contextt)).equals("8") ||
                    (Butter.getSetup(Contextt)).equals("9") ||
                    (Butter.getSetup(Contextt)).equals("10")) {

                Show_Inter_Setup_Show_End(mContext);

            } else if ((Butter.getSetup(mContext)).equals("0")) {

                Pre_Interstial_Show_End_Normal(mContext);

            }

        } else if ((Butter.getextra1(mContext)).equals("2")) {


            Pre_App_Open_Show((Activity) mContext);

        } else {

            if ((Butter.getSetup(mContext)).equals("1") ||
                    (Butter.getSetup(Contextt)).equals("2") ||
                    (Butter.getSetup(Contextt)).equals("3") ||
                    (Butter.getSetup(Contextt)).equals("4") ||
                    (Butter.getSetup(Contextt)).equals("5") ||
                    (Butter.getSetup(Contextt)).equals("6") ||
                    (Butter.getSetup(Contextt)).equals("7") ||
                    (Butter.getSetup(Contextt)).equals("8") ||
                    (Butter.getSetup(Contextt)).equals("9") ||
                    (Butter.getSetup(Contextt)).equals("10")) {

                Show_Inter_Setup_Show_End(mContext);

            } else if ((Butter.getSetup(mContext)).equals("0")) {

                Pre_Interstial_Show_End_Normal(mContext);

            }

        }

    }

    public static void Pre_Interstial_Load_Normal(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getinter(mContext) == 0) {

            Interstial = Butter.getinter1(mContext);

            Butter.setinter(mContext, 1);


        } else {

            Interstial = Butter.getinter2(mContext);

            Butter.setinter(mContext, 0);


        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd1 = new InterstitialAd(mContext);
            InterstialAd1.setAdUnitId(Interstial);

            InterstialAd1.loadAd(adRequest);

            InterstialAd1.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    Inter_Failed = 0;
                    super.onAdLoaded();


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd1 = null;

                    Inter_Failed = 200;

                    Max_Inter(mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Pre_Interstial_Show_Normal(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            if (Inter_Failed == 0) {

                if (InterstialAd1 != null) {
                    InterstialAd1.show();
                    Butter.setsplashcount(mContext, 0);
                }

            }

            if (Inter_Failed == 200) {


                if (Butter.getextra2(Contextt).equals(FB)) {
                    FB_Inter_Show(mContext);
                } else if (Butter.getextra2(Contextt).equals(AL)) {
                    Max_Inter_Show(mContext);
                } else {
                    Max_Inter_Show(mContext);
                }

            }

            if (Inter_Failed == 1) {

                if (tappxInterstitial_preload != null)
                    tappxInterstitial_preload.show();

                Butter.setsplashcount(mContext,
                        (Butter.getsplashcount(mContext) + 1));

            }

            if (Inter_Failed == 50) {

                if (startAppAd.isReady()) {
                    startAppAd.showAd();
                    Butter.setsplashcount(mContext,
                            (Butter.getsplashcount(mContext) + 1));
                }


            }

            Pre_Interstial_Load_Normal(mContext);

        }
    }

    public static void Pre_Interstial_Show_End_Normal(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            if (Inter_Failed == 1) {

                if (tappxInterstitial_preload != null)
                    tappxInterstitial_preload.show();

                Butter.setsplashcount(mContext,
                        (Butter.getsplashcount(mContext) + 1));

            }

            if (Inter_Failed == 200) {

                Max_Inter_Show(mContext);

            }

            if (Inter_Failed == 0) {

                if (InterstialAd1 != null) {
                    InterstialAd1.show();
                    Butter.setsplashcount(mContext, 0);
                }

            }

            if (Inter_Failed == 50) {

                if (startAppAd.isReady()) {
                    startAppAd.showAd();
                    Butter.setsplashcount(mContext,
                            (Butter.getsplashcount(mContext) + 1));
                }

            }

        }

    }

    public static void Load_Inter_Setup1(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup = new InterstitialAd(mContext);
            InterstialAd_Setup.setAdUnitId("" + Interstial);

            InterstialAd_Setup.loadAd(adRequest);

            InterstialAd_Setup.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 1;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup = null;

                    if ((Butter.getSetup(Contextt)).equals("1")) {
                        Load_Inter_Setup22(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("2")) {
                        Load_Inter_Setup11111(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("3")) {
                        Load_Inter_Setup1111(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("4")) {
                        Load_Inter_Setup111(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("5")) {
                        Load_Inter_Setup11(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("6")) {
                        Load_Inter_Setup2(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("7")) {
                        Load_Inter_Setup11111(mContext);
                    }
                    if ((Butter.getSetup(Contextt)).equals("8")) {
                        Load_Inter_Setup1111(mContext);
                    }

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Load_Inter_Setup11(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup = new InterstitialAd(mContext);
            InterstialAd_Setup.setAdUnitId("" + Interstial);

            InterstialAd_Setup.loadAd(adRequest);

            InterstialAd_Setup.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 11;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup = null;

                    Load_Inter_Setup111(mContext);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Load_Inter_Setup111(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup = new InterstitialAd(mContext);
            InterstialAd_Setup.setAdUnitId("" + Interstial);

            InterstialAd_Setup.loadAd(adRequest);

            InterstialAd_Setup.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 111;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup = null;

                    Load_Inter_Setup1111(mContext);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Load_Inter_Setup1111(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup = new InterstitialAd(mContext);
            InterstialAd_Setup.setAdUnitId("" + Interstial);

            InterstialAd_Setup.loadAd(adRequest);

            InterstialAd_Setup.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 1111;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup = null;

                    Load_Inter_Setup11111(mContext);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Load_Inter_Setup11111(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII1(mContext) == 0) {

            Interstial = Butter.getI11(mContext);

            Butter.setII1(mContext, 1);

        } else {

            Interstial = Butter.getI111(mContext);

            Butter.setII1(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup = new InterstitialAd(mContext);
            InterstialAd_Setup.setAdUnitId("" + Interstial);

            InterstialAd_Setup.loadAd(adRequest);

            InterstialAd_Setup.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 11111;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup = null;

                    Load_Inter_Setup2(mContext);

                }

            });
        } catch (Exception e) {

        }

    }

    public static void Load_Inter_Setup2(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII2(mContext) == 0) {

            Interstial = Butter.getI22(mContext);

            Butter.setII2(mContext, 1);

        } else {

            Interstial = Butter.getI222(mContext);

            Butter.setII2(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup = new InterstitialAd(mContext);
            InterstialAd_Setup.setAdUnitId("" + Interstial);

            InterstialAd_Setup.loadAd(adRequest);

            InterstialAd_Setup.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 2;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup = null;

                    Load_Inter_Setup22(mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Load_Inter_Setup22(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII2(mContext) == 0) {

            Interstial = Butter.getI22(mContext);

            Butter.setII2(mContext, 1);

        } else {

            Interstial = Butter.getI222(mContext);

            Butter.setII2(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup = new InterstitialAd(mContext);
            InterstialAd_Setup.setAdUnitId("" + Interstial);

            InterstialAd_Setup.loadAd(adRequest);

            InterstialAd_Setup.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 22;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup = null;

                    Load_Inter_Setup3(mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Load_Inter_Setup3(final Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getII3(mContext) == 0) {

            Interstial = Butter.getI33(mContext);

            Butter.setII3(mContext, 1);

        } else {

            Interstial = Butter.getI333(mContext);

            Butter.setII3(mContext, 0);

        }

        try {

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstialAd_Setup = new InterstitialAd(mContext);
            InterstialAd_Setup.setAdUnitId("" + Interstial);

            InterstialAd_Setup.loadAd(adRequest);

            InterstialAd_Setup.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    super.onAdLoaded();

                    Inter_Setup = 3;


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                    super.onAdFailedToLoad(errorCode);

                    InterstialAd_Setup = null;

                    Inter_Setup = 200;

                    Max_Inter(mContext);


                }

            });
        } catch (Exception e) {

        }

    }

    public static void Show_Inter_Setup_Show(final Context context) {


        if (isNetworkConnected(context) == true) {


            if (Inter_Setup == 1
                    || Inter_Setup == 11
                    || Inter_Setup == 111
                    || Inter_Setup == 1111
                    || Inter_Setup == 11111
                    || Inter_Setup == 2
                    || Inter_Setup == 22
                    || Inter_Setup == 3) {

                if (InterstialAd_Setup != null) {
                    InterstialAd_Setup.show();
                    Load_Inter_Setup1(context);
                }

            }

            if (Inter_Setup == 200) {


                Load_Inter_Setup1(context);

                if (Butter.getextra2(Contextt).equals(FB)) {
                    FB_Inter_Show(context);
                } else if (Butter.getextra2(Contextt).equals(AL)) {
                    Max_Inter_Show(context);
                } else {
                    Max_Inter_Show(context);
                }

            }

            if (Inter_Setup == 0) {
                if (tappxInterstitial_preload != null)
                    tappxInterstitial_preload.show();
                Load_Inter_Setup1(context);
            }

            if (Inter_Setup == 50) {
                if (startAppAd.isReady()) {
                    startAppAd.showAd();
                    Butter.setsplashcount(context,
                            (Butter.getsplashcount(context) + 1));
                    Load_Inter_Setup1(context);
                }

            }


        }


    }

    public static void Show_Inter_Setup_Show_End(final Context context) {


        if (isNetworkConnected(context) == true) {


            if (Inter_Setup == 1
                    || Inter_Setup == 11
                    || Inter_Setup == 111
                    || Inter_Setup == 1111
                    || Inter_Setup == 11111
                    || Inter_Setup == 2
                    || Inter_Setup == 22
                    || Inter_Setup == 3) {

                if (InterstialAd_Setup != null) {
                    InterstialAd_Setup.show();
                }

            }

            if (Inter_Setup == 200) {

                Max_Inter_Show(context);
                Load_Inter_Setup1(context);
            }

            if (Inter_Setup == 0) {
                if (tappxInterstitial_preload != null)
                    tappxInterstitial_preload.show();
            }

            if (Inter_Setup == 50) {
                if (startAppAd.isReady()) {
                    startAppAd.showAd();
                    Butter.setsplashcount(context,
                            (Butter.getsplashcount(context) + 1));
                }

            }


        }


    }

    public static void Interstial_Counted(Context mContext,
                                          int How_Much_Click_After_Interstial) {

        if (isNetworkConnected(Contextt) == true) {

            if (Exit_Menu_Decided == 100) {
                return;
            }

            if (How_Much_Click_After_Interstial <= Butter.getcount(mContext)) {

                Butter.setcount(mContext, 1);
                Pre_Interstial_Show(mContext);

            } else {
                Butter.setcount(mContext, (Butter.getcount(mContext) + 1));
            }

        }

    }

    public static void Native(Context nContext, final RelativeLayout Ad_Layout,
                              int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(nContext) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                            Max_Native(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                            return;
                        }

                        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                            FB_Native(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                            return;
                        }

                        if ((Butter.getSetup(nContext)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Native_Auto_Setup(nContext, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        } else if ((Butter.getSetup(nContext)).equals("0")) {

                            Native_Normal(nContext, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        }


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public static void Native_Main_Linear(Context nContext, final RelativeLayout Ad_Layout,
                                          int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(nContext) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
                            Max_Native(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                            return;
                        }
                        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                            FB_Native(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                            return;
                        }

                        if ((Butter.getSetup(nContext)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Native_Auto_Setup_Main_Linear(nContext, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        } else if ((Butter.getSetup(nContext)).equals("0")) {

                            Native_Main_Linear_Normal(nContext, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        }


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public static void Native_Normal(Context nContext, final RelativeLayout Ad_Layout,
                                     int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if (Butter.getnative(nContext) == 0) {

                            Native_ID = Butter.getnative1(nContext);

                            Butter.setnative(nContext, 1);


                        } else {

                            Native_ID = Butter.getnative2(nContext);

                            Butter.setnative(nContext, 0);


                        }

                        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                    private ColorDrawable background;

                                    @Override
                                    public void onNativeAdLoaded(NativeAd nativeAd) {
                                        PizzaStyle styles = new
                                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                                        templateView.setStyles(styles);
                                        templateView.setNativeAd(nativeAd);

                                        Ad_Layout.removeAllViews();
                                        Ad_Layout.addView(templateView);
                                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                                .getLayoutParams();
                                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                                        Ad_Layout.setLayoutParams(relativeParams);

                                        templateView.setVisibility(View.VISIBLE);
                                        Ad_Layout.setVisibility(View.VISIBLE);


                                    }

                                })
                                .withAdListener(new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError adError) {


                                        Ad_Layout.removeAllViews();

                                        G_Native_Type = Native_Type;

                                        if (Native_Type == 2) {

                                            Banner(Ad_Layout, 4);

                                        } else {

                                            Banner(Ad_Layout, 3);
                                        }

                                    }
                                })
                                .withNativeAdOptions(new NativeAdOptions.Builder()

                                        .build())
                                .build();

                        adLoader.loadAd(new AdRequest.Builder().build());


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }
    }

    public static void Native_Main_Linear_Normal(Context nContext, final RelativeLayout Ad_Layout,
                                                 int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        if (Butter.getnative(nContext) == 0) {

                            Native_ID = Butter.getnative1(nContext);

                            Butter.setnative(nContext, 1);

                        } else {

                            Native_ID = Butter.getnative2(nContext);

                            Butter.setnative(nContext, 0);

                        }

                        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                    private ColorDrawable background;

                                    @Override
                                    public void onNativeAdLoaded(NativeAd nativeAd) {
                                        PizzaStyle styles = new
                                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                                        TemplateView templateView = new TemplateView(nContext, Native_Type);


                                        templateView.setStyles(styles);
                                        templateView.setNativeAd(nativeAd);

                                        Ad_Layout.removeAllViews();
                                        Ad_Layout.addView(templateView);
                                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                                .getLayoutParams();
                                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                                        Ad_Layout.setLayoutParams(relativeParams);

                                        templateView.setVisibility(View.VISIBLE);
                                        Ad_Layout.setVisibility(View.VISIBLE);


                                    }

                                })
                                .withAdListener(new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError adError) {


                                        Ad_Layout.removeAllViews();

                                        G_Native_Type = Native_Type;

                                        if (Native_Type == 2) {

                                            Banner_Main_Linear(Ad_Layout, 4);

                                        } else {

                                            Banner_Main_Linear(Ad_Layout, 3);
                                        }

                                    }
                                })
                                .withNativeAdOptions(new NativeAdOptions.Builder()

                                        .build())
                                .build();

                        adLoader.loadAd(new AdRequest.Builder().build());


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public static void Native_Auto_Setup(Context nContext, final RelativeLayout Ad_Layout,
                                         int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        Native_Auto_Setup1(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public static void Native_Auto_Setup1(Context nContext, final RelativeLayout Ad_Layout,
                                          int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);

                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();

                        if ((Butter.getSetup(Contextt)).equals("1")) {
                            Native_Auto_Setup22(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("2")) {
                            Native_Auto_Setup11111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("3")) {
                            Native_Auto_Setup1111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("4")) {
                            Native_Auto_Setup111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("5")) {
                            Native_Auto_Setup11(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("6")) {
                            Native_Auto_Setup2(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("7")) {
                            Native_Auto_Setup11111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("8")) {
                            Native_Auto_Setup1111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup11(Context nContext, final RelativeLayout Ad_Layout,
                                           int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup111(Context nContext, final RelativeLayout Ad_Layout,
                                            int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup1111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup1111(Context nContext, final RelativeLayout Ad_Layout,
                                             int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup11111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup11111(Context nContext, final RelativeLayout Ad_Layout,
                                              int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup2(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup2(Context nContext, final RelativeLayout Ad_Layout,
                                          int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN2(nContext) == 0) {

            Native_ID = Butter.getN22(nContext);

            Butter.setNN2(nContext, 1);


        } else {

            Native_ID = Butter.getN222(nContext);

            Butter.setNN2(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup22(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup22(Context nContext, final RelativeLayout Ad_Layout,
                                           int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN2(nContext) == 0) {

            Native_ID = Butter.getN22(nContext);

            Butter.setNN2(nContext, 1);


        } else {

            Native_ID = Butter.getN222(nContext);

            Butter.setNN2(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);

                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup3(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup3(Context nContext, final RelativeLayout Ad_Layout,
                                          int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN3(nContext) == 0) {

            Native_ID = Butter.getN33(nContext);

            Butter.setNN3(nContext, 1);


        } else {

            Native_ID = Butter.getN333(nContext);

            Butter.setNN3(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();

                        G_Native_Type = Native_Type;

                        if (Native_Type == 2) {

                            Banner_Auto_Setup1(Ad_Layout, 4);

                        } else {

                            Banner_Auto_Setup1(Ad_Layout, 3);
                        }

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup_Main_Linear(Context nContext, final RelativeLayout Ad_Layout,
                                                     int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        Native_Auto_Setup_Linear1(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }


    }

    public static void Native_Auto_Setup_Linear1(Context nContext, final RelativeLayout Ad_Layout,
                                                 int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();

                        if ((Butter.getSetup(Contextt)).equals("1")) {
                            Native_Auto_Setup_Linear22(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("2")) {
                            Native_Auto_Setup_Linear11111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("3")) {
                            Native_Auto_Setup_Linear1111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("4")) {
                            Native_Auto_Setup_Linear111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("5")) {
                            Native_Auto_Setup_Linear11(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("6")) {
                            Native_Auto_Setup_Linear2(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("7")) {
                            Native_Auto_Setup_Linear11111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }
                        if ((Butter.getSetup(Contextt)).equals("8")) {
                            Native_Auto_Setup_Linear1111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                        }

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup_Linear11(Context nContext, final RelativeLayout Ad_Layout,
                                                  int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup_Linear111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup_Linear111(Context nContext, final RelativeLayout Ad_Layout,
                                                   int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup_Linear1111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup_Linear1111(Context nContext, final RelativeLayout Ad_Layout,
                                                    int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup_Linear11111(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup_Linear11111(Context nContext, final RelativeLayout Ad_Layout,
                                                     int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN1(nContext) == 0) {

            Native_ID = Butter.getN11(nContext);

            Butter.setNN1(nContext, 1);


        } else {

            Native_ID = Butter.getN111(nContext);

            Butter.setNN1(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup_Linear2(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup_Linear2(Context nContext, final RelativeLayout Ad_Layout,
                                                 int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN2(nContext) == 0) {

            Native_ID = Butter.getN22(nContext);

            Butter.setNN2(nContext, 1);


        } else {

            Native_ID = Butter.getN222(nContext);

            Butter.setNN2(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup_Linear22(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup_Linear22(Context nContext, final RelativeLayout Ad_Layout,
                                                  int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN2(nContext) == 0) {

            Native_ID = Butter.getN22(nContext);

            Butter.setNN2(nContext, 1);


        } else {

            Native_ID = Butter.getN222(nContext);

            Butter.setNN2(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();
                        Native_Auto_Setup_Linear3(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_Auto_Setup_Linear3(Context nContext, final RelativeLayout Ad_Layout,
                                                 int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Butter.getNN3(nContext) == 0) {

            Native_ID = Butter.getN33(nContext);

            Butter.setNN3(nContext, 1);


        } else {

            Native_ID = Butter.getN333(nContext);

            Butter.setNN3(nContext, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);

                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);
                        LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) Ad_Layout
                                .getLayoutParams();
                        relativeParams.setMargins(0, Bottom_Ad_Margin, 0, Top_Ad_Margin);

                        Ad_Layout.setLayoutParams(relativeParams);

                        templateView.setVisibility(View.VISIBLE);
                        Ad_Layout.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Ad_Layout.removeAllViews();

                        G_Native_Type = Native_Type;

                        if (Native_Type == 2) {

                            Banner_Auto_Setup_Linear1(Ad_Layout, 4);

                        } else {

                            Banner_Auto_Setup_Linear1(Ad_Layout, 3);
                        }

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Start(Context aContext, String App_Name) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            int width = 480, Height = 800;

            final Dialog builder = new Dialog(aContext, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
            builder.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.BLACK));
            builder.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(builder.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;

            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {

                }
            });

            DisplayMetrics displayMetrics = new DisplayMetrics();
            builder.getWindow().getWindowManager().getDefaultDisplay()
                    .getMetrics(displayMetrics);

            width = displayMetrics.widthPixels;
            Height = displayMetrics.heightPixels;


            final RelativeLayout RL = new RelativeLayout(aContext);
            RL.setBackgroundColor(Color.WHITE);
            RL.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
            builder.addContentView(RL, new RelativeLayout.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT));


            Native_ID = "/6499/example/native";

            AdLoader adLoader = new AdLoader.Builder(aContext, Native_ID)
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        private ColorDrawable background;

                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            PizzaStyle styles = new
                                    PizzaStyle.Builder().withMainBackgroundColor(background).build();


                            TemplateView templateView = new TemplateView(aContext, 0);


                            templateView.setStyles(styles);
                            templateView.setNativeAd(nativeAd);

                            RL.removeAllViews();
                            RL.addView(templateView);

                            templateView.setVisibility(View.VISIBLE);


                        }

                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {


                            RL.removeAllViews();
                            Banner(RL, 4);

                        }
                    })
                    .withNativeAdOptions(new NativeAdOptions.Builder()


                            .build())
                    .build();

            adLoader.loadAd(new AdRequest.Builder().build());

            builder.show();
            builder.getWindow().setAttributes(lp);
            builder.setCancelable(false);


        }

    }

    public static void Pre_App_Open_Show(Activity currentActivity) {

        if (Exit_Menu_Decided == 5) {

            if (For_Approval <= Butter.getcount_Approval(currentActivity)) {

                Butter.setcount_Approval(currentActivity, 1);

            } else {
                Butter.setcount_Approval(currentActivity, (Butter.getcount_Approval(currentActivity) + 1));
                return;
            }


        }

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Inter_Show(currentActivity);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Inter_Show(currentActivity);
            return;
        }

        if (Exit_Menu_Decided == 100) {
            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        if ((Butter.getSetup(currentActivity)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Pre_App_Open_Show_Setup(currentActivity);

                        } else if ((Butter.getSetup(currentActivity)).equals("0")) {

                            Pre_App_Open_Show_Normal(currentActivity);

                        }

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        }


    }

    public static void Pre_App_Open_Show_Normal(Activity currentActivity) {


        if (Exit_Menu_Decided == 100) {

            return;
        }
        if (!isShowingAd && appOpenAd != null) {


            FullScreenContentCallback fullScreenContentCallback =
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {

                            appOpenAd = null;
                            isShowingAd = false;

                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {

                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            isShowingAd = true;
                        }
                    };

            appOpenAd.show(currentActivity, fullScreenContentCallback);

        }


        if (App_Open_Setup == 200) {


            if (Butter.getextra2(Contextt).equals(FB)) {
                FB_Inter_Show(Contextt);
            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Inter_Show(Contextt);
            } else {
                Max_Inter_Show(Contextt);
            }

        }


        Pre_App_Open_Load_Normal(currentActivity);

    }

    public static void Pre_App_Open_Load_Normal(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        loadCallback =
                new AppOpenAd.AppOpenAdLoadCallback() {

                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                        App_Open_Setup = 200;

                        Max_Inter(mContext);


                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, Butter.getapp_open(mContext), request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);


    }

    public static void Pre_App_Open_Load_Setup1(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        String App_Open_ID = "";

        if (Butter.getAOAO1(mContext) == 0) {

            App_Open_ID = Butter.getAO11(mContext);

            Butter.setAOAO1(mContext, 1);

        } else {

            App_Open_ID = Butter.getAO111(mContext);

            Butter.setAOAO1(mContext, 0);

        }

        loadCallback3 =
                new AppOpenAd.AppOpenAdLoadCallback() {

                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;
                        App_Open_Setup = 1;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {


                        if ((Butter.getSetup(Contextt)).equals("1")) {
                            Pre_App_Open_Load_Setup22(mContext);
                        }
                        if ((Butter.getSetup(Contextt)).equals("2")) {
                            Pre_App_Open_Load_Setup11111(mContext);
                        }
                        if ((Butter.getSetup(Contextt)).equals("3")) {
                            Pre_App_Open_Load_Setup1111(mContext);
                        }
                        if ((Butter.getSetup(Contextt)).equals("4")) {
                            Pre_App_Open_Load_Setup111(mContext);
                        }
                        if ((Butter.getSetup(Contextt)).equals("5")) {
                            Pre_App_Open_Load_Setup11(mContext);
                        }
                        if ((Butter.getSetup(Contextt)).equals("6")) {
                            Pre_App_Open_Load_Setup2(mContext);
                        }
                        if ((Butter.getSetup(Contextt)).equals("7")) {
                            Pre_App_Open_Load_Setup11111(mContext);
                        }
                        if ((Butter.getSetup(Contextt)).equals("8")) {
                            Pre_App_Open_Load_Setup1111(mContext);
                        }

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback3);


    }

    public static void Pre_App_Open_Load_Setup11(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        String App_Open_ID = "";

        if (Butter.getAOAO1(mContext) == 0) {

            App_Open_ID = Butter.getAO11(mContext);

            Butter.setAOAO1(mContext, 1);

        } else {

            App_Open_ID = Butter.getAO111(mContext);

            Butter.setAOAO1(mContext, 0);

        }

        loadCallback3 =
                new AppOpenAd.AppOpenAdLoadCallback() {

                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;
                        App_Open_Setup = 11;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                        Pre_App_Open_Load_Setup111(mContext);

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback3);


    }

    public static void Pre_App_Open_Load_Setup111(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        String App_Open_ID = "";

        if (Butter.getAOAO1(mContext) == 0) {

            App_Open_ID = Butter.getAO11(mContext);

            Butter.setAOAO1(mContext, 1);

        } else {

            App_Open_ID = Butter.getAO111(mContext);

            Butter.setAOAO1(mContext, 0);

        }

        loadCallback3 =
                new AppOpenAd.AppOpenAdLoadCallback() {

                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;
                        App_Open_Setup = 111;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                        Pre_App_Open_Load_Setup1111(mContext);

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback3);


    }

    public static void Pre_App_Open_Load_Setup1111(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        String App_Open_ID = "";

        if (Butter.getAOAO1(mContext) == 0) {

            App_Open_ID = Butter.getAO11(mContext);

            Butter.setAOAO1(mContext, 1);

        } else {

            App_Open_ID = Butter.getAO111(mContext);

            Butter.setAOAO1(mContext, 0);

        }

        loadCallback3 =
                new AppOpenAd.AppOpenAdLoadCallback() {

                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;
                        App_Open_Setup = 1111;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                        Pre_App_Open_Load_Setup11111(mContext);

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback3);


    }

    public static void Pre_App_Open_Load_Setup11111(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        String App_Open_ID = "";

        if (Butter.getAOAO1(mContext) == 0) {

            App_Open_ID = Butter.getAO11(mContext);

            Butter.setAOAO1(mContext, 1);

        } else {

            App_Open_ID = Butter.getAO111(mContext);

            Butter.setAOAO1(mContext, 0);

        }

        loadCallback3 =
                new AppOpenAd.AppOpenAdLoadCallback() {

                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;
                        App_Open_Setup = 11111;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                        Pre_App_Open_Load_Setup2(mContext);

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback3);


    }

    public static void Pre_App_Open_Load_Setup2(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        String App_Open_ID = "";

        if (Butter.getAOAO2(mContext) == 0) {

            App_Open_ID = Butter.getAO22(mContext);

            Butter.setAOAO2(mContext, 1);

        } else {

            App_Open_ID = Butter.getAO222(mContext);

            Butter.setAOAO2(mContext, 0);

        }

        loadCallback2 =
                new AppOpenAd.AppOpenAdLoadCallback() {


                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;

                        App_Open_Setup = 2;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                        Pre_App_Open_Load_Setup22(mContext);

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback2);


    }

    public static void Pre_App_Open_Load_Setup22(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        String App_Open_ID = "";

        if (Butter.getAOAO2(mContext) == 0) {

            App_Open_ID = Butter.getAO22(mContext);

            Butter.setAOAO2(mContext, 1);

        } else {

            App_Open_ID = Butter.getAO222(mContext);

            Butter.setAOAO2(mContext, 0);

        }

        loadCallback2 =
                new AppOpenAd.AppOpenAdLoadCallback() {


                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;

                        App_Open_Setup = 22;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                        Pre_App_Open_Load_Setup3(mContext);

                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback2);


    }

    public static void Pre_App_Open_Load_Setup3(Context mContext) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (appOpenAd != null) {
            return;
        }

        String App_Open_ID = "";

        if (Butter.getAOAO3(mContext) == 0) {

            App_Open_ID = Butter.getAO33(mContext);

            Butter.setAOAO3(mContext, 1);

        } else {

            App_Open_ID = Butter.getAO333(mContext);

            Butter.setAOAO3(mContext, 0);

        }

        loadCallback1 =
                new AppOpenAd.AppOpenAdLoadCallback() {


                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        appOpenAd = ad;

                        App_Open_Setup = 3;

                    }


                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                        App_Open_Setup = 200;

                        Max_Inter(mContext);


                    }

                };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(
                mContext, App_Open_ID, request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback1);


    }

    public static void Pre_App_Open_Show_Setup(Activity currentActivity) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (App_Open_Setup == 1 ||
                App_Open_Setup == 11 ||
                App_Open_Setup == 111 ||
                App_Open_Setup == 1111 ||
                App_Open_Setup == 11111 ||
                App_Open_Setup == 2 ||
                App_Open_Setup == 22 ||
                App_Open_Setup == 3) {

            if (!isShowingAd && appOpenAd != null) {


                FullScreenContentCallback fullScreenContentCallback3 =
                        new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {

                                appOpenAd = null;
                                isShowingAd = false;
                                Pre_App_Open_Load_Setup1(currentActivity);
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                isShowingAd = true;
                            }
                        };

                appOpenAd.show(currentActivity, fullScreenContentCallback3);

            }

        }

        if (App_Open_Setup == 200) {

            Pre_App_Open_Load_Setup1(currentActivity);

            if (Butter.getextra2(Contextt).equals(FB)) {
                FB_Inter_Show(Contextt);
            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Inter_Show(Contextt);
            } else {
                Max_Inter_Show(Contextt);
            }

        }

        if (App_Open_Setup == 0) {

            Pre_App_Open_Load_Setup1(currentActivity);
            if (tappxInterstitial_preload != null)
                tappxInterstitial_preload.show();
        }


    }

    public static void Reward_Inter_Show(Activity mContext, String title, String description, int Popupmenu_Type) {

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Inter_Reward(mContext, title, description, Popupmenu_Type);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Inter_Reward(mContext, title, description, Popupmenu_Type);
            return;
        }

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((Butter.getSetup(mContext)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {

            CustomProgressDialogue progressDialog = new CustomProgressDialogue(mContext, Popupmenu_Type, title, description);

            progressDialog.show();

            Reward_Inter_Show_Setup1(mContext, title, description, Popupmenu_Type, progressDialog);


        } else if ((Butter.getSetup(mContext)).equals("0")) {

            Reward_Inter_Show_Normal(mContext, title, description, Popupmenu_Type);

        }

    }

    public static void Reward_Inter_Show_Normal(Activity mContext, String title, String description, int Popupmenu_Type) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        CustomProgressDialogue progressDialog = new CustomProgressDialogue(mContext, Popupmenu_Type, title, description);

        progressDialog.show();

        RewardedInterstitialAd.load(mContext, Butter.getinter_reward(mContext),
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 1000);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;


                        if (Butter.getextra2(Contextt).equals(FB)) {
                            FB_Inter_Reward(mContext, title, description, Popupmenu_Type);
                        } else if (Butter.getextra2(Contextt).equals(AL)) {
                            Max_Inter_Reward(mContext, title, description, Popupmenu_Type);
                        } else {
                            Max_Inter_Reward(mContext, title, description, Popupmenu_Type);
                        }

                        progressDialog.dismiss();


                    }
                });


    }

    public static void Reward_Inter_Show_Setup1(Activity mContext, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;

                        if ((Butter.getSetup(Contextt)).equals("1")) {
                            Reward_Inter_Show_Setup22(mContext, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("2")) {
                            Reward_Inter_Show_Setup11111(mContext, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("3")) {
                            Reward_Inter_Show_Setup1111(mContext, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("4")) {
                            Reward_Inter_Show_Setup111(mContext, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("5")) {
                            Reward_Inter_Show_Setup11(mContext, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("6")) {
                            Reward_Inter_Show_Setup2(mContext, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("7")) {
                            Reward_Inter_Show_Setup11111(mContext, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("8")) {
                            Reward_Inter_Show_Setup1111(mContext, title, description, Popupmenu_Type, progressDialog);
                        }

                    }
                });


    }

    public static void Reward_Inter_Show_Setup11(Activity mContext, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        Reward_Inter_Show_Setup111(mContext, title, description, Popupmenu_Type, progressDialog);
                    }
                });


    }

    public static void Reward_Inter_Show_Setup111(Activity mContext, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        Reward_Inter_Show_Setup1111(mContext, title, description, Popupmenu_Type, progressDialog);
                    }
                });


    }

    public static void Reward_Inter_Show_Setup1111(Activity mContext, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        Reward_Inter_Show_Setup11111(mContext, title, description, Popupmenu_Type, progressDialog);
                    }
                });


    }

    public static void Reward_Inter_Show_Setup11111(Activity mContext, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        Reward_Inter_Show_Setup2(mContext, title, description, Popupmenu_Type, progressDialog);
                    }
                });


    }

    public static void Reward_Inter_Show_Setup2(Activity mContext, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD2(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD22(mContext);

            Butter.setIIRRDD2(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD222(mContext);

            Butter.setIIRRDD2(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                progressDialog.dismiss();


                            }

                        }, 1000);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        Reward_Inter_Show_Setup22(mContext, title, description, Popupmenu_Type, progressDialog);
                    }
                });


    }

    public static void Reward_Inter_Show_Setup22(Activity mContext, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD2(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD22(mContext);

            Butter.setIIRRDD2(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD222(mContext);

            Butter.setIIRRDD2(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                progressDialog.dismiss();


                            }

                        }, 1000);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;
                        Reward_Inter_Show_Setup3(mContext, title, description, Popupmenu_Type, progressDialog);
                    }
                });


    }

    public static void Reward_Inter_Show_Setup3(Activity mContext, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD3(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD33(mContext);

            Butter.setIIRRDD3(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD333(mContext);

            Butter.setIIRRDD3(mContext, 0);


        }


        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                new AdRequest.Builder().build(), new RewardedInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(RewardedInterstitialAd ad) {


                        rewardedInterstitialAd = ad;

                        rewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                progressDialog.dismiss();


                            }

                        }, 1000);


                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        rewardedInterstitialAd = null;


                        if (Butter.getextra2(Contextt).equals(FB)) {
                            FB_Inter_Reward(mContext, title, description, Popupmenu_Type);
                        } else if (Butter.getextra2(Contextt).equals(AL)) {
                            Max_Inter_Reward(mContext, title, description, Popupmenu_Type);
                        } else {
                            Max_Inter_Reward(mContext, title, description, Popupmenu_Type);
                        }

                        progressDialog.dismiss();
                    }
                });


    }

    public static void Reward_Inter_Show_with_Dialog(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type) {

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
            return;
        }

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((Butter.getSetup(mContext)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {

            CustomProgressDialogue progressDialog = new CustomProgressDialogue(mContext, Popupmenu_Type, title, description);

            new FancyGifDialog.Builder(mContext)
                    .setTitle(title)
                    .setMessage(description)
                    .setTitleTextColor(R.color.titleText)
                    .setDescriptionTextColor(R.color.descriptionText)
                    .setNegativeBtnText("Close")
                    .setPositiveBtnBackground(R.color.positiveButton)
                    .setPositiveBtnText("Watch Now (Ad)")
                    .setNegativeBtnBackground(R.color.positiveButton)
                    .setGifResource(R.drawable.ad1)
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            progressDialog.show();
                            Reward_Inter_Show_with_Dialog_Setup1(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                        }
                    })
                    .OnNegativeClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {


                        }
                    })
                    .build();


        } else if ((Butter.getSetup(mContext)).equals("0")) {

            Reward_Inter_Show_with_Dialog_Normal(mContext, onRewardgetListner, title, description, Popupmenu_Type);

        }

    }

    public static void Reward_Inter_Show_with_Dialog_Normal(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        CustomProgressDialogue progressDialog = new CustomProgressDialogue(mContext, Popupmenu_Type, title, description);


        new FancyGifDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(description)
                .setTitleTextColor(R.color.titleText)
                .setDescriptionTextColor(R.color.descriptionText)
                .setNegativeBtnText("Close")
                .setPositiveBtnBackground(R.color.positiveButton)
                .setPositiveBtnText("Watch Now (Ad)")
                .setNegativeBtnBackground(R.color.positiveButton)
                .setGifResource(R.drawable.ad1)
                .isCancellable(true)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {


                        progressDialog.show();

                        AdRequest adRequest = new AdRequest.Builder().build();
                        RewardedInterstitialAd.load(mContext, Butter.getinter_reward(mContext),
                                adRequest, new RewardedInterstitialAdLoadCallback() {
                                    @Override
                                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                                        mrewardedInterstitialAd = null;


                                        if (Butter.getextra2(Contextt).equals(FB)) {
                                            FB_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                                        } else if (Butter.getextra2(Contextt).equals(AL)) {
                                            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                                        } else {
                                            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                                        }


                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                                        super.onAdLoaded(rewardedInterstitialAd);

                                        mrewardedInterstitialAd = rewardedInterstitialAd;

                                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                                            @Override
                                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                                onRewardgetListner.OnReward(true);
                                            }
                                        });


                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {


                                                progressDialog.dismiss();


                                            }

                                        }, 500);
                                    }


                                });

                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {


                    }
                })
                .build();


    }

    public static void Reward_Inter_Show_with_Dialog_Setup1(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mrewardedInterstitialAd = null;

                        if ((Butter.getSetup(Contextt)).equals("1")) {
                            Reward_Inter_Show_with_Dialog_Setup22(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("2")) {
                            Reward_Inter_Show_with_Dialog_Setup11111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("3")) {
                            Reward_Inter_Show_with_Dialog_Setup1111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("4")) {
                            Reward_Inter_Show_with_Dialog_Setup111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("5")) {
                            Reward_Inter_Show_with_Dialog_Setup11(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("6")) {
                            Reward_Inter_Show_with_Dialog_Setup2(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("7")) {
                            Reward_Inter_Show_with_Dialog_Setup11111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("8")) {
                            Reward_Inter_Show_with_Dialog_Setup1111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }

                    }


                });


    }

    public static void Reward_Inter_Show_with_Dialog_Setup11(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mrewardedInterstitialAd = null;

                        Reward_Inter_Show_with_Dialog_Setup111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                    }


                });


    }

    public static void Reward_Inter_Show_with_Dialog_Setup111(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mrewardedInterstitialAd = null;

                        Reward_Inter_Show_with_Dialog_Setup1111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                    }


                });


    }

    public static void Reward_Inter_Show_with_Dialog_Setup1111(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mrewardedInterstitialAd = null;

                        Reward_Inter_Show_with_Dialog_Setup11111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                    }


                });


    }

    public static void Reward_Inter_Show_with_Dialog_Setup11111(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD1(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD11(mContext);

            Butter.setIIRRDD1(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD111(mContext);

            Butter.setIIRRDD1(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mrewardedInterstitialAd = null;

                        Reward_Inter_Show_with_Dialog_Setup2(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                    }


                });


    }

    public static void Reward_Inter_Show_with_Dialog_Setup2(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD2(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD22(mContext);

            Butter.setIIRRDD2(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD222(mContext);

            Butter.setIIRRDD2(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mrewardedInterstitialAd = null;


                        Reward_Inter_Show_with_Dialog_Setup22(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }


                });


    }

    public static void Reward_Inter_Show_with_Dialog_Setup22(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD2(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD22(mContext);

            Butter.setIIRRDD2(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD222(mContext);

            Butter.setIIRRDD2(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mrewardedInterstitialAd = null;


                        Reward_Inter_Show_with_Dialog_Setup3(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }


                });


    }

    public static void Reward_Inter_Show_with_Dialog_Setup3(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {


        String Inter_Reward_Ad_ID;

        if (Butter.getIIRRDD3(mContext) == 0) {

            Inter_Reward_Ad_ID = Butter.getIRD33(mContext);

            Butter.setIIRRDD3(mContext, 1);


        } else {

            Inter_Reward_Ad_ID = Butter.getIRD333(mContext);

            Butter.setIIRRDD3(mContext, 0);


        }

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedInterstitialAd.load(mContext, Inter_Reward_Ad_ID,
                adRequest, new RewardedInterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                        super.onAdLoaded(rewardedInterstitialAd);

                        mrewardedInterstitialAd = rewardedInterstitialAd;

                        mrewardedInterstitialAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                onRewardgetListner.OnReward(true);
                            }
                        });


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mrewardedInterstitialAd = null;


                        if (Butter.getextra2(Contextt).equals(FB)) {
                            FB_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                        } else if (Butter.getextra2(Contextt).equals(AL)) {
                            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                        } else {
                            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                        }


                        progressDialog.dismiss();
                    }


                });


    }


    public static void Reward(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type) {

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
            return;
        }

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((Butter.getSetup(mContext)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {

            CustomProgressDialogue progressDialog = new CustomProgressDialogue(mContext, Popupmenu_Type, title, description);

            new FancyGifDialog.Builder(mContext)
                    .setTitle(title)
                    .setMessage(description)
                    .setTitleTextColor(R.color.titleText)
                    .setDescriptionTextColor(R.color.descriptionText)
                    .setNegativeBtnText("Close")
                    .setPositiveBtnBackground(R.color.positiveButton)
                    .setPositiveBtnText("Watch Now (Ad)")
                    .setNegativeBtnBackground(R.color.positiveButton)
                    .setGifResource(R.drawable.ad1)
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {

                            progressDialog.show();

                            Reward_Setup1(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);

                        }
                    })
                    .OnNegativeClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {


                        }
                    })
                    .build();


        } else if ((Butter.getSetup(mContext)).equals("0")) {

            Reward_Normal(mContext, onRewardgetListner, title, description, Popupmenu_Type);

        }

    }

    public static void Reward_Normal(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        CustomProgressDialogue progressDialog = new CustomProgressDialogue(mContext, Popupmenu_Type, title, description);


        new FancyGifDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(description)
                .setTitleTextColor(R.color.titleText)
                .setDescriptionTextColor(R.color.descriptionText)
                .setNegativeBtnText("Close")
                .setPositiveBtnBackground(R.color.positiveButton)
                .setPositiveBtnText("Watch Now (Ad)")
                .setNegativeBtnBackground(R.color.positiveButton)
                .setGifResource(R.drawable.ad1)
                .isCancellable(true)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {


                        progressDialog.show();

                        AdRequest adRequest = new AdRequest.Builder().build();
                        RewardedAd.load(mContext, Butter.getreward(mContext),
                                adRequest, new RewardedAdLoadCallback() {
                                    @Override
                                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                                        mRewardedAd = null;


                                        if (Butter.getextra2(Contextt).equals(FB)) {
                                            FB_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                                        } else if (Butter.getextra2(Contextt).equals(AL)) {
                                            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                                        } else {
                                            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                                        }


                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                        mRewardedAd = rewardedAd;


                                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                                            @Override
                                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                                onRewardgetListner.OnReward(true);


                                            }
                                        });

                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {


                                                progressDialog.dismiss();


                                            }

                                        }, 500);


                                    }

                                });

                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {


                    }
                })
                .build();


    }

    public static void Reward_Setup1(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (Butter.getRRDD1(mContext) == 0) {

            Reward_Ad_ID = Butter.getRD11(mContext);

            Butter.setRRDD1(mContext, 1);


        } else {

            Reward_Ad_ID = Butter.getRD111(mContext);

            Butter.setRRDD1(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mRewardedAd = null;

                        if ((Butter.getSetup(Contextt)).equals("1")) {
                            Reward_Setup22(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("2")) {
                            Reward_Setup11111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("3")) {
                            Reward_Setup1111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("4")) {
                            Reward_Setup111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("5")) {
                            Reward_Setup11(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("6")) {
                            Reward_Setup2(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("7")) {
                            Reward_Setup11111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }
                        if ((Butter.getSetup(Contextt)).equals("8")) {
                            Reward_Setup1111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                        }

                    }

                });


    }

    public static void Reward_Setup11(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (Butter.getRRDD1(mContext) == 0) {

            Reward_Ad_ID = Butter.getRD11(mContext);

            Butter.setRRDD1(mContext, 1);


        } else {

            Reward_Ad_ID = Butter.getRD111(mContext);

            Butter.setRRDD1(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mRewardedAd = null;
                        Reward_Setup111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }

                });


    }

    public static void Reward_Setup111(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (Butter.getRRDD1(mContext) == 0) {

            Reward_Ad_ID = Butter.getRD11(mContext);

            Butter.setRRDD1(mContext, 1);


        } else {

            Reward_Ad_ID = Butter.getRD111(mContext);

            Butter.setRRDD1(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mRewardedAd = null;
                        Reward_Setup1111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }

                });


    }

    public static void Reward_Setup1111(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (Butter.getRRDD1(mContext) == 0) {

            Reward_Ad_ID = Butter.getRD11(mContext);

            Butter.setRRDD1(mContext, 1);


        } else {

            Reward_Ad_ID = Butter.getRD111(mContext);

            Butter.setRRDD1(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mRewardedAd = null;
                        Reward_Setup11111(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }

                });


    }

    public static void Reward_Setup11111(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (Butter.getRRDD1(mContext) == 0) {

            Reward_Ad_ID = Butter.getRD11(mContext);

            Butter.setRRDD1(mContext, 1);


        } else {

            Reward_Ad_ID = Butter.getRD111(mContext);

            Butter.setRRDD1(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mRewardedAd = null;
                        Reward_Setup2(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }

                });


    }

    public static void Reward_Setup2(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (Butter.getRRDD2(mContext) == 0) {

            Reward_Ad_ID = Butter.getRD22(mContext);

            Butter.setRRDD2(mContext, 1);


        } else {

            Reward_Ad_ID = Butter.getRD222(mContext);

            Butter.setRRDD2(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mRewardedAd = null;
                        Reward_Setup22(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }

                });


    }

    public static void Reward_Setup22(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (Butter.getRRDD2(mContext) == 0) {

            Reward_Ad_ID = Butter.getRD22(mContext);

            Butter.setRRDD2(mContext, 1);


        } else {

            Reward_Ad_ID = Butter.getRD222(mContext);

            Butter.setRRDD2(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mRewardedAd = null;
                        Reward_Setup3(mContext, onRewardgetListner, title, description, Popupmenu_Type, progressDialog);
                    }

                });


    }

    public static void Reward_Setup3(Activity mContext, OnRewardgetListner onRewardgetListner, String title, String description, int Popupmenu_Type, CustomProgressDialogue progressDialog) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        String Reward_Ad_ID;

        if (Butter.getRRDD3(mContext) == 0) {

            Reward_Ad_ID = Butter.getRD33(mContext);

            Butter.setRRDD3(mContext, 1);


        } else {

            Reward_Ad_ID = Butter.getRD333(mContext);

            Butter.setRRDD3(mContext, 0);


        }


        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(mContext, Reward_Ad_ID,
                adRequest, new RewardedAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.show(mContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                                onRewardgetListner.OnReward(true);


                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();

                            }

                        }, 500);


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        mRewardedAd = null;


                        if (Butter.getextra2(Contextt).equals(FB)) {
                            FB_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                        } else if (Butter.getextra2(Contextt).equals(AL)) {
                            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                        } else {
                            Max_Reward(mContext, onRewardgetListner, title, description, Popupmenu_Type);
                        }


                        progressDialog.dismiss();
                    }

                });


    }

    public static void Exit(Context aContext) {

        Exit("Do you want to exit ?", aContext,
                "" + aContext.getString(R.string.app_name));

    }

    @SuppressLint({"InflateParams", "InlinedApi"})
    public static void Exit(String Description, final Context context, String App_Name) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.exitt);

        TextView text = (TextView) dialog.findViewById(R.id.title);
        text.setText(Description);

        RelativeLayout Exit_Ads = (RelativeLayout) dialog.findViewById(R.id.banner);

        Button Btn_Yes = (Button) dialog.findViewById(R.id.Btn_Yes);
        Button Btn_Rate = (Button) dialog.findViewById(R.id.Btn_Rate);
        Button Btn_No = (Button) dialog.findViewById(R.id.Btn_No);

        Btn_Yes.setText("Yes");
        Btn_Rate.setText("Rate Us");
        Btn_No.setText("No");

        Btn_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ((Activity) context).moveTaskToBack(true);
                ((Activity) context).finish();
            }
        });
        Btn_Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id="
                        + Packages);
                Intent goToMarket = new Intent(
                        Intent.ACTION_VIEW, uri);

                goToMarket
                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
                                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    context.startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/OneForAll/apps/details?id="
                                    + Packages)));
                }
            }
        });
        Btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

    public static void Tappx_Inter(final Context context) {

        if (isNetworkConnected(Contextt) == true) {

            tappxInterstitial = new TappxInterstitial(context,
                    Butter.gettx(Contextt));
            tappxInterstitial.loadAd();
            tappxInterstitial.setListener(new TappxInterstitialListener() {
                @Override
                public void onInterstitialLoaded(
                        TappxInterstitial tappxInterstitial) {

                    tappxInterstitial.show();

                    try {
                        Ad_ProgressDialog.dismiss();
                    } catch (Exception e) {
                    }


                    Butter.setsplashcount(context,
                            (Butter.getsplashcount(context) + 1));
                }

                @Override
                public void onInterstitialLoadFailed(
                        TappxInterstitial tappxInterstitial,
                        TappxAdError tappxAdError) {

                    if ((new Random().nextInt((2 - 1) + 1) + 1) == 1) {
                        SO = SO_FULLPAGE;
                    } else {
                        SO = SO_OFFERWALL;
                    }
                    startAppAd.loadAd(SO, new AdEventListener() {
                        @Override
                        public void onReceiveAd(Ad ad) {

                            startAppAd.showAd();
                            try {
                                Ad_ProgressDialog.dismiss();
                            } catch (Exception e) {
                            }

                        }

                        @Override
                        public void onFailedToReceiveAd(Ad ad) {
                            try {
                                Ad_ProgressDialog.dismiss();
                            } catch (Exception e) {
                            }
                        }

                    });

                }

                @Override
                public void onInterstitialClicked(TappxInterstitial arg0) {


                }

                @Override
                public void onInterstitialDismissed(TappxInterstitial arg0) {


                }

                @Override
                public void onInterstitialShown(TappxInterstitial arg0) {


                }

            });

        }

    }

    @SuppressLint("SetTextI18n")
    public static void Exit_With_Ads_Banner(final Context context) {


        final int Banner_Type = 4;

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Exit_Popup_With_Ads_Banner(context, Banner_Type);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            Exit_Popup_With_Ads_Banner(context, Banner_Type);
            return;
        }

        if (Exit_Menu_Decided == 0) {

            onBackPressed(context);

        } else if (Exit_Menu_Decided == 1) {

            Exit("Do You Want To Exit ?", context,
                    "" + context.getString(R.string.app_name));

        } else if (Exit_Menu_Decided == 2) {

            Exit_Popup_With_Ads_Banner(context, Banner_Type);

        } else if (Exit_Menu_Decided == 3) {

            Exit("Do You Want To Exit ?", context,
                    "" + context.getString(R.string.app_name));

        } else if (Exit_Menu_Decided == 4) {

            Exit_Popup_With_Ads_Banner(context, Banner_Type);

        } else {

            onBackPressed(context);

        }

    }

    public static void Exit_Popup_With_Ads_Banner(final Context context, final int Banner_Type) {

        String Description = "Do You Want To Exit ?";

        final Dialog dialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.exitt);

        TextView text = (TextView) dialog.findViewById(R.id.title);
        text.setText(Description);

        gifImageView = (GifImageView) dialog.findViewById(R.id.gifImageView);

        RelativeLayout Exit_Ads = (RelativeLayout) dialog.findViewById(R.id.banner);

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Native_Exit(context, Exit_Ads, 2, 0, 0, 0);
        } else if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Native_Exit(context, Exit_Ads, 2, 0, 0, 0);
        } else {
            Banner_Back_Setup1(Exit_Ads, Banner_Type);
        }


        Button Btn_Yes = (Button) dialog.findViewById(R.id.Btn_Yes);
        Button Btn_Rate = (Button) dialog.findViewById(R.id.Btn_Rate);
        Button Btn_No = (Button) dialog.findViewById(R.id.Btn_No);

        Btn_Yes.setText("Yes");
        Btn_Rate.setText("Rate Us");
        Btn_No.setText("No");

        Btn_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ((Activity) context).moveTaskToBack(true);
                ((Activity) context).finish();
            }
        });
        Btn_Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id="
                        + Packages);
                Intent goToMarket = new Intent(
                        Intent.ACTION_VIEW, uri);

                goToMarket
                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
                                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    context.startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/OneForAll/apps/details?id="
                                    + Packages)));
                }
            }
        });
        Btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

    public static void Banner_Back_Setup1(final RelativeLayout Ad_Layout, final int Banner_Type) {


        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        AdSize Banner_Type_Size = null;

                        if (Banner_Type == 1) {

                            Banner_Type_Size = AdSize.BANNER;

                        } else if (Banner_Type == 2) {

                            Banner_Type_Size = AdSize.LARGE_BANNER;

                        } else if (Banner_Type == 3) {

                            Banner_Type_Size = AdSize.LARGE_BANNER;

                        } else if (Banner_Type == 4) {

                            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

                        } else {

                            Banner_Type_Size = AdSize.BANNER;

                        }

                        if ((Butter.getSetup(Contextt)).equals("1")) {


                            if (Butter.getBB1(Contextt) == 0) {

                                Banner = Butter.getB11(Contextt);

                                Butter.setBB1(Contextt, 1);

                            } else {

                                Banner = Butter.getB111(Contextt);

                                Butter.setBB1(Contextt, 0);

                            }
                        } else if ((Butter.getSetup(Contextt)).equals("0")) {


                            if (Butter.getbanner(Contextt) == 0) {

                                Banner = Butter.getbanner1(Contextt);

                                Butter.setbanner(Contextt, 1);

                            } else {

                                Banner = Butter.getbanner2(Contextt);

                                Butter.setbanner(Contextt, 0);

                            }

                        }

                        mAdView = new AdView(Contextt);
                        mAdView.setAdSize(Banner_Type_Size);
                        mAdView.setAdUnitId(Banner);
                        AdRequest adore = new AdRequest.Builder().build();
                        mAdView.loadAd(adore);
                        Ad_Layout.addView(mAdView);

                        mAdView.setAdListener(new AdListener() {

                            @Override
                            public void onAdLoaded() {


                                Ad_Layout.setVisibility(View.VISIBLE);
                                gifImageView.setVisibility(View.GONE);
                                Butter.setsplashcount(Contextt, 0);

                                super.onAdLoaded();

                            }

                            @Override
                            public void onAdFailedToLoad(int errorCode) {

                                super.onAdFailedToLoad(errorCode);

                                mAdView.destroy();

                                Banner_Back_Setup2(Ad_Layout, Banner_Type);


                            }
                        });
                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public static void Banner_Back_Setup2(final RelativeLayout Ad_Layout, final int Banner_Type) {


        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }

        if ((Butter.getSetup(Contextt)).equals("1")) {


            if (Butter.getBB2(Contextt) == 0) {

                Banner = Butter.getB22(Contextt);

                Butter.setBB2(Contextt, 1);

            } else {

                Banner = Butter.getB222(Contextt);

                Butter.setBB2(Contextt, 0);

            }

        } else if ((Butter.getSetup(Contextt)).equals("0")) {


            if (Butter.getbanner(Contextt) == 0) {

                Banner = Butter.getbanner1(Contextt);

                Butter.setbanner(Contextt, 1);

            } else {

                Banner = Butter.getbanner2(Contextt);

                Butter.setbanner(Contextt, 0);

            }

        }

        mAdView = new AdView(Contextt);
        mAdView.setAdSize(Banner_Type_Size);
        mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView.loadAd(adore);
        Ad_Layout.addView(mAdView);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);
                gifImageView.setVisibility(View.GONE);

                Butter.setsplashcount(Contextt, 0);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView.destroy();

                Banner_Back_Setup3(Ad_Layout, Banner_Type);


            }
        });


    }

    public static void Banner_Back_Setup3(final RelativeLayout Ad_Layout, final int Banner_Type) {


        AdSize Banner_Type_Size = null;

        if (Banner_Type == 1) {

            Banner_Type_Size = AdSize.BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 3) {

            Banner_Type_Size = AdSize.LARGE_BANNER;

        } else if (Banner_Type == 4) {

            Banner_Type_Size = AdSize.MEDIUM_RECTANGLE;

        } else {

            Banner_Type_Size = AdSize.BANNER;

        }


        if ((Butter.getSetup(Contextt)).equals("1")) {


            if (Butter.getBB3(Contextt) == 0) {

                Banner = Butter.getB33(Contextt);

                Butter.setBB3(Contextt, 1);

            } else {

                Banner = Butter.getB333(Contextt);

                Butter.setBB3(Contextt, 0);

            }

        } else if ((Butter.getSetup(Contextt)).equals("0")) {


            if (Butter.getbanner(Contextt) == 0) {

                Banner = Butter.getbanner1(Contextt);

                Butter.setbanner(Contextt, 1);

            } else {

                Banner = Butter.getbanner2(Contextt);

                Butter.setbanner(Contextt, 0);

            }

        }

        mAdView = new AdView(Contextt);
        mAdView.setAdSize(Banner_Type_Size);
        mAdView.setAdUnitId(Banner);
        AdRequest adore = new AdRequest.Builder().build();
        mAdView.loadAd(adore);
        Ad_Layout.addView(mAdView);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {


                Ad_Layout.setVisibility(View.VISIBLE);
                gifImageView.setVisibility(View.GONE);
                Butter.setsplashcount(Contextt, 0);

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

                super.onAdFailedToLoad(errorCode);

                mAdView.destroy();
                Ad_Layout.removeAllViews();

                if (Butter.getextra2(Contextt).equals(FB)) {
                    FB_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
                } else if (Butter.getextra2(Contextt).equals(AL)) {
                    Max_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
                } else {
                    Max_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
                }


            }
        });


    }

    public static void Exit_With_Ads_Native(final Context context) {

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Exit_Popup_With_Ads_Native(context);
            return;
        }
        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            Exit_Popup_With_Ads_Native(context);
            return;
        }

        if (Exit_Menu_Decided == 0) {

            onBackPressed(context);

        } else if (Exit_Menu_Decided == 1) {

            Exit("Do You Want To Exit ?", context,
                    "" + context.getString(R.string.app_name));

        } else if (Exit_Menu_Decided == 2) {

            Exit_Popup_With_Ads_Native(context);

        } else if (Exit_Menu_Decided == 3) {

            Exit("Do You Want To Exit ?", context,
                    "" + context.getString(R.string.app_name));

        } else if (Exit_Menu_Decided == 4) {

            Exit_Popup_With_Ads_Native(context);

        } else if (Exit_Menu_Decided == 100) {

            onBackPressed(context);

        } else {

            onBackPressed(context);

        }

    }

    @SuppressLint("SetTextI18n")
    public static void Exit_Popup_With_Ads_Native(final Context context) {

        int Native_Type = 2;

        String Description = "Do You Want To Exit ?";

        final Dialog dialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setCancelable(true);
        dialog.setContentView(R.layout.exitt);

        TextView text = (TextView) dialog.findViewById(R.id.title);
        text.setText(Description);

        gifImageView = (GifImageView) dialog.findViewById(R.id.gifImageView);

        RelativeLayout Exit_Ads = (RelativeLayout) dialog.findViewById(R.id.banner);

        if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {
            Max_Native_Exit(context, Exit_Ads, Native_Type, 0, 0, 0);
        } else if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
            FB_Native_Exit(context, Exit_Ads, 2, 0, 0, 0);
        } else {
            Native_Back(context, Exit_Ads, Native_Type, 0, 0, 0);
        }


        Button Btn_Yes = (Button) dialog.findViewById(R.id.Btn_Yes);
        Button Btn_Rate = (Button) dialog.findViewById(R.id.Btn_Rate);
        Button Btn_No = (Button) dialog.findViewById(R.id.Btn_No);

        Btn_Yes.setText("Yes");
        Btn_Rate.setText("Rate Us");
        Btn_No.setText("No");

        Btn_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ((Activity) context).moveTaskToBack(true);
                ((Activity) context).finish();
            }
        });
        Btn_Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id="
                        + Packages);
                Intent goToMarket = new Intent(
                        Intent.ACTION_VIEW, uri);

                goToMarket
                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
                                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    context.startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/OneForAll/apps/details?id="
                                    + Packages)));
                }
            }
        });
        Btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

    public static void Native_Back(Context nContext, final RelativeLayout Ad_Layout, int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Exit_Menu_Decided == 100) {
            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {


                        Native_Show_Exit(Ad_Layout);

                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        } else {

            Ad_Layout.setVisibility(View.GONE);

        }

    }

    public static void Exit_Popup_With_Ads_Loading(final int Which_Native_Load) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (isNetworkConnected(Contextt) == true) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (Server_Yes_No == 1 || Server_Yes_No == 0) {

                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Native_Pre_Load_Setup1_Exit(Which_Native_Load);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Native_Pre_Load_Normal_Exit(Which_Native_Load);

                        }


                    } else {

                        handler.postDelayed(this, 500);

                    }

                }

            }, 500);

        }
    }

    public static void Native_Pre_Load_Normal_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getnative(Contextt) == 0) {

            Native_ID_Exit = Butter.getnative1(Contextt);

            Butter.setnative(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getnative2(Contextt);

            Butter.setnative(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 1;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {


                        Native_Load_Not_Exit = 200;

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup1_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID_Exit = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 1;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {


                        if ((Butter.getSetup(Contextt)).equals("1")) {
                            Native_Pre_Load_Setup22_Exit(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("2")) {
                            Native_Pre_Load_Setup11111_Exit(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("3")) {
                            Native_Pre_Load_Setup1111_Exit(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("4")) {
                            Native_Pre_Load_Setup111_Exit(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("5")) {
                            Native_Pre_Load_Setup11_Exit(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("6")) {
                            Native_Pre_Load_Setup2_Exit(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("7")) {
                            Native_Pre_Load_Setup11111_Exit(Which_Native_Load);
                        }
                        if ((Butter.getSetup(Contextt)).equals("8")) {
                            Native_Pre_Load_Setup1111_Exit(Which_Native_Load);
                        }


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup11_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID_Exit = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 11;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup111_Exit(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup111_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID_Exit = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 111;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup1111_Exit(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup1111_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID_Exit = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 1111;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup11111_Exit(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup11111_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getNN1(Contextt) == 0) {

            Native_ID_Exit = Butter.getN11(Contextt);

            Butter.setNN1(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getN111(Contextt);

            Butter.setNN1(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 11111;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup2_Exit(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup2_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getNN2(Contextt) == 0) {

            Native_ID_Exit = Butter.getN22(Contextt);

            Butter.setNN2(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getN222(Contextt);

            Butter.setNN2(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 2;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup22_Exit(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup22_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getNN2(Contextt) == 0) {

            Native_ID_Exit = Butter.getN22(Contextt);

            Butter.setNN2(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getN222(Contextt);

            Butter.setNN2(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 2;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                        Native_Pre_Load_Setup3_Exit(Which_Native_Load);

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Pre_Load_Setup3_Exit(final int Which_Native_Load) {

        Which_Native_Exit = Which_Native_Load;

        if (Butter.getNN3(Contextt) == 0) {

            Native_ID_Exit = Butter.getN33(Contextt);

            Butter.setNN3(Contextt, 1);


        } else {

            Native_ID_Exit = Butter.getN333(Contextt);

            Butter.setNN3(Contextt, 0);


        }

        AdLoader adLoader = new AdLoader.Builder(Contextt, Native_ID_Exit)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        Pre_Load_Native_templateView_Exit = new TemplateView(Contextt, Which_Native_Load);

                        Pre_Load_Native_templateView_Exit.setStyles(styles);
                        Pre_Load_Native_templateView_Exit.setNativeAd(nativeAd);
                        Pre_Load_Native_templateView_Exit.setVisibility(View.VISIBLE);

                        Native_Load_Not_Exit = 3;


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {


                        Native_Load_Not_Exit = 200;

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()

                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Pre_Banner_Load_Tappx_Normal_For_Native_Exit(int Which_Native_Load) {

        Pre_Tappxbanner_Exit = new TappxBanner(Contextt, Butter.gettx(Contextt));


        Pre_Tappxbanner_Exit
                .setAdSize(TappxBanner.AdSize.BANNER_300x250);


        Pre_Tappxbanner_Exit.loadAd();
        Pre_Tappxbanner_Exit.setRefreshTimeSeconds(30);

        Pre_Tappxbanner_Exit.setListener(new TappxBannerListener() {
            @Override
            public void onBannerLoaded(TappxBanner tappxBanner) {

                Butter.setsplashcount(Contextt,
                        (Butter.getsplashcount(Contextt) + 1));

                Native_Load_Not_Exit = 0;

            }

            @Override
            public void onBannerLoadFailed(TappxBanner tappxBanner,
                                           TappxAdError tappxAdError) {


            }

            @Override
            public void onBannerClicked(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerExpanded(TappxBanner tappxBanner) {

            }

            @Override
            public void onBannerCollapsed(TappxBanner tappxBanner) {

            }
        });

    }

    public static void Native_Show_Normal_Exit(final RelativeLayout Ad_Layout) {

        if (Native_Load_Not_Exit == 1) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Normal_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not_Exit == 0) {

            if (Pre_Tappxbanner_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Tappxbanner_Exit);
                    Native_Pre_Load_Normal_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not_Exit == 200) {


            if (Butter.getextra2(Contextt).equals(FB)) {
                FB_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
            } else {
                Max_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
            }

        }

    }

    public static void Native_Show_Setup_Exit(final RelativeLayout Ad_Layout) {

        if (Native_Load_Not_Exit == 1) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }
        if (Native_Load_Not_Exit == 11) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }
        if (Native_Load_Not_Exit == 111) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }
        if (Native_Load_Not_Exit == 1111) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }
        if (Native_Load_Not_Exit == 11111) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not_Exit == 2) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not_Exit == 22) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not_Exit == 3) {

            if (Pre_Load_Native_templateView_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Load_Native_templateView_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not_Exit == 0) {

            if (Pre_Tappxbanner_Exit != null) {


                try {

                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.VISIBLE);
                    gifImageView.setVisibility(View.GONE);
                    Ad_Layout.addView(Pre_Tappxbanner_Exit);
                    Native_Pre_Load_Setup1_Exit(Which_Native_Exit);

                } catch (Exception e) {

                }


            }
        }

        if (Native_Load_Not_Exit == 200) {

            if (Butter.getextra2(Contextt).equals(FB)) {
                FB_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
            } else {
                Max_Native_Exit(Contextt, Ad_Layout, 2, 0, 0, 0);
            }
        }


    }

    public static void Native_Show_Exit(final RelativeLayout Ad_Layout) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((Butter.getSetup(Contextt)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {

            Native_Show_Setup_Exit(Ad_Layout);

        } else if ((Butter.getSetup(Contextt)).equals("0")) {

            Native_Show_Normal_Exit(Ad_Layout);

        }


    }

    public static void Native_Back_Setup1(Context nContext, final RelativeLayout Ad_Layout, int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if ((Butter.getSetup(Contextt)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {


            if (Butter.getNN1(nContext) == 0) {

                Native_ID = Butter.getN11(nContext);

                Butter.setNN1(nContext, 1);


            } else {

                Native_ID = Butter.getN111(nContext);

                Butter.setNN1(nContext, 0);


            }
        } else if ((Butter.getSetup(Contextt)).equals("0")) {


            if (Butter.getnative(nContext) == 0) {

                Native_ID = Butter.getnative1(nContext);

                Butter.setnative(nContext, 1);


            } else {

                Native_ID = Butter.getnative2(nContext);

                Butter.setnative(nContext, 0);


            }

        }
        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);


                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);

                        templateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {


                        Ad_Layout.removeAllViews();


                        Native_Back_Setup2(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()


                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Back_Setup2(Context nContext, final RelativeLayout Ad_Layout, int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }
        if ((Butter.getSetup(Contextt)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {


            if (Butter.getNN2(nContext) == 0) {

                Native_ID = Butter.getN22(nContext);

                Butter.setNN2(nContext, 1);


            } else {

                Native_ID = Butter.getN222(nContext);

                Butter.setNN2(nContext, 0);


            }
        } else if ((Butter.getSetup(Contextt)).equals("0")) {


            if (Butter.getnative(nContext) == 0) {

                Native_ID = Butter.getnative1(nContext);

                Butter.setnative(nContext, 1);


            } else {

                Native_ID = Butter.getnative2(nContext);

                Butter.setnative(nContext, 0);


            }

        }
        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);


                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);

                        templateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {


                        Ad_Layout.removeAllViews();


                        Native_Back_Setup3(nContext, Ad_Layout, Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()


                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Native_Back_Setup3(Context nContext, final RelativeLayout Ad_Layout, int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        if (Exit_Menu_Decided == 100) {

            return;
        }
        if ((Butter.getSetup(Contextt)).equals("1") ||
                (Butter.getSetup(Contextt)).equals("2") ||
                (Butter.getSetup(Contextt)).equals("3") ||
                (Butter.getSetup(Contextt)).equals("4") ||
                (Butter.getSetup(Contextt)).equals("5") ||
                (Butter.getSetup(Contextt)).equals("6") ||
                (Butter.getSetup(Contextt)).equals("7") ||
                (Butter.getSetup(Contextt)).equals("8") ||
                (Butter.getSetup(Contextt)).equals("9") ||
                (Butter.getSetup(Contextt)).equals("10")) {


            if (Butter.getNN3(nContext) == 0) {

                Native_ID = Butter.getN33(nContext);

                Butter.setNN3(nContext, 1);


            } else {

                Native_ID = Butter.getN333(nContext);

                Butter.setNN3(nContext, 0);


            }
        } else if ((Butter.getSetup(Contextt)).equals("0")) {


            if (Butter.getnative(nContext) == 0) {

                Native_ID = Butter.getnative1(nContext);

                Butter.setnative(nContext, 1);


            } else {

                Native_ID = Butter.getnative2(nContext);

                Butter.setnative(nContext, 0);


            }

        }
        AdLoader adLoader = new AdLoader.Builder(nContext, Native_ID)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    private ColorDrawable background;

                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        PizzaStyle styles = new
                                PizzaStyle.Builder().withMainBackgroundColor(background).build();


                        TemplateView templateView = new TemplateView(nContext, Native_Type);


                        templateView.setStyles(styles);
                        templateView.setNativeAd(nativeAd);

                        Ad_Layout.removeAllViews();
                        Ad_Layout.addView(templateView);

                        templateView.setVisibility(View.VISIBLE);


                    }

                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {


                        Ad_Layout.removeAllViews();


                        Banner_Back_Setup1(Ad_Layout, 4);


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()


                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public static void Ad_Popup(Context mContext, String Title_Text_Of_Popup) {


        Ad_ProgressDialog = ProgressDialog.show(mContext, "", ""
                + Title_Text_Of_Popup, true);

        Ad_ProgressDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        Ad_ProgressDialog.setCancelable(true);
        Ad_ProgressDialog.show();

    }

    public static void Rate_App_Randomly(Context mContext) {


        if ((new Random().nextInt((20 - 1) + 1) + 1) == 10) {
            Rate_App(mContext);
        }

    }

    public static void Rate_App(final Context mContext) {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);


        alertDialogBuilder.setTitle("" + mContext.getString(R.string.app_name));


        alertDialogBuilder
                .setMessage("Please Rate Our Application")
                .setCancelable(true)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @SuppressLint("InlinedApi")
                            public void onClick(DialogInterface dialog, int id) {

                                Uri uri = Uri.parse("market://details?id="
                                        + mContext.getPackageName());
                                Intent goToMarket = new Intent(
                                        Intent.ACTION_VIEW, uri);

                                goToMarket
                                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
                                                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                                try {
                                    mContext.startActivity(goToMarket);
                                } catch (ActivityNotFoundException e) {
                                    mContext.startActivity(new Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("http://play.google.com/OneForAll/apps/details?id="
                                                    + mContext.getPackageName())));
                                }
                            }
                        })

                .setNeutralButton("Remind Me Later",
                        new DialogInterface.OnClickListener() {
                            @SuppressLint("InlinedApi")
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();

                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }

    public static class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();


            String jsonStr = sh.makeServiceCall("" + Server);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);


                    JSONArray contacts = jsonObj.getJSONArray("" + Packages);


                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);


                        String id = c.getString("exit_popup");
                        String tx = c.getString("tx");
                        String b1 = c.getString("b1");
                        String b2 = c.getString("b2");
                        String i1 = c.getString("i1");
                        String i2 = c.getString("i2");
                        String na1 = c.getString("na1");
                        String na2 = c.getString("na2");
                        String aid = c.getString("aid");
                        String ao = c.getString("ao");
                        String rd = c.getString("rd");
                        String ird = c.getString("ird");
                        String extra1 = c.getString("extra1");
                        String extra2 = c.getString("extra2");

                        String setup = c.getString("setup");
                        String b11 = c.getString("b11");
                        String b111 = c.getString("b111");
                        String b22 = c.getString("b22");
                        String b222 = c.getString("b222");
                        String b33 = c.getString("b33");
                        String b333 = c.getString("b333");
                        String i11 = c.getString("i11");
                        String i111 = c.getString("i111");
                        String i22 = c.getString("i22");
                        String i222 = c.getString("i222");
                        String i33 = c.getString("i33");
                        String i333 = c.getString("i333");
                        String n11 = c.getString("n11");
                        String n111 = c.getString("n111");
                        String n22 = c.getString("n22");
                        String n222 = c.getString("n222");
                        String n33 = c.getString("n33");
                        String n333 = c.getString("n333");
                        String ao11 = c.getString("ao11");
                        String ao111 = c.getString("ao111");
                        String ao22 = c.getString("ao22");
                        String ao222 = c.getString("ao222");
                        String ao33 = c.getString("ao33");
                        String ao333 = c.getString("ao333");
                        String rd11 = c.getString("rd11");
                        String rd111 = c.getString("rd111");
                        String rd22 = c.getString("rd22");
                        String rd222 = c.getString("rd222");
                        String rd33 = c.getString("rd33");
                        String rd333 = c.getString("rd333");
                        String ird11 = c.getString("ird11");
                        String ird111 = c.getString("ird111");
                        String ird22 = c.getString("ird22");
                        String ird222 = c.getString("ird222");
                        String ird33 = c.getString("ird33");
                        String ird333 = c.getString("ird333");

                        String AL_SDK_Key = c.getString("AL_SDK_Key");

                        String AL_Banner = c.getString("AL_Banner");
                        String AL_MREC_Banner = c.getString("AL_MREC_Banner");
                        String AL_Inter = c.getString("AL_Inter");
                        String AL_Native_Small = c.getString("AL_Native_Small");
                        String AL_Native_Medium = c.getString("AL_Native_Medium");
                        String AL_Native_Manual = c.getString("AL_Native_Manual");
                        String AL_Reward_Video = c.getString("AL_Reward_Video");

                        String FB_SDK_Key = c.getString("FB_SDK_Key");

                        String FB_Setup = c.getString("FB_Setup");

                        String FB_Banner1 = c.getString("FB_Banner1");
                        String FB_Banner2 = c.getString("FB_Banner2");
                        String FB_Banner3 = c.getString("FB_Banner3");
                        String FB_Banner4 = c.getString("FB_Banner4");
                        String FB_Banner5 = c.getString("FB_Banner5");

                        String FB_MREC_Banner1 = c.getString("FB_MREC_Banner1");
                        String FB_MREC_Banner2 = c.getString("FB_MREC_Banner2");
                        String FB_MREC_Banner3 = c.getString("FB_MREC_Banner3");
                        String FB_MREC_Banner4 = c.getString("FB_MREC_Banner4");
                        String FB_MREC_Banner5 = c.getString("FB_MREC_Banner5");

                        String FB_Inter1 = c.getString("FB_Inter1");
                        String FB_Inter2 = c.getString("FB_Inter2");
                        String FB_Inter3 = c.getString("FB_Inter3");
                        String FB_Inter4 = c.getString("FB_Inter4");
                        String FB_Inter5 = c.getString("FB_Inter5");

                        String FB_Native_Small1 = c.getString("FB_Native_Small1");
                        String FB_Native_Small2 = c.getString("FB_Native_Small2");
                        String FB_Native_Small3 = c.getString("FB_Native_Small3");
                        String FB_Native_Small4 = c.getString("FB_Native_Small4");
                        String FB_Native_Small5 = c.getString("FB_Native_Small5");

                        String FB_Native_Medium1 = c.getString("FB_Native_Medium1");
                        String FB_Native_Medium2 = c.getString("FB_Native_Medium2");
                        String FB_Native_Medium3 = c.getString("FB_Native_Medium3");
                        String FB_Native_Medium4 = c.getString("FB_Native_Medium4");
                        String FB_Native_Medium5 = c.getString("FB_Native_Medium5");

                        String FB_Reward_Video1 = c.getString("FB_Reward_Video1");
                        String FB_Reward_Video2 = c.getString("FB_Reward_Video2");
                        String FB_Reward_Video3 = c.getString("FB_Reward_Video3");
                        String FB_Reward_Video4 = c.getString("FB_Reward_Video4");
                        String FB_Reward_Video5 = c.getString("FB_Reward_Video5");


                        HashMap<String, String> contact = new HashMap<String, String>();


                        contact.put("exit_popup", id);
                        contact.put("tx", tx);
                        contact.put("b1", b1);
                        contact.put("b2", b2);
                        contact.put("i1", i1);
                        contact.put("i2", i2);
                        contact.put("na1", na1);
                        contact.put("na2", na2);
                        contact.put("aid", aid);
                        contact.put("ao", ao);
                        contact.put("rd", rd);
                        contact.put("ird", ird);
                        contact.put("extra1", extra1);
                        contact.put("extra2", extra2);

                        contact.put("setup", setup);
                        contact.put("b11", b11);
                        contact.put("b111", b111);
                        contact.put("b22", b22);
                        contact.put("b222", b222);
                        contact.put("b33", b33);
                        contact.put("b333", b333);
                        contact.put("i11", i11);
                        contact.put("i111", i111);
                        contact.put("i22", i22);
                        contact.put("i222", i222);
                        contact.put("i33", i33);
                        contact.put("i333", i333);
                        contact.put("n11", n11);
                        contact.put("n111", n111);
                        contact.put("n22", n22);
                        contact.put("n222", n222);
                        contact.put("n33", n33);
                        contact.put("n333", n333);
                        contact.put("ao11", ao11);
                        contact.put("ao111", ao111);
                        contact.put("ao22", ao22);
                        contact.put("ao222", ao222);
                        contact.put("ao33", ao33);
                        contact.put("ao333", ao333);
                        contact.put("rd11", rd11);
                        contact.put("rd111", rd111);
                        contact.put("rd22", rd22);
                        contact.put("rd222", rd222);
                        contact.put("rd33", rd33);
                        contact.put("rd333", rd333);
                        contact.put("ird11", ird11);
                        contact.put("ird111", ird111);
                        contact.put("ird22", ird22);
                        contact.put("ird222", ird222);
                        contact.put("ird33", ird33);
                        contact.put("ird333", ird333);

                        contact.put("AL_SDK_Key", AL_SDK_Key);

                        contact.put("AL_Banner", AL_Banner);
                        contact.put("AL_MREC_Banner", AL_MREC_Banner);
                        contact.put("AL_Inter", AL_Inter);
                        contact.put("AL_Native_Small", AL_Native_Small);
                        contact.put("AL_Native_Medium", AL_Native_Medium);
                        contact.put("AL_Native_Manual", AL_Native_Manual);
                        contact.put("AL_Reward_Video", AL_Reward_Video);

                        contact.put("FB_SDK_Key", FB_SDK_Key);

                        contact.put("FB_Setup", FB_Setup);

                        contact.put("FB_Banner1", FB_Banner1);
                        contact.put("FB_Banner2", FB_Banner2);
                        contact.put("FB_Banner3", FB_Banner3);
                        contact.put("FB_Banner4", FB_Banner4);
                        contact.put("FB_Banner5", FB_Banner5);

                        contact.put("FB_MREC_Banner1", FB_MREC_Banner1);
                        contact.put("FB_MREC_Banner2", FB_MREC_Banner2);
                        contact.put("FB_MREC_Banner3", FB_MREC_Banner3);
                        contact.put("FB_MREC_Banner4", FB_MREC_Banner4);
                        contact.put("FB_MREC_Banner5", FB_MREC_Banner5);

                        contact.put("FB_Inter1", FB_Inter1);
                        contact.put("FB_Inter2", FB_Inter2);
                        contact.put("FB_Inter3", FB_Inter3);
                        contact.put("FB_Inter4", FB_Inter4);
                        contact.put("FB_Inter5", FB_Inter5);

                        contact.put("FB_Native_Small1", FB_Native_Small1);
                        contact.put("FB_Native_Small2", FB_Native_Small2);
                        contact.put("FB_Native_Small3", FB_Native_Small3);
                        contact.put("FB_Native_Small4", FB_Native_Small4);
                        contact.put("FB_Native_Small5", FB_Native_Small5);

                        contact.put("FB_Native_Medium1", FB_Native_Medium1);
                        contact.put("FB_Native_Medium2", FB_Native_Medium2);
                        contact.put("FB_Native_Medium3", FB_Native_Medium3);
                        contact.put("FB_Native_Medium4", FB_Native_Medium4);
                        contact.put("FB_Native_Medium5", FB_Native_Medium5);

                        contact.put("FB_Reward_Video1", FB_Reward_Video1);
                        contact.put("FB_Reward_Video2", FB_Reward_Video2);
                        contact.put("FB_Reward_Video3", FB_Reward_Video3);
                        contact.put("FB_Reward_Video4", FB_Reward_Video4);
                        contact.put("FB_Reward_Video5", FB_Reward_Video5);


                        contactList.add(contact);


                    }
                } catch (final JSONException e) {

                }
            } else {

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);


            if (contactList.size() > 0) {

                Exit_Menu_Decided = Integer.parseInt(contactList.get(0).get("exit_popup"));


                Butter.setincreseeee(Contextt, Exit_Menu_Decided);


                TX = "" + contactList.get(0).get("tx");
                BR1 = "" + contactList.get(0).get("b1");
                BR2 = "" + contactList.get(0).get("b2");
                IN1 = "" + contactList.get(0).get("i1");
                IN2 = "" + contactList.get(0).get("i2");
                NA1 = "" + contactList.get(0).get("na1");
                NA2 = "" + contactList.get(0).get("na2");
                AID = "" + contactList.get(0).get("aid");
                AO = "" + contactList.get(0).get("ao");
                RD = "" + contactList.get(0).get("rd");
                IRD = "" + contactList.get(0).get("ird");
                EX1 = "" + contactList.get(0).get("extra1");
                EX2 = "" + contactList.get(0).get("extra2");

                Setup = "" + contactList.get(0).get("setup");
                B11 = "" + contactList.get(0).get("b11");
                B111 = "" + contactList.get(0).get("b111");
                B22 = "" + contactList.get(0).get("b22");
                B222 = "" + contactList.get(0).get("b222");
                B33 = "" + contactList.get(0).get("b33");
                B333 = "" + contactList.get(0).get("b333");
                I11 = "" + contactList.get(0).get("i11");
                I111 = "" + contactList.get(0).get("i111");
                I22 = "" + contactList.get(0).get("i22");
                I222 = "" + contactList.get(0).get("i222");
                I33 = "" + contactList.get(0).get("i33");
                I333 = "" + contactList.get(0).get("i333");
                N11 = "" + contactList.get(0).get("n11");
                N111 = "" + contactList.get(0).get("n111");
                N22 = "" + contactList.get(0).get("n22");
                N222 = "" + contactList.get(0).get("n222");
                N33 = "" + contactList.get(0).get("n33");
                N333 = "" + contactList.get(0).get("n333");
                AO11 = "" + contactList.get(0).get("ao11");
                AO111 = "" + contactList.get(0).get("ao111");
                AO22 = "" + contactList.get(0).get("ao22");
                AO222 = "" + contactList.get(0).get("ao222");
                AO33 = "" + contactList.get(0).get("ao33");
                AO333 = "" + contactList.get(0).get("ao333");
                RD11 = "" + contactList.get(0).get("rd11");
                RD111 = "" + contactList.get(0).get("rd111");
                RD22 = "" + contactList.get(0).get("rd22");
                RD222 = "" + contactList.get(0).get("rd222");
                RD33 = "" + contactList.get(0).get("rd33");
                RD333 = "" + contactList.get(0).get("rd333");
                IRD11 = "" + contactList.get(0).get("ird11");
                IRD111 = "" + contactList.get(0).get("ird111");
                IRD22 = "" + contactList.get(0).get("ird22");
                IRD222 = "" + contactList.get(0).get("ird222");
                IRD33 = "" + contactList.get(0).get("ird33");
                IRD333 = "" + contactList.get(0).get("ird333");

                AL_SDK_Key = "" + contactList.get(0).get("AL_SDK_Key");

                AL_Banner = "" + contactList.get(0).get("AL_Banner");
                AL_MREC_Banner = "" + contactList.get(0).get("AL_MREC_Banner");
                AL_Inter = "" + contactList.get(0).get("AL_Inter");
                AL_Native_Small = "" + contactList.get(0).get("AL_Native_Small");
                AL_Native_Medium = "" + contactList.get(0).get("AL_Native_Medium");
                AL_Native_Manual = "" + contactList.get(0).get("AL_Native_Manual");
                AL_Reward_Video = "" + contactList.get(0).get("AL_Reward_Video");

                FB_SDK_Key = "" + contactList.get(0).get("FB_SDK_Key");

                FB_Setup = Integer.parseInt(contactList.get(0).get("FB_Setup"));

                FB_Banner1 = "" + contactList.get(0).get("FB_Banner1");
                FB_Banner2 = "" + contactList.get(0).get("FB_Banner2");
                FB_Banner3 = "" + contactList.get(0).get("FB_Banner3");
                FB_Banner4 = "" + contactList.get(0).get("FB_Banner4");
                FB_Banner5 = "" + contactList.get(0).get("FB_Banner5");

                FB_MREC_Banner1 = "" + contactList.get(0).get("FB_MREC_Banner1");
                FB_MREC_Banner2 = "" + contactList.get(0).get("FB_MREC_Banner2");
                FB_MREC_Banner3 = "" + contactList.get(0).get("FB_MREC_Banner3");
                FB_MREC_Banner4 = "" + contactList.get(0).get("FB_MREC_Banner4");
                FB_MREC_Banner5 = "" + contactList.get(0).get("FB_MREC_Banner5");

                FB_Inter1 = "" + contactList.get(0).get("FB_Inter1");
                FB_Inter2 = "" + contactList.get(0).get("FB_Inter2");
                FB_Inter3 = "" + contactList.get(0).get("FB_Inter3");
                FB_Inter4 = "" + contactList.get(0).get("FB_Inter4");
                FB_Inter5 = "" + contactList.get(0).get("FB_Inter5");

                FB_Native_Small1 = "" + contactList.get(0).get("FB_Native_Small1");
                FB_Native_Small2 = "" + contactList.get(0).get("FB_Native_Small2");
                FB_Native_Small3 = "" + contactList.get(0).get("FB_Native_Small3");
                FB_Native_Small4 = "" + contactList.get(0).get("FB_Native_Small4");
                FB_Native_Small5 = "" + contactList.get(0).get("FB_Native_Small5");

                FB_Native_Medium1 = "" + contactList.get(0).get("FB_Native_Medium1");
                FB_Native_Medium2 = "" + contactList.get(0).get("FB_Native_Medium2");
                FB_Native_Medium3 = "" + contactList.get(0).get("FB_Native_Medium3");
                FB_Native_Medium4 = "" + contactList.get(0).get("FB_Native_Medium4");
                FB_Native_Medium5 = "" + contactList.get(0).get("FB_Native_Medium5");

                FB_Reward_Video1 = "" + contactList.get(0).get("FB_Reward_Video1");
                FB_Reward_Video2 = "" + contactList.get(0).get("FB_Reward_Video2");
                FB_Reward_Video3 = "" + contactList.get(0).get("FB_Reward_Video3");
                FB_Reward_Video4 = "" + contactList.get(0).get("FB_Reward_Video4");
                FB_Reward_Video5 = "" + contactList.get(0).get("FB_Reward_Video5");


                Butter.settx(Contextt, "" + TX);
                Butter.setbanner1(Contextt, "" + BR1);
                Butter.setbanner2(Contextt, "" + BR2);
                Butter.setinter1(Contextt, "" + IN1);
                Butter.setinter2(Contextt, "" + IN2);
                Butter.setnative1(Contextt, "" + NA1);
                Butter.setnative2(Contextt, "" + NA2);
                Butter.setapp_id(Contextt, "" + AID);
                Butter.setapp_open(Contextt, "" + AO);
                Butter.setreward(Contextt, "" + RD);
                Butter.setinter_reward(Contextt, "" + IRD);
                Butter.setextra1(Contextt, "" + EX1);
                Butter.setextra2(Contextt, "" + EX2);

                Butter.setSetup(Contextt, "" + Setup);
                Butter.setB11(Contextt, "" + B11);
                Butter.setB111(Contextt, "" + B111);
                Butter.setB22(Contextt, "" + B22);
                Butter.setB222(Contextt, "" + B222);
                Butter.setB33(Contextt, "" + B33);
                Butter.setB333(Contextt, "" + B333);
                Butter.setI11(Contextt, "" + I11);
                Butter.setI111(Contextt, "" + I111);
                Butter.setI22(Contextt, "" + I22);
                Butter.setI222(Contextt, "" + I222);
                Butter.setI33(Contextt, "" + I33);
                Butter.setI333(Contextt, "" + I333);
                Butter.setN11(Contextt, "" + N11);
                Butter.setN111(Contextt, "" + N111);
                Butter.setN22(Contextt, "" + N22);
                Butter.setN222(Contextt, "" + N222);
                Butter.setN33(Contextt, "" + N33);
                Butter.setN333(Contextt, "" + N333);
                Butter.setAO11(Contextt, "" + AO11);
                Butter.setAO111(Contextt, "" + AO111);
                Butter.setAO22(Contextt, "" + AO22);
                Butter.setAO222(Contextt, "" + AO222);
                Butter.setAO33(Contextt, "" + AO33);
                Butter.setAO333(Contextt, "" + AO333);
                Butter.setRD11(Contextt, "" + RD11);
                Butter.setRD111(Contextt, "" + RD111);
                Butter.setRD22(Contextt, "" + RD22);
                Butter.setRD222(Contextt, "" + RD222);
                Butter.setRD33(Contextt, "" + RD33);
                Butter.setRD333(Contextt, "" + RD333);
                Butter.setIRD11(Contextt, "" + IRD11);
                Butter.setIRD111(Contextt, "" + IRD111);
                Butter.setIRD22(Contextt, "" + IRD22);
                Butter.setIRD222(Contextt, "" + IRD222);
                Butter.setIRD33(Contextt, "" + IRD33);
                Butter.setIRD333(Contextt, "" + IRD333);

                Butter.setAL_SDK_Key(Contextt, "" + AL_SDK_Key);

                Butter.setAL_Banner(Contextt, "" + AL_Banner);
                Butter.setAL_MREC_Banner(Contextt, "" + AL_MREC_Banner);
                Butter.setAL_Inter(Contextt, "" + AL_Inter);
                Butter.setAL_Native_Small(Contextt, "" + AL_Native_Small);
                Butter.setAL_Native_Medium(Contextt, "" + AL_Native_Medium);
                Butter.setAL_Native_Manual(Contextt, "" + AL_Native_Manual);
                Butter.setAL_Reward_Video(Contextt, "" + AL_Reward_Video);

                Butter.setFB_SDK_Key(Contextt, "" + FB_SDK_Key);

                Butter.setFB_Setup(Contextt, FB_Setup);

                Butter.setFB_Banner1(Contextt, "" + FB_Banner1);
                Butter.setFB_Banner2(Contextt, "" + FB_Banner2);
                Butter.setFB_Banner3(Contextt, "" + FB_Banner3);
                Butter.setFB_Banner4(Contextt, "" + FB_Banner4);
                Butter.setFB_Banner5(Contextt, "" + FB_Banner5);

                Butter.setFB_MREC_Banner1(Contextt, "" + FB_MREC_Banner1);
                Butter.setFB_MREC_Banner2(Contextt, "" + FB_MREC_Banner2);
                Butter.setFB_MREC_Banner3(Contextt, "" + FB_MREC_Banner3);
                Butter.setFB_MREC_Banner4(Contextt, "" + FB_MREC_Banner4);
                Butter.setFB_MREC_Banner5(Contextt, "" + FB_MREC_Banner5);

                Butter.setFB_Inter1(Contextt, "" + FB_Inter1);
                Butter.setFB_Inter2(Contextt, "" + FB_Inter2);
                Butter.setFB_Inter3(Contextt, "" + FB_Inter3);
                Butter.setFB_Inter4(Contextt, "" + FB_Inter4);
                Butter.setFB_Inter5(Contextt, "" + FB_Inter5);

                Butter.setFB_Native_Small1(Contextt, "" + FB_Native_Small1);
                Butter.setFB_Native_Small2(Contextt, "" + FB_Native_Small2);
                Butter.setFB_Native_Small3(Contextt, "" + FB_Native_Small3);
                Butter.setFB_Native_Small4(Contextt, "" + FB_Native_Small4);
                Butter.setFB_Native_Small5(Contextt, "" + FB_Native_Small5);

                Butter.setFB_Native_Medium1(Contextt, "" + FB_Native_Medium1);
                Butter.setFB_Native_Medium2(Contextt, "" + FB_Native_Medium2);
                Butter.setFB_Native_Medium3(Contextt, "" + FB_Native_Medium3);
                Butter.setFB_Native_Medium4(Contextt, "" + FB_Native_Medium4);
                Butter.setFB_Native_Medium5(Contextt, "" + FB_Native_Medium5);

                Butter.setFB_Reward_Video1(Contextt, "" + FB_Reward_Video1);
                Butter.setFB_Reward_Video2(Contextt, "" + FB_Reward_Video2);
                Butter.setFB_Reward_Video3(Contextt, "" + FB_Reward_Video3);
                Butter.setFB_Reward_Video4(Contextt, "" + FB_Reward_Video4);
                Butter.setFB_Reward_Video5(Contextt, "" + FB_Reward_Video5);

                Butter.setJSON_TRUE_FALSE(Contextt, "1");


                FB_splash_inter_id_count = FB_Setup;
                FB_inter_id_count = FB_Setup;
                FB_banner_id_count = FB_Setup;
                FB_native_id_count = FB_Setup;
                FB_native_exit_id_count = FB_Setup;
                FB_banner_decided_id_count = FB_Setup;
                FB_banner_loaded_id_count = FB_Setup;
                FB_native_loaded_id_count = FB_Setup;

                Server_Yes_No = 1;


                if ((Butter.getapp_id(Contextt)).equals("ca-app-pub-3940256099942544~3347511713")) {
                } else {
                    MobileAds.initialize(Contextt, Butter.getapp_id(Contextt));
                }

                AudienceNetworkAds.initialize(Contextt);
                UnityAds.initialize(Contextt, "" + Butter.getAL_SDK_Key(Contextt), false, new IUnityAdsInitializationListener() {
                    @Override
                    public void onInitializationComplete() {
                    }

                    @Override
                    public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {
                    }
                });

                if (Exit_Menu_Decided == 2 || Exit_Menu_Decided == 4) {

                    Exit_Popup_With_Ads_Loading(0);

                }

                if ((Butter.getextra1(Contextt)).equals("1")) {

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Load_Inter_Setup1(Contextt);

                    } else if ((Butter.getSetup(Contextt)).equals("0")) {

                        Pre_Interstial_Load_Normal(Contextt);

                    }


                } else if ((Butter.getextra1(Contextt)).equals("2")) {

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Pre_App_Open_Load_Setup1(Contextt);


                    } else if ((Butter.getSetup(Contextt)).equals("0")) {


                        Pre_App_Open_Load_Normal(Contextt);

                    }


                } else if ((Butter.getextra1(Contextt)).equals("3")) {

                    Load_Inter_Setup1(Contextt);

                    Pre_App_Open_Load_Setup1(Contextt);

                    Pre_Interstial_Load_Normal(Contextt);

                    Pre_App_Open_Load_Normal(Contextt);

                } else {

                    Load_Inter_Setup1(Contextt);

                    Pre_App_Open_Load_Setup1(Contextt);

                    Pre_Interstial_Load_Normal(Contextt);

                    Pre_App_Open_Load_Normal(Contextt);

                }


                if (Exit_Menu_Decided == 100) {


                } else if (Exit_Menu_Decided == 200 || Exit_Menu_Decided == 201 || Exit_Menu_Decided == 202 || Exit_Menu_Decided == 203) {


                } else if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {


                    Exit_Popup_With_Ads_Loading(0);

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Load_Inter_Setup1(Contextt);

                    } else if ((Butter.getSetup(Contextt)).equals("0")) {

                        Pre_Interstial_Load_Normal(Contextt);

                    }

                } else {


                }


            }

            if (contactList.size() == 0) {


                if (Butter.getJSON_TRUE_FALSE(Contextt).equals("0")) {

                    Butter.settx(Contextt, "" + Tx_ID);
                    Butter.setbanner1(Contextt, "" + Banner1);
                    Butter.setbanner2(Contextt, "" + Banner2);
                    Butter.setinter1(Contextt, "" + Interstial1);
                    Butter.setinter2(Contextt, "" + Interstial2);
                    Butter.setnative1(Contextt, "" + Native_ID1);
                    Butter.setnative2(Contextt, "" + Native_ID2);
                    Butter.setapp_id(Contextt, "" + APP_ID);
                    Butter.setapp_open(Contextt, "" + APP_OPEN);
                    Butter.setreward(Contextt, "" + REWARD);
                    Butter.setinter_reward(Contextt, "" + INTER_REWARD);
                    Butter.setextra1(Contextt, "" + EXTRA1);
                    Butter.setextra2(Contextt, "" + EXTRA2);

                    Butter.setSetup(Contextt, "" + Setup_ID);
                    Butter.setB11(Contextt, "" + B11_ID);
                    Butter.setB111(Contextt, "" + B111_ID);
                    Butter.setB22(Contextt, "" + B22_ID);
                    Butter.setB222(Contextt, "" + B222_ID);
                    Butter.setB33(Contextt, "" + B33_ID);
                    Butter.setB333(Contextt, "" + B333_ID);
                    Butter.setI11(Contextt, "" + I11_ID);
                    Butter.setI111(Contextt, "" + I111_ID);
                    Butter.setI22(Contextt, "" + I22_ID);
                    Butter.setI222(Contextt, "" + I222_ID);
                    Butter.setI33(Contextt, "" + I33_ID);
                    Butter.setI333(Contextt, "" + I333_ID);
                    Butter.setN11(Contextt, "" + N11_ID);
                    Butter.setN111(Contextt, "" + N111_ID);
                    Butter.setN22(Contextt, "" + N22_ID);
                    Butter.setN222(Contextt, "" + N222_ID);
                    Butter.setN33(Contextt, "" + N33_ID);
                    Butter.setN333(Contextt, "" + N333_ID);
                    Butter.setAO11(Contextt, "" + AO11_ID);
                    Butter.setAO111(Contextt, "" + AO111_ID);
                    Butter.setAO22(Contextt, "" + AO22_ID);
                    Butter.setAO222(Contextt, "" + AO222_ID);
                    Butter.setAO33(Contextt, "" + AO33_ID);
                    Butter.setAO333(Contextt, "" + AO333_ID);
                    Butter.setRD11(Contextt, "" + RD11_ID);
                    Butter.setRD111(Contextt, "" + RD111_ID);
                    Butter.setRD22(Contextt, "" + RD22_ID);
                    Butter.setRD222(Contextt, "" + RD222_ID);
                    Butter.setRD33(Contextt, "" + RD33_ID);
                    Butter.setRD333(Contextt, "" + RD333_ID);
                    Butter.setIRD11(Contextt, "" + IRD11_ID);
                    Butter.setIRD111(Contextt, "" + IRD111_ID);
                    Butter.setIRD22(Contextt, "" + IRD22_ID);
                    Butter.setIRD222(Contextt, "" + IRD222_ID);
                    Butter.setIRD33(Contextt, "" + IRD33_ID);
                    Butter.setIRD333(Contextt, "" + IRD333_ID);

                } else {

                    if ((Butter.getapp_id(Contextt)).equals("ca-app-pub-3940256099942544~3347511713")) {
                    } else {
                        MobileAds.initialize(Contextt, Butter.getapp_id(Contextt));
                    }

                    AudienceNetworkAds.initialize(Contextt);
                    UnityAds.initialize(Contextt, "" + Butter.getAL_SDK_Key(Contextt), false, new IUnityAdsInitializationListener() {
                        @Override
                        public void onInitializationComplete() {
                        }

                        @Override
                        public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {
                        }
                    });

                    if ((Butter.getincreseeee(Contextt)) == 100) {


                    } else if ((Butter.getincreseeee(Contextt)) == 200 || (Butter.getincreseeee(Contextt)) == 201
                            || (Butter.getincreseeee(Contextt)) == 202 || (Butter.getincreseeee(Contextt)) == 203) {


                    } else if ((Butter.getincreseeee(Contextt)) == 300 || (Butter.getincreseeee(Contextt)) == 301
                            || (Butter.getincreseeee(Contextt)) == 302 || (Butter.getincreseeee(Contextt)) == 303) {

                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Load_Inter_Setup1(Contextt);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Pre_Interstial_Load_Normal(Contextt);

                        }

                    }

                }

                if ((Butter.getapp_id(Contextt)).equals("ca-app-pub-3940256099942544~3347511713")) {

                } else {
                    MobileAds.initialize(Contextt, Butter.getapp_id(Contextt));
                }

                Exit_Menu_Decided = 0;

                Server_Yes_No = 0;


                if ((Butter.getextra1(Contextt)).equals("1")) {

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Load_Inter_Setup1(Contextt);

                    } else if ((Butter.getSetup(Contextt)).equals("0")) {

                        Pre_Interstial_Load_Normal(Contextt);

                    }

                } else if ((Butter.getextra1(Contextt)).equals("2")) {

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Pre_App_Open_Load_Setup1(Contextt);

                    } else if ((Butter.getSetup(Contextt)).equals("0")) {

                        Pre_App_Open_Load_Normal(Contextt);

                    }


                } else if ((Butter.getextra1(Contextt)).equals("3")) {

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Load_Inter_Setup1(Contextt);

                        Pre_App_Open_Load_Setup1(Contextt);

                    } else if ((Butter.getSetup(Contextt)).equals("0")) {

                        Pre_Interstial_Load_Normal(Contextt);

                        Pre_App_Open_Load_Normal(Contextt);

                    }


                } else {

                    if ((Butter.getSetup(Contextt)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Load_Inter_Setup1(Contextt);

                        Pre_App_Open_Load_Setup1(Contextt);

                    } else if ((Butter.getSetup(Contextt)).equals("0")) {

                        Pre_Interstial_Load_Normal(Contextt);

                        Pre_App_Open_Load_Normal(Contextt);

                    }

                }

            }

        }

    }

    public static class HttpHandler {

        public HttpHandler() {
        }

        public String makeServiceCall(String reqUrl) {
            String response = null;
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url
                        .openConnection();
                conn.setRequestMethod("GET");

                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (MalformedURLException e) {

            } catch (ProtocolException e) {

            } catch (IOException e) {

            } catch (Exception e) {

            }
            return response;
        }

        private String convertStreamToString(InputStream is) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return sb.toString();
        }
    }

    public static boolean isNetworkConnected(Context aContext) {
        ConnectivityManager cm = (ConnectivityManager) aContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public static void onBackPressed(Context aContext) {

        if (doubleBackToExitPressedOnce) {
            ((Activity) aContext).moveTaskToBack(true);
            ((Activity) aContext).finish();
        } else {

            Toast.makeText(aContext, "Press Back Again to Exit",
                    Toast.LENGTH_SHORT).show();

            doubleBackToExitPressedOnce = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);

        }

    }

    public static void Increase_Ads(Context aContext) {

        if (Exit_Menu_Decided == 201 || Exit_Menu_Decided == 203) {

            Max_Inter_Show(aContext);
            return;

        }
        if (Exit_Menu_Decided == 301 || Exit_Menu_Decided == 303) {
            FB_Inter_Show(aContext);
            return;
        }

        if (Exit_Menu_Decided == 100) {

            return;
        }

        if (Exit_Menu_Decided == 3) {

            Pre_Interstial_Show(aContext);

        }

        if (Exit_Menu_Decided == 4) {

            Pre_Interstial_Show(aContext);

        }


    }

    public static void onDestroy(Context aContext) {

        if (Splash_tappxInterstitial_preload != null) {
            Splash_tappxInterstitial_preload.destroy();
        }
        if (tappxInterstitial != null) {
            tappxInterstitial.destroy();
        }
        if (Tappxbanner != null) {
            Tappxbanner.destroy();
        }
        if (tappxInterstitial_preload != null) {
            tappxInterstitial_preload.destroy();
        }
        if (Pre_Tappxbanner != null) {
            Pre_Tappxbanner.destroy();
        }
        if (Splash_InterstialAd != null) {
        }
        if (InterstialAd != null) {
        }
        if (InterstialAd1 != null) {
        }
        if (InterstialAd_Setup != null) {
        }
        if (mAdView != null) {
            mAdView.destroy();
        }
        if (mAdView_exit != null) {
            mAdView_exit.destroy();
        }
        if (mRewardedAd != null) {
        }
        if (mrewardedInterstitialAd != null) {
        }
        if (rewardedInterstitialAd != null) {
        }
    }

    public static void SO_Banner(final RelativeLayout Ad_Layout, final int Banner_Type) {

        if (Banner_Type == 1) {

            final Banner SO_Banner = new Banner(Contextt);
            SO_Banner.setBannerListener(new BannerListener() {
                @Override
                public void onReceiveAd(View view) {


                    try {
                        if (gifImageView.getVisibility() == View.VISIBLE) {
                            gifImageView.setVisibility(View.GONE);

                        }
                    } catch (Exception e) {

                    }

                    Ad_Layout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailedToReceiveAd(View view) {
                    Ad_Layout.setVisibility(View.GONE);
                }

                @Override
                public void onImpression(View view) {

                }

                @Override
                public void onClick(View view) {
                    Ad_Layout.setVisibility(View.GONE);
                }
            });
            Ad_Layout.removeAllViews();
            Ad_Layout.addView(SO_Banner);

        } else {

            final Mrec SO_Banner = new Mrec(Contextt);
            SO_Banner.setBannerListener(new BannerListener() {
                @Override
                public void onReceiveAd(View view) {
                    Ad_Layout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailedToReceiveAd(View view) {
                    Ad_Layout.setVisibility(View.GONE);
                }

                @Override
                public void onImpression(View view) {

                }

                @Override
                public void onClick(View view) {
                    Ad_Layout.setVisibility(View.GONE);
                }
            });
            Ad_Layout.removeAllViews();
            Ad_Layout.addView(SO_Banner);

        }


    }

    public static void Max_Inter(Context mContext) {

    }

    public static void FB_Max_Inter(Context mContext) {


    }

    public static void Max_Inter_Show(Context mContext) {

        if (Butter.getAL_Inter(Contextt).equals("")) {
            Tappx_Inter(mContext);
            return;
        }

        Unity_Inter(mContext);

    }

    public static void Max_Inter_Splash(final Dialog builder, final Context mContext) {

        UnityAds.load("" + Butter.getAL_Inter(Contextt), new IUnityAdsLoadListener() {
            @Override
            public void onUnityAdsAdLoaded(String placementId) {

                IUnityAdsShowListener showListener = new IUnityAdsShowListener() {

                    @Override
                    public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {

                        if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                            FB_Inter(mContext);
                        }
                        Splash_Tappx_Inter(builder, mContext);

                    }

                    @Override
                    public void onUnityAdsShowStart(String placementId) {
                    }

                    @Override
                    public void onUnityAdsShowClick(String placementId) {
                    }

                    @Override
                    public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                    }
                };

                try {

                    UnityAds.show((Activity) mContext, "" + Butter.getAL_Inter(Contextt), new UnityAdsShowOptions(), showListener);
                    Splash_Popup_Dissmiss(builder);


                    if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                        FB_Inter(mContext);
                    }

                } catch (Exception e) {

                }
            }

            @Override
            public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {

                Splash_Tappx_Inter(builder, mContext);


                if (Exit_Menu_Decided == 300 || Exit_Menu_Decided == 301 || Exit_Menu_Decided == 302 || Exit_Menu_Decided == 303) {
                    FB_Inter(mContext);
                }

            }
        });

    }

    public static void Max_Reward(Activity activity, OnRewardgetListner onRewardgetListner, String Title, String Description, int Popup_Type) {

        CustomProgressDialogue progressDialog = new CustomProgressDialogue(activity, Popup_Type, Title, Description);

        new FancyGifDialog.Builder(activity)
                .setTitle(Title)
                .setMessage(Description)
                .setTitleTextColor(R.color.titleText)
                .setDescriptionTextColor(R.color.descriptionText)
                .setNegativeBtnText("Close")
                .setPositiveBtnBackground(R.color.positiveButton)
                .setPositiveBtnText("Watch Now (Ad)")
                .setNegativeBtnBackground(R.color.positiveButton)
                .setGifResource(R.drawable.ad1)
                .isCancellable(true)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {

                        progressDialog.show();

                        UnityAds.load("" + Butter.getAL_Inter(Contextt), new IUnityAdsLoadListener() {
                            @Override
                            public void onUnityAdsAdLoaded(String placementId) {

                                IUnityAdsShowListener showListener = new IUnityAdsShowListener() {

                                    @Override
                                    public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
                                        onRewardgetListner.OnReward(false);
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onUnityAdsShowStart(String placementId) {
                                    }

                                    @Override
                                    public void onUnityAdsShowClick(String placementId) {
                                    }

                                    @Override
                                    public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                                    }
                                };

                                try {

                                    UnityAds.show((Activity) Contextt, "" + Butter.getAL_Inter(Contextt), new UnityAdsShowOptions(), showListener);
                                    onRewardgetListner.OnReward(true);
                                    progressDialog.dismiss();

                                } catch (Exception e) {

                                }
                            }

                            @Override
                            public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
                                onRewardgetListner.OnReward(false);
                                progressDialog.dismiss();
                            }
                        });

                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {


                    }
                })
                .build();


    }

    public static void Max_Inter_Reward(Activity activity, String Title, String Description, int Popup_Type) {

        CustomProgressDialogue progressDialog = new CustomProgressDialogue(activity, Popup_Type, Title, Description);
        progressDialog.show();

        UnityAds.load("" + Butter.getAL_Inter(Contextt), new IUnityAdsLoadListener() {
            @Override
            public void onUnityAdsAdLoaded(String placementId) {

                IUnityAdsShowListener showListener = new IUnityAdsShowListener() {

                    @Override
                    public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onUnityAdsShowStart(String placementId) {
                    }

                    @Override
                    public void onUnityAdsShowClick(String placementId) {
                    }

                    @Override
                    public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                    }
                };

                try {

                    UnityAds.show((Activity) Contextt, "" + Butter.getAL_Inter(Contextt), new UnityAdsShowOptions(), showListener);
                    progressDialog.dismiss();

                } catch (Exception e) {

                }
            }

            @Override
            public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
                progressDialog.dismiss();
            }
        });

    }

    public static void Max_Banner(RelativeLayout Ad_Layout, int Type) {

        Tappx_Banner(Ad_Layout, Type);

    }

    public static void Max_Native(Context mContext, final RelativeLayout Ad_Layout,
                                  int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        Tappx_Banner(Ad_Layout, Native_Type);

    }

    public static void Max_Native_Exit(Context mContext, final RelativeLayout Ad_Layout,
                                       int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        Tappx_Banner(Ad_Layout, Native_Type);

    }

    public static void Max_Banner_Preload_Decided(int Type) {


    }

    public static void Max_Banner_Preload_Show_Decided(final RelativeLayout Ad_Layout,
                                                       final int Banner_Type) {

        Tappx_Banner(Ad_Layout, Banner_Type);

    }

    public static void Max_Banner_Preload(int Type) {

        Which_Banner_Max = Type;

    }

    public static void Max_Banner_Preload_Show(final RelativeLayout Ad_Layout) {

        Tappx_Banner(Ad_Layout, Which_Banner_Max);

    }

    public static void Max_Native_Pre_Load(int Native_Type) {

        Which_Banner_Max = Native_Type;

    }

    public static void Max_Native_Pre_Load_Show(final RelativeLayout Ad_Layout) {

        Tappx_Banner(Ad_Layout, Which_Banner_Max);

    }

    public static void FB_Inter(Context mContext) {

        if (FB_inter_id_count == 1) {
            FB_inter_id_count = 2;
            FBinterstitialAd = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter1(Contextt));
        } else if (FB_inter_id_count == 2) {
            FB_inter_id_count = 3;
            FBinterstitialAd = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter2(Contextt));
        } else if (FB_inter_id_count == 3) {
            FB_inter_id_count = 4;
            FBinterstitialAd = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter3(Contextt));
        } else if (FB_inter_id_count == 4) {
            FB_inter_id_count = 5;
            FBinterstitialAd = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter4(Contextt));
        } else {
            FB_inter_id_count = 6;
            FBinterstitialAd = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter5(Contextt));
        }


        InterstitialAdListener adListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(com.facebook.ads.Ad ad) {

                FB_inter_id_count = FB_Setup;

                FB_Inter(mContext);
            }

            @Override
            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {
                FBinterstitialAd = null;

                int aa = FB_inter_id_count - 1;

                if (FB_inter_id_count == 6) {
                    FB_inter_id_count = FB_Setup;


                    if (Butter.getextra2(Contextt).equals(GL)) {
                        AL_FB_Inter_Failed = 300;

                    } else if (Butter.getextra2(Contextt).equals(AL)) {
                        FB_Max_Inter(mContext);
                    } else {
                        FB_Max_Inter(mContext);
                    }

                } else {
                    FB_Inter(mContext);

                }
            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {
            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {
            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {
            }
        };

        FBinterstitialAd.loadAd(
                FBinterstitialAd.buildLoadAdConfig()
                        .withAdListener(adListener)
                        .build());


    }

    public static void FB_Inter_Show(Context mContext) {

        try {


            if (FBinterstitialAd != null) {
                if (FBinterstitialAd.isAdLoaded()) {
                    FBinterstitialAd.show();
                }
            } else {

                if (Butter.getextra2(Contextt).equals(GL)) {


                    if ((Butter.getSetup(mContext)).equals("1") ||
                            (Butter.getSetup(Contextt)).equals("2") ||
                            (Butter.getSetup(Contextt)).equals("3") ||
                            (Butter.getSetup(Contextt)).equals("4") ||
                            (Butter.getSetup(Contextt)).equals("5") ||
                            (Butter.getSetup(Contextt)).equals("6") ||
                            (Butter.getSetup(Contextt)).equals("7") ||
                            (Butter.getSetup(Contextt)).equals("8") ||
                            (Butter.getSetup(Contextt)).equals("9") ||
                            (Butter.getSetup(Contextt)).equals("10")) {

                        Show_Inter_Setup_Show(mContext);

                    } else if ((Butter.getSetup(mContext)).equals("0")) {

                        Pre_Interstial_Show_Normal(mContext);

                    }


                } else if (Butter.getextra2(Contextt).equals(AL)) {

                    Unity_Inter(mContext);

                } else {

                    Unity_Inter(mContext);

                }

            }


            if (AL_FB_Inter_Failed == 1) {
                if (tappxInterstitial_preload != null) {
                    tappxInterstitial_preload.show();
                }
            } else if (AL_FB_Inter_Failed == 50) {
                if (startAppAd.isReady()) {
                    startAppAd.showAd();

                }
            }

            FB_Inter(mContext);

        } catch (Exception e) {

        }
    }

    public static void FB_Inter_Splash(final Dialog builder, final Context mContext) {


        if (FB_splash_inter_id_count == 1) {
            FB_splash_inter_id_count = 2;
            FBinterstitialAd_Splash = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter1(Contextt));
        } else if (FB_splash_inter_id_count == 2) {
            FB_splash_inter_id_count = 3;
            FBinterstitialAd_Splash = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter2(Contextt));
        } else if (FB_splash_inter_id_count == 3) {
            FB_splash_inter_id_count = 4;
            FBinterstitialAd_Splash = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter3(Contextt));
        } else if (FB_splash_inter_id_count == 4) {
            FB_splash_inter_id_count = 5;
            FBinterstitialAd_Splash = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter4(Contextt));
        } else {
            FB_splash_inter_id_count = 6;
            FBinterstitialAd_Splash = new com.facebook.ads.InterstitialAd(mContext, "" + Butter.getFB_Inter5(Contextt));
        }


        InterstitialAdListener adListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(com.facebook.ads.Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(com.facebook.ads.Ad ad) {
                FB_splash_inter_id_count = FB_Setup;
                FB_Inter(mContext);
            }

            @Override
            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {
                FBinterstitialAd_Splash = null;

                int aa = FB_splash_inter_id_count - 1;

                if (FB_splash_inter_id_count == 6) {
                    FB_splash_inter_id_count = FB_Setup;


                    if (Butter.getextra2(Contextt).equals(GL)) {
                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Splash_Interstial_Setup1(builder, Contextt);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Splash_Interstial(builder, Contextt);

                        }
                    } else if (Butter.getextra2(Contextt).equals(AL)) {
                        Max_Inter_Splash(builder, mContext);
                    } else {
                        Max_Inter_Splash(builder, mContext);
                    }


                } else {
                    FB_Inter_Splash(builder, mContext);
                }
            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {


                if (FBinterstitialAd_Splash.isAdLoaded()) {
                    FBinterstitialAd_Splash.show();
                    Splash_Popup_Dissmiss(builder);
                }
            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {
            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {
            }
        };

        FBinterstitialAd_Splash.loadAd(
                FBinterstitialAd_Splash.buildLoadAdConfig()
                        .withAdListener(adListener)
                        .build());


    }

    public static void FB_Reward(Activity activity, OnRewardgetListner onRewardgetListner, String Title, String Description, int Popup_Type) {

        CustomProgressDialogue progressDialog = new CustomProgressDialogue(activity, Popup_Type, Title, Description);

        new FancyGifDialog.Builder(activity)
                .setTitle(Title)
                .setMessage(Description)
                .setTitleTextColor(R.color.titleText)
                .setDescriptionTextColor(R.color.descriptionText)
                .setNegativeBtnText("Close")
                .setPositiveBtnBackground(R.color.positiveButton)
                .setPositiveBtnText("Watch Now (Ad)")
                .setNegativeBtnBackground(R.color.positiveButton)
                .setGifResource(R.drawable.ad1)
                .isCancellable(true)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {

                        progressDialog.show();
                        FBinterstitialAd_Reward = new com.facebook.ads.InterstitialAd(activity, "" + Butter.getFB_Inter1(Contextt));
                        InterstitialAdListener adListener = new InterstitialAdListener() {
                            @Override
                            public void onInterstitialDisplayed(com.facebook.ads.Ad ad) {

                            }

                            @Override
                            public void onInterstitialDismissed(com.facebook.ads.Ad ad) {
                                onRewardgetListner.OnReward(true);


                            }

                            @Override
                            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {
                                FBinterstitialAd_Reward = null;
                                onRewardgetListner.OnReward(false);
                                progressDialog.dismiss();

                            }

                            @Override
                            public void onAdLoaded(com.facebook.ads.Ad ad) {
                                progressDialog.dismiss();
                                if (FBinterstitialAd_Reward.isAdLoaded()) {
                                    FBinterstitialAd_Reward.show();
                                }
                            }

                            @Override
                            public void onAdClicked(com.facebook.ads.Ad ad) {
                            }

                            @Override
                            public void onLoggingImpression(com.facebook.ads.Ad ad) {
                            }
                        };

                        FBinterstitialAd_Reward.loadAd(
                                FBinterstitialAd_Reward.buildLoadAdConfig()
                                        .withAdListener(adListener)
                                        .build());


                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {


                    }
                })
                .build();


    }

    public static void FB_Inter_Reward(Activity activity, String Title, String Description, int Popup_Type) {

        CustomProgressDialogue progressDialog = new CustomProgressDialogue(activity, Popup_Type, Title, Description);

        new FancyGifDialog.Builder(activity)
                .setTitle(Title)
                .setMessage(Description)
                .setTitleTextColor(R.color.titleText)
                .setDescriptionTextColor(R.color.descriptionText)
                .setNegativeBtnText("Close")
                .setPositiveBtnBackground(R.color.positiveButton)
                .setPositiveBtnText("Watch Now (Ad)")
                .setNegativeBtnBackground(R.color.positiveButton)
                .setGifResource(R.drawable.ad1)
                .isCancellable(true)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {

                        progressDialog.show();

                        FBinterstitialAd_Reward = new com.facebook.ads.InterstitialAd(Contextt, "" + Butter.getFB_Inter1(Contextt));
                        InterstitialAdListener adListener = new InterstitialAdListener() {
                            @Override
                            public void onInterstitialDisplayed(com.facebook.ads.Ad ad) {

                            }

                            @Override
                            public void onInterstitialDismissed(com.facebook.ads.Ad ad) {
                            }

                            @Override
                            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {
                                FBinterstitialAd_Reward = null;
                                progressDialog.dismiss();
                            }

                            @Override
                            public void onAdLoaded(com.facebook.ads.Ad ad) {
                                progressDialog.dismiss();
                                if (FBinterstitialAd_Reward.isAdLoaded()) {
                                    FBinterstitialAd_Reward.show();
                                }
                            }

                            @Override
                            public void onAdClicked(com.facebook.ads.Ad ad) {
                            }

                            @Override
                            public void onLoggingImpression(com.facebook.ads.Ad ad) {
                            }
                        };

                        FBinterstitialAd_Reward.loadAd(
                                FBinterstitialAd_Reward.buildLoadAdConfig()
                                        .withAdListener(adListener)
                                        .build());


                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {


                    }
                })
                .build();


    }

    public static void FB_Banner(RelativeLayout Ad_Layout, int Type) {


        com.facebook.ads.AdListener adListener;
        adListener = new com.facebook.ads.AdListener() {
            @Override
            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {


                int aa = FB_native_id_count - 1;

                if (FB_banner_id_count == 6) {
                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.GONE);
                    FB_banner_id_count = FB_Setup;

                    if (Butter.getextra2(Contextt).equals(GL)) {

                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Banner_Auto_Setup(Ad_Layout, Type);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Banner_Normal(Ad_Layout, Type);

                        }

                    } else if (Butter.getextra2(Contextt).equals(AL)) {
                        Max_Banner(Ad_Layout, Type);
                    } else {
                        Max_Banner(Ad_Layout, Type);
                    }


                } else {
                    FB_Banner(Ad_Layout, Type);
                }

            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {
                Ad_Layout.setVisibility(View.VISIBLE);
                Ad_Layout.removeAllViews();
                Ad_Layout.addView(FB_adView);

                FB_banner_id_count = FB_Setup;

            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {

            }
        };

        if (Type == 1) {


            if (FB_banner_id_count == 1) {
                FB_banner_id_count = 2;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_id_count == 2) {
                FB_banner_id_count = 3;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_id_count == 3) {
                FB_banner_id_count = 4;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_id_count == 4) {
                FB_banner_id_count = 5;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else {
                FB_banner_id_count = 6;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            }
        } else if (Type == 2 || Type == 3) {


            if (FB_banner_id_count == 1) {
                FB_banner_id_count = 2;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_id_count == 2) {
                FB_banner_id_count = 3;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_id_count == 3) {
                FB_banner_id_count = 4;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_id_count == 4) {
                FB_banner_id_count = 5;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else {
                FB_banner_id_count = 6;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            }
        } else if (Type == 4) {

            if (FB_banner_id_count == 1) {
                FB_banner_id_count = 2;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner1(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_id_count == 2) {
                FB_banner_id_count = 3;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner2(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_id_count == 3) {
                FB_banner_id_count = 4;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner3(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_id_count == 4) {
                FB_banner_id_count = 5;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner4(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else {
                FB_banner_id_count = 6;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner5(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            }
        } else {

            if (FB_banner_id_count == 1) {
                FB_banner_id_count = 2;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_id_count == 2) {
                FB_banner_id_count = 3;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_id_count == 3) {
                FB_banner_id_count = 4;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_id_count == 4) {
                FB_banner_id_count = 5;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else {
                FB_banner_id_count = 6;
                FB_adView = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            }

        }


        FB_adView.loadAd(FB_adView.buildLoadAdConfig().withAdListener(adListener).build());


    }

    public static void FB_Native(Context mContext, final RelativeLayout Ad_Layout,
                                 int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {


        if (Native_Type == 2) {

            Ad_Layout.getLayoutParams().height = 800;


            if (FB_native_id_count == 1) {
                FB_native_id_count = 2;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium1(Contextt));
            } else if (FB_native_id_count == 2) {
                FB_native_id_count = 3;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium2(Contextt));
            } else if (FB_native_id_count == 3) {
                FB_native_id_count = 4;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium3(Contextt));
            } else if (FB_native_id_count == 4) {
                FB_native_id_count = 5;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium4(Contextt));
            } else {
                FB_native_id_count = 6;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium5(Contextt));
            }


        } else {

            if (FB_native_id_count == 1) {
                FB_native_id_count = 2;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small1(Contextt));
            } else if (FB_native_id_count == 2) {
                FB_native_id_count = 3;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small2(Contextt));
            } else if (FB_native_id_count == 3) {
                FB_native_id_count = 4;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small3(Contextt));
            } else if (FB_native_id_count == 4) {
                FB_native_id_count = 5;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small4(Contextt));
            } else {
                FB_native_id_count = 6;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small5(Contextt));
            }
        }


        NativeAdListener nativeAdListener = new NativeAdListener() {

            @Override
            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {
                int aa = FB_native_id_count - 1;

                if (FB_native_id_count == 6) {
                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.GONE);
                    FB_native_id_count = FB_Setup;


                    if (Butter.getextra2(Contextt).equals(GL)) {
                        if ((Butter.getSetup(Contextt)).equals("1") ||
                                (Butter.getSetup(Contextt)).equals("2") ||
                                (Butter.getSetup(Contextt)).equals("3") ||
                                (Butter.getSetup(Contextt)).equals("4") ||
                                (Butter.getSetup(Contextt)).equals("5") ||
                                (Butter.getSetup(Contextt)).equals("6") ||
                                (Butter.getSetup(Contextt)).equals("7") ||
                                (Butter.getSetup(Contextt)).equals("8") ||
                                (Butter.getSetup(Contextt)).equals("9") ||
                                (Butter.getSetup(Contextt)).equals("10")) {

                            Native_Auto_Setup(Contextt, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        } else if ((Butter.getSetup(Contextt)).equals("0")) {

                            Native_Normal(Contextt, Ad_Layout,
                                    Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                        }
                    } else if (Butter.getextra2(Contextt).equals(AL)) {
                        Max_Native(mContext, Ad_Layout,
                                Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                    } else {
                        Max_Native(mContext, Ad_Layout,
                                Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                    }


                } else {
                    FB_Native(mContext, Ad_Layout,
                            Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                }


            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {

                View adView;
                if (Native_Type == 2) {
                    adView = NativeAdView.render(mContext, nativeAd_FB);
                } else {
                    adView = NativeBannerAdView.render(mContext, nativeAd_Banner_FB, NativeBannerAdView.Type.HEIGHT_120);
                }


                Ad_Layout.setVisibility(View.VISIBLE);
                Ad_Layout.removeAllViews();
                Ad_Layout.addView(adView);


                FB_native_id_count = FB_Setup;
            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onMediaDownloaded(com.facebook.ads.Ad ad) {

            }

        };

        if (Native_Type == 2) {
            nativeAd_FB.loadAd(
                    nativeAd_FB.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                            .build());
        } else {
            nativeAd_Banner_FB.loadAd(
                    nativeAd_Banner_FB.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .build());
        }


    }

    public static void FB_Native_Exit(Context mContext, final RelativeLayout Ad_Layout,
                                      int Native_Type, int Bottom_Ad_Margin, int Top_Ad_Margin, int Animation) {

        DisplayMetrics metrics = Contextt.getResources()
                .getDisplayMetrics();

        if (Native_Type == 2) {

            Ad_Layout.getLayoutParams().height = (int) (metrics.heightPixels / 1.5);
            if (FB_native_exit_id_count == 1) {
                FB_native_exit_id_count = 2;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium1(Contextt));
            } else if (FB_native_exit_id_count == 2) {
                FB_native_exit_id_count = 3;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium2(Contextt));
            } else if (FB_native_exit_id_count == 3) {
                FB_native_exit_id_count = 4;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium3(Contextt));
            } else if (FB_native_exit_id_count == 4) {
                FB_native_exit_id_count = 5;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium4(Contextt));
            } else {
                FB_native_exit_id_count = 6;
                nativeAd_FB = new com.facebook.ads.NativeAd(mContext, Butter.getFB_Native_Medium5(Contextt));
            }

        } else {

            if (FB_native_exit_id_count == 1) {
                FB_native_exit_id_count = 2;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small1(Contextt));
            } else if (FB_native_exit_id_count == 2) {
                FB_native_exit_id_count = 3;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small2(Contextt));
            } else if (FB_native_exit_id_count == 3) {
                FB_native_exit_id_count = 4;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small3(Contextt));
            } else if (FB_native_exit_id_count == 4) {
                FB_native_exit_id_count = 5;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small4(Contextt));
            } else {
                FB_native_exit_id_count = 6;
                nativeAd_Banner_FB = new com.facebook.ads.NativeBannerAd(mContext, Butter.getFB_Native_Small5(Contextt));
            }


        }


        NativeAdListener nativeAdListener = new NativeAdListener() {

            @Override
            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {


                int aa = FB_native_exit_id_count - 1;

                if (FB_native_exit_id_count == 6) {
                    Ad_Layout.removeAllViews();
                    Ad_Layout.setVisibility(View.GONE);
                    FB_native_exit_id_count = FB_Setup;


                    if (Butter.getextra2(Contextt).equals(GL)) {

                        Ad_Layout.getLayoutParams().height = (int) (metrics.heightPixels);
                        Native_Back(mContext, Ad_Layout, Native_Type, 0, 0, 0);

                    } else if (Butter.getextra2(Contextt).equals(AL)) {
                        Max_Native_Exit(mContext, Ad_Layout,
                                Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                    } else {
                        Max_Native_Exit(mContext, Ad_Layout,
                                Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);
                    }


                } else {
                    FB_Native_Exit(mContext, Ad_Layout,
                            Native_Type, Bottom_Ad_Margin, Top_Ad_Margin, Animation);

                }


            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {

                View adView;
                if (Native_Type == 2) {
                    adView = NativeAdView.render(mContext, nativeAd_FB);
                } else {
                    adView = NativeBannerAdView.render(mContext, nativeAd_Banner_FB, NativeBannerAdView.Type.HEIGHT_120);
                }


                Ad_Layout.setVisibility(View.VISIBLE);
                Ad_Layout.removeAllViews();
                Ad_Layout.addView(adView);


                FB_native_exit_id_count = FB_Setup;
                try {
                    if (gifImageView.getVisibility() == View.VISIBLE) {
                        gifImageView.setVisibility(View.GONE);

                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onMediaDownloaded(com.facebook.ads.Ad ad) {

            }

        };

        if (Native_Type == 2) {
            nativeAd_FB.loadAd(
                    nativeAd_FB.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                            .build());
        } else {
            nativeAd_Banner_FB.loadAd(
                    nativeAd_Banner_FB.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .build());
        }

    }

    public static void FB_Banner_Preload_Decided(int Type) {


        com.facebook.ads.AdListener adListener;
        adListener = new com.facebook.ads.AdListener() {
            @Override
            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {


                int aa = FB_banner_decided_id_count - 1;

                if (FB_banner_decided_id_count == 6) {

                    FB_banner_decided_id_count = FB_Setup;

                    FB_adView_Decided = null;

                } else {
                    FB_Banner_Preload_Decided(Type);
                }


            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {

                FB_banner_decided_id_count = FB_Setup;
            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {

            }
        };

        if (Type == 1) {


            if (FB_banner_decided_id_count == 1) {
                FB_banner_decided_id_count = 2;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_decided_id_count == 2) {
                FB_banner_decided_id_count = 3;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_decided_id_count == 3) {
                FB_banner_decided_id_count = 4;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_decided_id_count == 4) {
                FB_banner_decided_id_count = 5;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else {
                FB_banner_decided_id_count = 6;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            }
        } else if (Type == 2 || Type == 3) {


            if (FB_banner_decided_id_count == 1) {
                FB_banner_decided_id_count = 2;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_decided_id_count == 2) {
                FB_banner_decided_id_count = 3;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_decided_id_count == 3) {
                FB_banner_decided_id_count = 4;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_decided_id_count == 4) {
                FB_banner_decided_id_count = 5;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else {
                FB_banner_decided_id_count = 6;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            }
        } else if (Type == 4) {

            if (FB_banner_decided_id_count == 1) {
                FB_banner_decided_id_count = 2;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner1(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_decided_id_count == 2) {
                FB_banner_decided_id_count = 3;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner2(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_decided_id_count == 3) {
                FB_banner_decided_id_count = 4;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner3(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_decided_id_count == 4) {
                FB_banner_decided_id_count = 5;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner4(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else {
                FB_banner_decided_id_count = 6;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner5(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            }
        } else {

            if (FB_banner_decided_id_count == 1) {
                FB_banner_decided_id_count = 2;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_decided_id_count == 2) {
                FB_banner_decided_id_count = 3;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_decided_id_count == 3) {
                FB_banner_decided_id_count = 4;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_decided_id_count == 4) {
                FB_banner_decided_id_count = 5;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else {
                FB_banner_decided_id_count = 6;
                FB_adView_Decided = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            }

        }


        FB_adView_Decided.loadAd(FB_adView_Decided.buildLoadAdConfig().withAdListener(adListener).build());


    }

    public static void FB_Banner_Preload_Show_Decided(final RelativeLayout Ad_Layout,
                                                      final int Banner_Type) {

        if (FB_adView_Decided != null) {
            Ad_Layout.setVisibility(View.VISIBLE);
            Ad_Layout.removeAllViews();
            Ad_Layout.addView(FB_adView_Decided);
        } else {
            Ad_Layout.setVisibility(View.GONE);


            if (Butter.getextra2(Contextt).equals(GL)) {

                if ((Butter.getSetup(Contextt)).equals("1") ||
                        (Butter.getSetup(Contextt)).equals("2") ||
                        (Butter.getSetup(Contextt)).equals("3") ||
                        (Butter.getSetup(Contextt)).equals("4") ||
                        (Butter.getSetup(Contextt)).equals("5") ||
                        (Butter.getSetup(Contextt)).equals("6") ||
                        (Butter.getSetup(Contextt)).equals("7") ||
                        (Butter.getSetup(Contextt)).equals("8") ||
                        (Butter.getSetup(Contextt)).equals("9") ||
                        (Butter.getSetup(Contextt)).equals("10")) {

                    Banner_Auto_Setup(Ad_Layout, Banner_Type);

                } else if ((Butter.getSetup(Contextt)).equals("0")) {

                    Banner_Normal(Ad_Layout, Banner_Type);

                }

            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Banner(Ad_Layout, Banner_Type);
            } else {
                Max_Banner(Ad_Layout, Banner_Type);
            }

        }


    }

    public static void FB_Banner_Preload(int Type) {


        Which_Banner_Max = Type;

        com.facebook.ads.AdListener adListener;
        adListener = new com.facebook.ads.AdListener() {
            @Override
            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {


                int aa = FB_banner_loaded_id_count - 1;

                if (FB_banner_loaded_id_count == 6) {

                    FB_banner_loaded_id_count = FB_Setup;

                    FB_adView_Pre = null;
                } else {
                    FB_Banner_Preload(Type);
                }


            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {

                FB_banner_loaded_id_count = FB_Setup;
            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {

            }
        };

        if (Type == 1) {

            if (FB_banner_loaded_id_count == 1) {
                FB_banner_loaded_id_count = 2;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_loaded_id_count == 2) {
                FB_banner_loaded_id_count = 3;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_loaded_id_count == 3) {
                FB_banner_loaded_id_count = 4;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else if (FB_banner_loaded_id_count == 4) {
                FB_banner_loaded_id_count = 5;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            } else {
                FB_banner_loaded_id_count = 6;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            }
        } else if (Type == 2 || Type == 3) {


            if (FB_banner_loaded_id_count == 1) {
                FB_banner_loaded_id_count = 2;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_loaded_id_count == 2) {
                FB_banner_loaded_id_count = 3;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_loaded_id_count == 3) {
                FB_banner_loaded_id_count = 4;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_loaded_id_count == 4) {
                FB_banner_loaded_id_count = 5;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else {
                FB_banner_loaded_id_count = 6;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            }
        } else if (Type == 4) {

            if (FB_banner_loaded_id_count == 1) {
                FB_banner_loaded_id_count = 2;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner1(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_loaded_id_count == 2) {
                FB_banner_loaded_id_count = 3;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner2(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_loaded_id_count == 3) {
                FB_banner_loaded_id_count = 4;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner3(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else if (FB_banner_loaded_id_count == 4) {
                FB_banner_loaded_id_count = 5;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner4(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            } else {
                FB_banner_loaded_id_count = 6;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_MREC_Banner5(Contextt), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
            }
        } else {

            if (FB_banner_loaded_id_count == 1) {
                FB_banner_loaded_id_count = 2;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner1(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_loaded_id_count == 2) {
                FB_banner_loaded_id_count = 3;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner2(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_loaded_id_count == 3) {
                FB_banner_loaded_id_count = 4;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner3(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else if (FB_banner_loaded_id_count == 4) {
                FB_banner_loaded_id_count = 5;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner4(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            } else {
                FB_banner_loaded_id_count = 6;
                FB_adView_Pre = new com.facebook.ads.AdView(Contextt, "" + Butter.getFB_Banner5(Contextt), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
            }

        }


        FB_adView_Pre.loadAd(FB_adView_Pre.buildLoadAdConfig().withAdListener(adListener).build());


    }

    public static void FB_Banner_Preload_Show(final RelativeLayout Ad_Layout) {

        if (FB_adView_Pre != null) {
            Ad_Layout.setVisibility(View.VISIBLE);
            Ad_Layout.removeAllViews();
            Ad_Layout.addView(FB_adView_Pre);
        } else {
            Ad_Layout.setVisibility(View.GONE);


            if (Butter.getextra2(Contextt).equals(GL)) {

                if ((Butter.getSetup(Contextt)).equals("1") ||
                        (Butter.getSetup(Contextt)).equals("2") ||
                        (Butter.getSetup(Contextt)).equals("3") ||
                        (Butter.getSetup(Contextt)).equals("4") ||
                        (Butter.getSetup(Contextt)).equals("5") ||
                        (Butter.getSetup(Contextt)).equals("6") ||
                        (Butter.getSetup(Contextt)).equals("7") ||
                        (Butter.getSetup(Contextt)).equals("8") ||
                        (Butter.getSetup(Contextt)).equals("9") ||
                        (Butter.getSetup(Contextt)).equals("10")) {

                    Banner_Auto_Setup(Ad_Layout, Which_Banner_Max);

                } else if ((Butter.getSetup(Contextt)).equals("0")) {

                    Banner_Normal(Ad_Layout, Which_Banner_Max);

                }

            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Banner(Ad_Layout, Which_Banner_Max);
            } else {
                Max_Banner(Ad_Layout, Which_Banner_Max);
            }


        }
        FB_Banner_Preload(Which_Banner_Max);
    }

    public static void FB_Native_Pre_Load(int Native_Type) {


        Which_Native_Max = Native_Type;

        DisplayMetrics metrics = Contextt.getResources()
                .getDisplayMetrics();

        if (Native_Type == 2) {

            if (FB_native_loaded_id_count == 1) {
                FB_native_loaded_id_count = 2;
                nativeAd_FB_Pre = new com.facebook.ads.NativeAd(Contextt, Butter.getFB_Native_Medium1(Contextt));
            } else if (FB_native_loaded_id_count == 2) {
                FB_native_loaded_id_count = 3;
                nativeAd_FB_Pre = new com.facebook.ads.NativeAd(Contextt, Butter.getFB_Native_Medium2(Contextt));
            } else if (FB_native_loaded_id_count == 3) {
                FB_native_loaded_id_count = 4;
                nativeAd_FB_Pre = new com.facebook.ads.NativeAd(Contextt, Butter.getFB_Native_Medium3(Contextt));
            } else if (FB_native_loaded_id_count == 4) {
                FB_native_loaded_id_count = 5;
                nativeAd_FB_Pre = new com.facebook.ads.NativeAd(Contextt, Butter.getFB_Native_Medium4(Contextt));
            } else {
                FB_native_loaded_id_count = 6;
                nativeAd_FB_Pre = new com.facebook.ads.NativeAd(Contextt, Butter.getFB_Native_Medium5(Contextt));
            }


        } else {

            if (FB_native_loaded_id_count == 1) {
                FB_native_loaded_id_count = 2;
                nativeAd_Banner_FB_Pre = new com.facebook.ads.NativeBannerAd(Contextt, Butter.getFB_Native_Small1(Contextt));
            } else if (FB_native_loaded_id_count == 2) {
                FB_native_loaded_id_count = 3;
                nativeAd_Banner_FB_Pre = new com.facebook.ads.NativeBannerAd(Contextt, Butter.getFB_Native_Small2(Contextt));
            } else if (FB_native_loaded_id_count == 3) {
                FB_native_loaded_id_count = 4;
                nativeAd_Banner_FB_Pre = new com.facebook.ads.NativeBannerAd(Contextt, Butter.getFB_Native_Small3(Contextt));
            } else if (FB_native_loaded_id_count == 4) {
                FB_native_loaded_id_count = 5;
                nativeAd_Banner_FB_Pre = new com.facebook.ads.NativeBannerAd(Contextt, Butter.getFB_Native_Small4(Contextt));
            } else {
                FB_native_loaded_id_count = 6;
                nativeAd_Banner_FB_Pre = new com.facebook.ads.NativeBannerAd(Contextt, Butter.getFB_Native_Small5(Contextt));
            }
        }


        NativeAdListener nativeAdListener = new NativeAdListener() {

            @Override
            public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {
                int aa = FB_native_loaded_id_count - 1;


                if (FB_native_loaded_id_count == 6) {

                    FB_native_loaded_id_count = FB_Setup;


                    nativeAd_Banner_FB_Pre = null;
                    nativeAd_FB_Pre = null;


                } else {
                    FB_Native_Pre_Load(Native_Type);
                }


            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {

                View adView;
                if (Native_Type == 2) {
                    adView = NativeAdView.render(Contextt, nativeAd_FB_Pre);
                } else {
                    adView = NativeBannerAdView.render(Contextt, nativeAd_Banner_FB_Pre, NativeBannerAdView.Type.HEIGHT_120);
                }

                FB_native_loaded_id_count = FB_Setup;
            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {

            }

            @Override
            public void onMediaDownloaded(com.facebook.ads.Ad ad) {

            }

        };

        if (Native_Type == 2) {
            nativeAd_FB_Pre.loadAd(
                    nativeAd_FB_Pre.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                            .build());
        } else {
            nativeAd_Banner_FB_Pre.loadAd(
                    nativeAd_Banner_FB_Pre.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .build());
        }

    }

    public static void FB_Native_Pre_Load_Show(final RelativeLayout Ad_Layout) {


        if (nativeAd_Banner_FB_Pre != null || nativeAd_FB_Pre != null) {


            View adView;
            if (Which_Native_Max == 2) {
                Ad_Layout.getLayoutParams().height = 800;
                adView = NativeAdView.render(Contextt, nativeAd_FB_Pre);
            } else {
                adView = NativeBannerAdView.render(Contextt, nativeAd_Banner_FB_Pre, NativeBannerAdView.Type.HEIGHT_120);
            }

            Ad_Layout.setVisibility(View.VISIBLE);
            Ad_Layout.removeAllViews();
            Ad_Layout.addView(adView);

        } else {
            Ad_Layout.setVisibility(View.GONE);


            if (Butter.getextra2(Contextt).equals(GL)) {

                if ((Butter.getSetup(Contextt)).equals("1") ||
                        (Butter.getSetup(Contextt)).equals("2") ||
                        (Butter.getSetup(Contextt)).equals("3") ||
                        (Butter.getSetup(Contextt)).equals("4") ||
                        (Butter.getSetup(Contextt)).equals("5") ||
                        (Butter.getSetup(Contextt)).equals("6") ||
                        (Butter.getSetup(Contextt)).equals("7") ||
                        (Butter.getSetup(Contextt)).equals("8") ||
                        (Butter.getSetup(Contextt)).equals("9") ||
                        (Butter.getSetup(Contextt)).equals("10")) {

                    Native_Auto_Setup(Contextt, Ad_Layout,
                            Which_Native_Max, 0, 0, 0);

                } else if ((Butter.getSetup(Contextt)).equals("0")) {

                    Native_Normal(Contextt, Ad_Layout,
                            Which_Native_Max, 0, 0, 0);

                }

            } else if (Butter.getextra2(Contextt).equals(AL)) {
                Max_Native(Contextt, Ad_Layout, Which_Native_Max, 0, 0, 0);
            } else {
                Max_Native(Contextt, Ad_Layout, Which_Native_Max, 0, 0, 0);
            }

        }

        FB_Native_Pre_Load(Which_Native_Max);

    }

    public static void Tappx_PreLoad_Inter(Context mContext, int Ad_Type) {


        tappxInterstitial_preload = new TappxInterstitial(mContext,
                Butter.gettx(Contextt));
        tappxInterstitial_preload.loadAd();
        tappxInterstitial_preload
                .setListener(new TappxInterstitialListener() {
                    @Override
                    public void onInterstitialLoaded(
                            TappxInterstitial tappxInterstitial) {
                        AL_FB_Inter_Failed = 1;


                    }

                    @Override
                    public void onInterstitialLoadFailed(
                            TappxInterstitial tappxInterstitial,
                            TappxAdError tappxAdError) {


                        if ((new Random().nextInt((2 - 1) + 1) + 1) == 1) {
                            SO = SO_FULLPAGE;
                        } else {
                            SO = SO_OFFERWALL;
                        }

                        startAppAd.loadAd(SO, new AdEventListener() {
                            @Override
                            public void onReceiveAd(Ad ad) {
                                AL_FB_Inter_Failed = 50;


                            }

                            @Override
                            public void onFailedToReceiveAd(Ad ad) {


                            }

                        });

                    }

                    @Override
                    public void onInterstitialClicked(
                            TappxInterstitial arg0) {

                    }

                    @Override
                    public void onInterstitialDismissed(
                            TappxInterstitial arg0) {


                    }

                    @Override
                    public void onInterstitialShown(
                            TappxInterstitial arg0) {


                    }

                });


    }

    public static void Tappx_Banner(RelativeLayout Ad_Layout, int Banner_Type) {

        Ad_Layout.removeAllViews();

        TappxBanner.AdSize Banner_Type_Size_Tappx = null;

        if (Banner_Type == 1) {

            Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

        } else if (Banner_Type == 2) {

            Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

        } else if (Banner_Type == 3) {

            Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

        } else if (Banner_Type == 4) {

            Banner_Type_Size_Tappx = TappxBanner.AdSize.BANNER_300x250;

        } else {

            Banner_Type_Size_Tappx = TappxBanner.AdSize.SMART_BANNER;

        }

        Tappxbanner = new TappxBanner(Contextt, Butter
                .gettx(Contextt));
        Tappxbanner.setAdSize(Banner_Type_Size_Tappx);
        Ad_Layout.addView(Tappxbanner);
        Tappxbanner.loadAd();
        Tappxbanner.setRefreshTimeSeconds(45);

        Tappxbanner.setListener(new TappxBannerListener() {
            @Override
            public void onBannerLoaded(
                    TappxBanner tappxBanner) {

                Ad_Layout.setVisibility(View.VISIBLE);

                try {
                    if (gifImageView.getVisibility() == View.VISIBLE) {
                        gifImageView.setVisibility(View.GONE);
                    }
                } catch (Exception e) {
                }

                Butter.setsplashcount(
                        Contextt,
                        (Butter.getsplashcount(Contextt) + 1));

            }

            @Override
            public void onBannerLoadFailed(
                    TappxBanner tappxBanner,
                    TappxAdError tappxAdError) {

                Ad_Layout.setVisibility(View.GONE);
                SO_Banner(Ad_Layout, Banner_Type);

            }

            @Override
            public void onBannerClicked(
                    TappxBanner tappxBanner) {
                Ad_Layout.setVisibility(View.GONE);
            }

            @Override
            public void onBannerExpanded(
                    TappxBanner tappxBanner) {
            }

            @Override
            public void onBannerCollapsed(
                    TappxBanner tappxBanner) {
            }
        });

    }

    public static void Unity_Inter(Context uContext) {

        Dialog dialog_ad;
        dialog_ad = new Dialog(uContext);
        dialog_ad.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog_ad.getWindow() != null)
            dialog_ad.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_ad.setCancelable(false);
        dialog_ad.setContentView(R.layout.loading_ads);

        TextView title1 = dialog_ad.findViewById(R.id.title);
        TextView message1 = dialog_ad.findViewById(R.id.message);
        title1.setText("Loading Ads . . .");
        message1.setText("Wait While Loading Ads, Sorry for Inconvenience and Thank You for Support and Waiting.");

        dialog_ad.show();

        UnityAds.load("" + Butter.getAL_Inter(Contextt), new IUnityAdsLoadListener() {
            @Override
            public void onUnityAdsAdLoaded(String placementId) {

                IUnityAdsShowListener showListener = new IUnityAdsShowListener() {

                    @Override
                    public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
                        try {
                            Tappx_Inter(uContext);
                            dialog_ad.dismiss();
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onUnityAdsShowStart(String placementId) {
                    }

                    @Override
                    public void onUnityAdsShowClick(String placementId) {
                    }

                    @Override
                    public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                    }
                };

                try {
                    UnityAds.show((Activity) Contextt, "" + Butter.getAL_Inter(Contextt), new UnityAdsShowOptions(), showListener);
                    if (dialog_ad != null) {
                        if (dialog_ad.isShowing()) {
                            dialog_ad.dismiss();
                        }
                    }
                } catch (Exception e) {
                    if (dialog_ad != null) {
                        if (dialog_ad.isShowing()) {
                            dialog_ad.dismiss();
                        }
                    }
                }
            }

            @Override
            public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
                try {
                    if (dialog_ad != null) {
                        if (dialog_ad.isShowing()) {
                            Tappx_Inter(uContext);
                            dialog_ad.dismiss();
                        }
                    }

                } catch (Exception e) {
                }
            }
        });
    }

    public static void Unity_Inter_App_Open(Context uContext) {

        UnityAds.load("" + Butter.getAL_Inter(Contextt), new IUnityAdsLoadListener() {
            @Override
            public void onUnityAdsAdLoaded(String placementId) {

                IUnityAdsShowListener showListener = new IUnityAdsShowListener() {

                    @Override
                    public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
                        try {
                            Tappx_Inter(uContext);
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onUnityAdsShowStart(String placementId) {
                    }

                    @Override
                    public void onUnityAdsShowClick(String placementId) {
                    }

                    @Override
                    public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                    }
                };

                try {
                    UnityAds.show((Activity) Contextt, "" + Butter.getAL_Inter(Contextt), new UnityAdsShowOptions(), showListener);
                } catch (Exception e) {

                }
            }

            @Override
            public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
                Tappx_Inter(uContext);
            }
        });
    }

    public static void Unity_Banner(final RelativeLayout Ad_Layout, final int Banner_Type) {

        BannerView bannerView = new BannerView((Activity) Contextt, "" + Butter.getAL_Banner(Contextt), new UnityBannerSize(468, 60));
        bannerView.load();

        bannerView.setListener(new BannerView.IListener() {
            @Override
            public void onBannerLoaded(BannerView bannerAdView) {
                Ad_Layout.addView(bannerView);
                Ad_Layout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onBannerClick(BannerView bannerAdView) {

            }

            @Override
            public void onBannerFailedToLoad(BannerView bannerAdView, BannerErrorInfo errorInfo) {
                Tappx_Banner(Ad_Layout, Banner_Type);
            }

            @Override
            public void onBannerLeftApplication(BannerView bannerView) {

            }
        });

    }

}