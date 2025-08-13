package io.swagger.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static io.swagger.petstore.utils.Variables.ID_ELIMINAR;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class RequestDelete implements Task {
    public Object bodyDelete;

    public RequestDelete(Object bodyDelete) {
        this.bodyDelete = bodyDelete;
    }

    public static RequestDelete requestDelete(Object bodyDelete) {

        return Tasks.instrumented(RequestDelete.class, bodyDelete);
}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(ID_ELIMINAR).with(
                request -> request
                        .header("Content-Type", "application/Json")
                        .header("api_key", "asd")
                        //.body(bodyDelete)
                         .request().log().all()
                )
        );
        actor.should(
                seeThatResponse(
                        response -> response.log().all()
                )
        );
    }
}
