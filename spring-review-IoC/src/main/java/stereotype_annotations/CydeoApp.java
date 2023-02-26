package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.ConfigClass;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.ExtraHours;
import stereotype_annotations.model.Microservice;

public class CydeoApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

        DataStructure ds = context.getBean(DataStructure.class);
        ds.getTotalHours();

        Microservice ms = context.getBean(Microservice.class);
        ms.getTotalHours();

        ExtraHours extraHours = context.getBean(ExtraHours.class);
        System.out.println(extraHours.getHours());


    }
}
