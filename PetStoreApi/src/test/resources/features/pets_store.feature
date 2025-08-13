#language: es
# Creacion, Consulta, Modificacion y Eliminacion

Característica: Creacion de mascota

  @CreacionMascota
  Escenario: Creacion de un registro nuevo de mascota
    Cuando el usuario crea una nueva mascota
    Entonces usuario recibe resuesta exitosa


  @ConsultaMascota
  Escenario: Consulta de un registro de mascota
    Cuando el usuario consulta los datos
    Entonces usuario recibe respuesta exitosa


@ActualizacionMascota
  Escenario: Actualizacion de un registro de mascota
  Cuando el usuario actualiza los datos
  Entonces el usuario recibe respuesta exitosa de actualizacion

  @EliminacionMascota
  Escenario: Eliminacion de un registro de mascota
    Cuando usuario elimina la mascota
    Entonces el sistema debe eliminar la mascota exitosamente