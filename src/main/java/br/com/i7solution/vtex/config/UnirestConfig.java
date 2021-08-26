package br.com.i7solution.vtex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnirestConfig {

    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper mapper;

}