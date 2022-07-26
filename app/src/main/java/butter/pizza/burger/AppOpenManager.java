package butter.pizza.burger;

import static androidx.lifecycle.Lifecycle.Event.ON_START;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;


public class AppOpenManager implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
    private AppOpenAd appOpenAd = null;
    private Activity currentActivity;
    private static boolean isShowingAd = false;
    String App_Open_ID = "";
    int Check = 1, Count = 1, Total_Count = 3;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;

    private final Application myApplication;


    public AppOpenManager(Application myApplication) {
        this.myApplication = myApplication;


        this.myApplication.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

        fetchAd();

    }


    public void showAdIfAvailable() {


        if (Butter.getincreseeee(myApplication) == 202 || Butter.getincreseeee(myApplication) == 203) {
            Pizza.Unity_Inter_App_Open(myApplication);
            return;
        }

        if (Butter.getincreseeee(myApplication) == 302 || Butter.getincreseeee(myApplication) == 303) {
            Pizza.FB_Inter_Show(myApplication);
            return;
        }

        if (Pizza.Exit_Menu_Decided == 100
                | Butter.getincreseeee(myApplication) == 200 || Butter.getincreseeee(myApplication) == 201
                || Butter.getincreseeee(myApplication) == 300 || Butter.getincreseeee(myApplication) == 301) {
            return;
        }


        if (!isShowingAd && isAdAvailable()) {

            FullScreenContentCallback fullScreenContentCallback =
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            AppOpenManager.this.appOpenAd = null;
                            isShowingAd = false;

                            if ((Butter.getSetup(myApplication)).equals("1") ||
                                    (Butter.getSetup(myApplication)).equals("2") ||
                                    (Butter.getSetup(myApplication)).equals("3") ||
                                    (Butter.getSetup(myApplication)).equals("4") ||
                                    (Butter.getSetup(myApplication)).equals("5") ||
                                    (Butter.getSetup(myApplication)).equals("6") ||
                                    (Butter.getSetup(myApplication)).equals("7") ||
                                    (Butter.getSetup(myApplication)).equals("8") ||
                                    (Butter.getSetup(myApplication)).equals("9") ||
                                    (Butter.getSetup(myApplication)).equals("10")) {

                                Check = 1;
                                fetchAd();

                            } else if ((Butter.getSetup(myApplication)).equals("0")) {

                                Check = 0;
                                fetchAd();

                            }


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

        } else {

            if ((Butter.getSetup(myApplication)).equals("1") ||
                    (Butter.getSetup(myApplication)).equals("2") ||
                    (Butter.getSetup(myApplication)).equals("3") ||
                    (Butter.getSetup(myApplication)).equals("4") ||
                    (Butter.getSetup(myApplication)).equals("5") ||
                    (Butter.getSetup(myApplication)).equals("6") ||
                    (Butter.getSetup(myApplication)).equals("7") ||
                    (Butter.getSetup(myApplication)).equals("8") ||
                    (Butter.getSetup(myApplication)).equals("9") ||
                    (Butter.getSetup(myApplication)).equals("10")) {

                Check = 1;
                fetchAd();

            } else if ((Butter.getSetup(myApplication)).equals("0")) {

                Check = 0;
                fetchAd();

            }

        }
    }


    public void fetchAd() {

        if (Pizza.Exit_Menu_Decided == 100
                || Butter.getincreseeee(myApplication) == 200 || Butter.getincreseeee(myApplication) == 201
                || Butter.getincreseeee(myApplication) == 202 || Butter.getincreseeee(myApplication) == 203
                || Butter.getincreseeee(myApplication) == 300 || Butter.getincreseeee(myApplication) == 301
                || Butter.getincreseeee(myApplication) == 302 || Butter.getincreseeee(myApplication) == 303) {
            return;
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Pizza.Server_Yes_No == 1 || Pizza.Server_Yes_No == 0) {

                    if (isAdAvailable()) {
                        return;
                    }

                    if ((Butter.getSetup(myApplication)).equals("1") ||
                            (Butter.getSetup(myApplication)).equals("2") ||
                            (Butter.getSetup(myApplication)).equals("3") ||
                            (Butter.getSetup(myApplication)).equals("4") ||
                            (Butter.getSetup(myApplication)).equals("5") ||
                            (Butter.getSetup(myApplication)).equals("6") ||
                            (Butter.getSetup(myApplication)).equals("7") ||
                            (Butter.getSetup(myApplication)).equals("8") ||
                            (Butter.getSetup(myApplication)).equals("9") ||
                            (Butter.getSetup(myApplication)).equals("10")) {


                        if ((Butter.getSetup(myApplication)).equals("1")) {

                            if (Check == 1) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (Butter.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO33(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO333(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((Butter.getSetup(myApplication)).equals("2")) {

                            if (Check == 1) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {

                                if (Butter.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO33(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO333(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((Butter.getSetup(myApplication)).equals("3")) {

                            if (Check == 1) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {

                                if (Butter.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO33(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO333(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((Butter.getSetup(myApplication)).equals("4")) {

                            if (Check == 1) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 6) {

                                if (Butter.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO33(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO333(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((Butter.getSetup(myApplication)).equals("5")) {

                            if (Check == 1) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 6) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 7) {

                                if (Butter.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO33(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO333(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((Butter.getSetup(myApplication)).equals("6")) {

                            if (Check == 1) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {

                                if (Butter.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO33(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO333(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((Butter.getSetup(myApplication)).equals("7")) {

                            if (Check == 1) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {

                                if (Butter.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO33(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO333(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((Butter.getSetup(myApplication)).equals("8")) {

                            if (Check == 1) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (Butter.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO11(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO111(myApplication);

                                    Butter.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {


                                if (Butter.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO22(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO222(myApplication);

                                    Butter.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 6) {

                                if (Butter.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = Butter.getAO33(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = Butter.getAO333(myApplication);

                                    Butter.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }


                    } else if ((Butter.getSetup(myApplication)).equals("0")) {

                        App_Open_ID = Butter.getapp_open(myApplication);

                    }

                    loadCallback =
                            new AppOpenAd.AppOpenAdLoadCallback() {

                                @Override
                                public void onAppOpenAdLoaded(AppOpenAd ad) {

                                    if ((Butter.getSetup(myApplication)).equals("1") ||
                                            (Butter.getSetup(myApplication)).equals("2") ||
                                            (Butter.getSetup(myApplication)).equals("3") ||
                                            (Butter.getSetup(myApplication)).equals("4") ||
                                            (Butter.getSetup(myApplication)).equals("5") ||
                                            (Butter.getSetup(myApplication)).equals("6") ||
                                            (Butter.getSetup(myApplication)).equals("7") ||
                                            (Butter.getSetup(myApplication)).equals("8") ||
                                            (Butter.getSetup(myApplication)).equals("9") ||
                                            (Butter.getSetup(myApplication)).equals("10")) {
                                        Check = 1;
                                    } else if ((Butter.getSetup(myApplication)).equals("0")) {
                                        Check = 0;
                                    }

                                    AppOpenManager.this.appOpenAd = ad;
                                }


                                @Override
                                public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                                    if ((Butter.getSetup(myApplication)).equals("1") ||
                                            (Butter.getSetup(myApplication)).equals("2") ||
                                            (Butter.getSetup(myApplication)).equals("3") ||
                                            (Butter.getSetup(myApplication)).equals("4") ||
                                            (Butter.getSetup(myApplication)).equals("5") ||
                                            (Butter.getSetup(myApplication)).equals("6") ||
                                            (Butter.getSetup(myApplication)).equals("7") ||
                                            (Butter.getSetup(myApplication)).equals("8") ||
                                            (Butter.getSetup(myApplication)).equals("9") ||
                                            (Butter.getSetup(myApplication)).equals("10")) {
                                        Check = Check + 1;

                                        if ((Butter.getSetup(myApplication)).equals("1")) {
                                            Total_Count = 3;
                                        } else if ((Butter.getSetup(myApplication)).equals("2")) {
                                            Total_Count = 4;
                                        } else if ((Butter.getSetup(myApplication)).equals("3")) {
                                            Total_Count = 5;
                                        } else if ((Butter.getSetup(myApplication)).equals("4")) {
                                            Total_Count = 6;
                                        } else if ((Butter.getSetup(myApplication)).equals("5")) {
                                            Total_Count = 7;
                                        } else if ((Butter.getSetup(myApplication)).equals("6")) {
                                            Total_Count = 4;
                                        } else if ((Butter.getSetup(myApplication)).equals("7")) {
                                            Total_Count = 5;
                                        } else if ((Butter.getSetup(myApplication)).equals("8")) {
                                            Total_Count = 6;
                                        } else if ((Butter.getSetup(myApplication)).equals("9")) {
                                            Total_Count = 3;
                                        } else if ((Butter.getSetup(myApplication)).equals("10")) {
                                            Total_Count = 3;
                                        } else {
                                            Total_Count = 3;
                                        }

                                        if (Count == Total_Count) {
                                            Count = 1;

                                        } else {
                                            Count++;
                                            fetchAd();
                                        }

                                    } else if ((Butter.getSetup(myApplication)).equals("0")) {
                                        Check = 0;

                                    }

                                }


                            };
                    AdRequest request = getAdRequest();
                    AppOpenAd.load(
                            myApplication, App_Open_ID, request,
                            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);

                } else {

                    handler.postDelayed(this, 500);

                }

            }

        }, 500);


    }


    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }


    public boolean isAdAvailable() {
        return appOpenAd != null;
    }


    @OnLifecycleEvent(ON_START)
    public void onStart() {
        showAdIfAvailable();
    }


    @Override
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        currentActivity = null;
    }

}

