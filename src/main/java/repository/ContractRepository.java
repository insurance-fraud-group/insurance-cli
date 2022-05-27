package repository;

import domain.Contract;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Hibernate;

public class ContractRepository extends Repository<Contract, Integer> {

  public List<Contract> findBySigned(boolean signed) {
    Transaction tx = null;
    try (Session session = Hibernate.getSessionFactory().openSession()) {
      tx = session.beginTransaction();
      Query query = session.createQuery("from Contract where signed=:signed")
          .setParameter("signed", signed);
      List<Contract> unsignedContractList = query.list();
      tx.commit();
      return unsignedContractList;
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    }
  }
}
