package io.swagger.petstore.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObtenerLogger {

private ObtenerLogger(){

}

public static Logger obtenerLogger(){
    return LoggerFactory.getLogger(ObtenerLogger.class);
}
}
