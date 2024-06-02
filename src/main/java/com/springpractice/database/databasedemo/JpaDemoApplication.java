package com.springpractice.database.databasedemo;

import com.springpractice.database.databasedemo.entity.Person;
import com.springpractice.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //private String[] names = {"John", "Peter", "Matthew"};
    //private String[] locations = {"New York", "Chicago", "Tampa"};
    @Autowired
    PersonJpaRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //logger.info("\nAll users -> {}", repo.findAll());
        logger.info("\nUser with id 10001 -> {}", repo.findById(10001));
        /*
        for(String name : names) {
            logger.info("\nUser named {} -> {}", name, repo.findByName(name));
        }
        for(String city : locations) {
            logger.info("\nUser living in {} -> {}", city, repo.findByLocation(city));
        }
        */
        //logger.info("\nDeleting user with id 10002 -> No. rows deleted: {}", repo.deleteById(10002));
        logger.info("\nInserting new user -> {}",
                repo.insert(new Person("Sarah","Des Moines", new Date())));
        logger.info("\nUser with name {} -> {}", "Sarah", repo.findById(1));
        logger.info("\nUser with id 10005 -> {}", repo.findById(10005));
        logger.info("\nUpdating User 10005, setting city to {} -> {}", "Osaka",
                repo.update(new Person(10005,"John","Osaka", new Date())));
        logger.info("\nUser with id 10005 -> {}", repo.findById(10005));
        repo.deleteById(10002);
        logger.info("\nAll users -> {}", repo.findAll());
    }
}