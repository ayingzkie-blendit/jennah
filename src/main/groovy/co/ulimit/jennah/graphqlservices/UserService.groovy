package co.ulimit.jennah.graphqlservices

import co.ulimit.jennah.dao.UserDao
import co.ulimit.jennah.domain.Authority
import co.ulimit.jennah.domain.Employee
import co.ulimit.jennah.domain.Permission
import co.ulimit.jennah.domain.PersistentToken
import co.ulimit.jennah.domain.User
import co.ulimit.jennah.repository.EmployeeRepository
import co.ulimit.jennah.repository.UserRepository
import co.ulimit.jennah.security.SecurityUtils
import groovy.transform.TypeChecked
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLContext
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@TypeChecked
@Component
@GraphQLApi
class UserService {
	
	@Autowired
	private UserRepository userRepository

	@Autowired
	private EmployeeRepository employeeRepository

	@Autowired
	UserDao userDao

	@GraphQLQuery(name = "account", description = "Get User by login")
	Employee findOneByLogin() {
		User user = userRepository.findOneByLogin(SecurityUtils.currentLogin())
		return employeeRepository.findOneByUser(user)
	}

	@GraphQLQuery(name = "authorities", description = "Get all User authorities")
	List<Authority> getAuthorities(@GraphQLContext User user) {
		return userDao.getAuthorities(user)
	}
	
	@GraphQLQuery(name = "persistentTokens", description = "Get all User persistentTokens")
	List<PersistentToken> getPersistentTokens(@GraphQLContext User user) {
		return userDao.getPersistentTokens(user)
	}
	
	@GraphQLQuery(name = "permissions", description = "Get all User permissions")
	List<Permission> getPermissions(@GraphQLContext User user) {
		return userDao.getPermissions(user)
	}
	
	@GraphQLQuery(name = "roles", description = "Get all User roles")
	List<String> getRoles(@GraphQLContext User user) {
		//return userDao.getRoles(user)
		
		// FYI Roles are save in the Session already... Lets save database acccess  round trip
		SecurityUtils.roles
	}
	
	@GraphQLQuery(name = "access", description = "Get all User access")
	List<String> getAccess(@GraphQLContext User user) {
		return userDao.getAccess(user)
	}
	
	@GraphQLQuery(name = "isLoginUnique", description = "Check if username exists")
	Boolean isLoginUnique(@GraphQLArgument(name = "login") String login) {
		return !userRepository.findOneByLogin(login.toLowerCase())
	}
}
