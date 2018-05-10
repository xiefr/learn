package com.xiefr.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xiefr.learn.entity.Student;
/**
 * 2018-5-8
 * @author xiefr
 *
 */
public interface StudentDao extends JpaRepository<Student, Integer> {

}
