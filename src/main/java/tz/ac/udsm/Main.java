package tz.ac.udsm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");

        Nyumba nyumba=container.getBean("nyumba",Nyumba.class);

        nyumba.fungaMlango();

        nyumba.funguaMlango();
    }
}