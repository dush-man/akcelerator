package net.croz.contacts.dao;

import java.util.List;

import net.croz.contacts.model.code.AbstractCode;

public interface CodeDao {

	<T extends AbstractCode> T fetchById(final Class<T> p_type, final Long p_id);
	<T extends AbstractCode> List<T> fetchAll(final Class<T> p_type);

}
