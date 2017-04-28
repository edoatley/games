package com.edoatley.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.edoatley.model.Difficulty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

public class CustomBooleanSerializer extends JsonSerializer<Boolean> implements ContextualSerializer { 

	private static final CustomBooleanSerializer instance = new CustomBooleanSerializer();
	
	@Override
	public JsonSerializer<Boolean> createContextual(SerializerProvider prov, BeanProperty property) 
			throws JsonMappingException {
		
		return instance;
	}
	
	@Override
	public void serialize(Boolean value, JsonGenerator jsonGenerator, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		
		String answer = value.booleanValue() ? "Yes" : "No";
	    jsonGenerator.writeString(answer);
	}
}
