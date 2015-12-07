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

import xyz.test.pojo.Role;

public class RoleModel {
    private static SessionFactory sessionFactory;

    public static void setSessionFactory(SessionFactory sf) {
	sessionFactory = sf;
    }

    public static Role findByPrimaryKey(int id) {
	Role role = new Role(id);

	Session session = sessionFactory.getCurrentSession();

	Query hqlQuery = session.createQuery("from Role where id = :id");
	@SuppressWarnings("unchecked")
	List<Role> results = hqlQuery.setProperties(role).list();
	if (results.size() != 0)
	    role = (Role) results.get(0);
	else
	    role = null;

	return role;
    }

    public static int create(Role role) {
	int id = 0;

	Session session = sessionFactory.getCurrentSession();
	
	Transaction tx = null;

	try {
	    tx = session.beginTransaction();
	    id = (Integer) session.save(role);
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

    public static void update(Role role) {

	Session session = sessionFactory.getCurrentSession();
	Transaction tx = null;

	try {
	    tx = session.beginTransaction();
	    session.update(role);
	    tx.commit();
	} catch (HibernateException e) {
	    if (tx != null)
		tx.rollback();
	    e.printStackTrace();
	} finally {
	    session.close();
	}

    }

    public static void delete(Role role) {

	Session session = sessionFactory.getCurrentSession();
	Transaction tx = null;

	try {
	    tx = session.beginTransaction();
	    session.delete(role);
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
    public static List<Role> findAllMatches(Role role) {
	if (role != null) {

	    Role RoleProxy = new Role();

	    return (List<Role>) sessionFactory.getCurrentSession()
		    .createCriteria(Role.class).add(Example.create(RoleProxy))
		    .list();

	}

	return (List<Role>) sessionFactory.getCurrentSession()
		.createCriteria(Role.class).list();
    }

    public static Set<ConstraintViolation<Role>> isValidForCreate(Role role) {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	Set<ConstraintViolation<Role>> errors = validator.validate(role);
	return errors;
    }

    public static Set<ConstraintViolation<Role>> isValidForUpdate(Role role) {
	return null;
    }
}
