package net.croz.contacts.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import net.croz.contacts.model.Address;
import net.croz.contacts.model.City;
import net.croz.contacts.model.Contact;
import net.croz.contacts.model.ContactBook;
import net.croz.contacts.model.Country;
import net.croz.contacts.model.Sex;
import net.croz.contacts.model.code.AbstractCode;
import net.croz.contacts.service.code.CodeService;
import net.croz.contacts.service.contactbook.ContactBookService;
import net.croz.contacts.service.contactbook.ContactBookServiceImpl;
import net.croz.contacts.service.exceptions.ServiceException;
import net.croz.contacts.web.model.ContactForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ContactsController {

	@Autowired
	ContactBookService contactBookServiceImpl;
	@Autowired
	CodeService codeServiceImpl;
	
	private ContactBook cb = new ContactBook();
	private Map<Class<AbstractCode>, List<AbstractCode>> mapaKodova;// = codeServiceImpl.getCodes();
	
	
	public void setContactBookServiceImpl(ContactBookServiceImpl cbsi) {
		this.contactBookServiceImpl = cbsi;
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String list(Model model) {

		mapaKodova = codeServiceImpl.getCodes();
		
		Long userId = new Long(SecurityContextHolder.getContext().getAuthentication().getName());
		
		Set<Contact> kontakti = new HashSet<Contact>();

		if ((cb = contactBookServiceImpl.fetchById(userId)) != null)
			kontakti.addAll(cb.getContacts());

		List<ContactForm> listaKontakta = new ArrayList<ContactForm>();

		for (Contact c : kontakti) {
			ContactForm kontakt = new ContactForm();

			kontakt = wrapContact(c);
			
			listaKontakta.add(kontakt);
		}

		model.addAttribute("contactsList", listaKontakta);
		model.addAttribute("contact", new ContactForm());
		return "list";
	}

	@RequestMapping(value = "/contacts/{contactId}", method = RequestMethod.GET)
	public String show(@PathVariable Long contactId, Model model) {

		ContactForm kontakt = new ContactForm();

		for (Contact c : cb.getContacts()) {
			if (c.getId() == contactId) {
				kontakt = wrapContact(c);
				break;
			}
		}

		model.addAttribute("contact", kontakt);
		return "contact";
	}

	@RequestMapping(value = "/contacts/{contactId}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable Long contactId, Model model) {
		
		ContactForm kontakt = new ContactForm();
		
		for (Contact c : cb.getContacts()) {
			if (c.getId() == contactId) {
				kontakt = wrapContact(c);
				break;
			}
		}
		
		model.addAttribute("contact", kontakt);

		return "edit";
	}

	@RequestMapping(value = "/contacts/{contactId}", method = RequestMethod.PUT)
	public String update(@PathVariable Long contactId, @Valid @ModelAttribute("contact") ContactForm contact, BindingResult result, Model model) {
		
		if(result.hasErrors())
			return "contacts";
		
		Contact kontaktZaUpdate = unwrapContactForm(contact);
		Contact kontaktZaDelete = new Contact();
		
		for(Contact c : cb.getContacts()){
			if (c.getId() == contactId){
				kontaktZaDelete=c;
			}
		}
		
		cb.getContacts().remove(kontaktZaDelete);
		cb.getContacts().add(kontaktZaUpdate);
		
		contactBookServiceImpl.update(cb);
		
//		contactBookServiceImpl.fetchById(kontaktZaUpdate.getId());
		
		return "contact";
	}

	@RequestMapping(value = "/contacts/{contactId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long contactId, Model model) {

		Contact contactToRemove = new Contact();
		
		for(final Contact c : cb.getContacts())
			if (c.getId().equals(contactId))
				contactToRemove=c;
			
		cb.getContacts().remove(contactToRemove);	
		
		contactBookServiceImpl.update(cb);
		
		return "delete";
	}

	@RequestMapping(value = "/contacts/new", method = RequestMethod.GET)
	public String newContact(Model model) {

		model.addAttribute("contact", new ContactForm());
		
		model.addAttribute("listaPolova", mapaKodova.get(Sex.class));
		model.addAttribute("listaGradova", mapaKodova.get(City.class));
		model.addAttribute("listaDrzava", mapaKodova.get(Country.class));
		
		return "new";
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("contact") ContactForm contact, BindingResult result, Model model) {
		
		if (result.hasErrors())
			return "new";
		
		
		Contact kontakt = unwrapContactForm(contact);
			
		cb.getContacts().add(kontakt);
		
		contactBookServiceImpl.update(cb);
		
		return "newContact";
		
	}
	
	@ExceptionHandler(ServiceException.class)
	public String handleAllException(Exception ex) {
 
		return "serviceError";
 
	}

	private ContactForm wrapContact(Contact c) {
		ContactForm contactForm = new ContactForm();
		
		contactForm.setId(c.getId());
		contactForm.setFirstName(c.getFirstName());
		contactForm.setLastName(c.getLastName());
		contactForm.setStreet(c.getAddress().getStreet());
		contactForm.setStreetNo(c.getAddress().getStreetNo());
		contactForm.setPhone(c.getPhone());
		contactForm.setEmail(c.getEmail());
		contactForm.setCityName(c.getAddress().getCity().getName());
		contactForm.setZipCode(c.getAddress().getCity().getZipCode());
		contactForm.setCountryName(c.getAddress().getCity().getCountry().getName());
		contactForm.setAlpha2(c.getAddress().getCity().getCountry().getAlpha2());
		contactForm.setAlpha3(c.getAddress().getCity().getCountry().getAlpha3());
		contactForm.setSexName(c.getSex().getName());

		return contactForm;
	}

	private Contact unwrapContactForm(ContactForm contactForm){
		Contact contact = new Contact();
		Sex sex = new Sex();
		Address address = new Address();
		City city = new City();
		Country country = new Country();
		
		sex.setName(contactForm.getSexName());
		
		country.setAlpha2(contactForm.getAlpha2());
		country.setAlpha3(contactForm.getAlpha3());
		country.setName(contactForm.getCountryName());
		
		city.setName(contactForm.getCityName());
		city.setZipCode(contactForm.getZipCode());
		city.setCountry(country);
		
		
		for(Object s : mapaKodova.get(Sex.class)){
			Sex tmp = (Sex) s;
			if(tmp.getName().equals(sex.getName()))
				sex=(Sex) s;
		}
		
		for(Object c : mapaKodova.get(City.class)){
			City tmp = (City) c;
			if(tmp.getName().equals(city.getName()))
				city=(City) c;
		}
		
		for(Object c : mapaKodova.get(Country.class)){
			Country tmp = (Country) c;
			if(tmp.getName().equals(country.getName()))
				country=(Country) c;
		}
		
		address.setStreet(contactForm.getStreet());
		address.setStreetNo(contactForm.getStreetNo());
		address.setCity(city);
		
		contact.setFirstName(contactForm.getFirstName());
		contact.setLastName(contactForm.getLastName());
		contact.setPhone(contactForm.getPhone());
		contact.setEmail(contactForm.getEmail());
		contact.setFirstName(contactForm.getFirstName());
		contact.setAddress(address);
		contact.setSex(sex);
		
		return contact;
	}
	
}
