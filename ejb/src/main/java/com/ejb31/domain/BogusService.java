package com.ejb31.domain;

import com.ejb31.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Without the existence of this service, my single unit test for the PersonRepository will fail because
 * the test application context cannot be loaded.  No idea how this has anything to do with successfully
 * loading the application context.  Incredible.
 */
@Service
public class BogusService {

    @Autowired
    private PersonRepository personRepository;

    public Person get(Long id) {
        return personRepository.findOne(id);
    }
}
