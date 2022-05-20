package com.insurancefraudgroup.insurancesystem.service.impl;

import com.insurancefraudgroup.insurancesystem.domain.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import com.insurancefraudgroup.insurancesystem.service.EmployeeService;

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
