package io.swagger.petstore.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static io.swagger.petstore.utils.ObtenerLogger.obtenerLogger;

public class LeerJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static String loadJsonAsString(String pathFile) throws IOException {
        return objectMapper.writeValueAsString(objectMapper.readTree(new File(pathFile)));
    }

    public static String creacionJson(String pathFile){
        String contenidoJson;
        try{
            contenidoJson = loadJsonAsString(pathFile);
            return contenidoJson;
        } catch (Exception e) {
            obtenerLogger().error("Error al cargar el archivo JSON: {} ", e.getMessage());
        }
        return  null;
    }
}
