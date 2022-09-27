package com.d1;

public interface EmpRepo<T> {
	
	public void insertEmployee(T t);
	
	public T getEmployeeById(int id);
	
	public T deleteEmployee(int id);

}
