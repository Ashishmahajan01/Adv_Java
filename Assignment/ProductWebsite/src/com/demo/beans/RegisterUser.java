package com.demo.beans;

import java.time.LocalDate;
import java.util.Arrays;

public class RegisterUser {
	private int uid;
	private String name;
	private String addr;
	private String gender;
	private String[] skill;
	private LocalDate dt;
	private String city;
	private String uname;
	public RegisterUser() {
		super();
	}
	public RegisterUser(int uid, String name, String addr, String gender, String[] skill, LocalDate dt, String city,
			String uname) {
		super();
		this.uid = uid;
		this.name = name;
		this.addr = addr;
		this.gender = gender;
		this.skill = skill;
		this.dt = dt;
		this.city = city;
		this.uname = uname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getSkill() {
		return skill;
	}
	public void setSkill(String[] skill) {
		this.skill = skill;
	}
	public LocalDate getDt() {
		return dt;
	}
	public void setDt(LocalDate dt) {
		this.dt = dt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "RegisterUser [uid=" + uid + ", name=" + name + ", addr=" + addr + ", gender=" + gender + ", skill="
				+ Arrays.toString(skill) + ", dt=" + dt + ", city=" + city + ", uname=" + uname + "]";
	}
	

}
