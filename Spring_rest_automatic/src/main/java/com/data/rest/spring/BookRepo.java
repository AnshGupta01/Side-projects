package com.data.rest.spring;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "mybooks", collectionResourceRel = "boo")
public interface BookRepo extends JpaRepository<Book, Integer> {
}
