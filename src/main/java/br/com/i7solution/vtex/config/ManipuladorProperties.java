package br.com.i7solution.vtex.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManipuladorProperties {
    public Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./config/dados.properties"
        );
        props.load(file);
        return props;
    }
}