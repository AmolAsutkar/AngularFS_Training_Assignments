package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citiustech.dao.LondonDao;
import com.citiustech.dao.NewyorkDao;
import com.citiustech.dao.RegionalDao;
import com.citiustech.dao.RegionalDaoManager;
import com.citiustech.dao.TokyoDao;
import com.citiustech.service.Region;

import javax.sql.DataSource;

class TestRegionalDaoManager {
	
	    RegionalDaoManager regionalDaoManager = new RegionalDaoManager();

	    LondonDao londonDao = new LondonDao();

	    NewyorkDao newyorkDao = new NewyorkDao();

	    TokyoDao tokyoDao = new TokyoDao();

	@Test
    public void regionalDaoMangerTokyo() {

        DataSource dataSource = regionalDaoManager.getRegionalDao(Region.TOKYO).getDataSource();
        assertNotNull(dataSource);

    }
	@Test
    public void regionalDaoMangerLondon() {

        

		DataSource dataSource = regionalDaoManager.getRegionalDao(Region.LONDON).getDataSource();
        assertNotNull(dataSource);

       

    }
	@Test
    public void regionalDaoMangerNewyork() {

        

		DataSource dataSource = regionalDaoManager.getRegionalDao(Region.NEWYORK).getDataSource();
        assertNotNull(dataSource);


    }
	
	@Test
    public void regionalDaoMangerShouldThrowException() {


        assertThrows(IllegalArgumentException.class,() -> regionalDaoManager.getRegionalDao(Region.valueOf("amol")));

    }

}
