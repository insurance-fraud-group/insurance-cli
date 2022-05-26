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

}
