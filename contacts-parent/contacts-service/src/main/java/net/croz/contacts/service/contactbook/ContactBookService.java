package net.croz.contacts.service.contactbook;

import net.croz.contacts.model.ContactBook;

public interface ContactBookService {

	ContactBook fetchById(final Long p_id) throws IllegalArgumentException;

	ContactBook save(final ContactBook p_contactBook) throws IllegalArgumentException, IllegalStateException;

	ContactBook update(final ContactBook p_contactBook) throws IllegalArgumentException, IllegalStateException;

//	void setHcbd(HibernateContactBookDao hcbd);

}
