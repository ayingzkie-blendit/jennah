package co.ulimit.jennah.repository

import co.ulimit.jennah.domain.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DepartmentRepository extends JpaRepository<Department, UUID> {

	@Query(value = "Select department from Department department where upper(department.departmentCode) = upper(:departmentCode)")
	Department findOneByDepartmentCode(@Param("departmentCode") String departmentCode)

}
