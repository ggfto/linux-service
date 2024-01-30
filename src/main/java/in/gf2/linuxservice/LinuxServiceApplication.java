package in.gf2.linuxservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LinuxServiceApplication {


public static void main(String[] args) {
		SpringApplication.run(LinuxServiceApplication.class, args);
        log.info("It works!");
	}
}
