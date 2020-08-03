package org.sid.dao;

import org.sid.metier.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource(collectionResourceRel = "contacts",path = "contacts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface RestFul extends CrudRepository<Contact, Long> {

}
