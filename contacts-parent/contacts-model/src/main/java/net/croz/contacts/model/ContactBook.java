package net.croz.contacts.model;

import java.util.HashSet;
import java.util.Set;

import net.croz.contacts.model.code.AbstractEntity;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class ContactBook extends AbstractEntity {

	private Set<Contact> contacts;

	public ContactBook() {
		this.contacts = new HashSet<Contact>();
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(HashSet<Contact> m_contacts) {
		this.contacts = m_contacts;
	}

//	@Override
//	public int hashCode() {
//		int returnValue=0;
//		for(Contact c: getContacts())
//			returnValue += c.hashCode();
//		return new HashCodeBuilder(19, 37).appendSuper(super.hashCode())
//				.append(returnValue)
//				.toHashCode();
//	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { 
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		ContactBook rhs = (ContactBook) obj;
		boolean returnValue = new EqualsBuilder().appendSuper(super.equals(rhs))
				.isEquals();
		
		for(Contact c: this.getContacts())
			returnValue = returnValue && getContacts().contains(c);
		
		//returnValue = this.getContacts().equals(rhs.getContacts()) && returnValue;
		
		return returnValue;
	}
	
	// @Override
	// public int hashCode(){
	// return new HashCodeBuilder(17, 37).
	// append(name).
	// append(age).
	// append(smoker).
	// toHashCode();
	// }
	// return 1;
	// }
	// @Override
	// public boolean equals(Object obj){
	//
	// return true;
	// }

	// @Override
	// public int hashCode() {
	// // final int prime = 31;
	// // int result = super.hashCode();
	// // result = prime * result
	// // +
	// return ((contacts == null) ? 0 : contacts.hashCode());
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// // if (!super.equals(obj))
	// // return false;
	// // if (getClass() != obj.getClass())
	// // return false;
	// ContactBook other = (ContactBook) obj;
	// if (contacts == null) {
	// if (other.contacts != null)
	// return false;
	// } else if (!contacts.equals(other.contacts))
	// return false;
	// return true;
	// }
}
