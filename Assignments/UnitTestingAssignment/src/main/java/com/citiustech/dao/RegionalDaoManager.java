package com.citiustech.dao;

import com.citiustech.service.Region;

public class RegionalDaoManager {
	
	public RegionalDao getRegionalDao(Region region) {
		switch(region) {
		case LONDON:
			return new LondonDao();
		case NEWYORK:
			return new TokyoDao();
		case TOKYO:
			return new NewyorkDao();
		}
		throw new IllegalArgumentException("Unexpected error!");
	}
}
