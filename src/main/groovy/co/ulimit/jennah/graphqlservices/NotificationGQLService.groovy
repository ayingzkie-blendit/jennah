package co.ulimit.jennah.graphqlservices

import co.ulimit.jennah.repository.NotificationRepository
import co.ulimit.jennah.services.GeneratorService
import com.fasterxml.jackson.databind.ObjectMapper
import co.ulimit.jennah.domain.Notification
import co.ulimit.jennah.services.NotificationService
import groovy.transform.TypeChecked
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@TypeChecked
@Component
@GraphQLApi
class NotificationGQLService {
	
	@Autowired
	private NotificationService notificationService
	
	@Autowired
	private NotificationRepository notificationRepository
	
	@Autowired
	GeneratorService generatorService
	
	@Autowired
	ObjectMapper objectMapper
	
	//============== All Queries ====================
	
	@GraphQLQuery(name = "mynotifications", description = "Get All My Notifications")
	List<Notification> mynotifications(@GraphQLArgument(name = "id") UUID id) {
		def results = notificationRepository.findTop10ByToOrderByDatenotifiedDesc(id)
		return results
	}
}
