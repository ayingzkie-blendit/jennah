package co.ulimit.jennah.graphqlservices

import co.ulimit.jennah.domain.Item
import co.ulimit.jennah.repository.ItemRepository
import co.ulimit.jennah.services.GeneratorService
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.TypeChecked
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@TypeChecked
@Component
@GraphQLApi
class ItemService {

	@Autowired
	private ItemRepository itemRepository

	@Autowired
	GeneratorService generatorService

	@Autowired
	ObjectMapper objectMapper

	//============== All Queries ====================

	@GraphQLQuery(name = "getItems", description = "Get All Items")
	List<Item> getItems(@GraphQLArgument(name = "filter") String filter) {
		itemRepository.getItems(filter).sort {it.createdDate}
	}
}
