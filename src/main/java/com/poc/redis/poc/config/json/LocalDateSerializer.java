package com.poc.redis.poc.config.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(final LocalDate temporal, final JsonGenerator jsonGenerator,
                          final SerializerProvider serializerProvider)
            throws IOException {
        if (temporal == null) {
            jsonGenerator.writeNull();
        } else {
            jsonGenerator.writeString(temporal.toString());
        }
    }

}
