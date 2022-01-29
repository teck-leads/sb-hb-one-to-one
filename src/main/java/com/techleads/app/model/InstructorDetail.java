package com.techleads.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "youtbe_channel")
	private String youtbe_channel;
	@Column(name = "hobby")
	private String hobby;
	
	
	public InstructorDetail() {
		super();
	}
	
	public InstructorDetail(String youtbe_channel, String hobby) {
		super();
		this.youtbe_channel = youtbe_channel;
		this.hobby = hobby;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYoutbe_channel() {
		return youtbe_channel;
	}
	public void setYoutbe_channel(String youtbe_channel) {
		this.youtbe_channel = youtbe_channel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtbe_channel=" + youtbe_channel + ", hobby=" + hobby + "]";
	}
	
	

}
