package gmc.learning.kafkachatapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gmc.learning.kafkachatapp.entities.MessageEntity;
import gmc.learning.kafkachatapp.services.MessagingService;

@RestController
public class ChatController {
	
	@Autowired
	private MessagingService messagingService;
	
	@MessageMapping("/receive")
	@SendTo("/topic/group")
	public MessageEntity sendToAll(@Payload MessageEntity message) {
		return message;
	}
	
	@GetMapping("/message/{message}/send")
	public ResponseEntity<String> sendMessage(@PathVariable String message) {
		String returnValue = messagingService.sendMessage(message);
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
}
