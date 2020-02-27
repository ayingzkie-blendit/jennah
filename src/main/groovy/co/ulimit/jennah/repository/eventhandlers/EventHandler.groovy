package co.ulimit.jennah.repository.eventhandlers


import co.ulimit.jennah.services.GeneratorService

import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.core.annotation.*

import javax.transaction.Transactional

@TypeChecked
@RepositoryEventHandler
@Transactional
class EventHandler {
	
	@Autowired
	private GeneratorService generatorService

}
