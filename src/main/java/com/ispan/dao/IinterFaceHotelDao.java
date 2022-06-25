package com.ispan.dao;

import java.util.List;

import com.ispan.model.Hotel;


public interface IinterFaceHotelDao {
	public Object save(Hotel hol);

	public Hotel findById(Integer id);

	public boolean existsById(String id);

	public void update(Hotel hol);

	public void delete(Integer id);

	public List<Hotel> findAll();

	public void close();
}
