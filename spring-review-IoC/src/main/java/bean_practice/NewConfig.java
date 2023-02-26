package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewConfig {

    @Bean("welcome")
    public String obj1() {
        return "Welcome to Cydeo App";
    }

    @Bean("obj2")
    public String obj2() {
        return "Spring Core Practice";
    }
}
