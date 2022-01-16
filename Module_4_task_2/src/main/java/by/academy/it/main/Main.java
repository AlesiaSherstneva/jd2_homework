package by.academy.it.main;

import by.academy.it.beans.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("Person", Person.class);
        System.out.println(person);
        context.close();
    }
}
