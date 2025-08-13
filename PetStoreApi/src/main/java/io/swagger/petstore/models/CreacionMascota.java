package io.swagger.petstore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
        "id","nombre", "estado"
})
public class CreacionMascota {
    @JsonProperty("id")
    private int idMascota;
    @JsonProperty("nombre")
    private String nombreMascota;
    @JsonProperty("estado")
    private String estadoMascota;
}
