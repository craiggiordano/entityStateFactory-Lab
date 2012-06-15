package com.ejb31.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.io.Serializable;

/**
 *
 */
@NodeEntity
public class Person implements Serializable {

    @GraphId
    private Long nodeId;

    private String firstName;
    private String lastName;

    Person(){}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
