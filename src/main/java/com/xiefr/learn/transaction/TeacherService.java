package com.xiefr.learn.transaction;

import com.xiefr.learn.entity.Teacher;
/**
 * 2018-5-10
 * @author xiefr
 * 测试事务传播性被调用方
 */
public interface TeacherService {
    /**
     * 保存teacher
     * @param teacher
     */
    void saveTeacher(Teacher teacher);
    /**
     * 保存teacher并抛出运行时异常
     * @param teacher
     */
    void saveTeacherError(Teacher teacher);
}
