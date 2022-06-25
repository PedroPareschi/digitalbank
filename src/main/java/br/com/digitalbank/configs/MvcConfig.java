package br.com.digitalbank.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EntityScan(basePackages = { "br.com.digitalbank.domain" })
@EnableJpaRepositories(basePackages = { "br.com.digitalbank.repositories" })
@ComponentScan(basePackages = {"\"br.com.digitalbank.resources"})
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login.html");
		registry.addViewController("/").setViewName("greeting.html");
		registry.addViewController("/conta").setViewName("paginainicial.html");
		registry.addViewController("/esquecisenha").setViewName("senha.html");
		registry.addViewController("/esquecisenha/confirma").setViewName("confirmasenha.html");
	}

}