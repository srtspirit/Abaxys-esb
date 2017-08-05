package com.abaxys.esb;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ConfigurationProperties
public class Application implements EnvironmentAware {
	
	private Environment env;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ConnectionFactory jmsConnectionFactory(){
		return new ActiveMQConnectionFactory(env.getProperty("abaxys.esb.jms.brokerUrl"));
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}
}
