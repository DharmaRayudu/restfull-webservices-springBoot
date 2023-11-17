package com.example.restfullwebservicesspringBoot.versining;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
	
	record Person(String name) {};
	
	record PersonV2(NameDetails nameDetails) {};
	record NameDetails(String firstName, String lastName, Integer age) {};
	
	@GetMapping(path = "/V1/persons")
	public Person version1() {
		return new Person("Dharma");
	}
	
	@GetMapping(path = "/V2/persons")
	public PersonV2 version2() {
		
		return new PersonV2(new NameDetails("Dharma", "Rayudu", 32));
	}
	
	
	@GetMapping(path = "/persons", params = "version=1")
	public Person versionV1WithParams() {
		return new Person("Dharma");
	}
	
	@GetMapping(path = "/persons", params = "version=2")
	public PersonV2 versionV2WithParams() {
		
		return new PersonV2(new NameDetails("Dharma", "Rayudu", 32));
	}
	
	@GetMapping(path = "/persons", headers ="X-API-VERSION=1")
	public Person versionV1WithHeaders() {
		return new Person("Dharma");
	}
	
	@GetMapping(path = "/persons", headers ="X-API-VERSION=2")
	public PersonV2 versionV2WithHeaders() {
		
		return new PersonV2(new NameDetails("Dharma", "Rayudu", 32));
	}
	
	@GetMapping(path = "/persons", produces = "application/vnd.company.app-v1+json")
	public Person versionV1WithProduces() {
		return new Person("Dharma");
	}
	
	@GetMapping(path = "/persons", produces ="application/vnd.company.app-v2+json")
	public PersonV2 versionV2WithProduces() {
		
		return new PersonV2(new NameDetails("Dharma", "Rayudu", 32));
	}
	

}
