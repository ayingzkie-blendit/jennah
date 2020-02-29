package co.ulimit.jennah.repository

import co.ulimit.jennah.domain.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ItemRepository extends JpaRepository<Item, UUID> {
    @Query(value = "Select i from Item i where lower(i.itemName) like lower(concat('%',:filter,'%'))")
    List<Item> getItems(@Param("filter") String filter)
}
