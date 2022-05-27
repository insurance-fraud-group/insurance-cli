package repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Hibernate;

public abstract class Repository<T, ID> {

  private String tableName = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
  private Transaction tx = null;

  public void save(T object) {
    try (Session session = Hibernate.getSessionFactory().openSession()) {
      tx = session.beginTransaction();
      session.save(object);
      tx.commit();
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    }
  }

  public void update(T object) {
    try (Session session = Hibernate.getSessionFactory().openSession()) {
      tx = session.beginTransaction();
      session.update(object);
      tx.commit();
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    }
  }

  public void delete(T object) {
    try (Session session = Hibernate.getSessionFactory().openSession()) {
      tx = session.beginTransaction();
      session.delete(object);
      tx.commit();
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    }
  }

  public T findById(ID id) {
    try (Session session = Hibernate.getSessionFactory().openSession()) {
      tx = session.beginTransaction();
      Query query = session.createQuery(String.format("from %s where id=:id", tableName))
          .setParameter("id", id);
      T object = (T) query.uniqueResult();
      tx.commit();
      return object;
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    }
  }

  public List<T> findAll() {
    try (Session session = Hibernate.getSessionFactory().openSession()) {
      tx = session.beginTransaction();
      Query query = session.createQuery("from " + tableName);
      tx.commit();
      return query.list();
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    }
  }
}
