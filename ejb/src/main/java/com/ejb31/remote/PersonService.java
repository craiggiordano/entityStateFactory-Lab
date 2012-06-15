package com.ejb31.remote;

import com.ejb31.domain.Person;

/**
 *
 */
public interface PersonService {

    Person findPerson(Long nodeId);
}
