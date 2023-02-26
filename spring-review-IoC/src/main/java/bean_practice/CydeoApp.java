package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, NewConfig.class);

        FullTimeEmployee ft = context.getBean(FullTimeEmployee.class);
        ft.createAccount();

        PartTimeEmployee pt = context.getBean(PartTimeEmployee.class);
        pt.createAccount();

        String obj1 = context.getBean("welcome", String.class);
        System.out.println("obj1 = " + obj1);

        String obj2 = context.getBean("obj2", String.class);
        System.out.println("obj2 = " + obj2);

    }
}
