package net.croz.contacts.model;

import net.croz.contacts.model.code.AbstractEntity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Contact extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Sex sex;
	private Address address;

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = super.hashCode();
	// result = prime * result + ((address == null) ? 0 : address.hashCode());
	// result = prime * result + ((email == null) ? 0 : email.hashCode());
	// result = prime * result
	// + ((firstName == null) ? 0 : firstName.hashCode());
	// result = prime * result
	// + ((lastName == null) ? 0 : lastName.hashCode());
	// result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	// result = prime * result + ((sex == null) ? 0 : sex.hashCode());
	// return result;
	// }

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(this.getAddress()).append(this.getEmail())
				.append(this.getFirstName()).append(this.getLastName())
				.append(this.getPhone()).append(this.getSex()).toHashCode();
	}

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
		Contact rhs = (Contact) obj;
		boolean returnValue = new EqualsBuilder()
				.append(this.getEmail(), rhs.getEmail())
				.append(this.getPhone(), rhs.getPhone()) 
				.append(this.getFirstName(), rhs.getFirstName())
				.append(this.getLastName(), rhs.getLastName())
//				.append(this.getSex(), rhs.getSex())
//				.append(this.getAddress(), rhs.getAddress())
				.isEquals();
		
		returnValue=this.getAddress().equals(rhs.getAddress()) && returnValue && this.getSex().equals(rhs.getSex());
		
		return returnValue;
	}

	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// // if (!super.equals(obj))
	// // return false;
	// // if (getClass() != obj.getClass())
	// // return false;
	// Contact other = (Contact) obj;
	// // if (address == null) {
	// // if (other.address != null)
	// // return false;
	// // } else
	// if (!address.equals(other.address))
	// return false;
	// if (email == null) {
	// if (other.email != null)
	// return false;
	// } else
	// if (!email.equals(other.email))
	// return false;
	// if (firstName == null) {
	// if (other.firstName != null)
	// return false;
	// } else if (!firstName.equals(other.firstName))
	// return false;
	// if (lastName == null) {
	// if (other.lastName != null)
	// return false;
	// } else if (!lastName.equals(other.lastName))
	// return false;
	// if (phone == null) {
	// if (other.phone != null)
	// return false;
	// } else if (!phone.equals(other.phone))
	// return false;
	// // if (sex == null) {
	// // if (other.sex != null)
	// // return false;
	// // } else
	// if (!sex.equals(other.sex))
	// return false;
	// return true;
	// }
}
