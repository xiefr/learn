package com.xiefr.learn.transaction;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiefr.learn.dao.StudentDao;
import com.xiefr.learn.dao.TeacherDao;
import com.xiefr.learn.entity.Student;
import com.xiefr.learn.entity.Teacher;
import com.xiefr.learn.exception.PrepenseRuntimeException;
/**
 * 2018-5-10
 * @author xiefr
 *
 */
@Service
public class CallerService{

    
    private static final Logger log = LoggerFactory.getLogger(CallerService.class);

    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    /*
     * 为了方便测试，TeacherService由用户手动注入
     */
    private TeacherService TeacherService;
    
    /**
     * 调用方开启事务并保存student，再调用被调用方，最后抛出异常
     * 被调用方保存teacher
     * @param student
     * @param teacher
     */
    @Transactional
    public void callerErrorWithTransaction(Student student, Teacher teacher) {
        studentDao.save(student);
        TeacherService.saveTeacher(teacher);
        throw new PrepenseRuntimeException();
    }
    /**
     * 调用方开启事务并保存student，再调用被调用方并捕获被调用方抛出的异常
     * 被调用方保存teacher，再抛出异常
     * @param student
     * @param teacher
     */
    @Transactional
    public void calleeErrorCatchByCallerWithTransaction(Student student, Teacher teacher) {
        studentDao.save(student);
        try {
            TeacherService.saveTeacherError(teacher);
        } catch (PrepenseRuntimeException e) {
            log.info("catch 掉了执行方的异常");
        }
    }

    public TeacherService getTeacherService() {
        return TeacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        TeacherService = teacherService;
    }
    
    
}
