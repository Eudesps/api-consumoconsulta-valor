package com.consultacarros.consumoapi;

import com.consultacarros.consumoapi.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumoapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoapiApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main();

        main.exibirMenu();
    }
}
