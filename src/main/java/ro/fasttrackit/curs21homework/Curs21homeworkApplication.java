package ro.fasttrackit.curs21homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.fasttrackit.curs21homework.domain.CountryService;

@SpringBootApplication
public class Curs21homeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(Curs21homeworkApplication.class, args);
		CountryService countryService=new CountryService();
//		System.out.println(countryService.getCountries());
	}

}
