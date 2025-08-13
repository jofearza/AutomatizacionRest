package io.swagger.petstore.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.questions.ValidarCodigo;
import io.swagger.petstore.tasks.CreacionMascotaBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.util.function.Consumer;

import static io.swagger.petstore.tasks.ConsultaMascota.consultaMascota;
import static io.swagger.petstore.tasks.RequestDelete.requestDelete;
import static io.swagger.petstore.tasks.RequestPost.requestPost;
import static io.swagger.petstore.tasks.RequestUpdate.requestUpdate;
import static io.swagger.petstore.utils.LeerJson.creacionJson;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PetStoreStepDefinition {
    String baseUrlApi;
    CreacionMascotaBody creacionMascotaBody = new CreacionMascotaBody();

    @Before
    public void setUp(){
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        baseUrlApi = environmentVariables.getProperty("env.baseurlapi");
        setTheStage(OnlineCast.whereEveryoneCan(
                CallAnApi.at(baseUrlApi)
        ));
        SerenityRest.useRelaxedHTTPSValidation();
    }
    //Consulta(GET)
    @Cuando("el usuario consulta los datos")
    public void elUsuarioConsultaLosDatos() {
        theActorCalled("Vet").attemptsTo(
                consultaMascota()
        );
    }
    //Consulta(GET)
    @Entonces("usuario recibe respuesta exitosa")
    public void usuarioRecibeRespuestaExitosa() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarCodigo.esperadoEs(200)   //validacion del codigo de respuesta desde una question
                )

        );
                        /*
                        theActorInTheSpotlight().should(
                seeThatResponse(
                        "Codigo de respuesta 200",
                        response -> response.statusCode(200)));*/
    }


    //Creacion(POST)
    @Cuando("el usuario crea una nueva mascota")
    public void elUsuarioCreaUnaNuevaMascota() {
        theActorCalled("Vete").attemptsTo(
                   //requestPost(creacionMascotaBody.bodyCreacionMascota())  //Con este se crean con animales random de la clase
                requestPost(creacionJson("src/test/resources/CrearMascota.json"))  //Con este se carga lo que se encuentre en el json creado en la ruta
        );
    }

    //Creacion(POST
    @Entonces("usuario recibe resuesta exitosa")
    public void usuarioRecibeResuestaExitosa() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarCodigo.esperadoEs(200)   //validacion del codigo de respuesta desde una question
                )
        );
    }

    //Eliminacion(DELETE)
    @Cuando("usuario elimina la mascota")
    public void usuarioEliminaLaMascota() {
        theActorCalled("Vete").attemptsTo(
                requestDelete(creacionJson("src/test/resources/DeleteMascota.json"))  //Con este se carga lo que se encuentre en el json creado en la ruta

        );
    }
    @Entonces("el sistema debe eliminar la mascota exitosamente")
    public void elSistemaDebeEliminarLaMascotaExitosamente() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarCodigo.esperadoEs(200)   //validacion del codigo de respuesta desde una question
                )
        );
    }

    @Cuando("el usuario actualiza los datos")
    public void elUsuarioActualizaLosDatos() {
       theActorCalled("Vete").attemptsTo(
               requestUpdate(creacionJson("src/test/resources/UpdateMascota.json"))
       );
    }
    @Entonces("el usuario recibe respuesta exitosa de actualizacion")
    public void elUsuarioRecibeRespuestaExitosaDeActualizacion() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarCodigo.esperadoEs(200)   //validacion del codigo de respuesta desde una question
                )
        );
    }


}
