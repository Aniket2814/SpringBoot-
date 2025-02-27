package com.springboot.beans.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	Apple obj;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

}
@Override
public void run(String... args) throws Exception {
	obj.eatApple();
}



}