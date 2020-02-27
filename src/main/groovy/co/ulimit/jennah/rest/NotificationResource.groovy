package co.ulimit.jennah.rest

import co.ulimit.jennah.socket.SocketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationResource {
	
	@Autowired
	SocketService socketService
	
}
