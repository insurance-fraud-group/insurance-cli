package service;

import domain.Employee;

public interface AuthService {

  Employee signup(Employee request);

  Employee signin(Employee request);
}
