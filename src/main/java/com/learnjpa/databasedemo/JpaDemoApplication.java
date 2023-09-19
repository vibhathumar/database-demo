package com.learnjpa.databasedemo;

import com.learnjpa.databasedemo.entity.Person;
import com.learnjpa.databasedemo.jdbc.PersonJdbcDao;
import com.learnjpa.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 100001 -> {}" + repository.findById(100001));
		logger.info("Inserting 100004 -> {}"
				+ repository.insert(new Person(100004, "Vira", "Sweden", new Date())));
		logger.info("Inserting 100003 -> {}"
				+ repository.update(new Person(100003, "Yaana", "India", new Date())));
		 repository.deleteById(100001);
		logger.info("All Users -> {}" + repository.findAll());
	}
}
