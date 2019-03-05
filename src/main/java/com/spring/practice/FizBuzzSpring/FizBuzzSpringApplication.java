package com.spring.practice.FizBuzzSpring;

import com.practice.FizBuzz;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

@SpringBootApplication
public class FizBuzzSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizBuzzSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        FizBuzz fizbuzz = new FizBuzz();
        fizbuzz.addToTheTree(new BigInteger("3"), "fiz");
        fizbuzz.addToTheTree(new BigInteger("5"), "buzz");

        StringBuilder ret = new StringBuilder();

        for (int i = 1; i < 100; i++) {

            ret.append(fizbuzz.translate(new BigInteger("" + i)));
            ret.append(" ");
        }

        return args -> {
            System.out.println(ret.toString());
/*
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
*/

        };
    }
}
