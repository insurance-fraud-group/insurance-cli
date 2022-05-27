package service.impl;

import domain.Employee;
import dto.AuthDto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.AuthService;
import utils.Hibernate;

public class AuthServiceImpl implements AuthService {

  @Override
  public AuthDto.SignupResponse signup(AuthDto.SignupRequest request) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Employee employee = Employee.builder().employeeType(request.getEmployeeType())
        .email(request.getEmail()).password(request.getPassword()).name(request.getName()).build();
    session.save(employee);

    tx.commit();

    return AuthDto.SignupResponse.builder().employeeType(employee.getEmployeeType())
        .name(employee.getName()).build();
  }

  @Override
  public AuthDto.SigninResponse signin(AuthDto.SigninRequest request) {
    String email = request.getEmail();

    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Query query = session.createQuery("from Employee where email =:email ")
        .setParameter("email", email);
    Employee employee = (Employee) query.uniqueResult();

    tx.commit();

    if (request.getPassword().equals(employee.getPassword())) {
      return AuthDto.SigninResponse.builder().employeeType(employee.getEmployeeType())
          .name(employee.getName()).build();
    }

    return null;
  }
}
