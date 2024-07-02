package tz.ac.udsm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        Nyumba nyumba1=container.getBean(Nyumba.class);

        nyumba1.setUkubwa(200);

        nyumba1.fungaMlango();

        nyumba1.funguaMlango();

        Nyumba nyumba2=container.getBean(Nyumba.class);

        nyumba2.fungaMlango();

        nyumba2.funguaMlango();


    }
}