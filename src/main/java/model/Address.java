package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String careof;
	private boolean use_careof_as_attention;
	private String street_address;
	private String zipcode;
	private String city;
	private String country;
	
	public Address() {}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCareof() {
		return careof;
	}
	public void setCareof(String careof) {
		this.careof = careof;
	}
	
	
	
	public boolean isUse_careof_as_attention() {
		return use_careof_as_attention;
	}
	public void setUse_careof_as_attention(boolean use_careof_as_attention) {
		this.use_careof_as_attention = use_careof_as_attention;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [careof=" + careof + ", use_careof_as_attention=" + use_careof_as_attention
				+ ", street_address=" + street_address + ", zipcode=" + zipcode + ", city=" + city + ", country="
				+ country + "]";
	}
	
	
	
	
}
