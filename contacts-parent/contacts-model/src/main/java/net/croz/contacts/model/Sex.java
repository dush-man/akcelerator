package net.croz.contacts.model;

import net.croz.contacts.model.code.AbstractCode;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Sex extends AbstractCode {

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).appendSuper(super.hashCode())
				.toHashCode();
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//		if (obj == this) {
//			return true;
//		}
//		if (obj.getClass() != getClass()) {
//			return false;
//		}
//		Sex rhs = (Sex) obj; 
//		return new EqualsBuilder().appendSuper(super.equals(rhs)).isEquals();
//	}
}