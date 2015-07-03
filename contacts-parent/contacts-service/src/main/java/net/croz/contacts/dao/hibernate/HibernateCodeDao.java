package net.croz.contacts.dao.hibernate;

import java.util.List;
import net.croz.contacts.dao.CodeDao;
import net.croz.contacts.model.code.AbstractCode;
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")
public class HibernateCodeDao implements CodeDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public <T extends AbstractCode> T fetchById(Class<T> p_type, Long p_id) {

		T returnValue = (T) this.sessionFactory.getCurrentSession().get(p_type,
				p_id);
		return returnValue;
	}

	public <T extends AbstractCode> List<T> fetchAll(Class<T> p_type) {

		List<T> returnValue = this.sessionFactory.getCurrentSession()
				.createCriteria(p_type).list();
		return returnValue;
	}

}
