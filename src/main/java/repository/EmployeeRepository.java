package repository;

import domain.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Hibernate;

public class EmployeeRepository extends Repository<Employee, Integer> {

  public Employee findByEmail(String email) {
    Transaction tx = null;
    try (Session session = Hibernate.getSessionFactory().openSession()) {
      tx = session.beginTransaction();
      Query query = session.createQuery("from Employee where email=:email")
          .setParameter("email", email);
      Employee employee = (Employee) query.uniqueResult();
      tx.commit();
      return employee;
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    }
  }
}
