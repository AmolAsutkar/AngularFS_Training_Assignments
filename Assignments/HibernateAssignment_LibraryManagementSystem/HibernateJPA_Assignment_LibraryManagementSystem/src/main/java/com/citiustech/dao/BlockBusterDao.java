package com.citiustech.dao;
import java.util.List;

import com.citiustech.entity.Movie;
import com.citiustech.entity.Shop;
import com.citiustech.entity.Staff;


public class BlockBusterDao  extends GenericDao{

	
		
		public List<Staff> fetchStaffDetail(int staff_id) {
			return entitymanagerfactory
					.createEntityManager()
					.createQuery("select s from Staff s where s.staff_id =:staff_id ", Staff.class)
					.setParameter("staff_id", staff_id)
					.getResultList();
		}

		public List<String> fetchMovies() {
			return entitymanagerfactory
					.createEntityManager()
					.createQuery("select distinct movie_name from Movie")
					.getResultList();
		}
}
