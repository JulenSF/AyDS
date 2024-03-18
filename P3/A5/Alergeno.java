/**
 * Clase enumerada que es atributo de Ingrediente.
 * 
 * Autor: Julen Sáenz Ferrero
 */
public enum Alergeno {
    GLUTEN("gluten"), LACTOSA("lactosa"), HUEVO("huevo"), FRUTOS_SECOS("frutos secos");

    private String nombre;

    private Alergeno(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
