package com.example.restfullwebservicesspringBoot.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@RestController
public class FilteringController {
	
	//@JsonPropertyOrder({"field3", "field2"})
	record SomeBean(String field1, @JsonIgnore String field2, String field3) {};
	
	@RequestMapping("/filtering")
	public SomeBean someBean() {
		return new SomeBean("Value1", "Value2", "Value3");
	}
	
	@RequestMapping("/filtering-list")
	public List<SomeBean> someBeanList() {
		return Arrays.asList(new SomeBean("Value11", "Value22", "Value33"),
				
				new SomeBean("Value111", "Value222", "Value333"),
				new SomeBean("Value1111", "Value2222", "Value3333")
				
				);
		
	}

}
