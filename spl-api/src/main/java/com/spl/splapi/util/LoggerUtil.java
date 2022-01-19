package com.spl.splapi.util;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.spl.splapi.util.annotations.SensitiveData;

public interface LoggerUtil {

	default String prettyPrint(Object object) {
		if (ObjectUtils.allNull(object, null))
			return null;

		try {
			ObjectMapper mapper = initializeMapper();
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			String message = "Unable to process pretty print. Your object toString value is {0}";
			return MessageFormat.format(message, object);
		}
	}

	public static ObjectMapper initializeMapper() {
		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector sis = mapper.getSerializationConfig().getAnnotationIntrospector();
		AnnotationIntrospector dis = mapper.getDeserializationConfig().getAnnotationIntrospector();

		AnnotationIntrospector is1 = AnnotationIntrospector.pair(sis, new SensitiveDataAnnotationIntrospector());
		AnnotationIntrospector is2 = AnnotationIntrospector.pair(dis, new SensitiveDataAnnotationIntrospector());

		mapper.setAnnotationIntrospectors(is1, is2);
		return mapper;
	}

	public static class SensitiveDataAnnotationIntrospector extends NopAnnotationIntrospector {

		private static final long serialVersionUID = 1L;

		@Override
		public Object findSerializer(Annotated a) {
			SensitiveData annotation = a.getAnnotation(SensitiveData.class);
			return annotation == null ? null : SensitiveDataSerializer.class;
		}

		@Override
		public Object findDeserializationConverter(Annotated a) {
			SensitiveData annotation = a.getAnnotation(SensitiveData.class);
			return annotation == null ? null : SensitiveDataSerializer.class;
		}

	}

	public static class SensitiveDataSerializer extends StdSerializer<String> {

		private static final long serialVersionUID = 1L;

		public SensitiveDataSerializer() {
			super(String.class);
		}
		
		@Override
		public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
			int length = value.length();
			gen.writeString(StringUtils.repeat("*", length));
		}

	}

	public static class SensitiveDataDeserializer extends StdDeserializer<String> {

		private static final long serialVersionUID = 1L;

		public SensitiveDataDeserializer() {
			super(String.class);
		}

		@Override
		public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
			return p.getValueAsString();
		}

	}
}
