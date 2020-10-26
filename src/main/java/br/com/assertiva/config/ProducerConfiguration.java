package br.com.assertiva.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Profile("test")
public class ProducerConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(ProducerConfiguration.class);

	@Bean
	public NewTopic mensage(){
		return TopicBuilder.name("mensagem")
				.partitions(3)
				.replicas(3)
				.build();
	}

}