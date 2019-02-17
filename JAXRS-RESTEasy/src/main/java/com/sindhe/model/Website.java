package com.sindhe.model;

import java.io.Serializable;

public class Website implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7911826740514620422L;
	private String title;
	private String description;
	private String url;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Website [title=" + title + ", description=" + description + ", url=" + url + ", id=" + id + "]";
	}

}
