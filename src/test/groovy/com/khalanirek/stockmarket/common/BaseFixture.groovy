package com.khalanirek.stockmarket.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.khalanirek.stockmarket.infrastructure.ObjectMapperConfiguration

class BaseFixture {

    private static ObjectMapper objectMapper = new ObjectMapperConfiguration().objectMapper()

    static String toJson(Object value) {
        objectMapper.writeValueAsString(value)
    }

    static<T> T fromJson(String json, Class<T> valueType) {
        objectMapper.readValue(json, valueType)
    }

}
