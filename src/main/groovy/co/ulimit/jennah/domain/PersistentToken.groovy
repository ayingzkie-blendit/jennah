package co.ulimit.jennah.domain

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import java.time.LocalDate

@Entity
@Table(name = "T_PERSISTENT_TOKEN")
class PersistentToken {
	
	@Transient
	static int MAX_USER_AGENT_LEN = 255
	
	@Id
	String series
	
	@JsonIgnore
	@NotNull
	@Column(name = "token_value", nullable = false)
	String tokenValue
	
	@JsonIgnore
	@Column(name = "token_date")
	LocalDate tokenDate
	
	//an IPV6 address max length is 39 characters
	@Size(min = 0, max = 39)
	@Column(name = "ip_address", length = 39)
	String ipAddress
	
	@Column(name = "user_agent")
	String userAgent
	
	void setUserAgent(String value) {
		if (userAgent != null && userAgent.size() >= MAX_USER_AGENT_LEN) {
			userAgent = userAgent?.substring(0, MAX_USER_AGENT_LEN - 1)
		} else {
			userAgent = userAgent
		}
	}
	
	@JsonIgnore
	@ManyToOne
	User user
	
}
