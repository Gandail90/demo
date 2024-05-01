package de.sni.demo.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("de.sni.demo.businesslogic")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ApiConfig
{

}
