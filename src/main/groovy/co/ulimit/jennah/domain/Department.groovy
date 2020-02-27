package co.ulimit.jennah.domain

import io.leangen.graphql.annotations.GraphQLQuery
import org.hibernate.annotations.*

import javax.persistence.*

@javax.persistence.Entity
@javax.persistence.Table(name = "departments", schema = "public")
class Department extends AbstractAuditingEntity {
	@GraphQLQuery
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "uuid")
	@Type(type = "pg-uuid")
	UUID id
	
	@GraphQLQuery
	@Column(name = "department_name", columnDefinition = "varchar")
	String departmentName

	@GraphQLQuery
	@Column(name = "department_code", columnDefinition = "varchar")
	String departmentCode
}
