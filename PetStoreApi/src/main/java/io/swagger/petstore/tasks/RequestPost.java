package io.swagger.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class RequestPost implements Task {
    public Object bodyPost;

    public RequestPost(Object bodyPost){
        this.bodyPost = bodyPost;
    }

    public static RequestPost requestPost(Object bodyPost){
        return Tasks.instrumented(RequestPost.class, bodyPost);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("").with(
                        request -> request
                                .header("Content-Type", "application/json")
                                .body(bodyPost)
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
