package com.digitalsolution.digitalsolution;

import com.digitalsolution.digitalsolution.entityes.Employee;
import com.digitalsolution.digitalsolution.entityes.Enterprise;
import com.digitalsolution.digitalsolution.entityes.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalsolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalsolutionApplication.class, args);

		Employee employee = new Employee();
		Enterprise enterprise = new Enterprise();
		Transaction transaction = new Transaction();
		
		employee.setCedula(1023645098);
		enterprise.setNit(123589452);
		transaction.setIdm(20054);
			
		System.out.println(employee.getCedula());
		System.out.println(enterprise.getNit());
		System.out.println(transaction.getIdm());
	}

}
