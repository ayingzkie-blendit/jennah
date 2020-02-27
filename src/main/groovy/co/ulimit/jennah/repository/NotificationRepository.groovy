package co.ulimit.jennah.repository

import co.ulimit.jennah.domain.Notification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface NotificationRepository extends JpaRepository<Notification, UUID> {
	
	@Query("Select n From Notification n Where n.to = :to")
	List<Notification> findByTo(@Param("to") UUID to);
	List<Notification> findTop10ByToOrderByDateNotifiedDesc(@Param("to") UUID to)
}
