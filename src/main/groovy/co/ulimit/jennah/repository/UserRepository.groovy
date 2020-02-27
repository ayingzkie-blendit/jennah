package co.ulimit.jennah.repository

import co.ulimit.jennah.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface UserRepository extends JpaRepository<User, Long> {
	
	User findOneByLogin(@Param("login") String login)
	
}