package com.ejb31.repository;

import com.ejb31.domain.Person;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;

/**
 *
 */
public interface PersonRepository extends GraphRepository<Person>, NamedIndexRepository<Person> {
}
