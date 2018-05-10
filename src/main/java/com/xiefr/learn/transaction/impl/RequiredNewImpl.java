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
 * 创建新事务，无论当前存不存在事务，都创建新事务。
 */
@Service
@Qualifier("REQUIRES_NEW")
public class RequiredNewImpl implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;
    
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void saveTeacher(Teacher teacher) {
        teacherDao.save(teacher);
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void saveTeacherError(Teacher teacher) {
        teacherDao.save(teacher);
        throw new PrepenseRuntimeException();
    }
}
