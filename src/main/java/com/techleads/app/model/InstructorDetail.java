package com.techleads.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "instructor_detail")
public class InstructorDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "youtbe_channel")
	private String youtbe_channel;
	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetail() {
	}

	public InstructorDetail(String youtbe_channel, String hobby) {
		this.youtbe_channel = youtbe_channel;
		this.hobby = hobby;
	}

	public InstructorDetail(String youtbe_channel, String hobby, Instructor instructor) {
		super();
		this.youtbe_channel = youtbe_channel;
		this.hobby = hobby;
		this.instructor = instructor;
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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtbe_channel=" + youtbe_channel + ", hobby=" + hobby + "]";
	}

//	@Override
//	public String toString() {
//		return "InstructorDetail [id=" + id + ", youtbe_channel=" + youtbe_channel + ", hobby=" + hobby
//				+ ", instructor=" + instructor + "]";
//	}
	

}
