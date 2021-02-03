package my.mimos.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.mimos.restapi.dao.EmployeeDAO;
import my.mimos.restapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao;
	
	@Autowired
	private EmployeeServiceImpl(EmployeeDAO theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}
	
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.getAllEmployees();
	}


	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeDao.findById(id);
	}

}
