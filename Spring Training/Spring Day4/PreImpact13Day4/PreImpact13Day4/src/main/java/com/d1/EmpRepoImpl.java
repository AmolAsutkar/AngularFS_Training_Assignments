package com.d1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
//@Component
public class EmpRepoImpl  implements EmpRepo {
	
	private Map<Integer,Employee> repository;
 
	EmpRepoImpl(){
		this.repository=new HashMap();
	}

	public Employee getEmployeeById(int id) {
		
		return repository.get(id) ;
	}

	public Employee deleteEmployee(int id) {
		
		return repository.remove(id);
	}

	public void insertEmployee(Employee t) {
		repository.put(t.getEmp_id(), t);
		
	}

	public void insertEmployee(Object t) {
		// TODO Auto-generated method stub
		System.out.println();
	}


}
