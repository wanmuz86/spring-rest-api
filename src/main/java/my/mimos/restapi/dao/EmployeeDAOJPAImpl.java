package my.mimos.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.mimos.restapi.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {

		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", 
				Employee.class);
		List<Employee> employees  =theQuery.getResultList();
		return employees;
	}

	@Override
	public void save(Employee employee) {
		Employee dbemployee = entityManager.merge(employee);
		employee.setId(dbemployee.getId());
	}

	@Override
	public Employee findById(int employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		Query query = entityManager.createQuery("delete FROM Employee WHERE id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();

	}

}
