package my.mimos.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import my.mimos.restapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
