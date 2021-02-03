package my.mimos.restapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.mimos.restapi.entity.Employee;
import my.mimos.restapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable(name="id") int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		newEmployee.setId(0);
		employeeService.save(newEmployee);		
		return newEmployee;
		
	}
		
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, 
			@PathVariable(name="id") int employeeId) {
		employee.setId(employeeId);
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable(name="id") int id) {
		Employee employee = employeeService.getEmployeeById(id);
		if (employee == null) {
			return "Employee id "+id+" not found";
		}
		
		employeeService.deleteById(id);
		return "Employee deleted "+id;
	}

}
