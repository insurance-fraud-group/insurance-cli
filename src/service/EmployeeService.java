package service;

import domain.employee.Employee;


public interface EmployeeService {

  void create(Employee employee);

  void delete(int id);

  Employee read(int id);

  void update(Employee employee);
}
