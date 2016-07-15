package com.poisonh.realmdemo.dao;

import com.poisonh.realmdemo.Student;

import java.util.List;

/**
 * Created by PoisonH on 2016/7/15.
 */
public interface StudentDao
{
    /**
     * 添加一条记录
     *
     * @param student
     * @throws Exception
     */
    void addone(Student student) throws Exception;

    /**
     * 添加一个集合
     *
     * @param list
     * @throws Exception
     */

    void addList(List<Student> list) throws Exception;

    /**
     * 条件删除
     *
     * @param id
     * @throws Exception
     */

    void delete(int id) throws Exception;

    /**
     * 条件查询
     *
     * @param id
     * @return
     * @throws Exception
     */

    boolean query(int id) throws Exception;

    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */

    List<Student> findAll() throws Exception;

    /**
     * 更新数据
     *
     * @return
     * @throws Exception
     */

    void updata(Student student) throws Exception;

    /**
     * 关闭对象
     *
     * @throws Exception
     */

    void close() throws Exception;
}
