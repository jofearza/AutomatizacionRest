package io.swagger.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static io.swagger.petstore.utils.Variables.PATH_CONSULTA_API;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultaMascota implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH_CONSULTA_API)
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                //.header("Authorization", "Basic Y29.........") cuando se necesita un virtual token para usar el api
                                .request().log().all()
                        )
        );
        actor.should(
                seeThatResponse(
                      response -> response.log().all()
                )
        );
    }

    public static ConsultaMascota consultaMascota(){
        return Tasks.instrumented(ConsultaMascota.class);
    }
}
