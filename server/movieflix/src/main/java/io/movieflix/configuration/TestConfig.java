package io.movieflix.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages={
		"io.movieflix.controller",
		"io.movieflix.dao", 
		"io.movieflix.entity",
		"io.movieflix.services",
		"io.movieflix.exception"
})
public class TestConfig {

}
