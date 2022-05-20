package com.insurancefraudgroup.insurancesystem.service;

import com.insurancefraudgroup.insurancesystem.domain.employee.Employee;


public interface EmployeeService {

  void create(Employee employee);

  void delete(int id);

  Employee read(int id);

  void update(Employee employee);
}
