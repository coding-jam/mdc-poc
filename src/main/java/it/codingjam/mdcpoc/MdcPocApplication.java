package it.codingjam.mdcpoc;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.UUID;

@ServletComponentScan
@SpringBootApplication
public class MdcPocApplication {

	public static void main(String[] args) {
        String logData = String.format("[IP: %s | REQ_ID: %s]", "", "");
        MDC.put("logData", logData);
		SpringApplication.run(MdcPocApplication.class, args);
	}
}
