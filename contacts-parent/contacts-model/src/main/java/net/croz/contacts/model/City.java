package net.croz.contacts.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import net.croz.contacts.model.code.AbstractCode;

public class City extends AbstractCode {

	private String zipCode;
	private Country country;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).appendSuper(super.hashCode())
				.append(this.getCountry()).append(this.getZipCode())
				.toHashCode();
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
		City rhs = (City) obj;
		boolean returnValue = new EqualsBuilder().appendSuper(super.equals(rhs))
				.append(this.getZipCode(), rhs.getZipCode()).isEquals();
		
		returnValue = this.getCountry().equals(rhs.getCountry()) && returnValue;
		
		return returnValue;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = super.hashCode();
	// result = prime * result + ((country == null) ? 0 : country.hashCode());
	// result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
	// return result;
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
	// City other = (City) obj;
	// // if (country == null) {
	// // if (other.country != null)
	// // return false;
	// // } else
	// if (!country.equals(other.country))
	// return false;
	// if (zipCode == null) {
	// if (other.zipCode != null)
	// return false;
	// } else if (!zipCode.equals(other.zipCode))
	// return false;
	// return true;
	// }

}
