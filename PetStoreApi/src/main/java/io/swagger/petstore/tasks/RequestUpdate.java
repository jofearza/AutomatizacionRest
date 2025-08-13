package io.swagger.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class RequestUpdate implements Task {
    public Object bodyUpdate;

    public RequestUpdate(Object bodyUpdate){
        this.bodyUpdate = bodyUpdate;
    }

    public static RequestUpdate requestUpdate(Object bodyUpdate){
        return Tasks.instrumented(RequestUpdate.class, bodyUpdate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("").with(
                request -> request
                        .header("Content-Type", "application/json")
                        .body(bodyUpdate)
                        .request().log().all()
                )
        );
        actor.should(
                seeThatResponse(
                response-> response.log().all()
                )
        );
    }
}
