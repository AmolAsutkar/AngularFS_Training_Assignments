package com.citiustech.dao;

import javax.sql.DataSource;

import com.citiustech.ds.OracleDataSource;



public class NewyorkDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new OracleDataSource();
	}

}
