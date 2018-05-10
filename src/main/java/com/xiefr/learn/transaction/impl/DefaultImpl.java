package com.xiefr.learn.transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xiefr.learn.dao.TeacherDao;
import com.xiefr.learn.entity.Teacher;
import com.xiefr.learn.exception.PrepenseRuntimeException;
import com.xiefr.learn.transaction.TeacherService;

/**
 * 2018-5-10
 * @author xiefr
 * 没有开启事务的方法，在事务的传播性上等同于PROPAGATION_SUPPORTS
 */
@Service
@Qualifier("DEFAULT")
public class DefaultImpl implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;
    
    public void saveTeacher(Teacher teacher) {
        teacherDao.save(teacher);
    }
    public void saveTeacherError(Teacher teacher) {
        teacherDao.save(teacher);
        throw new PrepenseRuntimeException();
    }
}
