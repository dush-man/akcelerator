package net.croz.contacts.service.faza2;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import net.croz.contacts.dao.CodeDao;
import net.croz.contacts.dao.ContactBookDao;
import net.croz.contacts.dao.hibernate.HibernateCodeDao;
import net.croz.contacts.dao.hibernate.HibernateContactBookDao;
import net.croz.contacts.model.City;
import net.croz.contacts.model.Contact;
import net.croz.contacts.model.ContactBook;
import net.croz.contacts.model.Country;
import net.croz.contacts.model.Sex;
import net.croz.contacts.model.code.AbstractCode;
import net.croz.contacts.service.code.CodeService;
import net.croz.contacts.service.code.CodeServiceImpl;

import org.hibernate.PropertyValueException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

public class TransactionTest {

	@SuppressWarnings({ "resource", "unused" })
	@Test
	public void test() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("contacts-app-context.xml");
//		ContactBook imenik = context.getBean("contactBook", ContactBook.class);
//		CodeService servis = context.getBean("codeServiceImpl", CodeServiceImpl.class);
//
//		try {
//			Map<Class<AbstractCode>, List<AbstractCode>> mapa = servis.getCodes();
//
//			ContactBookDao hcbd = context.getBean("hibernateContactBookDao", HibernateContactBookDao.class);
//
//			CodeDao hcd = context.getBean("hibernateCodeDao",HibernateCodeDao.class);
//			
//			//upis u bazu
//			hcbd.save(imenik);
//			
//			//citanje tek upisanog imenika
//			ContactBook imenikIzBaze = hcbd.fetchById(new Long(1));
//
//			//provera jednakosti imenika koji se upisuje i imenika koji je upisan
//			Assert.assertEquals(imenik, imenikIzBaze);
//
//			//provera da li se menja samo imenik iz konteksta
//			Contact amel = context.getBean("amel", Contact.class);
//			amel.setEmail("novi mail");
//			//Assert.assertEquals(imenik, imenikIzBaze);
//
//			//testiranje equals i hashcode metoda zarad pokrivenosti koda
//			for (Contact c : imenik.getContacts())
//				for (Contact d : imenikIzBaze.getContacts())
//					c.equals(d);
//			
//			//update-ujemo bazu sa novim mailom za kontakt amel i proveravamo da li vraca dobru vrednost
//			imenikIzBaze = hcbd.update(imenik);
//			Assert.assertEquals(imenik, imenikIzBaze);
//			
//			//fetch all
//			List<Sex> polovi = hcd.fetchAll(Sex.class); 
//			List<Country> drzave = hcd.fetchAll(Country.class);
//			List<City> gradovi = hcd.fetchAll(City.class);
//
//			Assert.assertEquals(2, polovi.size());
//			Assert.assertEquals(2, drzave.size());
//			Assert.assertEquals(3, gradovi.size());
//			
//			//fetchbyid
//			Sex pol = hcd.fetchById(Sex.class, new Long(1)); 
//			Country drzava = hcd.fetchById(Country.class, new Long(1));
//			City grad = hcd.fetchById(City.class, new Long(1));
//			
//		}catch (DataIntegrityViolationException e1) {
//			JOptionPane.showMessageDialog(null, "Pokusaj narusavanja integriteta, null vrednost se ne moze upisati u sifarnik ili entitet.");
//			//e1.printStackTrace();
//
//		} catch (PropertyValueException e) {
//			e.printStackTrace();
////
//		}  finally {
//			// session.close();
//		}
//
	}

}
