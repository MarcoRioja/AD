package com.example.modelo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringdatabaseApplication {

    private static ConfigurableApplicationContext run;

	public static void main(String[] args) {
        run = SpringApplication.run(SpringdatabaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(JdbcTemplate jdbcTemplate) {
        return args -> {
            // Obtener los datos de la tabla fabricante y mostrarlos
            jdbcTemplate.query(
                    "SELECT id, nombre FROM Fabricante",
                    (rs, rowNum) -> new Fabricante(rs.getInt("id"), rs.getString("nombre"))
            ).forEach(fabricante -> System.out.println(fabricante.toString()));
        };
    }
}