package com.rytesoft.demospringapp.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends StdSerializer<Date> {

    // create an instance of SimpleDateFormat to form date in dd-MM-yyyy hh:mm:ss
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    // default constructor
    public CustomDateSerializer() {
        this(null);
    }

    // parameterized constructor
    public CustomDateSerializer(Class t) {
        super(t);
    }

    // override serialize() method
    @Override
    public void serialize (Date value, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeString(sdf.format(value));
    }
}
