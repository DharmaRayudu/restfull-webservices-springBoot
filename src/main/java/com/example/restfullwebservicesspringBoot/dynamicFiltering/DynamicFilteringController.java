package com.example.restfullwebservicesspringBoot.dynamicFiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {
	
	@JsonFilter("SomeBeanFilter")
	record FieldBean(String field1, String field2, String field3) {};
	
	@GetMapping(path = "/dynamic-filter")
	public MappingJacksonValue fieldBean() {
		
		FieldBean  bean =new FieldBean("Value1", "Value2", "Value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
	
	@GetMapping(path = "/dynamic-filter-list")
	public MappingJacksonValue fieldBeanList() {
		
		List<FieldBean> list =  Arrays.asList(
				new FieldBean("Value1", "Value2", "Value3"),
				new FieldBean("Value11", "Value22", "Value33"),
				new FieldBean("Value111", "Value222", "Value333"),
				new FieldBean("Value1111", "Value2222", "Value3333")
				);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

}
