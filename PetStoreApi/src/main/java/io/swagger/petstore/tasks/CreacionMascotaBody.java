package io.swagger.petstore.tasks;

import com.github.javafaker.Faker;
import io.swagger.petstore.models.CreacionMascota;


public class CreacionMascotaBody {

    Faker datosDummy = new Faker();
    public int idMascota = datosDummy.number().numberBetween(600,900);
    public String nombreMascota = datosDummy.animal().name();
    public String estadoMascota = datosDummy.options().option("Available", "Sold", "Pending");
    public CreacionMascota bodyCreacionMascota(){
        CreacionMascota creacionMascota = new CreacionMascota();
        creacionMascota.setIdMascota(idMascota);
        creacionMascota.setNombreMascota(nombreMascota);
        creacionMascota.setEstadoMascota(estadoMascota);
        return creacionMascota;
    }

}
