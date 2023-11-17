package com.example.restfullwebservicesspringBoot.hellocontroller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfullwebservicesspringBoot.model.HelloWorld;

@RestController
public class HelloWorldController {
	
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping(path = "hello")
	public String helo() {
		return "Hello Spring Rest";
	}
	
	@GetMapping(path = "hello-world")
	public HelloWorld heloJsonF() {
		return new HelloWorld("Hello Spring Rest!");
	}

	//Path Parameters
	
	//Path Variable, hello-world/path-variable/{name}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorld heloJsonFPath(@PathVariable String name) {
		
		return new HelloWorld(String.format("Hello Path Variable, %s", name));
	}
	
	@GetMapping(path = "hello-world-in")
	public String heloJsonFIN() {
		Locale locale =  LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning", null, locale);
		//return new HelloWorld("Hello Spring Rest!");
	}
}

