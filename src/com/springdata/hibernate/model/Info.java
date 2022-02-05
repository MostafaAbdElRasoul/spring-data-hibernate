package com.springdata.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "information")
public class Info {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id")
	private int id;

	@Column(name = "info_phone")
	private String phone;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_student")
	private Student student;

	public Info() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
