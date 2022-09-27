package com.citiustech.dao;

import javax.sql.DataSource;

import com.citiustech.ds.MySqlDataSource;


public class LondonDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new MySqlDataSource();
	}

}
