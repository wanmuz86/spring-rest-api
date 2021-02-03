package my.mimos.restapi.dao;

import java.util.List;

import my.mimos.restapi.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployees();
	
	// TO DO Create
	// TO DO update
	
	public void save(Employee employee);
	
	
	// TO DO find by id
	
	public Employee findById(int employee);
	// TO DO Delete
	
	public void deleteEmployee(int id);
	


}
