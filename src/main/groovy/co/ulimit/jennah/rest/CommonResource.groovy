package co.ulimit.jennah.rest

import co.ulimit.jennah.services.DepartmentCategoryService
import co.ulimit.jennah.services.NotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CommonResource {

	@Autowired
	co.ulimit.jennah.socket.SocketService socketService

	@Autowired
	NotificationService notificationService

	@Autowired
	DepartmentCategoryService departmentCategoryService

	@RequestMapping("/ping")
	String ping() {
		"PONG"
	}

	@RequestMapping("/")
	String index() {

		"WELCOME TO Jennah GraphQL Server."
	}

	@RequestMapping("/categories")
	List<String> cat () {
	return departmentCategoryService.allcategory()
	}


	@RequestMapping("/hey")
	String hey() {
		//notificationService.notifyUser(UUID.fromString("3eec9518-f3b0-41fe-84d2-97a2f30ab83a"), "Sample Title", "Sample Message")
	}
}
