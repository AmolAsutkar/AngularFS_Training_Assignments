package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citiustech.dao.RegionalDao;
import com.citiustech.dao.RegionalDaoManager;
import com.citiustech.dao.TokyoDao;
import com.citiustech.service.Region;
import com.citiustech.service.TradeDetails;
import com.citiustech.service.TradeService;

import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)

class testService {

	@Spy
    private TradeService tradeService = new TradeService();

    @InjectMocks
    private TradeService mockTradeService;

    @Mock
    private RegionalDao regionalDao;

    @Mock
    private RegionalDaoManager regionalDaoManager;


    @Mock
    private TradeDetails tradeDetails;





    @Test
    public void getTradeRegionShouldBeTrue() {


    Region region = tradeService.getTradeRegion(121456903);
    Region expectedRegion = Region.LONDON;
        assertEquals(expectedRegion,region);

        

        


    }
    
    @Test
    public void getTradeRegion_London_ShouldBeTrue() {


    Region region = tradeService.getTradeRegion(121456903);
    Region expectedRegion = Region.LONDON;
        assertEquals(expectedRegion,region);


    }
    
    @Test
    public void getTradeRegion_Newyork_ShouldBeTrue() {

    	Region region = tradeService.getTradeRegion(12236547);
    	Region expectedRegion = Region.NEWYORK;

         assertEquals(expectedRegion,region);

    	


    }
    @Test
    public void getTradeRegion_Tokyo_ShouldBeTrue() {


    	Region region = tradeService.getTradeRegion(123456903);
        Region expectedRegion = Region.TOKYO;

        assertEquals(expectedRegion,region);
        

    }
    
    

    @Test
    public void getTradeRegionShouldThrowException() {

        assertThrows(RuntimeException.class,() -> tradeService.getTradeRegion(129456903));

    }


   
    
    @Test
    public void getTradeDetailsShouldThrowException() {
        Mockito.when(regionalDao.getTradeDetails(Mockito.anyLong())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> regionalDao.getTradeDetails(76590123));
    }


    @Test
    public void getTradeDetailsShouldBeNotNull(){
        Mockito.when(regionalDao.getTradeDetails(Mockito.any(long.class))).thenReturn(new TradeDetails());
        TradeDetails tradeDetails = regionalDao.getTradeDetails(90834567);
        assertNotNull(tradeDetails);

    }

}
