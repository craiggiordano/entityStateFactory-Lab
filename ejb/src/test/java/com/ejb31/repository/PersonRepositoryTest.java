package com.ejb31.repository;

import com.ejb31.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/domain-test-context.xml"})
@Transactional
public class PersonRepositoryTest {

    private String firstName = "Thomas";
    private String lastName = "Anderson";

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void canFindPerson() throws Exception {
        Person person = new Person(firstName, lastName).persist();
        Long nodeId = person.getNodeId();
        Person foundPerson = personRepository.findOne(nodeId);
        assertNotNull("Person not found.", foundPerson);
        assertEquals("Wrong first name.", firstName, foundPerson.getFirstName());
        assertEquals("Wrong last name.", lastName, foundPerson.getLastName());
    }
}
