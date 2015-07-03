package net.croz.contacts.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import net.croz.contacts.model.code.AbstractCode;

public class Country extends AbstractCode {

	private String alpha2;
	private String alpha3;

	public String getAlpha2() {
		return alpha2;
	}

	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).appendSuper(super.hashCode())
				.append(this.getAlpha2()).append(this.getAlpha3()).toHashCode();
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
		Country rhs = (Country) obj;
		return new EqualsBuilder().appendSuper(super.equals(rhs))
				.append(this.getAlpha2(), rhs.getAlpha2())
				.append(this.getAlpha3(), rhs.getAlpha3()).isEquals();
	}
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((alpha2 == null) ? 0 : alpha2.hashCode());
//		result = prime * result + ((alpha3 == null) ? 0 : alpha3.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
////		if (!super.equals(obj))
////			return false;
////		if (getClass() != obj.getClass())
////			return false;
//		Country other = (Country) obj;
//		if (alpha2 == null) {
//			if (other.alpha2 != null)
//				return false; 
//		} else if (!alpha2.equals(other.alpha2))
//			return false;
//		if (alpha3 == null) {
//			if (other.alpha3 != null)
//				return false;
//		} else if (!alpha3.equals(other.alpha3))
//			return false;
//		return true;
//	}

}
