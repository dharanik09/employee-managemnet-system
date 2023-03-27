package com.employeestorageservice.employeestorageservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValueMapper {
    private ValueMapper() {

    }
    public static String jsonAsString(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
