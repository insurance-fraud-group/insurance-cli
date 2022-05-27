package service.impl;

import domain.Contract;
import domain.Customer;
import domain.Employee;
import domain.Insurance;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.SalesService;
import utils.Hibernate;

public class SalesServiceImpl implements SalesService {

  @Override
  public List<Insurance> getInsuranceList() {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Query query = session.createQuery("from Insurance");
    List<Insurance> insuranceList = query.list();

    tx.commit();
    return insuranceList;
  }

  @Override
  public Insurance getInsurance(String insuranceCode) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Insurance insurance = session.get(Insurance.class, insuranceCode);

    tx.commit();
    return insurance;
  }

  @Override
  public List<Employee> getEmployeeList() {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Query query = session.createQuery("from Employee");
    List<Employee> employeeList = query.list();

    tx.commit();
    return employeeList;
  }

  @Override
  public Employee getEmployee(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Employee employee = session.get(Employee.class, id);

    tx.commit();
    return employee;
  }

  @Override
  public Customer createCustomer(Customer customer) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    session.save(customer);

    tx.commit();
    return customer;
  }

  @Override
  public List<Customer> getCustomerList() {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Query query = session.createQuery("from Customer");
    List<Customer> customerList = query.list();

    tx.commit();
    return customerList;
  }

  @Override
  public Customer getCustomer(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Customer customer = session.get(Customer.class, id);

    tx.commit();
    return customer;
  }

  @Override
  public Contract createContract(Insurance insurance, Customer customer) {
    Contract contract = Contract.builder()
        .insurance(insurance)
        .customer(customer)
        .signed(false)
        .build();

    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    session.save(contract);

    tx.commit();
    return contract;
  }

  @Override
  public List<Contract> getUnsignedContract() {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Query query = session.createQuery("from Contract where signed=false");
    List<Contract> unsignedContractList = query.list();

    tx.commit();
    return unsignedContractList;
  }

  @Override
  public Contract getContract(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Contract contract = session.get(Contract.class, id);

    tx.commit();
    return contract;
  }

  @Override
  public Contract makeContractSigned(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Contract contract = session.get(Contract.class, id);
    contract.setSigned(true);
    session.update(contract);

    tx.commit();

    return contract;
  }
}
