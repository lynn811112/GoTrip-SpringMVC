package com.ispan.model;

import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_data")
public class MemberBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_no;
	private String email;
	private String ch_name;
	private String en_name;
	private String password;
	private String gender;
	private String birthday;
	private String phone;
	private String city;
	private String location;
	private String address;
	private Blob image;
	private String status;
	
	
	
	public MemberBean(int user_no, String email, String ch_name, String en_name, String password, String gender,
			String birthday2, String phone, String city, String location, String address) {
		super();
		this.user_no = user_no;
		this.email = email;
		this.ch_name = ch_name;
		this.en_name = en_name;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday2;
		this.phone = phone;
		this.city = city;
		this.location = location;
		this.address = address;
//		this.image = image;
	}
	
	public MemberBean(String email, String ch_name, String en_name, String password, String gender, String birthday,
			String phone, String city, String location, String address) {
		super();
		this.email = email;
		this.ch_name = ch_name;
		this.en_name = en_name;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.city = city;
		this.location = location;
		this.address = address;
	}

	public MemberBean() {
		// TODO Auto-generated constructor stub
	}

	public MemberBean(String email2, String ch_name2, String en_name2, String password2, String gender2, String birthday2,
			String phone2, String city2, String location2, String address2, int user_no2) {
		// TODO Auto-generated constructor stub
	}
	
	

	public MemberBean(int user_no, String email, String ch_name, String en_name, String password, String gender,
			String birthday, String phone, String city, String location, String address, Blob image, String status) {
		super();
		this.user_no = user_no;
		this.email = email;
		this.ch_name = ch_name;
		this.en_name = en_name;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.city = city;
		this.location = location;
		this.address = address;
		this.image = image;
		this.status = status;
	}

	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}
	public String getEn_name() {
		return en_name;
	}
	public void setEn_name(String en_name) {
		this.en_name = en_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
