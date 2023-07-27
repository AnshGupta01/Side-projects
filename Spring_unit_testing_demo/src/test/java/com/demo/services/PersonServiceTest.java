package com.demo.services;

import com.demo.entites.Person;
import com.demo.repo.PersonRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    //As we have already tested repo in our other test, we wont be testing our repo again

    //Hence we will use Mockito
    @Mock
    private PersonRepo personRepo;
    private PersonService personService;

    //this is used because we removed autowire from personService which was indirectly calling
    //real data from the database
    @BeforeEach
    void setUp() {
        this.personService = new PersonService(this.personRepo);
    }

    @Test
    void getAllPerson() {
        personService.getAllPerson();
        verify(personRepo).findAll();
    }
}