package repository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Hibernate;

public abstract class Repository<T, ID> {

  private final String domainName = ((ParameterizedType) getClass().getGenericSuperclass())
      .getActualTypeArguments()[0].getTypeName();
  private Transaction tx = null;

  public void transaction(String methodName, T object) {
    try (Session session = Hibernate.getSessionFactory().openSession()) {
      tx = session.beginTransaction();
      session.getClass().getMethod(methodName, Object.class).invoke(session, object);
      tx.commit();
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      throw new RuntimeException(e);
    }
  }

  public Object transactionByQuery(String methodName, String queryString) throws Exception {
    Session session = Hibernate.getSessionFactory().openSession();
    tx = session.beginTransaction();
    Query<?> query = session.createQuery(queryString);
    Object result = query.getClass().getMethod(methodName).invoke(query);
    tx.commit();
    return result;
  }

  public void save(T object) {
    transaction("save", object);
  }

  public void update(T object) {
    transaction("update", object);
  }

  public void delete(T object) {
    transaction("delete", object);
  }

  public T findById(ID id) {
    String queryString = String.format("from %s where id=%s", domainName, id);
    try {
      return (T) transactionByQuery("uniqueResult", queryString);
    } catch (Exception e) {
      return null;
    }
  }

  public T findBy(String field, Object value) {
    String queryString = String.format("from %s where %s='%s'", domainName, field, value);
    try {
      return (T) transactionByQuery("uniqueResult", queryString);
    } catch (Exception e) {
      return null;
    }
  }

  public List<T> findAll() {
    String queryString = String.format("from %s", domainName);
    try {
      return (List<T>) transactionByQuery("getResultList", queryString);
    } catch (Exception e) {
      return new ArrayList<T>();
    }
  }

  public List<T> findAllBy(String field, Object value) {
    String queryString = String.format("from %s where %s='%s'", domainName, field, value);
    try {
      return (List<T>) transactionByQuery("getResultList", queryString);
    } catch (Exception e) {
      return new ArrayList<T>();
    }
  }
}
