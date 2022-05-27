package repository;

import domain.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Hibernate;

public class EmployeeRepository {

  public void save(Employee employee) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    session.save(employee);
    tx.commit();
  }

  public Employee findByEmail(String email) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    Query query = session.createQuery("from Employee where email =:email ")
        .setParameter("email", email);
    Employee employee = (Employee) query.uniqueResult();
    tx.commit();
    return employee;
  }
}
