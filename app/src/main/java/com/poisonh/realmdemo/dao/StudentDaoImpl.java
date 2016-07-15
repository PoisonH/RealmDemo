package com.poisonh.realmdemo.dao;

import android.content.Context;

import com.poisonh.realmdemo.Student;
import com.poisonh.realmdemo.utils.RealmUtils;

import java.util.List;

import io.realm.Realm;

/**
 * Created by PoisonH on 2016/7/15.
 */
public class StudentDaoImpl implements StudentDao
{
    private Context mContext;
    private Realm mRealm;

    public StudentDaoImpl(Context context)
    {
        this.mContext = context;
        mRealm = RealmUtils.getInstance(mContext).getRealm();
    }

    @Override
    public void addone(Student student) throws Exception
    {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(student);
        mRealm.commitTransaction();
    }

    @Override
    public void addList(List<Student> list) throws Exception
    {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(list);
        mRealm.commitTransaction();
    }

    @Override
    public void delete(int id) throws Exception
    {
        mRealm.beginTransaction();
        Student mStudent = mRealm.where(Student.class).equalTo("id", id).findFirst();
        mStudent.deleteFromRealm();
        mRealm.commitTransaction();
    }

    @Override
    public boolean query(int id) throws Exception
    {
        List<Student> mStudent = mRealm.where(Student.class).equalTo("id", id).findAll();
        if (mStudent.size() != 0)
        {
            return true;
        } else
        {
            return false;
        }

    }

    @Override
    public List<Student> findAll() throws Exception
    {
        List<Student> mList = mRealm.where(Student.class).findAll();
        return mList;
    }

    @Override
    public void updata(Student student) throws Exception
    {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(student);
        mRealm.commitTransaction();
    }

    @Override
    public void close() throws Exception
    {
        mRealm.close();
    }
}
