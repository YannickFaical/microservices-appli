package com.gestion.customersevice;

import com.gestion.customersevice.entities.Customer;
import com.gestion.customersevice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSeviceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
					.name("mohamed")
					.email("mohammed@gmail.com").build());

			customerRepository.save(Customer.builder()
					.name("yannick")
					.email("yannick@gmail.com").build());
			customerRepository.save(Customer.builder()
					.name("ahmed")
					.email("ahmed@gmail.com").build());

			customerRepository.findAll().forEach(c->{
				System.out.println("==============");
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getEmail());
				System.out.println("==============");


			});

		};
	}
}
