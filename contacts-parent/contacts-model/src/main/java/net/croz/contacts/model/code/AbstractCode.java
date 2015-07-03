package net.croz.contacts.model.code;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class AbstractCode {

	private Long id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(name).toHashCode();
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
		AbstractCode rhs = (AbstractCode) obj;
		return new EqualsBuilder().append(this.getName(), rhs.getName())
				.isEquals();
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// //// result = prime * result + ((id == null) ? 0 : id.hashCode());
	// result = prime * result + ((name == null) ? 0 : name.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// // if (getClass() != obj.getClass())
	// // return false;
	// AbstractCode other = (AbstractCode) obj;
	// // if (id == null) {
	// // if (other.id != null)
	// // return false;
	// // } else if (!id.equals(other.id))
	// // return false;
	// if (!name.equals(other.name))
	// return false;
	// return true;
	// }
}
