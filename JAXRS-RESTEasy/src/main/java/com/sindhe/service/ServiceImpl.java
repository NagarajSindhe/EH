package com.sindhe.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sindhe.model.DBConstants;
import com.sindhe.model.Website;

public class ServiceImpl implements Service {

	static List<Website> list = null;

	public List<Website> getRecordsById(int id) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Website website = new Website();
		list = new ArrayList<>();
		try {

			statement = DBConstants.dbConnection.getConnection()
					.prepareStatement(DBConstants.SELECT_STATEMENT + "where id='" + id + "'");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				website.setId(Integer.parseInt(resultSet.getString(1)));
				website.setTitle(resultSet.getString(2));
				website.setDescription(resultSet.getString(3));
				website.setUrl(resultSet.getString(4));
				list.add(website);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Website> getAllRecords() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		list = new ArrayList<>();
		try {
			statement = DBConstants.dbConnection.getConnection().prepareStatement(DBConstants.SELECT_STATEMENT);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Website website = new Website();
				website.setId(resultSet.getInt(1));
				website.setTitle(resultSet.getString(2));
				website.setDescription(resultSet.getString(3));
				website.setUrl(resultSet.getString(4));
				list.add(website);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteById(int id) {
		PreparedStatement statement = null;
		System.out.println("Id in deltById ... " + id);
		int i = 0;
		try {
			System.out.println("Connecting  ... " + id);
			statement = DBConstants.dbConnection.getConnection()
					.prepareStatement("DELETE FROM WEBSITE WHERE ID='" + id + "'");
			System.out.println("Deleteing ... " + id);
			i = statement.executeUpdate();
			System.out.println("Deleted ... " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}

	@Override
	public int userRegister(String title, String description, String url) {
		PreparedStatement statement = null;
		int i = 0;
		String sql = "insert into website (title,description,url) values (?,?,?)";
		try {
			statement = DBConstants.dbConnection.getConnection().prepareStatement(sql);
			statement.setString(1, title);
			statement.setString(2, description);
			statement.setString(3, url);
			i = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int registerUsers(Website website) {
		PreparedStatement statement = null;
		int i = 0;
		String sql = "insert into website (title,description,url) values (?,?,?)";
		try {
			statement = DBConstants.dbConnection.getConnection().prepareStatement(sql);
			statement.setString(1, website.getTitle());
			statement.setString(2, website.getDescription());
			statement.setString(3, website.getUrl());
			i = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateUsers(Website website) {
		PreparedStatement statement = null;
		int i = 0;
		String sql = "UPDATE website SET title=?, description=?, url=? WHERE id='"+website.getId()+"'";
		try {
			statement = DBConstants.dbConnection.getConnection().prepareStatement(sql);
			statement.setString(1, website.getTitle());
			statement.setString(2, website.getDescription());
			statement.setString(3, website.getUrl());
			//statement.setInt(website.getId(), 4);
			i = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
