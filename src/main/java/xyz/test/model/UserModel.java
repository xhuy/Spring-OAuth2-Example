package xyz.test.model;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import xyz.test.pojo.User;

@Repository
public class UserModel {
    private static SessionFactory sessionFactory;

    public static void setSessionFactory(SessionFactory sf) {
	sessionFactory = sf;
    }

    public static User findByPrimaryKey(int id) {
	User user = new User(id);

	Session session = sessionFactory.getCurrentSession();

	Query hqlQuery = session.createQuery("from User where id = :id");
	@SuppressWarnings("unchecked")
	List<User> results = hqlQuery.setProperties(user).list();
	if (results.size() != 0)
	    user = (User) results.get(0);
	else
	    user = null;

	return user;
    }

    public static int create(User user) {
	int id = 0;

	Session session = sessionFactory.getCurrentSession();

	Transaction tx = null;

	try {
	    tx = session.beginTransaction();
	    id = (Integer) session.save(user);
	    tx.commit();
	} catch (HibernateException e) {
	    if (tx != null)
		tx.rollback();
	    e.printStackTrace();
	} finally {
	    session.close();
	}

	return id;
    }

    public static void update(User user) {

	Session session = sessionFactory.getCurrentSession();
	Transaction tx = null;

	try {
	    tx = session.beginTransaction();
	    session.update(user);
	    tx.commit();
	} catch (HibernateException e) {
	    if (tx != null)
		tx.rollback();
	    e.printStackTrace();
	} finally {
	    session.close();
	}

    }

    public static void delete(User user) {

	Session session = sessionFactory.getCurrentSession();
	Transaction tx = null;

	try {
	    tx = session.beginTransaction();
	    session.delete(user);
	    tx.commit();
	} catch (HibernateException e) {
	    if (tx != null)
		tx.rollback();
	    e.printStackTrace();
	} finally {
	    session.close();
	}

    }

    @SuppressWarnings("unchecked")
    public static List<User> findAllMatches(User user) {
	if (user != null) {

	    User UserProxy = new User();

	    return (List<User>) sessionFactory.getCurrentSession()
		    .createCriteria(User.class).add(Example.create(UserProxy))
		    .list();

	}

	return (List<User>) sessionFactory.getCurrentSession()
		.createCriteria(User.class).list();
    }

    public static User findByUsername(String username) {
	User user = new User();
	user.setUsername(username);

	Session session = sessionFactory.getCurrentSession();

	Query hqlQuery = session
		.createQuery("from User where username = :username");
	@SuppressWarnings("unchecked")
	List<User> results = hqlQuery.setProperties(user).list();
	if (results.size() != 0)
	    user = (User) results.get(0);
	else
	    user = null;

	return user;
    }

    public static Set<ConstraintViolation<User>> isValidForCreate(User user) {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	Set<ConstraintViolation<User>> errors = validator.validate(user);
	return errors;
    }

    public static Set<ConstraintViolation<User>> isValidForUpdate(User user) {
	return null;
    }

}
