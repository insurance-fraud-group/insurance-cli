package service;

import domain.Employee;

public interface AuthService {

  Employee signUp(Employee request);

  Employee signIn(Employee request);
}
