package com.xiefr.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xiefr.learn.entity.Teacher;
/**
 * 2018-5-8
 * @author xiefr
 *
 */
public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
