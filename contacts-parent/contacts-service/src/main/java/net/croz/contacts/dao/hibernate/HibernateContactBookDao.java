package net.croz.contacts.dao.hibernate;

import net.croz.contacts.dao.ContactBookDao;
import net.croz.contacts.model.ContactBook;

import org.hibernate.SessionFactory;

public class HibernateContactBookDao implements ContactBookDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ContactBook fetchById(Long p_id) {
		ContactBook returnValue = new ContactBook();
		returnValue = (ContactBook) this.sessionFactory.getCurrentSession()
				.get(ContactBook.class, p_id);

		return returnValue;
	}

	public ContactBook save(ContactBook p_contactBook) {
		this.sessionFactory.getCurrentSession().save(p_contactBook);
		ContactBook returnValue = (ContactBook) this.sessionFactory
				.getCurrentSession().get(ContactBook.class,
						p_contactBook.getId());

		return returnValue;
	}

	public ContactBook update(ContactBook p_contactBook) {
		this.sessionFactory.getCurrentSession().update(p_contactBook);
		ContactBook returnValue = (ContactBook) this.sessionFactory
				.getCurrentSession().get(ContactBook.class,
						p_contactBook.getId());

		return returnValue;
	}

}
