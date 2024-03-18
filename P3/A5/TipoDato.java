/**
 * Clase enumerada para uso de ManejadorFicheros.
 * 
 * Autor: Julen Sáenz Ferrero
 */
public enum TipoDato {
    INGREDIENTE_PESO("INGREDIENTE_PESO"), INGREDIENTE_UNIDAD("INGREDIENTE_UNIDAD"), PLATO("PLATO"), MENU("MENU");

    private String nombre;

    private TipoDato(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}