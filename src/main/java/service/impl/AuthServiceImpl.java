package service.impl;

import domain.Employee;
import repository.EmployeeRepository;
import service.AuthService;

public class AuthServiceImpl implements AuthService {

  private final EmployeeRepository employeeRepository;

  public AuthServiceImpl() {
    employeeRepository = new EmployeeRepository();
  }

  @Override
  public Employee signUp(Employee request) {
    Employee employee = Employee.builder().employeeType(request.getEmployeeType())
        .email(request.getEmail()).password(request.getPassword()).name(request.getName()).build();

    employeeRepository.save(employee);

    return Employee.builder().employeeType(employee.getEmployeeType())
        .name(employee.getName()).build();
  }

  @Override
  public Employee signIn(Employee request) {
    Employee employee = employeeRepository.findBy("email", request.getEmail());

    if (request.getPassword().equals(employee.getPassword())) {
      return Employee.builder().employeeType(employee.getEmployeeType())
          .name(employee.getName()).build();
    }

    return null;
  }
}
