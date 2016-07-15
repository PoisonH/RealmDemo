package com.poisonh.realmdemo.utils;

import android.content.Context;

import io.realm.Realm;

/**
 * 数据库工具类
 * Created by PoisonH on 2016/7/15.
 */
public class RealmUtils
{
    private static RealmUtils sIntance;
    public final Context mContext;
    private String mStrRealmName = "poisonh.realm";

    public RealmUtils(Context context)
    {
        this.mContext = context;
    }

    /**
     * 获取sIntance单例
     *
     * @param context
     * @return
     */
    public static RealmUtils getInstance(Context context)
    {
        if (sIntance == null)
        {
            synchronized (RealmUtils.class)
            {
                if (sIntance == null)
                {
                    sIntance = new RealmUtils(context);
                }
            }
        }
        return sIntance;
    }

    /**
     * 获取realm对象
     *
     * @return
     */
    public Realm getRealm()
    {
        Realm mRealm = Realm.getDefaultInstance();
        return mRealm;
    }

}
