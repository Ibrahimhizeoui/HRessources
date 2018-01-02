package dao;

import org.springframework.beans.factory.annotation.Autowired;

import repositories.ContactRepository;

public class ContactDao {
	
	@Autowired
	private ContactRepository contactRepository;

	public ContactRepository getContactRepository() {
		return contactRepository;
	}
}
