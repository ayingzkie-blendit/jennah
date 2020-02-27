package co.ulimit.jennah.repository

import co.ulimit.jennah.domain.User
import co.ulimit.jennah.domain.Employee
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface EmployeeRepository extends JpaRepository<Employee, UUID> {
	
	@Query(
			value = "Select e from Employee e where lower(e.fullName) like lower(concat('%',:filter,'%'))",
			countQuery = "Select count(e) from Employee e where lower(e.fullName) like lower(concat('%',:filter,'%'))"
	)
	Page<Employee> getEmployees(@Param("filter") String filter, Pageable pageable)
	
	@Query(
			value = "Select e from Employee e where lower(e.fullName) like lower(concat('%',:filter,'%'))",
			countQuery = "Select count(e) from Employee e where lower(e.fullName) like lower(concat('%',:filter,'%'))"
	)
	List<Employee> searchEmployees(@Param("filter") String filter)
	
	@Query(
			value = "Select e from Employee e where e.user.login = :username"
	)
	List<Employee> findByUsername(@Param("username") String username)

	@Query(
			value = "Select e from Employee e where e.department.id = :id"
	)
	List<Employee> findEmployeesByDepartment(@Param("id") UUID id)

	Employee findOneByUser(@Param("user") User user)
}
