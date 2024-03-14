public enum TipoDato {
    INGREDIENTE_PESO("INGREDIENTE_PESO"), INGREDIENTE_UNIDAD("INGREDIENTE_UNIDAD"), PLATO("PLATO"), MENU("MENU");

    private String nombre;

    private TipoIngrediente(String nombre){
        this.nombre = nombre;
    }
}