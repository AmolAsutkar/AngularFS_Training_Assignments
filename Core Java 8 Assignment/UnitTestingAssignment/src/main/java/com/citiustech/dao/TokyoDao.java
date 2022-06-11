package com.citiustech.dao;

import javax.sql.DataSource;

import com.citiustech.ds.SqlServerDataSource;

public class TokyoDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new SqlServerDataSource();
	}

}
