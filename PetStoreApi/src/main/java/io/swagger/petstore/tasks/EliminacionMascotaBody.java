package io.swagger.petstore.tasks;

import io.swagger.petstore.models.CreacionMascota;

import static io.swagger.petstore.utils.Variables.ID_ELIMINAR;
import static io.swagger.petstore.utils.Variables.NAME_ELIMINAR;

public class EliminacionMascotaBody {
    public CreacionMascota bodyEliminacionMascota(){
        CreacionMascota eliminacionMascota = new CreacionMascota();
        eliminacionMascota.setIdMascota(Integer.parseInt(ID_ELIMINAR));
        eliminacionMascota.setNombreMascota(NAME_ELIMINAR);
        return eliminacionMascota;
    }
}
