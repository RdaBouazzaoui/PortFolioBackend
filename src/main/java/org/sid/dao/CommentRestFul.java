package org.sid.dao;

import org.sid.metier.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource(collectionResourceRel = "comments",path = "comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface CommentRestFul extends CrudRepository<Comment, Long> {

}
