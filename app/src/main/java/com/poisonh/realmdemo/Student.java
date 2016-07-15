package com.poisonh.realmdemo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by PoisonH on 2016/7/15.
 */
public class Student extends RealmObject
{
    @PrimaryKey
    private int id;
    private String mStrName;
    private String mStrScore;
    private String mStrAge;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getmStrName()
    {
        return mStrName;
    }

    public void setmStrName(String mStrName)
    {
        this.mStrName = mStrName;
    }

    public String getmStrScore()
    {
        return mStrScore;
    }

    public void setmStrScore(String mStrScore)
    {
        this.mStrScore = mStrScore;
    }

    public String getmStrAge()
    {
        return mStrAge;
    }

    public void setmStrAge(String mStrAge)
    {
        this.mStrAge = mStrAge;
    }
}
