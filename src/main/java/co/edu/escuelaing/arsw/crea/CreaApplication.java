/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.crea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author CamiloCastiblanco
 */
@SuppressWarnings("deprecation")
@SpringBootApplication
//@ComponentScan("co.edu.escuelaing.arsw.crea")
public class CreaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreaApplication.class, args);
    }
    
    //@Override
    public void run(String... args) throws Exception {
    }

    @Bean
        public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}
