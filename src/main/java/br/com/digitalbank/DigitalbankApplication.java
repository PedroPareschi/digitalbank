package br.com.digitalbank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalbankApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DigitalbankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
