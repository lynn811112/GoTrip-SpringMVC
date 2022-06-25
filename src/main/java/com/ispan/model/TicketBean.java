package com.ispan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


//@Entity的Bean是告訴Spring這是數據模型層的宣告
@Entity
@Table(name="Ticket")
@Component("TicketBean")
public class TicketBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketNo")
	private int ticketNo;
	
	@Column(name = "ticketName")
	private String ticketName;
	
	@Column(name = "ticketIntro")
	private String ticketIntro;
	
	@Column(name = "ticketOpenWeek")
	private String ticketOpenWeek;
	
	@Column(name = "ticketOpenTime")
	private String ticketOpenTime;
	
	@Column(name = "ticketEndTime")
	private String ticketEndTime;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "price")
	private int price;
	
	public int getTicketNo() {
		return ticketNo;
	}

	public TicketBean() {
		super();
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getTicketIntro() {
		return ticketIntro;
	}

	public void setTicketIntro(String ticketIntro) {
		this.ticketIntro = ticketIntro;
	}

	public String getTicketOpenWeek() {
		return ticketOpenWeek;
	}

	public void setTicketOpenWeek(String ticketOpenWeek) {
		this.ticketOpenWeek = ticketOpenWeek;
	}

	public String getTicketOpenTime() {
		return ticketOpenTime;
	}

	public void setTicketOpenTime(String ticketOpenTime) {
		this.ticketOpenTime = ticketOpenTime;
	}

	public String getTicketEndTime() {
		return ticketEndTime;
	}

	public void setTicketEndTime(String ticketEndTime) {
		this.ticketEndTime = ticketEndTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public TicketBean(String ticketName, String ticketIntro, String ticketOpenWeek, String ticketOpenTime,
			String ticketEndTime, String phone, String country, String city, String location, String address,
			int price) {
		super();
		this.ticketName = ticketName;
		this.ticketIntro = ticketIntro;
		this.ticketOpenWeek = ticketOpenWeek;
		this.ticketOpenTime = ticketOpenTime;
		this.ticketEndTime = ticketEndTime;
		this.phone = phone;
		this.country = country;
		this.city = city;
		this.location = location;
		this.address = address;
		this.price = price;
	}

	public TicketBean(int ticketNo, String ticketName, String ticketIntro, String ticketOpenWeek, String ticketOpenTime,
			String ticketEndTime, String phone, String country, String city, String location, String address,
			int price) {
		super();
		this.ticketNo = ticketNo;
		this.ticketName = ticketName;
		this.ticketIntro = ticketIntro;
		this.ticketOpenWeek = ticketOpenWeek;
		this.ticketOpenTime = ticketOpenTime;
		this.ticketEndTime = ticketEndTime;
		this.phone = phone;
		this.country = country;
		this.city = city;
		this.location = location;
		this.address = address;
		this.price = price;
	}

}




//原始碼
//package model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.stereotype.Component;
//
//
////@Entity的Bean是告訴Spring這是數據模型層的宣告
//@Component("ViewBean")
//@Entity
//@Table(name="viewpro")
//public class TicketBean {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "PRODNO")
//	private int ticketNo;
//	
//	@Column(name = "PRODNAME")
//	private String ticketName;
//	
//	@Column(name = "PRODINTRO")
//	private String ticketIntro;
//	
//	@Column(name = "OPENWEEK")
//	private String ticketOpenWeek;
//	
//	@Column(name = "OPENTIME")
//	private String ticketOpenTime;
//	
//	@Column(name = "ENDTIME")
//	private String end_time;
//	
//	@Column(name = "PHONE")
//	private String phone;
//	
//	@Column(name = "COUNTRY")
//	private String Country;
//	
//	@Column(name = "CITY")
//	private String City;
//	
//	@Column(name = "LOCATION")
//	private String Location;
//	
//	@Column(name = "ADDRESS")
//	private String address;
//	
//	@Column(name = "PRICE")
//	private int price;
//	//private String img_id;
//
//	
//	
//	
//	public TicketBean(int prod_no, String prod_name, String prod_Intro, String open_week, String open_time,
//			String end_time, String phone, String country, String city, String location, String address, int price) {
//		this.prod_no = prod_no;
//		this.prod_name = prod_name;
//		this.prod_Intro = prod_Intro;
//		this.open_week = open_week;
//		this.open_time = open_time;
//		this.end_time = end_time;
//		this.phone = phone;
//		Country = country;
//		City = city;
//		Location = location;
//		this.address = address;
//		this.price = price;
//	}
//	public TicketBean(String prod_name, String prod_Intro, String open_week, String open_time, String end_time,
//			String phone, String country, String city, String location, String address, int price) {
//		this.prod_name = prod_name;
//		this.prod_Intro = prod_Intro;
//		this.open_week = open_week;
//		this.open_time = open_time;
//		this.end_time = end_time;
//		this.phone = phone;
//		Country = country;
//		City = city;
//		Location = location;
//		this.address = address;
//		this.price = price;
//	}
//	public TicketBean() {
//	}
//	public int getProd_no() {
//		return prod_no;
//	}
//	public void setProd_no(int prod_no) {
//		this.prod_no = prod_no;
//	}
//	public String getProd_name() {
//		return prod_name;
//	}
//	public void setProd_name(String prod_name) {
//		this.prod_name = prod_name;
//	}
//	public String getProd_Intro() {
//		return prod_Intro;
//	}
//	public void setProd_Intro(String prod_Intro) {
//		this.prod_Intro = prod_Intro;
//	}
//	public String getOpen_week() {
//		return open_week;
//	}
//	public void setOpen_week(String open_week) {
//		this.open_week = open_week;
//	}
//	public String getOpen_time() {
//		return open_time;
//	}
//	public void setOpen_time(String open_time) {
//		this.open_time = open_time;
//	}
//	public String getEnd_time() {
//		return end_time;
//	}
//	public void setEnd_time(String end_time) {
//		this.end_time = end_time;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public String getCountry() {
//		return Country;
//	}
//	public void setCountry(String country) {
//		Country = country;
//	}
//	public String getCity() {
//		return City;
//	}
//	public void setCity(String city) {
//		City = city;
//	}
//	public String getLocation() {
//		return Location;
//	}
//	public void setLocation(String location) {
//		Location = location;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//
//	
//	
//}
//
//
//
