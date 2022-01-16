package by.academy.it.main;

import by.academy.it.beans.Person;
import by.academy.it.beansForExcluding.AnotherPerson;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person firstPerson = context.getBean("person", Person.class);
        System.out.println(firstPerson);

        try {
            AnotherPerson secondPerson = context.getBean("anotherPerson", AnotherPerson.class);
            System.out.println(secondPerson);
        } catch (NoSuchBeanDefinitionException exception) {
            System.out.println("\nBean \"AnotherPerson\" was excluded successfully!");
        }

        context.close();
    }
}
