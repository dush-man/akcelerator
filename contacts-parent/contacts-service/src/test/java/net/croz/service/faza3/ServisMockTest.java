package net.croz.service.faza3;

import net.croz.contacts.dao.hibernate.HibernateContactBookDao;
import net.croz.contacts.model.ContactBook;
import net.croz.contacts.service.contactbook.ContactBookServiceImpl;
import net.croz.contacts.service.exceptions.ServiceException;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;


public class ServisMockTest{
	
	private ApplicationContext context;

	@SuppressWarnings("serial")
	@Test(expected=ServiceException.class)
	public void test() {
		
		context = new ClassPathXmlApplicationContext("test-service-context.xml");
		
		ContactBook cb = context.getBean("contactBook",ContactBook.class);
		
		HibernateContactBookDao hcbdMock = Mockito.mock(HibernateContactBookDao.class);
		
		Mockito.when(hcbdMock.fetchById(new Long(1))).thenReturn(new ContactBook());
		Mockito.when(hcbdMock.save(cb)).thenReturn(cb);
		Mockito.when(hcbdMock.update(cb)).thenReturn(cb);
		
		
		ContactBookServiceImpl cbsi = context.getBean("contactBookServiceImpl",ContactBookServiceImpl.class);
		cbsi.setHcbd(hcbdMock);
		
		//ovo nije normalno ponasanje, ali mockirani metodi rade ono za sta su mokirani
		ContactBook cbIzBaze = cbsi.save(cb);	
		cbsi.save(cbIzBaze);		
		cbsi.update(cbIzBaze);
		
		
		Mockito.when(hcbdMock.fetchById(new Long(1))).thenThrow(new IllegalStateException());
		Mockito.when(hcbdMock.save(cb)).thenThrow(new IllegalArgumentException());
		Mockito.when(hcbdMock.update(cb)).thenThrow(new DataAccessException("this was the reason"){});
		cbIzBaze = cbsi.save(cb);	
		cbsi.save(cbIzBaze);		
		cbsi.update(cb);
		cbsi.fetchById(new Long(1));
		
	}

	

}
