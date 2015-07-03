package net.croz.contacts.service.contactbook;

import net.croz.contacts.dao.hibernate.HibernateContactBookDao;
import net.croz.contacts.model.ContactBook;
import org.springframework.util.Assert;
import org.springframework.transaction.annotation.Transactional;

public class ContactBookServiceImpl implements ContactBookService {

	private HibernateContactBookDao hcbd;
	
	public void setHcbd(HibernateContactBookDao hcbd){
		this.hcbd = hcbd;
	}
	
	@Transactional
	public ContactBook fetchById(Long p_id) {
		Assert.notNull(p_id,"Id objekta koji pokusavate da dovucete iz baze je null");
		return hcbd.fetchById(p_id);
	}

	@Transactional
	public ContactBook save(ContactBook p_contactBook) {
		Assert.notNull(p_contactBook, "ContactBook koji pokusavate da sacuvate je null");
		Assert.state(p_contactBook.getId()==null, "Objekate vec postoji u bazi, nema potrebe za ponovnim cuvanjem");
		return hcbd.save(p_contactBook);
	}

	@Transactional
	public ContactBook update(ContactBook p_contactBook) {
		Assert.notNull(p_contactBook, "ContactBook koji pokusavate da apdejtujete je null");
//		Assert.state(p_contactBook.getId()==null, "Objekat vec postoji u bazi, nema potrebe za azuriranjem");
		return hcbd.update(p_contactBook);
	}

}
