package com.sindhe.service;

import java.util.List;

import com.sindhe.model.Website;

public interface Service {

	public abstract List<Website> getRecordsById(int id);

	public abstract List<Website> getAllRecords();

	public abstract int deleteById(int id);

	public abstract int userRegister(String title, String description, String url);

	public abstract int registerUsers(Website website);
	
	public abstract int updateUsers(Website website);

}
