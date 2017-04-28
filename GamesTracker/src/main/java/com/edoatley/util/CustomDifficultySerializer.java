package com.edoatley.util;

import java.io.IOException;

import com.edoatley.model.Difficulty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

public class CustomDifficultySerializer extends JsonSerializer<Difficulty> implements ContextualSerializer { 

	private static final CustomDifficultySerializer instance = new CustomDifficultySerializer();
	
	@Override
	public JsonSerializer<Difficulty> createContextual(SerializerProvider prov, BeanProperty property) 
			throws JsonMappingException {
		
		return instance;
	}
	
	@Override
	public void serialize(Difficulty value, JsonGenerator jsonGenerator, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		
	    jsonGenerator.writeString(value.description());
	}
}
