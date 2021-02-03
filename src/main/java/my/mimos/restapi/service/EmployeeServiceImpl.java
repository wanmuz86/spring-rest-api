package my.mimos.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import my.mimos.restapi.dao.EmployeeDAO;
import my.mimos.restapi.dao.EmployeeRepository;
import my.mimos.restapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//private EmployeeDAO employeeDao;
	private EmployeeRepository employeeRepo;
	
//	@Autowired
//	private EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO theEmployeeDao) {
//		employeeDao = theEmployeeDao;
//	}
//	
	
	private EmployeeServiceImpl(EmployeeRepository theRepo) {
		employeeRepo = theRepo;
	}
	
	@Override
	public List<Employee> findAll() {
//		return employeeDao.getAllEmployees();
		return employeeRepo.findAll();
	}


	@Override
	public Employee getEmployeeById(int id) {
		
		Optional<Employee> employee = employeeRepo.findById(id);
		Employee theEmployee = null;
		if (employee.isPresent()) {
			theEmployee = employee.get();
		}
		else {
			throw new RuntimeException("Employee not found "+id);
		}
		return theEmployee;
	}


	@Override
	public void save(Employee newEmployee) {
		employeeRepo.save(newEmployee);
		
	}


	@Override
	public void deleteById(int id) {
		//employeeDao.deleteEmployee(id);
		employeeRepo.deleteById(id);
		
	}

}
