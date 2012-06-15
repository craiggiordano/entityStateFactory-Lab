package com.ejb31.remote;

import com.ejb31.domain.Person;
import com.ejb31.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 */
@Stateless
@Remote({PersonService.class})
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class PersonServiceBean {

    @Autowired
    private PersonRepository personRepository;

    public Person findPerson(Long nodeId) {
        return personRepository.findOne(nodeId);
    }
}
