package net.croz.contacts.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import net.croz.contacts.model.code.AbstractEntity;

public class Address extends AbstractEntity {

	private String street;
	private String streetNo;
	private City city;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(this.getStreet()).append(this.getStreetNo()).append(this.getCity())
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
		Address rhs = (Address) obj;
		boolean returnValue = new EqualsBuilder()
				.append(this.getStreet(), rhs.getStreet())
				.append(this.getStreetNo(), rhs.getStreetNo())
				.isEquals();
		
		returnValue = this.getCity().equals(rhs.getCity()) && returnValue;
		
		return returnValue;
	}

	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((city == null) ? 0 : city.hashCode());
//		result = prime * result + ((street == null) ? 0 : street.hashCode());
//		result = prime * result
//				+ ((streetNo == null) ? 0 : streetNo.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		// if (!super.equals(obj))
//		// return false;
//		// if (getClass() != obj.getClass())
//		// return false;
//		Address other = (Address) obj;
//		// if (city == null) {
//		// if (other.city != null)
//		// return false;
//		// } else
//		if (!city.equals(other.city))
//			return false;
//		if (street == null) {
//			if (other.street != null)
//				return false;
//		} else if (!street.equals(other.street))
//			return false;
//		if (streetNo == null) {
//			if (other.streetNo != null)
//				return false;
//		} else if (!streetNo.equals(other.streetNo))
//			return false;
//		return true;
//	}
}
