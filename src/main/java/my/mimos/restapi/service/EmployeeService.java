package my.mimos.restapi.service;

import java.util.List;

import my.mimos.restapi.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee getEmployeeById(int id);
	
	public void save(Employee newEmployee);
	
	public void deleteById(int id);

}
