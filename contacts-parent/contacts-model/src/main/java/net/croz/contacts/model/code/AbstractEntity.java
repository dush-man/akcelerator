package net.croz.contacts.model.code;

import org.apache.commons.lang3.builder.EqualsBuilder;

public abstract class AbstractEntity {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() { 
		return 31;
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
//		AbstractEntity rhs = (AbstractEntity) obj;
		return new EqualsBuilder()
				.isEquals();
	}
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// // if (!(getClass().equals(obj.getClass())))
	// // return false;
	// // AbstractEntity other = (AbstractEntity) obj;
	// // if (id == null) {
	// // if (other.id != null)
	// // return false;
	// // } else if (!id.equals(other.id))
	// // return false;
	// return true;
	// }
}
