package it.codingjam.mdcpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MdcPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdcPocApplication.class, args);
	}
}
