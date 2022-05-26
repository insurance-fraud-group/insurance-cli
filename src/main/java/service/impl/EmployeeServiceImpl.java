package service.impl;

import domain.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

  private final List<Employee> employeeList;

  public EmployeeServiceImpl() {
  employeeList = new ArrayList<>();
  }

  public void create(Employee employee) {

  }

  public void delete(int id) {

  }

  public Employee read(int id) {
    return null;
  }

  public void update(Employee employee) {

  }
}
