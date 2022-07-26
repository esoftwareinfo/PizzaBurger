package butter.pizza.burger;

import android.content.Context;

public class Butter {

    private static final String TX = "tx";

    public static void settx(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(TX, string).commit();
    }

    public static String gettx(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(TX, "");
    }

    private static final String BANNER = "banner";

    public static void setbanner(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(BANNER, Int).commit();
    }

    public static int getbanner(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(BANNER, 0);
    }

    private static final String BANNER1 = "banner1";

    public static void setbanner1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(BANNER1, string).commit();
    }

    public static String getbanner1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(BANNER1, "");
    }

    private static final String BANNER2 = "banner2";

    public static void setbanner2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(BANNER2, string).commit();
    }

    public static String getbanner2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(BANNER2, "");
    }

    private static final String INTER = "inter";

    public static void setinter(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(INTER, Int).commit();
    }

    public static int getinter(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(INTER, 0);
    }

    private static final String INTER1 = "inter1";

    public static void setinter1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(INTER1, string).commit();
    }

    public static String getinter1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(INTER1, "");
    }

    private static final String INTER2 = "inter2";

    public static void setinter2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(INTER2, string).commit();
    }

    public static String getinter2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(INTER2, "");
    }

    private static final String NATIVE = "native";

    public static void setnative(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(NATIVE, Int).commit();
    }

    public static int getnative(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(NATIVE, 0);
    }

    private static final String NATIVE1 = "native1";

    public static void setnative1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(NATIVE1, string).commit();
    }

    public static String getnative1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(NATIVE1, "");
    }

    private static final String NATIVE2 = "native2";

    public static void setnative2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(NATIVE2, string).commit();
    }

    public static String getnative2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(NATIVE2, "");
    }


    private static final String APP_ID = "app_id";

    public static void setapp_id(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(APP_ID, string).commit();
    }

    public static String getapp_id(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(APP_ID, "");
    }


    private static final String APP_OPEN = "app_open";

    public static void setapp_open(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(APP_OPEN, string).commit();
    }

    public static String getapp_open(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(APP_OPEN, "");
    }


    private static final String REWARD = "reward";

    public static void setreward(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(REWARD, string).commit();
    }

    public static String getreward(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(REWARD, "");
    }


    private static final String INTER_REWARD = "inter_reward";

    public static void setinter_reward(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(INTER_REWARD, string).commit();
    }

    public static String getinter_reward(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(INTER_REWARD, "");
    }


    private static final String EXTRA1 = "extra1";

    public static void setextra1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(EXTRA1, string).commit();
    }

    public static String getextra1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(EXTRA1, "");
    }


    private static final String EXTRA2 = "extra2";

    public static void setextra2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(EXTRA2, string).commit();
    }

    public static String getextra2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(EXTRA2, "");
    }


    private static final String SPLASHCOUNT = "splashcount";

    public static void setsplashcount(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(SPLASHCOUNT, Int).commit();
    }

    public static int getsplashcount(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(SPLASHCOUNT, 0);
    }

    private static final String COUNT = "count";

    public static void setcount(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(COUNT, Int).commit();
    }

    public static int getcount(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(COUNT, 1);
    }

    private static final String COUNT_Approval = "count_Approval";

    public static void setcount_Approval(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(COUNT_Approval, Int).commit();
    }

    public static int getcount_Approval(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(COUNT_Approval, 1);
    }

    private static final String INCREASEEEEE = "increseeee";

    public static void setincreseeee(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(INCREASEEEEE, Int).commit();
    }

    public static int getincreseeee(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(INCREASEEEEE, 0);
    }


    private static final String Setup = "Setup";

    public static void setSetup(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(Setup, string).commit();
    }

    public static String getSetup(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(Setup, "");
    }

    private static final String BB1 = "BB1";

    public static void setBB1(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(BB1, Int).commit();
    }

    public static int getBB1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(BB1, 0);
    }

    private static final String BB2 = "BB2";

    public static void setBB2(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(BB2, Int).commit();
    }

    public static int getBB2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(BB2, 0);
    }

    private static final String BB3 = "BB3";

    public static void setBB3(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(BB3, Int).commit();
    }

    public static int getBB3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(BB3, 0);
    }

    private static final String B11 = "B11";

    public static void setB11(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(B11, string).commit();
    }

    public static String getB11(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(B11, "");
    }

    private static final String B111 = "B111";

    public static void setB111(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(B111, string).commit();
    }

    public static String getB111(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(B111, "");
    }

    private static final String B22 = "B22";

    public static void setB22(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(B22, string).commit();
    }

    public static String getB22(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(B22, "");
    }

    private static final String B222 = "B222";

    public static void setB222(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(B222, string).commit();
    }

    public static String getB222(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(B222, "");
    }

    private static final String B33 = "B33";

    public static void setB33(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(B33, string).commit();
    }

    public static String getB33(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(B33, "");
    }

    private static final String B333 = "B333";

    public static void setB333(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(B333, string).commit();
    }

    public static String getB333(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(B333, "");
    }

    private static final String II1 = "II1";

    public static void setII1(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(II1, Int).commit();
    }

    public static int getII1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(II1, 0);
    }

    private static final String II2 = "II2";

    public static void setII2(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(II2, Int).commit();
    }

    public static int getII2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(II2, 0);
    }

    private static final String II3 = "II3";

    public static void setII3(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(II3, Int).commit();
    }

    public static int getII3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(II3, 0);
    }

    private static final String I11 = "I11";

    public static void setI11(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(I11, string).commit();
    }

    public static String getI11(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(I11, "");
    }

    private static final String I111 = "I111";

    public static void setI111(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(I111, string).commit();
    }

    public static String getI111(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(I111, "");
    }

    private static final String I22 = "I22";

    public static void setI22(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(I22, string).commit();
    }

    public static String getI22(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(I22, "");
    }

    private static final String I222 = "I222";

    public static void setI222(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(I222, string).commit();
    }

    public static String getI222(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(I222, "");
    }

    private static final String I33 = "I33";

    public static void setI33(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(I33, string).commit();
    }

    public static String getI33(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(I33, "");
    }

    private static final String I333 = "I333";

    public static void setI333(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(I333, string).commit();
    }

    public static String getI333(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(I333, "");
    }

    private static final String NN1 = "NN1";

    public static void setNN1(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(NN1, Int).commit();
    }

    public static int getNN1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(NN1, 0);
    }

    private static final String NN2 = "NN2";

    public static void setNN2(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(NN2, Int).commit();
    }

    public static int getNN2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(NN2, 0);
    }

    private static final String NN3 = "NN3";

    public static void setNN3(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(NN3, Int).commit();
    }

    public static int getNN3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(NN3, 0);
    }

    private static final String N11 = "N11";

    public static void setN11(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(N11, string).commit();
    }

    public static String getN11(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(N11, "");
    }

    private static final String N111 = "N111";

    public static void setN111(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(N111, string).commit();
    }

    public static String getN111(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(N111, "");
    }

    private static final String N22 = "N22";

    public static void setN22(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(N22, string).commit();
    }

    public static String getN22(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(N22, "");
    }

    private static final String N222 = "N222";

    public static void setN222(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(N222, string).commit();
    }

    public static String getN222(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(N222, "");
    }

    private static final String N33 = "N33";

    public static void setN33(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(N33, string).commit();
    }

    public static String getN33(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(N33, "");
    }

    private static final String N333 = "N333";

    public static void setN333(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(N333, string).commit();
    }

    public static String getN333(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(N333, "");
    }

    private static final String AOAO1 = "AOAO1";

    public static void setAOAO1(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(AOAO1, Int).commit();
    }

    public static int getAOAO1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(AOAO1, 0);
    }

    private static final String AOAO2 = "AOAO2";

    public static void setAOAO2(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(AOAO2, Int).commit();
    }

    public static int getAOAO2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(AOAO2, 0);
    }


    private static final String AOAO3 = "AOAO3";

    public static void setAOAO3(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(AOAO3, Int).commit();
    }

    public static int getAOAO3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(AOAO3, 0);
    }

    private static final String AOAO1_AO = "AOAO1_AO";

    public static void setAOAO1_AO(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(AOAO1_AO, Int).commit();
    }

    public static int getAOAO1_AO(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(AOAO1_AO, 0);
    }

    private static final String AOAO2_AO = "AOAO2_AO";

    public static void setAOAO2_AO(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(AOAO2_AO, Int).commit();
    }

    public static int getAOAO2_AO(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(AOAO2_AO, 0);
    }


    private static final String AOAO3_AO = "AOAO3_AO";

    public static void setAOAO3_AO(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(AOAO3_AO, Int).commit();
    }

    public static int getAOAO3_AO(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(AOAO3_AO, 0);
    }

    private static final String AO11 = "AO11";

    public static void setAO11(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AO11, string).commit();
    }

    public static String getAO11(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AO11, "");
    }

    private static final String AO111 = "AO111";

    public static void setAO111(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AO111, string).commit();
    }

    public static String getAO111(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AO111, "");
    }

    private static final String AO22 = "AO22";

    public static void setAO22(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AO22, string).commit();
    }

    public static String getAO22(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AO22, "");
    }

    private static final String AO222 = "AO222";

    public static void setAO222(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AO222, string).commit();
    }

    public static String getAO222(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AO222, "");
    }

    private static final String AO33 = "AO33";

    public static void setAO33(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AO33, string).commit();
    }

    public static String getAO33(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AO33, "");
    }

    private static final String AO333 = "AO333";

    public static void setAO333(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AO333, string).commit();
    }

    public static String getAO333(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AO333, "");
    }

    private static final String RRDD1 = "RRDD1";

    public static void setRRDD1(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(RRDD1, Int).commit();
    }

    public static int getRRDD1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(RRDD1, 0);
    }

    private static final String RRDD2 = "RRDD2";

    public static void setRRDD2(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(RRDD2, Int).commit();
    }

    public static int getRRDD2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(RRDD2, 0);
    }

    private static final String RRDD3 = "RRDD3";

    public static void setRRDD3(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(RRDD3, Int).commit();
    }

    public static int getRRDD3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(RRDD3, 0);
    }

    private static final String RD11 = "RD11";

    public static void setRD11(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(RD11, string).commit();
    }

    public static String getRD11(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(RD11, "");
    }

    private static final String RD111 = "RD111";

    public static void setRD111(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(RD111, string).commit();
    }

    public static String getRD111(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(RD111, "");
    }

    private static final String RD22 = "RD22";

    public static void setRD22(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(RD22, string).commit();
    }

    public static String getRD22(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(RD22, "");
    }

    private static final String RD222 = "RD222";

    public static void setRD222(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(RD222, string).commit();
    }

    public static String getRD222(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(RD222, "");
    }

    private static final String RD33 = "RD33";

    public static void setRD33(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(RD33, string).commit();
    }

    public static String getRD33(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(RD33, "");
    }

    private static final String RD333 = "RD333";

    public static void setRD333(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(RD333, string).commit();
    }

    public static String getRD333(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(RD333, "");
    }

    private static final String IIRRDD1 = "IIRRDD1";

    public static void setIIRRDD1(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(IIRRDD1, Int).commit();
    }

    public static int getIIRRDD1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(IIRRDD1, 0);
    }

    private static final String IIRRDD2 = "IIRRDD2";

    public static void setIIRRDD2(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(IIRRDD2, Int).commit();
    }

    public static int getIIRRDD2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(IIRRDD2, 0);
    }

    private static final String IIRRDD3 = "IIRRDD3";

    public static void setIIRRDD3(Context Context, int Int) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(IIRRDD3, Int).commit();
    }

    public static int getIIRRDD3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(IIRRDD3, 0);
    }

    private static final String IRD11 = "IRD11";

    public static void setIRD11(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(IRD11, string).commit();
    }

    public static String getIRD11(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(IRD11, "");
    }

    private static final String IRD111 = "IRD111";

    public static void setIRD111(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(IRD111, string).commit();
    }

    public static String getIRD111(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(IRD111, "");
    }

    private static final String IRD22 = "IRD22";

    public static void setIRD22(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(IRD22, string).commit();
    }

    public static String getIRD22(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(IRD22, "");
    }

    private static final String IRD222 = "IRD222";

    public static void setIRD222(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(IRD222, string).commit();
    }

    public static String getIRD222(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(IRD222, "");
    }

    private static final String IRD33 = "IRD33";

    public static void setIRD33(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(IRD33, string).commit();
    }

    public static String getIRD33(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(IRD33, "");
    }

    private static final String IRD333 = "IRD333";

    public static void setIRD333(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(IRD333, string).commit();
    }

    public static String getIRD333(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(IRD333, "");
    }

    private static final String FB_SDK_Key = "FB_SDK_Key";

    public static void setFB_SDK_Key(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_SDK_Key, string).commit();
    }

    public static String getFB_SDK_Key(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_SDK_Key, "");
    }

    private static final String FB_Banner1 = "FB_Banner1";

    public static void setFB_Banner1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Banner1, string).commit();
    }

    public static String getFB_Banner1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Banner1, "");
    }

    private static final String FB_Banner2 = "FB_Banner2";

    public static void setFB_Banner2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Banner2, string).commit();
    }

    public static String getFB_Banner2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Banner2, "");
    }

    private static final String FB_Banner3 = "FB_Banner3";

    public static void setFB_Banner3(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Banner3, string).commit();
    }

    public static String getFB_Banner3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Banner3, "");
    }

    private static final String FB_Banner4 = "FB_Banner4";

    public static void setFB_Banner4(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Banner4, string).commit();
    }

    public static String getFB_Banner4(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Banner4, "");
    }

    private static final String FB_Banner5 = "FB_Banner5";

    public static void setFB_Banner5(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Banner5, string).commit();
    }

    public static String getFB_Banner5(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Banner5, "");
    }

    private static final String FB_MREC_Banner1 = "FB_MREC_Banner1";

    public static void setFB_MREC_Banner1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_MREC_Banner1, string).commit();
    }

    public static String getFB_MREC_Banner1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_MREC_Banner1, "");
    }

    private static final String FB_MREC_Banner2 = "FB_MREC_Banner2";

    public static void setFB_MREC_Banner2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_MREC_Banner2, string).commit();
    }

    public static String getFB_MREC_Banner2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_MREC_Banner2, "");
    }

    private static final String FB_MREC_Banner3 = "FB_MREC_Banner3";

    public static void setFB_MREC_Banner3(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_MREC_Banner3, string).commit();
    }

    public static String getFB_MREC_Banner3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_MREC_Banner3, "");
    }

    private static final String FB_MREC_Banner4 = "FB_MREC_Banner4";

    public static void setFB_MREC_Banner4(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_MREC_Banner4, string).commit();
    }

    public static String getFB_MREC_Banner4(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_MREC_Banner4, "");
    }

    private static final String FB_MREC_Banner5 = "FB_MREC_Banner5";

    public static void setFB_MREC_Banner5(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_MREC_Banner5, string).commit();
    }

    public static String getFB_MREC_Banner5(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_MREC_Banner5, "");
    }

    private static final String FB_Inter1 = "FB_Inter1";

    public static void setFB_Inter1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Inter1, string).commit();
    }

    public static String getFB_Inter1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Inter1, "");
    }

    private static final String FB_Inter2 = "FB_Inter2";

    public static void setFB_Inter2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Inter2, string).commit();
    }

    public static String getFB_Inter2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Inter2, "");
    }

    private static final String FB_Inter3 = "FB_Inter3";

    public static void setFB_Inter3(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Inter3, string).commit();
    }

    public static String getFB_Inter3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Inter3, "");
    }

    private static final String FB_Inter4 = "FB_Inter4";

    public static void setFB_Inter4(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Inter4, string).commit();
    }

    public static String getFB_Inter4(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Inter4, "");
    }

    private static final String FB_Inter5 = "FB_Inter5";

    public static void setFB_Inter5(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Inter5, string).commit();
    }

    public static String getFB_Inter5(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Inter5, "");
    }

    private static final String FB_Native_Small1 = "FB_Native_Small1";

    public static void setFB_Native_Small1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Small1, string).commit();
    }

    public static String getFB_Native_Small1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Small1, "");
    }

    private static final String FB_Native_Small2 = "FB_Native_Small2";

    public static void setFB_Native_Small2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Small2, string).commit();
    }

    public static String getFB_Native_Small2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Small2, "");
    }

    private static final String FB_Native_Small3 = "FB_Native_Small3";

    public static void setFB_Native_Small3(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Small3, string).commit();
    }

    public static String getFB_Native_Small3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Small3, "");
    }

    private static final String FB_Native_Small4 = "FB_Native_Small4";

    public static void setFB_Native_Small4(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Small4, string).commit();
    }

    public static String getFB_Native_Small4(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Small4, "");
    }

    private static final String FB_Native_Small5 = "FB_Native_Small5";

    public static void setFB_Native_Small5(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Small5, string).commit();
    }

    public static String getFB_Native_Small5(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Small5, "");
    }

    private static final String FB_Native_Medium1 = "FB_Native_Medium1";

    public static void setFB_Native_Medium1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Medium1, string).commit();
    }

    public static String getFB_Native_Medium1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Medium1, "");
    }

    private static final String FB_Native_Medium2 = "FB_Native_Medium2";

    public static void setFB_Native_Medium2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Medium2, string).commit();
    }

    public static String getFB_Native_Medium2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Medium2, "");
    }

    private static final String FB_Native_Medium3 = "FB_Native_Medium3";

    public static void setFB_Native_Medium3(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Medium3, string).commit();
    }

    public static String getFB_Native_Medium3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Medium3, "");
    }

    private static final String FB_Native_Medium4 = "FB_Native_Medium4";

    public static void setFB_Native_Medium4(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Medium4, string).commit();
    }

    public static String getFB_Native_Medium4(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Medium4, "");
    }

    private static final String FB_Native_Medium5 = "FB_Native_Medium5";

    public static void setFB_Native_Medium5(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Native_Medium5, string).commit();
    }

    public static String getFB_Native_Medium5(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Native_Medium5, "");
    }

    private static final String FB_Reward_Video1 = "FB_Reward_Video1";

    public static void setFB_Reward_Video1(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Reward_Video1, string).commit();
    }

    public static String getFB_Reward_Video1(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Reward_Video1, "");
    }

    private static final String FB_Reward_Video2 = "FB_Reward_Video2";

    public static void setFB_Reward_Video2(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Reward_Video2, string).commit();
    }

    public static String getFB_Reward_Video2(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Reward_Video2, "");
    }

    private static final String FB_Reward_Video3 = "FB_Reward_Video3";

    public static void setFB_Reward_Video3(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Reward_Video3, string).commit();
    }

    public static String getFB_Reward_Video3(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Reward_Video3, "");
    }

    private static final String FB_Reward_Video4 = "FB_Reward_Video4";

    public static void setFB_Reward_Video4(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Reward_Video4, string).commit();
    }

    public static String getFB_Reward_Video4(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Reward_Video4, "");
    }

    private static final String FB_Reward_Video5 = "FB_Reward_Video5";

    public static void setFB_Reward_Video5(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(FB_Reward_Video5, string).commit();
    }

    public static String getFB_Reward_Video5(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(FB_Reward_Video5, "");
    }

    private static final String JSON_TRUE_FALSE = "JSON_TRUE_FALSE";

    public static void setJSON_TRUE_FALSE(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(JSON_TRUE_FALSE, string).commit();
    }

    public static String getJSON_TRUE_FALSE(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(JSON_TRUE_FALSE, "0");
    }

    private static final String AL_Banner = "AL_Banner";

    public static void setAL_Banner(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AL_Banner, string).commit();
    }

    public static String getAL_Banner(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AL_Banner, "");
    }

    private static final String AL_SDK_Key = "AL_SDK_Key";

    public static void setAL_SDK_Key(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AL_SDK_Key, string).commit();
    }

    public static String getAL_SDK_Key(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AL_SDK_Key, "");
    }

    private static final String AL_MREC_Banner = "AL_MREC_Banner";

    public static void setAL_MREC_Banner(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AL_MREC_Banner, string).commit();
    }

    public static String getAL_MREC_Banner(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AL_MREC_Banner, "");
    }

    private static final String AL_Inter = "AL_Inter";

    public static void setAL_Inter(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AL_Inter, string).commit();
    }

    public static String getAL_Inter(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AL_Inter, "");
    }

    private static final String AL_Native_Small = "AL_Native_Small";

    public static void setAL_Native_Small(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AL_Native_Small, string).commit();
    }

    public static String getAL_Native_Small(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AL_Native_Small, "");
    }

    private static final String AL_Native_Medium = "AL_Native_Medium";

    public static void setAL_Native_Medium(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AL_Native_Medium, string).commit();
    }

    public static String getAL_Native_Medium(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AL_Native_Medium, "");
    }

    private static final String AL_Reward_Video = "AL_Reward_Video";

    public static void setAL_Reward_Video(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AL_Reward_Video, string).commit();
    }

    public static String getAL_Reward_Video(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AL_Reward_Video, "");
    }

    private static final String AL_Native_Manual = "AL_Native_Manual";

    public static void setAL_Native_Manual(Context Context, String string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putString(AL_Native_Manual, string).commit();
    }

    public static String getAL_Native_Manual(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getString(AL_Native_Manual, "");
    }

    private static final String FB_Setup = "FB_Setup";

    public static void setFB_Setup(Context Context, int string) {
        Context.getSharedPreferences(Context.getPackageName(), 0).edit()
                .putInt(FB_Setup, string).commit();
    }

    public static int getFB_Setup(Context Context) {
        return Context.getSharedPreferences(Context.getPackageName(), 0)
                .getInt(FB_Setup, 1);
    }


}