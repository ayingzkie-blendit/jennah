package co.ulimit.jennah.repository

import co.ulimit.jennah.domain.Category
import co.ulimit.jennah.domain.Department
import co.ulimit.jennah.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Query(value = "Select c from Category c where lower(c.categoryName) like lower(concat('%',:filter,'%'))")
    List<Category> getCategories(@Param("filter") String filter)
}
