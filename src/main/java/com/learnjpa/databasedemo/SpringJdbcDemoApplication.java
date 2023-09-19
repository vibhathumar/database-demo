package com.learnjpa.databasedemo;

import com.learnjpa.databasedemo.entity.Person;
import com.learnjpa.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {}" + dao.findAll());
		logger.info("User id 100001 -> {}" + dao.findById(100001));
		logger.info("Deleting user id 100001 -> No of Rows Deleted - {}" + dao.deleteById(100001));
		logger.info("Inserting 100004 -> {}"
				+ dao.insert(new Person(100004, "Vira", "Sweden", new Date())));
		logger.info("Inserting 100003 -> {}"
				+ dao.update(new Person(100003, "Yaana", "India", new Date())));
	}
}
