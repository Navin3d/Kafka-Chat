package gmc.learning.kafkachatapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import gmc.learning.kafkachatapp.entities.MessageEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageListener {
	
	@Autowired
	private SimpMessagingTemplate simpTemplate;
	
	private static final String TOPIC = "Message";
	private static final String GROUPID = "Testing";
	
	
	@KafkaListener(topics = TOPIC, groupId = GROUPID)
	public void listen(@Payload String message) {
		log.error("The Output message is: " + message);
		
		simpTemplate.convertAndSend("/topic/group", message);
	}

}
