package com.xiefr.learn.transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiefr.learn.dao.TeacherDao;
import com.xiefr.learn.entity.Teacher;
import com.xiefr.learn.exception.PrepenseRuntimeException;
import com.xiefr.learn.transaction.TeacherService;

/**
 * 2018-5-10
 * @author xiefr
 * 如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，该设置是最常用的设置。
 */
@Service
@Qualifier("REQUIRED")
public class RequiredImpl implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;
    
    @Transactional(propagation=Propagation.REQUIRED)
    public void saveTeacher(Teacher teacher) {
        teacherDao.save(teacher);
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void saveTeacherError(Teacher teacher) {
        teacherDao.save(teacher);
        throw new PrepenseRuntimeException();
    }
}
