package co.ulimit.jennah.domain

import io.leangen.graphql.annotations.GraphQLQuery
import org.hibernate.annotations.*

import javax.persistence.*

import java.time.LocalDateTime

@javax.persistence.Entity
@javax.persistence.Table(schema = "public", name = "employees")
class Employee extends AbstractAuditingEntity {
	
	@GraphQLQuery
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "uuid")
	@Type(type = "pg-uuid")
	UUID id
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`user`", referencedColumnName = "id")
	User user
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department", referencedColumnName = "id")
	Department department
	
	@GraphQLQuery
	@Column(name = "employee_no", columnDefinition = "varchar")
	String employeeNo
	
	@GraphQLQuery
	@Column(name = "first_name", columnDefinition = "varchar")
	String firstName
	
	@GraphQLQuery
	@Column(name = "last_name", columnDefinition = "varchar")
	String lastName
	
	@GraphQLQuery
	@Column(name = "middle_name", columnDefinition = "varchar")
	String middleName

	@GraphQLQuery
	@Column(name = "gender", columnDefinition = "varchar")
	String gender

	@GraphQLQuery
	@Column(name = "dob", columnDefinition = "date")
	LocalDateTime dob

	@GraphQLQuery
	@Formula("concat(last_name , coalesce(', ' || nullif(first_name,'') , ''), coalesce(' ' || nullif(middle_name,'') , ''), coalesce(' ' || nullif(name_suffix,'') , ''))")
	String fullName

}
