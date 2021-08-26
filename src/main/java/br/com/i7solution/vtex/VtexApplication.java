package br.com.i7solution.vtex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(scanBasePackages = "br.com.i7solution.vtex")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class VtexApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtexApplication.class, args);
	}

}
