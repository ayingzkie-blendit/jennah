package co.ulimit.jennah.socket

import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@TypeChecked
@Service
class SocketService {
	
	@Autowired
	SocketController socketController
	
	@Autowired
	SimpMessageSendingOperations brokerMessagingTemplate
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate
	
	void helloWithPayload(Message payload) {
		simpMessagingTemplate.convertAndSend("/channel/hello", payload)
	}
	
	void helloToUser(Message payload, String user = 'admin') {
		simpMessagingTemplate.convertAndSendToUser(user, "/channel/hello", payload)
	}
	
	void payloadToUser(JennahWebsocketMessage payload, String username) {
		simpMessagingTemplate.convertAndSendToUser(username, "/channel/hello", payload)
	}
	
	void notificationToUser(JennahWebsocketMessage payload, String username) {
		simpMessagingTemplate.convertAndSendToUser(username, "/channel/notifications", payload)
	}
	
	void payloadToUser(JennahWebsocketMessage payload, String username, String destination) {
		simpMessagingTemplate.convertAndSendToUser(username, destination, payload)
	}
	
	void payloadToEveryone(JennahWebsocketMessage payload, String destination) {
		simpMessagingTemplate.convertAndSend(destination, payload)
	}
}
