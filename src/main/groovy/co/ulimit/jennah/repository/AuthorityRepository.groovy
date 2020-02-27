package co.ulimit.jennah.repository

import co.ulimit.jennah.domain.Authority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface AuthorityRepository extends JpaRepository<Authority, UUID> {
	
	Authority findOneByName(@Param("name") String name)
	
}