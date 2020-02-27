package co.ulimit.jennah.graphqlservices

import co.ulimit.jennah.domain.Department
import co.ulimit.jennah.repository.DepartmentRepository
import co.ulimit.jennah.services.GeneratorService
import com.fasterxml.jackson.databind.ObjectMapper

import groovy.transform.TypeChecked
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@TypeChecked
@Component
@GraphQLApi
class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository
	

	@Autowired
	GeneratorService generatorService

	@Autowired
	ObjectMapper objectMapper

	//============== All Queries ====================

	@GraphQLQuery(name = "departments", description = "Get All Departments")
	List<Department> findAll() {
		departmentRepository.findAll().sort { it.departmentName }
	}

}
