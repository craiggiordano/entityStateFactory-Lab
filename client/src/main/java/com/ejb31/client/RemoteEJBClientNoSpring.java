package com.ejb31.client;

import com.ejb31.domain.Person;
import com.ejb31.remote.PersonService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 *
 */
public class RemoteEJBClientNoSpring {

    public static void main(String[] args) throws Exception {
        Long nodeId = 1l;
        RemoteEJBClientNoSpring client = new RemoteEJBClientNoSpring();
        Person person = client.findPerson(nodeId);
        System.out.println("Person firstName = [" + person.getFirstName() + "].");
        System.out.println("Person lastName = [" + person.getLastName() + "].");

    }

    public Person findPerson(Long nodeId) throws NamingException {
        PersonService personService = find();
        return personService.findPerson(nodeId);
    }

    private PersonService find() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        // The JNDI lookup name for a stateless session bean has the syntax of:
        // ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
        //
        // <appName> The application name is the name of the EAR that the EJB is deployed in
        //           (without the .ear).  If the EJB JAR is not deployed in an EAR then this is
        //           blank.  The app name can also be specified in the EAR's application.xml
        //
        // <moduleName> By the default the module name is the name of the EJB JAR file (without the
        //              .jar suffix).  The module name might be overridden in the ejb-jar.xml
        //
        // <distinctName> : AS7 allows each deployment to have an (optional) distinct name.
        //                  This example does not use this so leave it blank.
        //
        // <beanName>     : The name of the session been to be invoked.
        //
        // <viewClassName>: The fully qualified classname of the remote interface.  Must include
        //                  the whole package name.

        // let's do the lookup
        return (PersonService) context.lookup(
                "ejb:ejb31/ejb31-server-side/PersonServiceBean!" + PersonService.class.getName()
        );
    }
}
