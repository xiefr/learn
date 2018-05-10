package com.xiefr.learn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.alibaba.fastjson.JSON;
/**
 * 2018-5-8
 * @author xiefr
 *
 */
@Entity
@Table(name="teacher")
@DynamicInsert
@DynamicUpdate
public class Teacher{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint(255) UNSIGNED")
    private Integer id;
	@Column(columnDefinition = "datetime NULL DEFAULT CURRENT_TIMESTAMP")
	private Date gmtCreate;
	@Column(columnDefinition = "datetime NULL ON UPDATE CURRENT_TIMESTAMP")
    private Date gmtModified;
	
	@Column(length=63)
	private String name;
    
	@Override
    public String toString() {
        return JSON.toJSONString(this);
    }
	
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getGmtCreate() {
        return gmtCreate;
    }
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtModified() {
        return gmtModified;
    }
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	
}
