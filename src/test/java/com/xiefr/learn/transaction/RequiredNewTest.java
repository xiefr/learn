package com.xiefr.learn.transaction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
@RunWith(SpringRunner.class)  
@SpringBootTest  
public class RequiredNewTest {
    
    private final static String PREFIX = "REQUIRES_NEW";
    
    @Autowired
    CallerService callerService;
    @Autowired
    @Qualifier("REQUIRES_NEW")
    TeacherService teacherService;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    
    @Before
    public void before() {
        callerService.setTeacherService(teacherService);
    }
    
    @Test
    public void callerErrorWithTransaction() {
        String name = "test-" + PREFIX + "-1";
        Student student = new Student();
        student.setName(name);
        Teacher teacher = new Teacher();
        teacher.setName(name);
        try {
            callerService.callerErrorWithTransaction(student, teacher);
        } catch (PrepenseRuntimeException e) {}
        // 创建新事务，无论当前存不存在事务，都创建新事务。
        assertFalse(studentDao.findById(student.getId()).isPresent());
        assertTrue(teacherDao.findById(teacher.getId()).isPresent());
    }
    @Test
    public void calleeErrorCatchByCallerWithTransaction() {
        String name = "test-" + PREFIX + "-2";
        Student student = new Student();
        student.setName(name);
        Teacher teacher = new Teacher();
        teacher.setName(name);
        callerService.calleeErrorCatchByCallerWithTransaction(student, teacher);
        // 创建新事务，无论当前存不存在事务，都创建新事务。
        assertTrue(studentDao.findById(student.getId()).isPresent());
        assertFalse(teacherDao.findById(teacher.getId()).isPresent());
    }
}
