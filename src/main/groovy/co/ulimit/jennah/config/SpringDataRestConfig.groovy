package co.ulimit.jennah.config

import co.ulimit.jennah.repository.eventhandlers.EventHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer

@Configuration
class SpringDataRestConfig implements RepositoryRestConfigurer {
	
	@Override
	void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor()

//		Example Code:
//		config.exposeIdsFor(
//				co.ulimit.jennah.domain.pms.Patient.class,
//		)
	}
	
	@Bean
	EventHandler eventHandler() {
		return new EventHandler()
	}
}
