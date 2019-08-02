package spring2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spr.xml");
        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);
        context.close();
    }

}
