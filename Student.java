package com.rediscache.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Student implements Serializable
{
	@Id
	private int stdid;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String standard;
	@Column
	private int marks;
	@Column
	private int percentage;
	public Student() {
		super();
	}
	public Student(int stdid, String firstname, String lastname, String standard, int marks, int percentage) {
		super();
		this.stdid = stdid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.standard = standard;
		this.marks = marks;
		this.percentage = percentage;
	}
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getPercenatage() {
		return percentage;
	}
	public void setPercenatage(int percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", firstname=" + firstname + ", lastname=" + lastname + ", standard="
				+ standard + ", marks=" + marks + ", percenatage=" + percentage + "]";
	}
	
}
