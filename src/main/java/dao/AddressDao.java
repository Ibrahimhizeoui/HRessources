package dao;

import org.springframework.beans.factory.annotation.Autowired;

import repositories.AddressRepository;

public class AddressDao {

	@Autowired
	private AddressRepository addressRepository;

	public AddressRepository getAddressRepository() {
		return addressRepository;
	}
}
