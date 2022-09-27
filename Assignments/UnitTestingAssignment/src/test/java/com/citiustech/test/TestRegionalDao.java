package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citiustech.dao.RegionalDao;
import com.citiustech.dao.RegionalDaoManager;

@ExtendWith(MockitoExtension.class)
class TestRegionalDao {
	
	@Mock
    RegionalDao regionalDao;

	@Test
    public void getTradeDetailsShouldThrowException() {
        Mockito.when(regionalDao.getTradeDetails(Mockito.any(long.class))).thenThrow(RuntimeException.class);

        Executable e = () -> regionalDao.getTradeDetails(78945678);

        assertThrows(RuntimeException.class,e);
    }


}
