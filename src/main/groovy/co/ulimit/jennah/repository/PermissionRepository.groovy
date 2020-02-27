package co.ulimit.jennah.repository

import co.ulimit.jennah.domain.Permission
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface PermissionRepository extends JpaRepository<Permission, UUID> {
	
	Permission findOneByName(@Param("name") String name)
	
}