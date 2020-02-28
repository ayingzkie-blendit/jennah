package co.ulimit.jennah.graphqlservices

import co.ulimit.jennah.domain.Category
import co.ulimit.jennah.domain.Department
import co.ulimit.jennah.repository.CategoryRepository
import co.ulimit.jennah.repository.DepartmentRepository
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
class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository
	

	@Autowired
	GeneratorService generatorService

	@Autowired
	ObjectMapper objectMapper

	//============== All Queries ====================

	@GraphQLQuery(name = "getCategories", description = "Get All Departments")
	List<Category> getCategories(@GraphQLArgument(name = "filter") String filter) {
		categoryRepository.getCategories(filter).sort {it.createdDate}
	}

}
