package xyz.test.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import xyz.test.pojo.Client;

@Repository
public class ClientModel {

    private static SessionFactory sessionFactory;

    public static void setSessionFactory(SessionFactory sf) {
	sessionFactory = sf;
    }

    public static Client getByClientId(String clientId) {
	Client client = new Client();
	client.setClientId(clientId);

	Session session = sessionFactory.getCurrentSession();

	Query hqlQuery = session
		.createQuery("from Client where clientId = :clientId");
	@SuppressWarnings("unchecked")
	List<Client> results = hqlQuery.setProperties(client).list();
	if (results.size() != 0)
	    client = (Client) results.get(0);
	else
	    client = null;

	return client;
    }

}