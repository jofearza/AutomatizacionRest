package io.swagger.petstore.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarCodigo implements Question<Boolean> {
    private final int codigoEsperado;

    public ValidarCodigo(int codigoEsperado){
        this.codigoEsperado = codigoEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int codigoObtenido = SerenityRest.lastResponse().statusCode();
        return codigoObtenido == codigoEsperado;
    }

    public static ValidarCodigo esperadoEs(int codigo){
        return new ValidarCodigo(codigo);
    }
}
