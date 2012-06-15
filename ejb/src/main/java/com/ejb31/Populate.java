package com.ejb31;

import com.ejb31.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
public class Populate {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Populate populate = (Populate) applicationContext.getBean("populate");
        populate.fill();
    }

    Populate() {}

    @Transactional
    public void fill() {
        Person albert = new Person("Albert", "Anderson").persist();
        Person bob = new Person("Bob", "Bush").persist();
        Person clint = new Person("Clint", "Calback").persist();
        Person dave = new Person("David", "Dirt").persist();
    }
}
