package gmc.learning.kafkachatapp.services.impl;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import gmc.learning.kafkachatapp.daos.MessageDao;
import gmc.learning.kafkachatapp.entities.MessageEntity;
import gmc.learning.kafkachatapp.services.MessagingService;

@Service
public class MessagingServiceImpl implements MessagingService {
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private KafkaTemplate<String, MessageEntity> kafkaTemplate;

	@Override
	public String sendMessage(String message) {
		MessageEntity messageToSend = new MessageEntity();
		messageToSend.setMessage(message);
		messageToSend.setSentAt(Timestamp.from(Instant.now()));
		
		messageDao.save(messageToSend);
		
		kafkaTemplate.send("Message", messageToSend);
		
		return "Message Sent Successfully: " + message;
	}

}
