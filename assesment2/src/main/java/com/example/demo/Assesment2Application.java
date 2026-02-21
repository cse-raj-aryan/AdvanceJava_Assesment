package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Assesment2Application {

    public static void main(String[] args) {

        ApplicationContext context=SpringApplication.run(Assesment2Application.class, args);

        System.out.println("\n--- Getting Default StorageService ---");
        StorageService storage=context.getBean(StorageService.class);
        storage.storeFile("data.txt");

        
        System.out.println("\n--- Getting LocalStorageService Twice ---");
        LocalStorageService ls1=(LocalStorageService) context.getBean("localStorage");
        LocalStorageService ls2=(LocalStorageService) context.getBean("localStorage");

        
        System.out.println("Are both LocalStorage beans same? " + (ls1 == ls2));
        

        ((ConfigurableApplicationContext) context).close();
    }
}