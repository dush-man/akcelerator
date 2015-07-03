package net.croz.contacts.dao;

import net.croz.contacts.model.ContactBook;

public interface ContactBookDao {

	ContactBook fetchById(final Long p_id);
	ContactBook save(final ContactBook p_contactBook);
	ContactBook update(final ContactBook p_contactBook);

}
