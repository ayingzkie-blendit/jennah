package co.ulimit.jennah.services

import co.ulimit.jennah.domain.Employee
import co.ulimit.jennah.domain.Notification
import co.ulimit.jennah.repository.EmployeeRepository
import co.ulimit.jennah.repository.NotificationRepository
import co.ulimit.jennah.security.SecurityUtils
import co.ulimit.jennah.socket.JennahMessageType
import co.ulimit.jennah.socket.JennahWebsocketMessage
import co.ulimit.jennah.socket.SocketService
import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.Instant

@Service
@TypeChecked
class NotificationService {
	
	@Autowired
	SocketService socketService
	
	@Autowired
	NotificationRepository notificationRepository

	@Autowired

	EmployeeRepository employeeRepository
	
	void notifyUser(UUID userid, String title, String message) {
		Employee e = employeeRepository.findByUsername(SecurityUtils.currentLogin()).first()
		Employee eto = employeeRepository.getOne(userid)

		Notification notification = new Notification()
		notification.message = message
		notification.to = userid
		notification.from = e.id
		notification.title = title
		notification.dateNotified = Instant.now()
		notificationRepository.save(notification)

		JennahWebsocketMessage payload = new JennahWebsocketMessage(e.fullName, message, title, JennahMessageType.NOTIFICATION_NEW)
		socketService.notificationToUser(payload, eto.user.login)
	}
	
	void notifyUsers(List<Employee> employees, String title, String message) {
		for (Employee emp : employees) {
			notifyUser(emp.id, title, message)
		}
	}
	
	void notifyUsersOfDepartment(UUID departmentId, String title, String message) {
		List<Employee> employeeList = employeeRepository.findEmployeesByDepartment(departmentId)
		for (Employee emp : employeeList) {
			notifyUser(emp.id, title, message)
		}
	}
	
}
