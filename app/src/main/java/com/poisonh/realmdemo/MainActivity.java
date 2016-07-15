package com.poisonh.realmdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.poisonh.realmdemo.dao.StudentDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button mBtnAdd, mBtnDelete, mBtnQuery, mBtnUpdata, mBtnFindAll, mBtnAddList;
    private TextView mTvShow;
    private StudentDaoImpl mStudentDaoImpl;
    private List<Student> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView()
    {
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnUpdata = (Button) findViewById(R.id.btn_updata);
        mBtnFindAll = (Button) findViewById(R.id.btn_findall);
        mBtnAddList = (Button) findViewById(R.id.btn_addlist);

        mTvShow = (TextView) findViewById(R.id.tv_reslut);
        mBtnAdd.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnUpdata.setOnClickListener(this);
        mBtnFindAll.setOnClickListener(this);
        mBtnAddList.setOnClickListener(this);


        mStudentDaoImpl = new StudentDaoImpl(this);
        mList = new ArrayList<>();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_add:
                Student student = new Student();
                student.setId(100);
                student.setmStrName("张三");
                student.setmStrAge("18");
                student.setmStrScore("100");
                try
                {
                    mStudentDaoImpl.addone(student);
                } catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }
                break;
            case R.id.btn_addlist:
                for (int i = 0; i < 5; i++)
                {
                    Student mStudent = new Student();
                    mStudent.setId(103 + i);
                    mStudent.setmStrAge("18" + i);
                    mStudent.setmStrScore("80" + i);
                    mStudent.setmStrName("小狗" + i);
                    mList.add(mStudent);
                }
                try
                {
                    mStudentDaoImpl.addList(mList);
                } catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "批量增加失败", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                break;
            case R.id.btn_delete:
                try
                {
                    mStudentDaoImpl.delete(100);
                } catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_query:
                try
                {

                    if (mStudentDaoImpl.query(100))
                    {
                        Toast.makeText(MainActivity.this, "查询成功", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_updata:
                try
                {
                    Student m = new Student();
                    m.setId(106);
                    m.setmStrAge("160");
                    m.setmStrName("PoisonH");
                    m.setmStrScore("10000");
                    mStudentDaoImpl.updata(m);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_findall:
                try
                {
                    List<Student> mListStudent = mStudentDaoImpl.findAll();
                    String s = "";
                    for (int i = 0; i < mListStudent.size(); i++)
                    {
                        s += "id:" + mListStudent.get(i).getId() + "name:" + mListStudent.get(i).getmStrName();
                    }
                    mTvShow.setText(s);
                } catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        try
        {
            mStudentDaoImpl.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
