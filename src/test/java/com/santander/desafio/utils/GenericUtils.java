package com.santander.desafio.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class GenericUtils {
	
	public static <T> T getMockContent(String jsonPath, Class<T> returnType) throws IOException {
		ObjectMapper mapper = getMapper();
		FileInputStream fis = new FileInputStream(jsonPath);
		return mapper.readValue(fis, returnType);
	}

	public static <T> List<T> getMockListContent(String jsonPath, Class<T> returnType) throws IOException {
		ObjectMapper mapper = getMapper();
		FileInputStream fis = new FileInputStream(jsonPath);
		return mapper.readValue(fis, mapper.getTypeFactory().constructCollectionType(List.class, returnType));
	}

	private static ObjectMapper getMapper() {
		return new ObjectMapper()
				.registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
				.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
				.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
				.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
	}
}