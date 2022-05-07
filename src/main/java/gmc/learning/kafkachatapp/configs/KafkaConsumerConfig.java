package gmc.learning.kafkachatapp.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import gmc.learning.kafkachatapp.entities.MessageEntity;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Autowired
	private KafkaConfig kafkaConfigs;
	
	public Map<String, Object> getConsumerConfiguration() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigs.getServerUrl());
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return configs;
	}
	
	public ConsumerFactory<String, MessageEntity> getConsumerFactory() {
		return new DefaultKafkaConsumerFactory<>(getConsumerConfiguration());
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MessageEntity> kafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, MessageEntity> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(getConsumerFactory());
		return factory;
	}
	
}
