package net.croz.contacts.web.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ContactForm {
	
	private Long id;
	@NotEmpty(message="{NotEmpty.contact.firstName}")
	@Size(max=20)
	private String firstName;
	@NotEmpty
	@Size(max=50)
	private String lastName;
	@NotEmpty
	@Size(max=13)
	private String phone;
	@NotEmpty
	@Size(max=50)
	private String email;
	@NotEmpty
	@Size(max=7)
	private String sexName;
	@NotEmpty
	@Size(max=50)
	private String street;
	@NotEmpty
	@Size(max=5)
	private String streetNo;
	@NotEmpty
	@Size(max=50)
	private String cityName;
//	@NotEmpty
//	@Size(max=10)
	private String zipCode;
	@NotEmpty
	@Size(max=50)
	private String countryName;
//	@NotEmpty
//	@Size(max=2)
	private String alpha2;
//	@NotEmpty
//	@Size(max=3)
	private String alpha3;

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

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
